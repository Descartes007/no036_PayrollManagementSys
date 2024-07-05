
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 员工考勤
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuangongKaoqin")
public class YuangongKaoqinController {
    private static final Logger logger = LoggerFactory.getLogger(YuangongKaoqinController.class);

    private static final String TABLE_NAME = "yuangongKaoqin";

    @Autowired
    private YuangongKaoqinService yuangongKaoqinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JintieService jintieService;//津贴
    @Autowired
    private JixiaoService jixiaoService;//绩效
    @Autowired
    private XinziService xinziService;//工资
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private YuangongKaoqinListService yuangongKaoqinListService;//员工考勤详情
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yuangongKaoqinService.queryPage(params);

        //字典表数据转换
        List<YuangongKaoqinView> list =(List<YuangongKaoqinView>)page.getList();
        for(YuangongKaoqinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuangongKaoqinEntity yuangongKaoqin = yuangongKaoqinService.selectById(id);
        if(yuangongKaoqin !=null){
            //entity转view
            YuangongKaoqinView view = new YuangongKaoqinView();
            BeanUtils.copyProperties( yuangongKaoqin , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongKaoqinEntity yuangongKaoqin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuangongKaoqin:{}",this.getClass().getName(),yuangongKaoqin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YuangongKaoqinEntity> queryWrapper = new EntityWrapper<YuangongKaoqinEntity>()
            .eq("yuangong_kaoqin_name", yuangongKaoqin.getYuangongKaoqinName())
            .eq("yuangong_kaoqin_types", yuangongKaoqin.getYuangongKaoqinTypes())
            .eq("bumen_types", yuangongKaoqin.getBumenTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongKaoqinEntity yuangongKaoqinEntity = yuangongKaoqinService.selectOne(queryWrapper);
        if(yuangongKaoqinEntity==null){
            yuangongKaoqin.setInsertTime(new Date());
            yuangongKaoqin.setCreateTime(new Date());
            yuangongKaoqinService.insert(yuangongKaoqin);
            List<YuangongEntity> yuangongEntityList = yuangongService.selectList(new EntityWrapper<YuangongEntity>()
                .eq("bumen_types",yuangongKaoqin.getBumenTypes())
            );
            if(yuangongEntityList == null){
            return R.error("没有被考勤的人群,请核实后再添加");
            }
            List<YuangongKaoqinListEntity> yuangongKaoqinListList = new ArrayList<>();
            for(YuangongEntity x:yuangongEntityList){
                YuangongKaoqinListEntity yuangongKaoqinListEntity = new YuangongKaoqinListEntity();
                yuangongKaoqinListEntity.setYuangongId(x.getId());//注册表
                yuangongKaoqinListEntity.setYuangongKaoqinId(yuangongKaoqin.getId());//考勤表
                yuangongKaoqinListEntity.setYuangongKaoqinListTypes(1);
                yuangongKaoqinListEntity.setCreateTime(new Date());
                yuangongKaoqinListEntity.setInsertTime(new Date());
                yuangongKaoqinListList.add(yuangongKaoqinListEntity);

            }
            yuangongKaoqinListService.insertBatch(yuangongKaoqinListList);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongKaoqinEntity yuangongKaoqin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yuangongKaoqin:{}",this.getClass().getName(),yuangongKaoqin.toString());
        YuangongKaoqinEntity oldYuangongKaoqinEntity = yuangongKaoqinService.selectById(yuangongKaoqin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yuangongKaoqin.getYuangongKaoqinContent()) || "null".equals(yuangongKaoqin.getYuangongKaoqinContent())){
                yuangongKaoqin.setYuangongKaoqinContent(null);
        }

            yuangongKaoqinService.updateById(yuangongKaoqin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YuangongKaoqinEntity> oldYuangongKaoqinList =yuangongKaoqinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yuangongKaoqinService.deleteBatchIds(Arrays.asList(ids));
        yuangongKaoqinListService.delete(new EntityWrapper<YuangongKaoqinListEntity>().in("yuangong_kaoqin_id",ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yuangongId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<YuangongKaoqinEntity> yuangongKaoqinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YuangongKaoqinEntity yuangongKaoqinEntity = new YuangongKaoqinEntity();
//                            yuangongKaoqinEntity.setYuangongKaoqinUuidNumber(data.get(0));                    //考勤唯一编号 要改的
//                            yuangongKaoqinEntity.setYuangongKaoqinName(data.get(0));                    //考勤标题 要改的
//                            yuangongKaoqinEntity.setYuangongKaoqinTypes(Integer.valueOf(data.get(0)));   //员工考勤类型 要改的
//                            yuangongKaoqinEntity.setBumenTypes(Integer.valueOf(data.get(0)));   //部门 要改的
//                            yuangongKaoqinEntity.setYuangongKaoqinContent("");//详情和图片
//                            yuangongKaoqinEntity.setInsertTime(date);//时间
//                            yuangongKaoqinEntity.setJiezhiTime(sdf.parse(data.get(0)));          //考勤截止时间 要改的
//                            yuangongKaoqinEntity.setCreateTime(date);//时间
                            yuangongKaoqinList.add(yuangongKaoqinEntity);


                            //把要查询是否重复的字段放入map中
                                //考勤唯一编号
                                if(seachFields.containsKey("yuangongKaoqinUuidNumber")){
                                    List<String> yuangongKaoqinUuidNumber = seachFields.get("yuangongKaoqinUuidNumber");
                                    yuangongKaoqinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yuangongKaoqinUuidNumber = new ArrayList<>();
                                    yuangongKaoqinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yuangongKaoqinUuidNumber",yuangongKaoqinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //考勤唯一编号
                        List<YuangongKaoqinEntity> yuangongKaoqinEntities_yuangongKaoqinUuidNumber = yuangongKaoqinService.selectList(new EntityWrapper<YuangongKaoqinEntity>().in("yuangong_kaoqin_uuid_number", seachFields.get("yuangongKaoqinUuidNumber")));
                        if(yuangongKaoqinEntities_yuangongKaoqinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YuangongKaoqinEntity s:yuangongKaoqinEntities_yuangongKaoqinUuidNumber){
                                repeatFields.add(s.getYuangongKaoqinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [考勤唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yuangongKaoqinService.insertBatch(yuangongKaoqinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}


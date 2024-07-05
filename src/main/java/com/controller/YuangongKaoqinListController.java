
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
 * 员工考勤详情
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuangongKaoqinList")
public class YuangongKaoqinListController {
    private static final Logger logger = LoggerFactory.getLogger(YuangongKaoqinListController.class);

    private static final String TABLE_NAME = "yuangongKaoqinList";

    @Autowired
    private YuangongKaoqinListService yuangongKaoqinListService;


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
    private YuangongKaoqinService yuangongKaoqinService;//员工考勤
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
        PageUtils page = yuangongKaoqinListService.queryPage(params);

        //字典表数据转换
        List<YuangongKaoqinListView> list =(List<YuangongKaoqinListView>)page.getList();
        for(YuangongKaoqinListView c:list){
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
        YuangongKaoqinListEntity yuangongKaoqinList = yuangongKaoqinListService.selectById(id);
        if(yuangongKaoqinList !=null){
            //entity转view
            YuangongKaoqinListView view = new YuangongKaoqinListView();
            BeanUtils.copyProperties( yuangongKaoqinList , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(yuangongKaoqinList.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 员工考勤
            //级联表
            YuangongKaoqinEntity yuangongKaoqin = yuangongKaoqinService.selectById(yuangongKaoqinList.getYuangongKaoqinId());
            if(yuangongKaoqin != null){
            BeanUtils.copyProperties( yuangongKaoqin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongKaoqinId(yuangongKaoqin.getId());
            }
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
    public R save(@RequestBody YuangongKaoqinListEntity yuangongKaoqinList, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuangongKaoqinList:{}",this.getClass().getName(),yuangongKaoqinList.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            yuangongKaoqinList.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YuangongKaoqinListEntity> queryWrapper = new EntityWrapper<YuangongKaoqinListEntity>()
            .eq("yuangong_id", yuangongKaoqinList.getYuangongId())
            .eq("yuangong_kaoqin_id", yuangongKaoqinList.getYuangongKaoqinId())
            .eq("yuangong_kaoqin_list_types", yuangongKaoqinList.getYuangongKaoqinListTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongKaoqinListEntity yuangongKaoqinListEntity = yuangongKaoqinListService.selectOne(queryWrapper);
        if(yuangongKaoqinListEntity==null){
            yuangongKaoqinList.setInsertTime(new Date());
            yuangongKaoqinList.setCreateTime(new Date());
            yuangongKaoqinListService.insert(yuangongKaoqinList);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongKaoqinListEntity yuangongKaoqinList, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yuangongKaoqinList:{}",this.getClass().getName(),yuangongKaoqinList.toString());
        YuangongKaoqinListEntity oldYuangongKaoqinListEntity = yuangongKaoqinListService.selectById(yuangongKaoqinList.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            yuangongKaoqinList.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        yuangongKaoqinList.setUpdateTime(new Date());

            yuangongKaoqinListService.updateById(yuangongKaoqinList);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YuangongKaoqinListEntity> oldYuangongKaoqinListList =yuangongKaoqinListService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yuangongKaoqinListService.deleteBatchIds(Arrays.asList(ids));

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
            List<YuangongKaoqinListEntity> yuangongKaoqinListList = new ArrayList<>();//上传的东西
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
                            YuangongKaoqinListEntity yuangongKaoqinListEntity = new YuangongKaoqinListEntity();
//                            yuangongKaoqinListEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            yuangongKaoqinListEntity.setYuangongKaoqinId(Integer.valueOf(data.get(0)));   //考勤 要改的
//                            yuangongKaoqinListEntity.setYuangongKaoqinListTypes(Integer.valueOf(data.get(0)));   //打卡状态 要改的
//                            yuangongKaoqinListEntity.setInsertTime(date);//时间
//                            yuangongKaoqinListEntity.setUpdateTime(sdf.parse(data.get(0)));          //打卡时间 要改的
//                            yuangongKaoqinListEntity.setCreateTime(date);//时间
                            yuangongKaoqinListList.add(yuangongKaoqinListEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yuangongKaoqinListService.insertBatch(yuangongKaoqinListList);
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


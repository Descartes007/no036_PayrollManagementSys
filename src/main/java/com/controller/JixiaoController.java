
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
 * 绩效
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jixiao")
public class JixiaoController {
    private static final Logger logger = LoggerFactory.getLogger(JixiaoController.class);

    private static final String TABLE_NAME = "jixiao";

    @Autowired
    private JixiaoService jixiaoService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JintieService jintieService;//津贴
    @Autowired
    private XinziService xinziService;//工资
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private YuangongKaoqinService yuangongKaoqinService;//员工考勤
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
        PageUtils page = jixiaoService.queryPage(params);

        //字典表数据转换
        List<JixiaoView> list =(List<JixiaoView>)page.getList();
        for(JixiaoView c:list){
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
        JixiaoEntity jixiao = jixiaoService.selectById(id);
        if(jixiao !=null){
            //entity转view
            JixiaoView view = new JixiaoView();
            BeanUtils.copyProperties( jixiao , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(jixiao.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
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
    public R save(@RequestBody JixiaoEntity jixiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jixiao:{}",this.getClass().getName(),jixiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            jixiao.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JixiaoEntity> queryWrapper = new EntityWrapper<JixiaoEntity>()
            .eq("yuangong_id", jixiao.getYuangongId())
            .eq("jixiao_name", jixiao.getJixiaoName())
            .eq("jixiao_types", jixiao.getJixiaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JixiaoEntity jixiaoEntity = jixiaoService.selectOne(queryWrapper);
        if(jixiaoEntity==null){
            jixiao.setInsertTime(new Date());
            jixiao.setCreateTime(new Date());
            jixiaoService.insert(jixiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JixiaoEntity jixiao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jixiao:{}",this.getClass().getName(),jixiao.toString());
        JixiaoEntity oldJixiaoEntity = jixiaoService.selectById(jixiao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            jixiao.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jixiao.getJixiaoFile()) || "null".equals(jixiao.getJixiaoFile())){
                jixiao.setJixiaoFile(null);
        }
        if("".equals(jixiao.getJixiaoContent()) || "null".equals(jixiao.getJixiaoContent())){
                jixiao.setJixiaoContent(null);
        }

            jixiaoService.updateById(jixiao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JixiaoEntity> oldJixiaoList =jixiaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jixiaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<JixiaoEntity> jixiaoList = new ArrayList<>();//上传的东西
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
                            JixiaoEntity jixiaoEntity = new JixiaoEntity();
//                            jixiaoEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            jixiaoEntity.setJixiaoUuidNumber(data.get(0));                    //绩效编号 要改的
//                            jixiaoEntity.setJixiaoName(data.get(0));                    //绩效标题 要改的
//                            jixiaoEntity.setJixiaoFile(data.get(0));                    //附件 要改的
//                            jixiaoEntity.setJixiaoTypes(Integer.valueOf(data.get(0)));   //绩效类型 要改的
//                            jixiaoEntity.setJixiaoDafen(data.get(0));                    //绩效打分 要改的
//                            jixiaoEntity.setPingguTime(sdf.parse(data.get(0)));          //评估时间 要改的
//                            jixiaoEntity.setJixiaoContent("");//详情和图片
//                            jixiaoEntity.setInsertTime(date);//时间
//                            jixiaoEntity.setCreateTime(date);//时间
                            jixiaoList.add(jixiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //绩效编号
                                if(seachFields.containsKey("jixiaoUuidNumber")){
                                    List<String> jixiaoUuidNumber = seachFields.get("jixiaoUuidNumber");
                                    jixiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jixiaoUuidNumber = new ArrayList<>();
                                    jixiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jixiaoUuidNumber",jixiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //绩效编号
                        List<JixiaoEntity> jixiaoEntities_jixiaoUuidNumber = jixiaoService.selectList(new EntityWrapper<JixiaoEntity>().in("jixiao_uuid_number", seachFields.get("jixiaoUuidNumber")));
                        if(jixiaoEntities_jixiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JixiaoEntity s:jixiaoEntities_jixiaoUuidNumber){
                                repeatFields.add(s.getJixiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [绩效编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jixiaoService.insertBatch(jixiaoList);
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


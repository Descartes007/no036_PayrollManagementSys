package com.dao;

import com.entity.YuangongKaoqinListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongKaoqinListView;

/**
 * 员工考勤详情 Dao 接口
 *
 * @author 
 */
public interface YuangongKaoqinListDao extends BaseMapper<YuangongKaoqinListEntity> {

   List<YuangongKaoqinListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

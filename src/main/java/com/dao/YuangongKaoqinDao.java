package com.dao;

import com.entity.YuangongKaoqinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongKaoqinView;

/**
 * 员工考勤 Dao 接口
 *
 * @author 
 */
public interface YuangongKaoqinDao extends BaseMapper<YuangongKaoqinEntity> {

   List<YuangongKaoqinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

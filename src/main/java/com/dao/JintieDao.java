package com.dao;

import com.entity.JintieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JintieView;

/**
 * 津贴 Dao 接口
 *
 * @author 
 */
public interface JintieDao extends BaseMapper<JintieEntity> {

   List<JintieView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

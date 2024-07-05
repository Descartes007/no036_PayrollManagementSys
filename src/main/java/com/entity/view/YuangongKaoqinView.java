package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YuangongKaoqinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 员工考勤
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yuangong_kaoqin")
public class YuangongKaoqinView extends YuangongKaoqinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 员工考勤类型的值
	*/
	@ColumnInfo(comment="员工考勤类型的字典表值",type="varchar(200)")
	private String yuangongKaoqinValue;
	/**
	* 部门的值
	*/
	@ColumnInfo(comment="部门的字典表值",type="varchar(200)")
	private String bumenValue;




	public YuangongKaoqinView() {

	}

	public YuangongKaoqinView(YuangongKaoqinEntity yuangongKaoqinEntity) {
		try {
			BeanUtils.copyProperties(this, yuangongKaoqinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 员工考勤类型的值
	*/
	public String getYuangongKaoqinValue() {
		return yuangongKaoqinValue;
	}
	/**
	* 设置： 员工考勤类型的值
	*/
	public void setYuangongKaoqinValue(String yuangongKaoqinValue) {
		this.yuangongKaoqinValue = yuangongKaoqinValue;
	}
	//当前表的
	/**
	* 获取： 部门的值
	*/
	public String getBumenValue() {
		return bumenValue;
	}
	/**
	* 设置： 部门的值
	*/
	public void setBumenValue(String bumenValue) {
		this.bumenValue = bumenValue;
	}




	@Override
	public String toString() {
		return "YuangongKaoqinView{" +
			", yuangongKaoqinValue=" + yuangongKaoqinValue +
			", bumenValue=" + bumenValue +
			"} " + super.toString();
	}
}

package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 员工考勤详情
 *
 * @author 
 * @email
 */
@TableName("yuangong_kaoqin_list")
public class YuangongKaoqinListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuangongKaoqinListEntity() {

	}

	public YuangongKaoqinListEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 考勤
     */
    @ColumnInfo(comment="考勤",type="int(11)")
    @TableField(value = "yuangong_kaoqin_id")

    private Integer yuangongKaoqinId;


    /**
     * 打卡状态
     */
    @ColumnInfo(comment="打卡状态",type="int(11)")
    @TableField(value = "yuangong_kaoqin_list_types")

    private Integer yuangongKaoqinListTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 打卡时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="打卡时间",type="timestamp")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 设置：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：考勤
	 */
    public Integer getYuangongKaoqinId() {
        return yuangongKaoqinId;
    }
    /**
	 * 设置：考勤
	 */

    public void setYuangongKaoqinId(Integer yuangongKaoqinId) {
        this.yuangongKaoqinId = yuangongKaoqinId;
    }
    /**
	 * 获取：打卡状态
	 */
    public Integer getYuangongKaoqinListTypes() {
        return yuangongKaoqinListTypes;
    }
    /**
	 * 设置：打卡状态
	 */

    public void setYuangongKaoqinListTypes(Integer yuangongKaoqinListTypes) {
        this.yuangongKaoqinListTypes = yuangongKaoqinListTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：打卡时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 设置：打卡时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YuangongKaoqinList{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", yuangongKaoqinId=" + yuangongKaoqinId +
            ", yuangongKaoqinListTypes=" + yuangongKaoqinListTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", updateTime=" + DateUtil.convertString(updateTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

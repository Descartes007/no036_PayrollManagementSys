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
 * 员工考勤
 *
 * @author 
 * @email
 */
@TableName("yuangong_kaoqin")
public class YuangongKaoqinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuangongKaoqinEntity() {

	}

	public YuangongKaoqinEntity(T t) {
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
     * 考勤唯一编号
     */
    @ColumnInfo(comment="考勤唯一编号",type="varchar(200)")
    @TableField(value = "yuangong_kaoqin_uuid_number")

    private String yuangongKaoqinUuidNumber;


    /**
     * 考勤标题
     */
    @ColumnInfo(comment="考勤标题",type="varchar(200)")
    @TableField(value = "yuangong_kaoqin_name")

    private String yuangongKaoqinName;


    /**
     * 员工考勤类型
     */
    @ColumnInfo(comment="员工考勤类型",type="int(11)")
    @TableField(value = "yuangong_kaoqin_types")

    private Integer yuangongKaoqinTypes;


    /**
     * 部门
     */
    @ColumnInfo(comment="部门",type="int(11)")
    @TableField(value = "bumen_types")

    private Integer bumenTypes;


    /**
     * 考勤详情
     */
    @ColumnInfo(comment="考勤详情",type="longtext")
    @TableField(value = "yuangong_kaoqin_content")

    private String yuangongKaoqinContent;


    /**
     * 考勤发起时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="考勤发起时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 考勤截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="考勤截止时间",type="timestamp")
    @TableField(value = "jiezhi_time")

    private Date jiezhiTime;


    /**
     * 创建时间
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
	 * 获取：考勤唯一编号
	 */
    public String getYuangongKaoqinUuidNumber() {
        return yuangongKaoqinUuidNumber;
    }
    /**
	 * 设置：考勤唯一编号
	 */

    public void setYuangongKaoqinUuidNumber(String yuangongKaoqinUuidNumber) {
        this.yuangongKaoqinUuidNumber = yuangongKaoqinUuidNumber;
    }
    /**
	 * 获取：考勤标题
	 */
    public String getYuangongKaoqinName() {
        return yuangongKaoqinName;
    }
    /**
	 * 设置：考勤标题
	 */

    public void setYuangongKaoqinName(String yuangongKaoqinName) {
        this.yuangongKaoqinName = yuangongKaoqinName;
    }
    /**
	 * 获取：员工考勤类型
	 */
    public Integer getYuangongKaoqinTypes() {
        return yuangongKaoqinTypes;
    }
    /**
	 * 设置：员工考勤类型
	 */

    public void setYuangongKaoqinTypes(Integer yuangongKaoqinTypes) {
        this.yuangongKaoqinTypes = yuangongKaoqinTypes;
    }
    /**
	 * 获取：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }
    /**
	 * 设置：部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：考勤详情
	 */
    public String getYuangongKaoqinContent() {
        return yuangongKaoqinContent;
    }
    /**
	 * 设置：考勤详情
	 */

    public void setYuangongKaoqinContent(String yuangongKaoqinContent) {
        this.yuangongKaoqinContent = yuangongKaoqinContent;
    }
    /**
	 * 获取：考勤发起时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：考勤发起时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：考勤截止时间
	 */
    public Date getJiezhiTime() {
        return jiezhiTime;
    }
    /**
	 * 设置：考勤截止时间
	 */

    public void setJiezhiTime(Date jiezhiTime) {
        this.jiezhiTime = jiezhiTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YuangongKaoqin{" +
            ", id=" + id +
            ", yuangongKaoqinUuidNumber=" + yuangongKaoqinUuidNumber +
            ", yuangongKaoqinName=" + yuangongKaoqinName +
            ", yuangongKaoqinTypes=" + yuangongKaoqinTypes +
            ", bumenTypes=" + bumenTypes +
            ", yuangongKaoqinContent=" + yuangongKaoqinContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", jiezhiTime=" + DateUtil.convertString(jiezhiTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

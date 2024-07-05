package com.entity.model;

import com.entity.YuangongKaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 员工考勤
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuangongKaoqinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考勤唯一编号
     */
    private String yuangongKaoqinUuidNumber;


    /**
     * 考勤标题
     */
    private String yuangongKaoqinName;


    /**
     * 员工考勤类型
     */
    private Integer yuangongKaoqinTypes;


    /**
     * 部门
     */
    private Integer bumenTypes;


    /**
     * 考勤详情
     */
    private String yuangongKaoqinContent;


    /**
     * 考勤发起时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 考勤截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiezhiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }

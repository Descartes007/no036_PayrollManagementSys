package com.entity.vo;

import com.entity.YuangongKaoqinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 员工考勤
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuangong_kaoqin")
public class YuangongKaoqinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 考勤唯一编号
     */

    @TableField(value = "yuangong_kaoqin_uuid_number")
    private String yuangongKaoqinUuidNumber;


    /**
     * 考勤标题
     */

    @TableField(value = "yuangong_kaoqin_name")
    private String yuangongKaoqinName;


    /**
     * 员工考勤类型
     */

    @TableField(value = "yuangong_kaoqin_types")
    private Integer yuangongKaoqinTypes;


    /**
     * 部门
     */

    @TableField(value = "bumen_types")
    private Integer bumenTypes;


    /**
     * 考勤详情
     */

    @TableField(value = "yuangong_kaoqin_content")
    private String yuangongKaoqinContent;


    /**
     * 考勤发起时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 考勤截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiezhi_time")
    private Date jiezhiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：考勤唯一编号
	 */
    public String getYuangongKaoqinUuidNumber() {
        return yuangongKaoqinUuidNumber;
    }


    /**
	 * 获取：考勤唯一编号
	 */

    public void setYuangongKaoqinUuidNumber(String yuangongKaoqinUuidNumber) {
        this.yuangongKaoqinUuidNumber = yuangongKaoqinUuidNumber;
    }
    /**
	 * 设置：考勤标题
	 */
    public String getYuangongKaoqinName() {
        return yuangongKaoqinName;
    }


    /**
	 * 获取：考勤标题
	 */

    public void setYuangongKaoqinName(String yuangongKaoqinName) {
        this.yuangongKaoqinName = yuangongKaoqinName;
    }
    /**
	 * 设置：员工考勤类型
	 */
    public Integer getYuangongKaoqinTypes() {
        return yuangongKaoqinTypes;
    }


    /**
	 * 获取：员工考勤类型
	 */

    public void setYuangongKaoqinTypes(Integer yuangongKaoqinTypes) {
        this.yuangongKaoqinTypes = yuangongKaoqinTypes;
    }
    /**
	 * 设置：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：考勤详情
	 */
    public String getYuangongKaoqinContent() {
        return yuangongKaoqinContent;
    }


    /**
	 * 获取：考勤详情
	 */

    public void setYuangongKaoqinContent(String yuangongKaoqinContent) {
        this.yuangongKaoqinContent = yuangongKaoqinContent;
    }
    /**
	 * 设置：考勤发起时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：考勤发起时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：考勤截止时间
	 */
    public Date getJiezhiTime() {
        return jiezhiTime;
    }


    /**
	 * 获取：考勤截止时间
	 */

    public void setJiezhiTime(Date jiezhiTime) {
        this.jiezhiTime = jiezhiTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

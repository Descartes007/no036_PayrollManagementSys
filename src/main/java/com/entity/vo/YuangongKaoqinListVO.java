package com.entity.vo;

import com.entity.YuangongKaoqinListEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 员工考勤详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuangong_kaoqin_list")
public class YuangongKaoqinListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 考勤
     */

    @TableField(value = "yuangong_kaoqin_id")
    private Integer yuangongKaoqinId;


    /**
     * 打卡状态
     */

    @TableField(value = "yuangong_kaoqin_list_types")
    private Integer yuangongKaoqinListTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 打卡时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：考勤
	 */
    public Integer getYuangongKaoqinId() {
        return yuangongKaoqinId;
    }


    /**
	 * 获取：考勤
	 */

    public void setYuangongKaoqinId(Integer yuangongKaoqinId) {
        this.yuangongKaoqinId = yuangongKaoqinId;
    }
    /**
	 * 设置：打卡状态
	 */
    public Integer getYuangongKaoqinListTypes() {
        return yuangongKaoqinListTypes;
    }


    /**
	 * 获取：打卡状态
	 */

    public void setYuangongKaoqinListTypes(Integer yuangongKaoqinListTypes) {
        this.yuangongKaoqinListTypes = yuangongKaoqinListTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：打卡时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：打卡时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.entity.vo;

import com.entity.JixiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 绩效
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jixiao")
public class JixiaoVO implements Serializable {
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
     * 绩效编号
     */

    @TableField(value = "jixiao_uuid_number")
    private String jixiaoUuidNumber;


    /**
     * 绩效标题
     */

    @TableField(value = "jixiao_name")
    private String jixiaoName;


    /**
     * 附件
     */

    @TableField(value = "jixiao_file")
    private String jixiaoFile;


    /**
     * 绩效类型
     */

    @TableField(value = "jixiao_types")
    private Integer jixiaoTypes;


    /**
     * 绩效打分
     */

    @TableField(value = "jixiao_dafen")
    private Double jixiaoDafen;


    /**
     * 评估时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "pinggu_time")
    private Date pingguTime;


    /**
     * 打分缘由
     */

    @TableField(value = "jixiao_content")
    private String jixiaoContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 photoShow
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
	 * 设置：绩效编号
	 */
    public String getJixiaoUuidNumber() {
        return jixiaoUuidNumber;
    }


    /**
	 * 获取：绩效编号
	 */

    public void setJixiaoUuidNumber(String jixiaoUuidNumber) {
        this.jixiaoUuidNumber = jixiaoUuidNumber;
    }
    /**
	 * 设置：绩效标题
	 */
    public String getJixiaoName() {
        return jixiaoName;
    }


    /**
	 * 获取：绩效标题
	 */

    public void setJixiaoName(String jixiaoName) {
        this.jixiaoName = jixiaoName;
    }
    /**
	 * 设置：附件
	 */
    public String getJixiaoFile() {
        return jixiaoFile;
    }


    /**
	 * 获取：附件
	 */

    public void setJixiaoFile(String jixiaoFile) {
        this.jixiaoFile = jixiaoFile;
    }
    /**
	 * 设置：绩效类型
	 */
    public Integer getJixiaoTypes() {
        return jixiaoTypes;
    }


    /**
	 * 获取：绩效类型
	 */

    public void setJixiaoTypes(Integer jixiaoTypes) {
        this.jixiaoTypes = jixiaoTypes;
    }
    /**
	 * 设置：绩效打分
	 */
    public Double getJixiaoDafen() {
        return jixiaoDafen;
    }


    /**
	 * 获取：绩效打分
	 */

    public void setJixiaoDafen(Double jixiaoDafen) {
        this.jixiaoDafen = jixiaoDafen;
    }
    /**
	 * 设置：评估时间
	 */
    public Date getPingguTime() {
        return pingguTime;
    }


    /**
	 * 获取：评估时间
	 */

    public void setPingguTime(Date pingguTime) {
        this.pingguTime = pingguTime;
    }
    /**
	 * 设置：打分缘由
	 */
    public String getJixiaoContent() {
        return jixiaoContent;
    }


    /**
	 * 获取：打分缘由
	 */

    public void setJixiaoContent(String jixiaoContent) {
        this.jixiaoContent = jixiaoContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

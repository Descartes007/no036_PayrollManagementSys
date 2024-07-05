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
 * 绩效
 *
 * @author 
 * @email
 */
@TableName("jixiao")
public class JixiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JixiaoEntity() {

	}

	public JixiaoEntity(T t) {
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
     * 绩效编号
     */
    @ColumnInfo(comment="绩效编号",type="varchar(200)")
    @TableField(value = "jixiao_uuid_number")

    private String jixiaoUuidNumber;


    /**
     * 绩效标题
     */
    @ColumnInfo(comment="绩效标题",type="varchar(200)")
    @TableField(value = "jixiao_name")

    private String jixiaoName;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "jixiao_file")

    private String jixiaoFile;


    /**
     * 绩效类型
     */
    @ColumnInfo(comment="绩效类型",type="int(11)")
    @TableField(value = "jixiao_types")

    private Integer jixiaoTypes;


    /**
     * 绩效打分
     */
    @ColumnInfo(comment="绩效打分",type="decimal(10,2)")
    @TableField(value = "jixiao_dafen")

    private Double jixiaoDafen;


    /**
     * 评估时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="评估时间",type="timestamp")
    @TableField(value = "pinggu_time")

    private Date pingguTime;


    /**
     * 打分缘由
     */
    @ColumnInfo(comment="打分缘由",type="longtext")
    @TableField(value = "jixiao_content")

    private String jixiaoContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="记录时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：绩效编号
	 */
    public String getJixiaoUuidNumber() {
        return jixiaoUuidNumber;
    }
    /**
	 * 设置：绩效编号
	 */

    public void setJixiaoUuidNumber(String jixiaoUuidNumber) {
        this.jixiaoUuidNumber = jixiaoUuidNumber;
    }
    /**
	 * 获取：绩效标题
	 */
    public String getJixiaoName() {
        return jixiaoName;
    }
    /**
	 * 设置：绩效标题
	 */

    public void setJixiaoName(String jixiaoName) {
        this.jixiaoName = jixiaoName;
    }
    /**
	 * 获取：附件
	 */
    public String getJixiaoFile() {
        return jixiaoFile;
    }
    /**
	 * 设置：附件
	 */

    public void setJixiaoFile(String jixiaoFile) {
        this.jixiaoFile = jixiaoFile;
    }
    /**
	 * 获取：绩效类型
	 */
    public Integer getJixiaoTypes() {
        return jixiaoTypes;
    }
    /**
	 * 设置：绩效类型
	 */

    public void setJixiaoTypes(Integer jixiaoTypes) {
        this.jixiaoTypes = jixiaoTypes;
    }
    /**
	 * 获取：绩效打分
	 */
    public Double getJixiaoDafen() {
        return jixiaoDafen;
    }
    /**
	 * 设置：绩效打分
	 */

    public void setJixiaoDafen(Double jixiaoDafen) {
        this.jixiaoDafen = jixiaoDafen;
    }
    /**
	 * 获取：评估时间
	 */
    public Date getPingguTime() {
        return pingguTime;
    }
    /**
	 * 设置：评估时间
	 */

    public void setPingguTime(Date pingguTime) {
        this.pingguTime = pingguTime;
    }
    /**
	 * 获取：打分缘由
	 */
    public String getJixiaoContent() {
        return jixiaoContent;
    }
    /**
	 * 设置：打分缘由
	 */

    public void setJixiaoContent(String jixiaoContent) {
        this.jixiaoContent = jixiaoContent;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Jixiao{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", jixiaoUuidNumber=" + jixiaoUuidNumber +
            ", jixiaoName=" + jixiaoName +
            ", jixiaoFile=" + jixiaoFile +
            ", jixiaoTypes=" + jixiaoTypes +
            ", jixiaoDafen=" + jixiaoDafen +
            ", pingguTime=" + DateUtil.convertString(pingguTime,"yyyy-MM-dd") +
            ", jixiaoContent=" + jixiaoContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

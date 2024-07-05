package com.entity.model;

import com.entity.JixiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 绩效
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JixiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 绩效编号
     */
    private String jixiaoUuidNumber;


    /**
     * 绩效标题
     */
    private String jixiaoName;


    /**
     * 附件
     */
    private String jixiaoFile;


    /**
     * 绩效类型
     */
    private Integer jixiaoTypes;


    /**
     * 绩效打分
     */
    private Double jixiaoDafen;


    /**
     * 评估时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pingguTime;


    /**
     * 打分缘由
     */
    private String jixiaoContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 photoShow
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
	 * 获取：创建时间  show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

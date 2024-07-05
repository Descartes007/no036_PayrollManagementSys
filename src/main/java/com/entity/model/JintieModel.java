package com.entity.model;

import com.entity.JintieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 津贴
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JintieModel implements Serializable {
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
     * 津贴编号
     */
    private String jintieUuidNumber;


    /**
     * 津贴标题
     */
    private String jintieName;


    /**
     * 附件
     */
    private String jintieFile;


    /**
     * 津贴类型
     */
    private Integer jintieTypes;


    /**
     * 津贴金额
     */
    private Double jintieJine;


    /**
     * 津贴缘由
     */
    private String jintieContent;


    /**
     * 上传时间
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
	 * 获取：津贴编号
	 */
    public String getJintieUuidNumber() {
        return jintieUuidNumber;
    }


    /**
	 * 设置：津贴编号
	 */
    public void setJintieUuidNumber(String jintieUuidNumber) {
        this.jintieUuidNumber = jintieUuidNumber;
    }
    /**
	 * 获取：津贴标题
	 */
    public String getJintieName() {
        return jintieName;
    }


    /**
	 * 设置：津贴标题
	 */
    public void setJintieName(String jintieName) {
        this.jintieName = jintieName;
    }
    /**
	 * 获取：附件
	 */
    public String getJintieFile() {
        return jintieFile;
    }


    /**
	 * 设置：附件
	 */
    public void setJintieFile(String jintieFile) {
        this.jintieFile = jintieFile;
    }
    /**
	 * 获取：津贴类型
	 */
    public Integer getJintieTypes() {
        return jintieTypes;
    }


    /**
	 * 设置：津贴类型
	 */
    public void setJintieTypes(Integer jintieTypes) {
        this.jintieTypes = jintieTypes;
    }
    /**
	 * 获取：津贴金额
	 */
    public Double getJintieJine() {
        return jintieJine;
    }


    /**
	 * 设置：津贴金额
	 */
    public void setJintieJine(Double jintieJine) {
        this.jintieJine = jintieJine;
    }
    /**
	 * 获取：津贴缘由
	 */
    public String getJintieContent() {
        return jintieContent;
    }


    /**
	 * 设置：津贴缘由
	 */
    public void setJintieContent(String jintieContent) {
        this.jintieContent = jintieContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：上传时间
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

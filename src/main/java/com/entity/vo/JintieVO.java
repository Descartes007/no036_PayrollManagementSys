package com.entity.vo;

import com.entity.JintieEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 津贴
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jintie")
public class JintieVO implements Serializable {
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
     * 津贴编号
     */

    @TableField(value = "jintie_uuid_number")
    private String jintieUuidNumber;


    /**
     * 津贴标题
     */

    @TableField(value = "jintie_name")
    private String jintieName;


    /**
     * 附件
     */

    @TableField(value = "jintie_file")
    private String jintieFile;


    /**
     * 津贴类型
     */

    @TableField(value = "jintie_types")
    private Integer jintieTypes;


    /**
     * 津贴金额
     */

    @TableField(value = "jintie_jine")
    private Double jintieJine;


    /**
     * 津贴缘由
     */

    @TableField(value = "jintie_content")
    private String jintieContent;


    /**
     * 上传时间
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
	 * 设置：津贴编号
	 */
    public String getJintieUuidNumber() {
        return jintieUuidNumber;
    }


    /**
	 * 获取：津贴编号
	 */

    public void setJintieUuidNumber(String jintieUuidNumber) {
        this.jintieUuidNumber = jintieUuidNumber;
    }
    /**
	 * 设置：津贴标题
	 */
    public String getJintieName() {
        return jintieName;
    }


    /**
	 * 获取：津贴标题
	 */

    public void setJintieName(String jintieName) {
        this.jintieName = jintieName;
    }
    /**
	 * 设置：附件
	 */
    public String getJintieFile() {
        return jintieFile;
    }


    /**
	 * 获取：附件
	 */

    public void setJintieFile(String jintieFile) {
        this.jintieFile = jintieFile;
    }
    /**
	 * 设置：津贴类型
	 */
    public Integer getJintieTypes() {
        return jintieTypes;
    }


    /**
	 * 获取：津贴类型
	 */

    public void setJintieTypes(Integer jintieTypes) {
        this.jintieTypes = jintieTypes;
    }
    /**
	 * 设置：津贴金额
	 */
    public Double getJintieJine() {
        return jintieJine;
    }


    /**
	 * 获取：津贴金额
	 */

    public void setJintieJine(Double jintieJine) {
        this.jintieJine = jintieJine;
    }
    /**
	 * 设置：津贴缘由
	 */
    public String getJintieContent() {
        return jintieContent;
    }


    /**
	 * 获取：津贴缘由
	 */

    public void setJintieContent(String jintieContent) {
        this.jintieContent = jintieContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
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

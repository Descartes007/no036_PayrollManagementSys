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
 * 津贴
 *
 * @author
 * @email
 */
@TableName("jintie")
public class JintieEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JintieEntity() {

	}

	public JintieEntity(T t) {
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
     * 津贴编号
     */
    @ColumnInfo(comment="津贴编号",type="varchar(200)")
    @TableField(value = "jintie_uuid_number")

    private String jintieUuidNumber;


    /**
     * 津贴标题
     */
    @ColumnInfo(comment="津贴标题",type="varchar(200)")
    @TableField(value = "jintie_name")

    private String jintieName;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "jintie_file")

    private String jintieFile;


    /**
     * 津贴类型
     */
    @ColumnInfo(comment="津贴类型",type="int(11)")
    @TableField(value = "jintie_types")

    private Integer jintieTypes;


    /**
     * 津贴金额
     */
    @ColumnInfo(comment="津贴金额",type="decimal(10,2)")
    @TableField(value = "jintie_jine")

    private Double jintieJine;


    /**
     * 津贴缘由
     */
    @ColumnInfo(comment="津贴缘由",type="longtext")
    @TableField(value = "jintie_content")

    private String jintieContent;


    /**
     * 津贴缘由
     */
    //@ColumnInfo(comment="津贴金额",type="decimal(2)")
   // @TableField(value = "price")

   // private Double price;

    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
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

    /**
     * 获取：津贴金额
     */
   // public Double getPrice() {
    //    return price;
//    }
    /**
     * 设置：津贴金额
     */

  //  public void setPrice(Double price) {
   //     this.price = price;
  //  }

    @Override
    public String toString() {
        return "Jintie{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", jintieUuidNumber=" + jintieUuidNumber +
            ", jintieName=" + jintieName +
            ", jintieFile=" + jintieFile +
            ", jintieTypes=" + jintieTypes +
            ", jintieJine=" + jintieJine +
           // ", price=" + price +
            ", jintieContent=" + jintieContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

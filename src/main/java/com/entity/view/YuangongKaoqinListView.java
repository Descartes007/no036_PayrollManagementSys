package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YuangongKaoqinListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 员工考勤详情
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yuangong_kaoqin_list")
public class YuangongKaoqinListView extends YuangongKaoqinListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 打卡状态的值
	*/
	@ColumnInfo(comment="打卡状态的字典表值",type="varchar(200)")
	private String yuangongKaoqinListValue;

	//级联表 员工
		/**
		* 员工编号
		*/

		@ColumnInfo(comment="员工编号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 职位
		*/
		@ColumnInfo(comment="职位",type="int(11)")
		private Integer zhiweiTypes;
			/**
			* 职位的值
			*/
			@ColumnInfo(comment="职位的字典表值",type="varchar(200)")
			private String zhiweiValue;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;
	//级联表 员工考勤
		/**
		* 考勤唯一编号
		*/

		@ColumnInfo(comment="考勤唯一编号",type="varchar(200)")
		private String yuangongKaoqinUuidNumber;
		/**
		* 考勤标题
		*/

		@ColumnInfo(comment="考勤标题",type="varchar(200)")
		private String yuangongKaoqinName;
		/**
		* 员工考勤类型
		*/
		@ColumnInfo(comment="员工考勤类型",type="int(11)")
		private Integer yuangongKaoqinTypes;
			/**
			* 员工考勤类型的值
			*/
			@ColumnInfo(comment="员工考勤类型的字典表值",type="varchar(200)")
			private String yuangongKaoqinValue;
		/**
		* 考勤详情
		*/

		@ColumnInfo(comment="考勤详情",type="longtext")
		private String yuangongKaoqinContent;
		/**
		* 考勤截止时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="考勤截止时间",type="timestamp")
		private Date jiezhiTime;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer bumenTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String bumenValue;


	public YuangongKaoqinListView() {

	}

	public YuangongKaoqinListView(YuangongKaoqinListEntity yuangongKaoqinListEntity) {
		try {
			BeanUtils.copyProperties(this, yuangongKaoqinListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 打卡状态的值
	*/
	public String getYuangongKaoqinListValue() {
		return yuangongKaoqinListValue;
	}
	/**
	* 设置： 打卡状态的值
	*/
	public void setYuangongKaoqinListValue(String yuangongKaoqinListValue) {
		this.yuangongKaoqinListValue = yuangongKaoqinListValue;
	}


	//级联表的get和set 员工

		/**
		* 获取： 员工编号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 员工编号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}
		/**
		* 获取： 职位
		*/
		public Integer getZhiweiTypes() {
			return zhiweiTypes;
		}
		/**
		* 设置： 职位
		*/
		public void setZhiweiTypes(Integer zhiweiTypes) {
			this.zhiweiTypes = zhiweiTypes;
		}


			/**
			* 获取： 职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}
	//级联表的get和set 员工考勤

		/**
		* 获取： 考勤唯一编号
		*/
		public String getYuangongKaoqinUuidNumber() {
			return yuangongKaoqinUuidNumber;
		}
		/**
		* 设置： 考勤唯一编号
		*/
		public void setYuangongKaoqinUuidNumber(String yuangongKaoqinUuidNumber) {
			this.yuangongKaoqinUuidNumber = yuangongKaoqinUuidNumber;
		}

		/**
		* 获取： 考勤标题
		*/
		public String getYuangongKaoqinName() {
			return yuangongKaoqinName;
		}
		/**
		* 设置： 考勤标题
		*/
		public void setYuangongKaoqinName(String yuangongKaoqinName) {
			this.yuangongKaoqinName = yuangongKaoqinName;
		}
		/**
		* 获取： 员工考勤类型
		*/
		public Integer getYuangongKaoqinTypes() {
			return yuangongKaoqinTypes;
		}
		/**
		* 设置： 员工考勤类型
		*/
		public void setYuangongKaoqinTypes(Integer yuangongKaoqinTypes) {
			this.yuangongKaoqinTypes = yuangongKaoqinTypes;
		}


			/**
			* 获取： 员工考勤类型的值
			*/
			public String getYuangongKaoqinValue() {
				return yuangongKaoqinValue;
			}
			/**
			* 设置： 员工考勤类型的值
			*/
			public void setYuangongKaoqinValue(String yuangongKaoqinValue) {
				this.yuangongKaoqinValue = yuangongKaoqinValue;
			}

		/**
		* 获取： 考勤详情
		*/
		public String getYuangongKaoqinContent() {
			return yuangongKaoqinContent;
		}
		/**
		* 设置： 考勤详情
		*/
		public void setYuangongKaoqinContent(String yuangongKaoqinContent) {
			this.yuangongKaoqinContent = yuangongKaoqinContent;
		}

		/**
		* 获取： 考勤截止时间
		*/
		public Date getJiezhiTime() {
			return jiezhiTime;
		}
		/**
		* 设置： 考勤截止时间
		*/
		public void setJiezhiTime(Date jiezhiTime) {
			this.jiezhiTime = jiezhiTime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getBumenTypes() {
			return bumenTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setBumenTypes(Integer bumenTypes) {
			this.bumenTypes = bumenTypes;
			}
				public String getBumenValue() {
				return bumenValue;
				}
				public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
				}

	@Override
	public String toString() {
		return "YuangongKaoqinListView{" +
			", yuangongKaoqinListValue=" + yuangongKaoqinListValue +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			", yuangongKaoqinUuidNumber=" + yuangongKaoqinUuidNumber +
			", yuangongKaoqinName=" + yuangongKaoqinName +
			", yuangongKaoqinContent=" + yuangongKaoqinContent +
			", jiezhiTime=" + DateUtil.convertString(jiezhiTime,"yyyy-MM-dd") +
			"} " + super.toString();
	}
}

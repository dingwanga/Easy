package cn.bdqn.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @author clack 用户表
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String euId;// 用户id
	private String euName;// 用户名
	private String euPassword;// 密码
	private String euSex;// 性别
	private Date euBirthday;// 出生日期
	private String euIdentity;// 身份证号
	private String euEmail;// email
	private String euMobile;// 手机
	private String euAddress;// 地址
	private Integer euStatus;// 类型

	public String getEuId() {
		return euId;
	}

	public void setEuId(String euId) {
		this.euId = euId;
	}

	public String getEuName() {
		return euName;
	}

	public void setEuName(String euName) {
		this.euName = euName;
	}

	public String getEuPassword() {
		return euPassword;
	}

	public void setEuPassword(String euPassword) {
		this.euPassword = euPassword;
	}

	public String getEuSex() {
		return euSex;
	}

	public void setEuSex(String euSex) {
		this.euSex = euSex;
	}

	public Date getEuBirthday() {
		return euBirthday;
	}

	public void setEuBirthday(Date euBirthday) {
		this.euBirthday = euBirthday;
	}

	public String getEuIdentity() {
		return euIdentity;
	}

	public void setEuIdentity(String euIdentity) {
		this.euIdentity = euIdentity;
	}

	public String getEuEmail() {
		return euEmail;
	}

	public void setEuEmail(String euEmail) {
		this.euEmail = euEmail;
	}

	public String getEuMobile() {
		return euMobile;
	}

	public void setEuMobile(String euMobile) {
		this.euMobile = euMobile;
	}

	public String getEuAddress() {
		return euAddress;
	}

	public void setEuAddress(String euAddress) {
		this.euAddress = euAddress;
	}

	public Integer getEuStatus() {
		return euStatus;
	}

	public void setEuStatus(Integer euStatus) {
		this.euStatus = euStatus;
	}

	public User(String euId, String euName, String euPassword, String euSex,
			Date euBirthday, String euIdentity, String euEmail,
			String euMobile, String euAddress, Integer euStatus) {
		super();
		this.euId = euId;
		this.euName = euName;
		this.euPassword = euPassword;
		this.euSex = euSex;
		this.euBirthday = euBirthday;
		this.euIdentity = euIdentity;
		this.euEmail = euEmail;
		this.euMobile = euMobile;
		this.euAddress = euAddress;
		this.euStatus = euStatus;
	}

	public User() {
		super();
	}
	
	
}

package com.accumulate.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YLF 管理者
 */
@SuppressWarnings("serial")
public class Admin implements Serializable {
	/**
	 * 管理者id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 登录次数
	 */
	private int loginTime;
	/**
	 * 上次登录时间
	 */
	private Date lastLoginDate;
	/**
	 * 上次登录IP
	 */
	private String lastLoginIp;
	/**
	 * 状态 ---0为正常，1为锁定 4为删除
	 */
	private int type;
	/**
	 * 插入时间
	 */
	private Date insertDate;

	public Admin(int id, String userName, String passWord, String trueName,
			int loginTime, Date lastLoginDate, String lastLoginIp, int type,
			Date insertDate) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.trueName = trueName;
		this.loginTime = loginTime;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIp = lastLoginIp;
		this.type = type;
		this.insertDate = insertDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(int loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}

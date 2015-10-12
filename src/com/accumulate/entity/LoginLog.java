package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *   登录日志
 *
 */
@SuppressWarnings("serial")
public class LoginLog implements Serializable{
	/**
	 * 登录
	 */
	private int pager;
	/**
	 *  登录日志总页数
	 */
	private int totlePager;
	/**
	 *  登录日志id
	 */
	private int id;
	/**
	 * 登录用户id
	 */
	private int userId;
	/**
	 * 登录用户名
	 */
	private String userName;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 登录时间
	 */
	private String loginDate;
	/**
	 * 登录结果
	 */
	private int loginResult;
	/**
	 * 登录设备ip
	 */
	private String loginIp;
	/**
	 * 登录备注信息（失败原因）
	 */
	private String remark;
	
	public LoginLog() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public int getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(int loginResult) {
		this.loginResult = loginResult;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	
	

}

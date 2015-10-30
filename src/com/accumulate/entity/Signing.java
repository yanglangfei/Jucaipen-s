package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  签约
 */
@SuppressWarnings("serial")
public class Signing implements Serializable{
	/**
	 * 签约id
	 */
	private int id;
	/**
	 * 签约用户id
	 */
	private int userId;
	/**
	 * 签约讲师id
	 */
	private int teacherId;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 联系方式
	 */
	private String mobileNum;
	/**
	 * 签约时间
	 */
	private String insertDate;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	/**
	 * 券商名称
	 */
	private String QSName;
	/**
	 * 是否生效，0表示未生效，1表示生效,2表示停止服务
	 */
	private int state;
	/**
	 * IP地址
	 */
	private String ip;
	/**
	 * 来源（1:PC，2：手机网页，3：App）
	 */
	private int comeType;
	
	public Signing(int id, int userId, int teacherId, String trueName,
			String mobileNum, String insertDate, String startDate,
			String endDate, String qSName, int state, String ip, int comeType) {
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.trueName = trueName;
		this.mobileNum = mobileNum;
		this.insertDate = insertDate;
		this.startDate = startDate;
		this.endDate = endDate;
		QSName = qSName;
		this.state = state;
		this.ip = ip;
		this.comeType = comeType;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getQSName() {
		return QSName;
	}
	public void setQSName(String qSName) {
		QSName = qSName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getComeType() {
		return comeType;
	}
	public void setComeType(int comeType) {
		this.comeType = comeType;
	}
	

}

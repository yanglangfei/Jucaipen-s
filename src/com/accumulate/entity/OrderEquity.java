package com.accumulate.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ylf
 * 
 *   预约股权
 *
 */
@SuppressWarnings("serial")
public class OrderEquity implements Serializable{
	/**
	 * 预约股权当前页
	 */
	private int pager;
	/**
	 * 预约股权总页数
	 */
	private int totlePager;
	/**
	 * 预约id
	 */
	private int id;
	/**
	 * 预约用户id
	 */
	private int uId;
	/**
	 * 预约用户真实姓名
	 */
	private String trueName;
	/**
	 * 预约用户手机号码
	 */
	private String mobileNum;
	/**
	 * 预约股权评价
	 */
	private String remark;
	/**
	 * 预约股权时间
	 */
	private String insertDate;
	/**
	 * 预约股权投资金额
	 */
	private String touziMoney;
	/**
	 * 预约股权id
	 */
	private int eId;
	/**
	 * 预约人登录设备ip
	 */
	private String uIp;
	/**
	 * 预约时间
	 */
	private Date orderDate;
	/**
	 *  预约分类  1  股权预约    2  私募预约
	 */
	private int orderType;
	
	
	
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderEquity() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getTouziMoney() {
		return touziMoney;
	}
	public void setTouziMoney(String touziMoney) {
		this.touziMoney = touziMoney;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getuIp() {
		return uIp;
	}
	public void setuIp(String uIp) {
		this.uIp = uIp;
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

package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class PayOrder implements Serializable{
	/**
	 * 
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 手机号
	 */
	private String mobileNum;
	/**
	 * 所在省份
	 */
	private int provinceId;
	/**
	 * 所在城市
	 */
	private int cityId;
	/**
	 * 所在县、区
	 */
	private int areaId;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 订单标题
	 */
	private String title;
	/**
	 * 订单编号
	 */
	private String orderCode;
	/**
	 * 订单金额
	 */
	private String allMoney;
	/**
	 * 支付金额
	 */
	private String payMoney;
	/**
	 * 订单生成时间
	 */
	private String insertDate;
	/**
	 * 1：支付宝；2：微信支付；3：易宝支付
	 */
	private int payModel;
	/**
	 * 1：未付款；2：已付款
	 */
	private int payState;
	/**
	 * 付款日期
	 */
	private String payDate;
	/**
	 * 1：正常订单；2：已关闭
	 */
	private int orderState;
	/**
	 * 来源讲师Id(此Id为了统计讲师的绩效)
	 */
	private int fromTeacherId;
	/**
	 * 产品状态（1：正常；4：删除）
	 */
	private int isDelete;
	
	public PayOrder(int id, String userName, String trueName, String mobileNum,
			int provinceId, int cityId, int areaId, String address,
			String title, String orderCode, String allMoney, String payMoney,
			String insertDate, int payModel, int payState, String payDate,
			int orderState, int fromTeacherId, int isDelete) {
		this.id = id;
		this.userName = userName;
		this.trueName = trueName;
		this.mobileNum = mobileNum;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.address = address;
		this.title = title;
		this.orderCode = orderCode;
		this.allMoney = allMoney;
		this.payMoney = payMoney;
		this.insertDate = insertDate;
		this.payModel = payModel;
		this.payState = payState;
		this.payDate = payDate;
		this.orderState = orderState;
		this.fromTeacherId = fromTeacherId;
		this.isDelete = isDelete;
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
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getPayModel() {
		return payModel;
	}
	public void setPayModel(int payModel) {
		this.payModel = payModel;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getFromTeacherId() {
		return fromTeacherId;
	}
	public void setFromTeacherId(int fromTeacherId) {
		this.fromTeacherId = fromTeacherId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
	
	
	

}

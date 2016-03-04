package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *    直播销售状况
 *
 */
@SuppressWarnings("serial")
public class TxtLiveSale implements Serializable{
	private int id;
	/**
	 *   购买用户id 
	 */
	private int userId;
	/**
	 *  直播讲师id
	 */
	private int teacherId;
	/**
	 * 订单号
	 */
	private String orderCode;
	/**
	 *   直播id
	 */
	private int liveId;
	/**
	 *    订单生成时间
	 */
	private String insertDate;
	public TxtLiveSale(int id, int userId, int teacherId, String orderCode,
			int liveId, String insertDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.orderCode = orderCode;
		this.liveId = liveId;
		this.insertDate = insertDate;
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
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getLiveId() {
		return liveId;
	}
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}

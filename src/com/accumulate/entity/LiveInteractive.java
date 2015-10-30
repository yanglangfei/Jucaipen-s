package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   直播互动
 *
 */
@SuppressWarnings("serial")
public class LiveInteractive implements Serializable {
	/**
	 *  互动id
	 */
	private int id;
	/**
	 * 直播id
	 */
	private int liveId;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 *  设备类型  （1：网站PC；2：手机网站；3：直播室PC；4：直播室手机；5：APP）
	 */
	private int deviceType;
	/**
	 * 互动时间
	 */
	private String insertDate;
	/**
	 * 互动内容
	 */
	private String bodys;
	/**
	 * 是否显示
	 */
	private int isShow;
	/**
	 * 用户ip
	 */
	private String ip;
	/**
	 * 上级分类id
	 */
	private int parentaId;
	
	public LiveInteractive(int id, int liveId, int userId, int deviceType,
			String insertDate, String bodys, int isShow, String ip,
			int parentaId) {
		this.id = id;
		this.liveId = liveId;
		this.userId = userId;
		this.deviceType = deviceType;
		this.insertDate = insertDate;
		this.bodys = bodys;
		this.isShow = isShow;
		this.ip = ip;
		this.parentaId = parentaId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLiveId() {
		return liveId;
	}
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getParentaId() {
		return parentaId;
	}
	public void setParentaId(int parentaId) {
		this.parentaId = parentaId;
	}
	
	
	

}

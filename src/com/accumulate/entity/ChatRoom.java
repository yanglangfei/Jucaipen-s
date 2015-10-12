package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 *
 *
 *   直播室
 */
@SuppressWarnings("serial")
public class ChatRoom implements Serializable{
	/**
	 *  房间id
	 */
	private int id;
	/**
	 * 房间名称
	 */
	private String roomName;
	/**
	 * 滚屏公告
	 */
	private String rollNotice;
	/**
	 * 房间通知
	 */
	private String roomNotice;
	/**
	 * 免责申明
	 */
	private String Mianze;
	/**
	 * 版权
	 */
	private String copyRight;
	/**
	 * 是否游客访问  (0--允许访问    1---不允许访问)
	 */
	private int isStopYouke;
	/**
	 * 可访问权限
	 */
	private String userLevel;
	/**
	 * 房间状态
	 */
	private int roomState;
	/**
	 * 是否正在直播
	 */
	private int isLive;
	/**
	 * 直播URL
	 */
	private String liveUrl;
	/**
	 * 
	 */
	private String viedoUrl;
	/**
	 * 创建时间
	 */
	private String createDate;
	/**
	 * 联系电话
	 */
	private String telNum;
	/**
	 * 手机听课id
	 */
	private String moblieLiveId;
	/**
	 * 房间二维码
	 */
	private String erweima;
	/**
	 * 试听天数
	 */
	private int shiTingDay;
	/**
	 * 直播间背景照
	 */
	private String roomFace;
	
	public String getRoomFace() {
		return roomFace;
	}
	public void setRoomFace(String roomFace) {
		this.roomFace = roomFace;
	}
	public ChatRoom() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRollNotice() {
		return rollNotice;
	}
	public void setRollNotice(String rollNotice) {
		this.rollNotice = rollNotice;
	}
	public String getRoomNotice() {
		return roomNotice;
	}
	public void setRoomNotice(String roomNotice) {
		this.roomNotice = roomNotice;
	}
	public String getMianze() {
		return Mianze;
	}
	public void setMianze(String mianze) {
		Mianze = mianze;
	}
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public int getIsStopYouke() {
		return isStopYouke;
	}
	public void setIsStopYouke(int isStopYouke) {
		this.isStopYouke = isStopYouke;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public int getRoomState() {
		return roomState;
	}
	public void setRoomState(int roomState) {
		this.roomState = roomState;
	}
	public int getIsLive() {
		return isLive;
	}
	public void setIsLive(int isLive) {
		this.isLive = isLive;
	}
	public String getLiveUrl() {
		return liveUrl;
	}
	public void setLiveUrl(String liveUrl) {
		this.liveUrl = liveUrl;
	}
	public String getViedoUrl() {
		return viedoUrl;
	}
	public void setViedoUrl(String viedoUrl) {
		this.viedoUrl = viedoUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getMoblieLiveId() {
		return moblieLiveId;
	}
	public void setMoblieLiveId(String moblieLiveId) {
		this.moblieLiveId = moblieLiveId;
	}
	public String getErweima() {
		return erweima;
	}
	public void setErweima(String erweima) {
		this.erweima = erweima;
	}
	public int getShiTingDay() {
		return shiTingDay;
	}
	public void setShiTingDay(int shiTingDay) {
		this.shiTingDay = shiTingDay;
	}
	
	
	


}

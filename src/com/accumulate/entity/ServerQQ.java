package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   在线客服
 *
 */
@SuppressWarnings("serial")
public class ServerQQ implements Serializable{
	
	/**
	 *  客服id
	 */
	private int id;
	/**
	 * 客服名称
	 */
	private String title;
	/**
	 * 客服QQ号
	 */
	private String qqCode;
	/**
	 * 客服所属房间
	 */
	private int roomId;
	/**
	 * 客服排序
	 */
	private int pxId;
	
	public ServerQQ() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQqCode() {
		return qqCode;
	}
	public void setQqCode(String qqCode) {
		this.qqCode = qqCode;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	

}

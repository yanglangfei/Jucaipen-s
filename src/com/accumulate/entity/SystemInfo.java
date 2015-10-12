package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   系统消息
 */
@SuppressWarnings("serial")
public class SystemInfo implements Serializable {
	/**
	 * 系统信息总页数
	 */
	private int totlePage;
	/**
	 * 系统信息当前页
	 */
	private int page;
	/**
	 * 消息id
	 */
	private int id;
	/**
	 * 消息接受者
	 */
	private int receiveId;
	/**
	 * 消息发送者
	 */
	private int sendId;
	/**
	 * 消息标题
	 */
	private String title;
	/**
	 * 消息内容
	 */
	private String bodys;
	/**
	 * 发送消息时间
	 */
	private String sendDate;
	/**
	 * 阅读消息时间
	 */
	private String readDate;
	/**
	 * 消息类型
	 */
	private int type;
	
	public SystemInfo(int id, int receiveId, int sendId, String title,
			String bodys, String sendDate, String readDate, int type) {
		this.id = id;
		this.receiveId = receiveId;
		this.sendId = sendId;
		this.title = title;
		this.bodys = bodys;
		this.sendDate = sendDate;
		this.readDate = readDate;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	

}

package com.accumulate.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ylf
 * 
 *   系统消息阅读
 *
 */
@SuppressWarnings("serial")
public class ReadInfo implements Serializable {
	/**
	 * 读取信息当前页
	 */
	private int pager;
	/**
	 * 读取信息总页数
	 */
	private int totlePager;
	/**
	 * 读取信息id
	 */
	private int id;
	/**
	 * 读取信息用户id
	 */
	private int uId;
	/**
	 * 读取消息id
	 */
	private int messageId;
	/**
	 * 读取信息时间
	 */
	private Date readDate;
	
	public ReadInfo(int id, int uId, int messageId, Date readDate) {
		this.id = id;
		this.uId = uId;
		this.messageId = messageId;
		this.readDate = readDate;
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
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
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

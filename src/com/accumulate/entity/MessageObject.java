package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   聊天消息实体类
 *
 */
@SuppressWarnings("serial")
public class MessageObject implements Serializable {
	/**
	 * 消息唯一标识符
	 */
	private String uuId;
	
	/**
	 * 消息id
	 */
	private int msgId;
	/**
	 *  消息类型   --0 上线   --1 下线   --2聊天
	 */
	private int msgType;
	/**
	 *   发送消息用户id
	 */
	private int fromUser;
	/**
	 *  聊天类型  ---1 公聊   ---2私聊
	 */
	private int chatType;
	/**
	 *  发送消息内容
	 */
	private String message;
	/**
	 * 接受消息用户id  ---默认-1 公聊
	 */
	private int toUser;
	/**
	 * 发送信息用户昵称
	 */
	private String fronName;
	/**
	 *  接受信息用户昵称
	 */
	private String toName;
	/**
	 * 聊天房间id
	 */
	private int roomId;
	/**
	 * 是否审核
	 */
	private int isCheck;
	/**
	 * 发送消息时间
	 */
	private String sendDate;
	/**
	 * 是否是管理员
	 */
	private int isManager;
	/**
	 * 是否是客服
	 */
	private int isServer;
	
	
	public String getUuId() {
		return uuId;
	}
	public void setUuId(String uuId) {
		this.uuId = uuId;
	}
	public int getIsServer() {
		return isServer;
	}
	public void setIsServer(int isServer) {
		this.isServer = isServer;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public MessageObject(int msgType,int fromUser) {
		this.msgType = msgType;
		this.fromUser = fromUser;
	}
	public String getFronName() {
		return fronName;
	}

	public void setFronName(String fronName) {
		this.fronName = fronName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getChatType() {
		return chatType;
	}
	public void setChatType(int chatType) {
		this.chatType = chatType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	
	

}

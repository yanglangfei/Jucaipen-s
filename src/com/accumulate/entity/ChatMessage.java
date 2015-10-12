package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   聊天信息
 *
 */
@SuppressWarnings("serial")
public class ChatMessage implements Serializable{
	
	/**
	 *  聊天信息id
	 */
	private int id;
	/**
	 * 聊天信息内容
	 */
	private String messageBody;
	/**
	 *  发送信息者id
	 */
	private int senderId;
	/**
	 * 接受信息者id
	 */
	private int receiverId;
	/**
	 * 发送信息者名称
	 */
	private String senderName;
	/**
	 * 接受信息者名称
	 */
	private String receiverName;
	/**
	 * 发送信息时间
	 */
	private String sendDate;
	/**
	 * 是否审核
	 */
	private int isCheck;
	/**
	 * 聊天室id
	 */
	private int roomId;
	/**
	 * 购买商品id
	 */
	private int buyProductId;
	private int receiverBuyId;
	private int receiveManager;
	private int sendManager;
	private int sendServerId;
	private int receiverServerId;
	/**
	 * 消息类型
	 */
	private int messageType;
	
	public ChatMessage() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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
	public int getBuyProductId() {
		return buyProductId;
	}
	public void setBuyProductId(int buyProductId) {
		this.buyProductId = buyProductId;
	}
	public int getReceiverBuyId() {
		return receiverBuyId;
	}
	public void setReceiverBuyId(int receiverBuyId) {
		this.receiverBuyId = receiverBuyId;
	}
	public int getReceiveManager() {
		return receiveManager;
	}
	public void setReceiveManager(int receiveManager) {
		this.receiveManager = receiveManager;
	}
	public int getSendManager() {
		return sendManager;
	}
	public void setSendManager(int sendManager) {
		this.sendManager = sendManager;
	}
	public int getSendServerId() {
		return sendServerId;
	}
	public void setSendServerId(int sendServerId) {
		this.sendServerId = sendServerId;
	}
	public int getReceiverServerId() {
		return receiverServerId;
	}
	public void setReceiverServerId(int receiverServerId) {
		this.receiverServerId = receiverServerId;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	
	

}

package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  问题对答
 *
 */
@SuppressWarnings("serial")
public class Question implements Serializable{
	/**
	 *  被提问讲师id
	 */
	private int teacherId;
	/**
	 * 讲师照片
	 */
	private String image;
	/**
	 * 讲师昵称
	 */
	private String nickName;
	/**
	 * 讲师头衔
	 */
	private String level;
	/**
	 *  是否加V  0 是   
	 */
	private int isV;
	/**
	 * 提问者昵称
	 */
	private String askName;
	/**
	 * 提问内容
	 */
	private String askBodys;
	/**
	 * 提问状态
	 */
	private int isReply;
	/**
	 * 回复内容
	 */
	private String answerBody;
	
	public Question(int teacherId, String image, String nickName, String level,
			int isV, String askName, String askBodys, int isReply,
			String answerBody) {
		this.teacherId = teacherId;
		this.image = image;
		this.nickName = nickName;
		this.level = level;
		this.isV = isV;
		this.askName = askName;
		this.askBodys = askBodys;
		this.isReply = isReply;
		this.answerBody = answerBody;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getIsV() {
		return isV;
	}
	public void setIsV(int isV) {
		this.isV = isV;
	}
	public String getAskName() {
		return askName;
	}
	public void setAskName(String askName) {
		this.askName = askName;
	}
	public String getAskBodys() {
		return askBodys;
	}
	public void setAskBodys(String askBodys) {
		this.askBodys = askBodys;
	}
	
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	

}

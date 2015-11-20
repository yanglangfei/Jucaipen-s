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
	 *  当前页数
	 */
	private int page;
	/**
	 *   总页数
	 */
	private int totlePage;
	/**
	 *  被提问讲师id
	 */
	private int teacherId;
	/**
	 * 提问id
	 */
	private int askId;
	/**
	 *  提问时间
	 */
	private String askDate;
	/**
	 * 讲师照片
	 */
	private String headFace;
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
	private String askBody;
	/**
	 * 提问状态
	 */
	private int isReply;
	/**
	 * 回复内容
	 */
	private String answerBody;
	
	public Question(int teacherId, String headFace, String nickName, String level,
			int isV, String askName, String askBody, int isReply,
			String answerBody) {
		this.teacherId = teacherId;
		this.headFace = headFace;
		this.nickName = nickName;
		this.level = level;
		this.isV = isV;
		this.askName = askName;
		this.askBody = askBody;
		this.isReply = isReply;
		this.answerBody = answerBody;
	}
	
	
	
	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public int getTotlePage() {
		return totlePage;
	}



	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}



	public String getAskDate() {
		return askDate;
	}


	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}


	public int getAskId() {
		return askId;
	}

	public void setAskId(int askId) {
		this.askId = askId;
	}

	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getHeadFace() {
		return headFace;
	}


	public void setHeadFace(String headFace) {
		this.headFace = headFace;
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
	public String getAskBody() {
		return askBody;
	}
	public void setAskBody(String askBody) {
		this.askBody = askBody;
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

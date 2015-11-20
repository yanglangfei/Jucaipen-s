package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *   教师回复
 */
@SuppressWarnings("serial")
public class Answer implements Serializable{
	/**
	 * 当前页数
	 */
	private int page;
	/**
	 * 总页数
	 */
	private int totlePage;
	/**
	 * id
	 */
	private int id;
	/**
	 * 回答问题内容
	 */
	private String answerBody;
	/**
	 * 讲师id
	 */
	private int teacherId;
	/**
	 * 回答问题时间
	 */
	private String answerDate;
	/**
	 * 评论
	 */
	private String remark;
	/**
	 * 回答问题的id
	 */
	private int askId;
	/**
	 * 评分
	 */
	private int pingFen;
	
	public Answer() {
		super();
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getAskId() {
		return askId;
	}
	public void setAskId(int askId) {
		this.askId = askId;
	}
	public int getPingFen() {
		return pingFen;
	}
	public void setPingFen(int pingFen) {
		this.pingFen = pingFen;
	}
	
	
	
	
	

}

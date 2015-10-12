package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   新闻评论
 */
@SuppressWarnings("serial")
public class NewsComment implements Serializable {
	/**
	 * 新闻评论总页数
	 */
	private int totlePager;
	
	/**
	 * 新闻评论当前页数
	 */
	private int pager;
	/**
	 * 评论id
	 */
	private int id;
	/**
	 * 用户id
	 */
	private int uId;
	/**
	 *   parentId
	 */
	private int pId;
	/**
	 * 新闻id
	 */
	private int nId;
	/**
	 * 评论内容
	 */
	private String bodys;
	/**
	 * 评论时间
	 */
	private String insertDate;
	/**
	 * 获赞数量
	 */
	private int goodNum;
	/**
	 * 是否显示（0 不显示   1显示）
	 */
	private int isShow;
	/**
	 * 回复数量
	 */
	private int repCount;
	/**
	 *   评论分类 ---0   新闻评论    --- 1 视频评论
	 */
	private int CommType;
	
	public NewsComment() {
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
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getRepCount() {
		return repCount;
	}
	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}

	public int getCommType() {
		return CommType;
	}

	public void setCommType(int commType) {
		CommType = commType;
	}
	
	
	

}

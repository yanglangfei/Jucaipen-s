package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   新闻评论回复
 *
 */
@SuppressWarnings("serial")
public class NewsCommRes implements Serializable {
	/**
	 *  新闻评论回复当前页
	 */
	private int pager;
	/**
	 *  新闻评论回复总页数
	 */
	private int totlePager;
	/**
	 * 回复id
	 */
	private int id;
	/**
	 * 回复用户id
	 */
	private int uId;
	/**
	 * 新闻id
	 */
	private int nId;
	/**
	 * 评论id
	 */
	private int commId;
	/**
	 * 回应主体
	 */
	private String bodys;
	/**
	 * 回应时间
	 */
	private String insertDate;
	/**
	 * 获赞数量
	 */
	private int goodNum;
	/**
	 * 是否显示（ 0 不显示  1 显示）
	 */
	private int isShow;
	
	public NewsCommRes(int id, int uId, int nId, int commId, String bodys,
			String insertDate, int goodNum, int isShow) {
		this.id = id;
		this.uId = uId;
		this.nId = nId;
		this.commId = commId;
		this.bodys = bodys;
		this.insertDate = insertDate;
		this.goodNum = goodNum;
		this.isShow = isShow;
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
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public int getCommId() {
		return commId;
	}
	public void setCommId(int commId) {
		this.commId = commId;
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

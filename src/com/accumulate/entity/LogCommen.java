package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *   日志评论
 *
 */
@SuppressWarnings("serial")
public class LogCommen implements Serializable{
	/**
	 * 日志评论当前页
	 */
	private int page;
	
	/**
	 * 日志评论总页数
	 */
	private int totlePage;
	/**
	 * 日志评论id
	 */
	private int id;
	/**
	 * 评论用户id
	 */
	private int userId;
	/**
	 * 上级分类id
	 */
	private int parentId;
	/**
	 * 评论日志id
	 */
	private int logId;
	/**
	 * 评论内容
	 */
	private String bodys;
	/**
	 * 评论时间
	 */
	private String insertDate;
	/**
	 * 点赞数
	 */
	private int goods;
	/**
	 * 是否显示
	 */
	private int isShow;
	/**
	 * 回复人数
	 */
	private int repCount;
	
	public LogCommen(int id, int userId, int parentId, int logId, String bodys,
			String insertDate, int goods, int isShow, int repCount) {
		this.id = id;
		this.userId = userId;
		this.parentId = parentId;
		this.logId = logId;
		this.bodys = bodys;
		this.insertDate = insertDate;
		this.goods = goods;
		this.isShow = isShow;
		this.repCount = repCount;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
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
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
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
	

}

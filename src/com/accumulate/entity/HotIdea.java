package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 * 热门观点
 *
 */
@SuppressWarnings("serial")
public class HotIdea implements Serializable{
	/**
	 * 数据当前页数
	 */
	private int page;
	/**
	 * 数据总页数
	 */
	private int totlePgae;
	/**
	 *  观点id
	 */
	private int id;
	/**
	 * 观点标题
	 */
	private String title;
	/**
	 * 观点内容
	 */
	private String bodys;
	/**
	 * 点赞数量
	 */
	private int goods;
	/**
	 * 点击数
	 */
	private int hits;
	/**
	 * 评论数
	 */
	private int commens;
	/**
	 * 分类id
	 */
	private int classId;
	/**
	 * 关键字
	 */
	private String keyWord;
	/**
	 * 发表观点时间
	 */
	private String insertDate;
	/**
	 * 发表观点教师id
	 */
	private int teacherId;
	/**
	 * 相关图片
	 */
	private String logImage;
	public HotIdea() {
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotlePgae() {
		return totlePgae;
	}

	public void setTotlePgae(int totlePgae) {
		this.totlePgae = totlePgae;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getCommens() {
		return commens;
	}
	public void setCommens(int commens) {
		this.commens = commens;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getLogImage() {
		return logImage;
	}
	public void setLogImage(String logImage) {
		this.logImage = logImage;
	}
	
	
	
	
	
	
	
	
	
	
	

}

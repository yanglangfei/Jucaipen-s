package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   直播信息
 *
 */
@SuppressWarnings("serial")
public class TextLive implements Serializable{
	/**
	 * 文字直播当前页数
	 */
	private int page;
	/**
	 *  文字直播总页数
	 */
	private int totlePage;
	/**
	 * 直播id
	 */
	private int id;
	/**
	 * 直播标题
	 */
	private String title;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	/**
	 * 点赞数量
	 */
	private int goods;
	/**
	 * 人气
	 */
	private int moods;
	/**
	 * 是否游客
	 */
	private int isYouKe;
	/**
	 * 讲师id
	 */
	private int teacherId;
	/**
	 * 是否结束   0 正在进行 1已结束 2未开始             
	 */
	private int isEnd;
	/**
	 *  价格
	 */
	private double price;
	/**
	 * 直播类型
	 */
	private int liveType;
	
	public TextLive() {
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getMoods() {
		return moods;
	}
	public void setMoods(int moods) {
		this.moods = moods;
	}
	public int getIsYouKe() {
		return isYouKe;
	}
	public void setIsYouKe(int isYouKe) {
		this.isYouKe = isYouKe;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getLiveType() {
		return liveType;
	}



	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}
	
	
	
	

}

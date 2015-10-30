package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *
 *  名家看盘 TextLive
 */
@SuppressWarnings("serial")
public class ReadTape implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 开始时候
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	/**
	 * 点赞数
	 */
	private int goods;
	/**
	 * 人气
	 */
	private int fans;
	/**
	 * 是否游客
	 */
	private int isYouKe;
	/**
	 * 教师id
	 */
	private int teacherId;
	/**
	 * 是否结束 0 正在进行  1已结束  2 未开始
	 */
	private int isEnd;
	
	public ReadTape() {
		super();
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
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
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
	
	
	
	
	
	
	

}

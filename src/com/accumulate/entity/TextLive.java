package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ֱ����Ϣ
 *
 */
@SuppressWarnings("serial")
public class TextLive implements Serializable{
	/**
	 * ����ֱ����ǰҳ��
	 */
	private int page;
	/**
	 *  ����ֱ����ҳ��
	 */
	private int totlePage;
	/**
	 * ֱ��id
	 */
	private int id;
	/**
	 * ֱ������
	 */
	private String title;
	/**
	 * ��ʼʱ��
	 */
	private String startDate;
	/**
	 * ����ʱ��
	 */
	private String endDate;
	/**
	 * ��������
	 */
	private int goods;
	/**
	 * ����
	 */
	private int moods;
	/**
	 * �Ƿ��ο�
	 */
	private int isYouKe;
	/**
	 * ��ʦid
	 */
	private int teacherId;
	/**
	 * �Ƿ����   0 ���ڽ��� 1�ѽ��� 2δ��ʼ
	 */
	private int isEnd;
	
	public TextLive(int id, String title, String startDate, String endDate,
			int goods, int moods, int isYouKe, int teacherId, int isEnd) {
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goods = goods;
		this.moods = moods;
		this.isYouKe = isYouKe;
		this.teacherId = teacherId;
		this.isEnd = isEnd;
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
	
	

}
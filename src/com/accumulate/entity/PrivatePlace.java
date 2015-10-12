package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   阳光私募
 *
 */
@SuppressWarnings("serial")
public class PrivatePlace implements Serializable {
	/**
	 *   私募id
	 */
	private int id;
	/**
	 * 私募标题
	 */
	private String title;
	/**
	 *  经理名称
	 */
	private String managerName;
	/**
	 * 连接专题页面地址
	 */
	private String LinkPageUrl;
	/**
	 *  经理图片
	 */
	private String ManagerImage;
	/**
	 *  投资门槛
	 */
	private String MenKan;
	/**
	 *  评级
	 */
	private int grade;
	/**
	 *  今年收益
	 */
	private String ThisYearShouyi;
	/**
	 *  去年收益
	 */
	private String LastYearShouyi;
	/**
	 * 推荐理由
	 */
	private String TuijianInfo;
	/**
	 * 是否首页显示
	 */
	private int IsIndex;
	/**
	 * 是否推荐
	 */
	private int IsTuijian;
	/**
	 * 是否置顶
	 */
	private int IsTop;
	
	public PrivatePlace(int id, String title, String managerName) {
		this.id = id;
		this.title = title;
		this.managerName = managerName;
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
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getLinkPageUrl() {
		return LinkPageUrl;
	}
	public void setLinkPageUrl(String linkPageUrl) {
		LinkPageUrl = linkPageUrl;
	}
	public String getManagerImage() {
		return ManagerImage;
	}
	public void setManagerImage(String managerImage) {
		ManagerImage = managerImage;
	}
	public String getMenKan() {
		return MenKan;
	}
	public void setMenKan(String menKan) {
		MenKan = menKan;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getThisYearShouyi() {
		return ThisYearShouyi;
	}
	public void setThisYearShouyi(String thisYearShouyi) {
		ThisYearShouyi = thisYearShouyi;
	}
	public String getLastYearShouyi() {
		return LastYearShouyi;
	}
	public void setLastYearShouyi(String lastYearShouyi) {
		LastYearShouyi = lastYearShouyi;
	}
	public String getTuijianInfo() {
		return TuijianInfo;
	}
	public void setTuijianInfo(String tuijianInfo) {
		TuijianInfo = tuijianInfo;
	}
	public int getIsIndex() {
		return IsIndex;
	}
	public void setIsIndex(int isIndex) {
		IsIndex = isIndex;
	}
	public int getIsTuijian() {
		return IsTuijian;
	}
	public void setIsTuijian(int isTuijian) {
		IsTuijian = isTuijian;
	}
	public int getIsTop() {
		return IsTop;
	}
	public void setIsTop(int isTop) {
		IsTop = isTop;
	}
	

}

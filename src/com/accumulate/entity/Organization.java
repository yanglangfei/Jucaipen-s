package com.accumulate.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ylf
 * 
 *   聚财盆机构
 *
 */
@SuppressWarnings("serial")
public class Organization implements Serializable {
	/**
	 * 组织机构当前页
	 */
	private int pager;
	/**
	 * 组织机构总页数
	 */
	private int totlePager;
	/**
	 * 机构id
	 */
	private int id;
	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 英文名称
	 */
	private String nameEn;
	/**
	 * 机构简称
	 */
	private String simpleName;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 机构类型
	 */
	private String quality;
	/**
	 * 投资领域
	 */
	private String investmentArea;
	/**
	 * 机构logo
	 */
	private String logo;
	/**
	 * 机构描述
	 */
	private String descript;
	/**
	 * 插入数据时间
	 */
	private Date insertDate;
	/**
	 * 排序
	 */
	private int sortId;
	

	public Organization(int id, String name, String nameEn, String simpleName,
			Date createDate, String quality, String investmentArea,
			String logo, String descript, Date insertDate, int sortId) {
		this.id = id;
		this.name = name;
		this.nameEn = nameEn;
		this.simpleName = simpleName;
		this.createDate = createDate;
		this.quality = quality;
		this.investmentArea = investmentArea;
		this.logo = logo;
		this.descript = descript;
		this.insertDate = insertDate;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getInvestmentArea() {
		return investmentArea;
	}
	public void setInvestmentArea(String investmentArea) {
		this.investmentArea = investmentArea;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
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

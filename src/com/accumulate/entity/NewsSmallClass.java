package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 *  新闻二级分类
 */
@SuppressWarnings("serial")
public class NewsSmallClass implements Serializable{
	/**
	 * 二级分类id
	 */
	private int id;
	/**
	 * 二级分类所属的一级分类id
	 */
	private int BigId;
	/**
	 * 二级分类名称
	 */
	private String samllName;
	/**
	 * 关键字
	 */
	private String keyWord;
	/**
	 * 描述
	 */
	private String descript;
	/**
	 * 模版路径
	 */
	private String templeteName;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 排序id
	 */
	private int pxId;
	/**
	 *  连接地址
	 */
	private String linkUrl;
	
	
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public NewsSmallClass(int id,String samllName) {
		this.id = id;
		this.samllName = samllName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBigId() {
		return BigId;
	}
	public void setBigId(int bigId) {
		BigId = bigId;
	}
	public String getSamllName() {
		return samllName;
	}
	public void setSamllName(String samllName) {
		this.samllName = samllName;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getTempleteName() {
		return templeteName;
	}
	public void setTempleteName(String templeteName) {
		this.templeteName = templeteName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	
	

}

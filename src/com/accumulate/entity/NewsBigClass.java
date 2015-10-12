package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *   新闻总分类
 *
 */
@SuppressWarnings("serial")
public class NewsBigClass implements Serializable{
	/**
	 * 总分类id
	 */
	private int id;
	/**
	 * 总分类名称
	 */
	private String bigName;
	/**
	 * 关键字
	 */
	private String keyWord;
	/**
	 * 描述
	 */
	private String descript;
	/**
	 *   连接地址
	 */
	private String linkUrl;
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
	
	public NewsBigClass(int id, String bigName, String keyWord,
			String descript, String templeteName, String filePath, int pxId) {
		this.id = id;
		this.bigName = bigName;
		this.keyWord = keyWord;
		this.descript = descript;
		this.templeteName = templeteName;
		this.filePath = filePath;
		this.pxId = pxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
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
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	
	

}

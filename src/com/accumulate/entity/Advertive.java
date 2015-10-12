package com.accumulate.entity;

/**
 * @author Administrator
 *
 *
 *   广告bean
 */
public class Advertive {
	/**
	 *   广告id
	 */
	private int id;
	/**
	 * 所属幻灯id
	 */
	private int pId;
	/**
	 *  标题
	 */
	private String title;
	/**
	 * 连接 URL
	 */
	private String linkUrl;
	/**
	 * 图片URL
	 */
	private String imageUrl;
	/**
	 * 排序
	 */
	private int sortId;
	
	public Advertive(int id, int pId, String title, String linkUrl,
			String imageUrl, int sortId) {
		this.id = id;
		this.pId = pId;
		this.title = title;
		this.linkUrl = linkUrl;
		this.imageUrl = imageUrl;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	

}

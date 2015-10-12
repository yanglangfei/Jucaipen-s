package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *         新闻类
 * 
 */
@SuppressWarnings("serial")
public class News implements Serializable {
	/**
	 * 总页数
	 */
	private int totlePager;
	/**
	 * 当前新闻页数
	 */
	private int pager;
	/**
	 * 模块名称
	 */
	private String modelName;
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻描述
	 */
	private String descript;
	/**
	 * 作者
	 */
	private String reporter;
	/**
	 * 新闻关键字
	 */
	private String KeyWord;
	/**
	 * 新闻id
	 */
	private int id;
	/**
	 * 新闻内容
	 */
	private String Bodys;
	/**
	 * 新闻图片链接
	 */
	private String ImageUrl;
	/**
	 *   新闻图标缩略图
	 */
	private String ImagesThumb;
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 新闻大类
	 */
	private int bigId;
	/**
	 * 新闻小类
	 */
	private int smallId;
	/**
	 * 来源
	 */
	private int comeFrom;
	/**
	 * 点击量
	 */
	private int hits;
	/**
	 * 评论数
	 */
	private int comments;
	/**
	 * 发布时间
	 */
	private String publishDate;
	/**
	 * 发布者
	 */
	private String publishUser;
	/**
	 * 是否置顶（1 置顶 0不置顶）
	 */
	private int isTop;
	/**
	 * 是否精选
	 */
	private int isBest;
	/**
	 * 是否是图片新闻
	 */
	private int isImage;
	/**
	 * 是否首页显示
	 */
	private int isIndex;
	/**
	 * 相关新闻
	 */
	private String relatedNews;
	/**
	 * 新闻网址
	 */
	private String htmlPath;
	/**
	 * 新闻来源
	 */
	private String from;
	
	

	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public String getImagesThumb() {
		return ImagesThumb;
	}

	public void setImagesThumb(String imagesThumb) {
		ImagesThumb = imagesThumb;
	}

	public News(int id) {
		this.id=id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBodys() {
		return Bodys;
	}

	public void setBodys(String bodys) {
		Bodys = bodys;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getBigId() {
		return bigId;
	}

	public void setBigId(int bigId) {
		this.bigId = bigId;
	}

	public int getSmallId() {
		return smallId;
	}

	public void setSmallId(int smallId) {
		this.smallId = smallId;
	}

	public int getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(int comeFrom) {
		this.comeFrom = comeFrom;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public int getIsBest() {
		return isBest;
	}

	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}

	public int getIsImage() {
		return isImage;
	}

	public void setIsImage(int isImage) {
		this.isImage = isImage;
	}

	public int getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}

	public String getRelatedNews() {
		return relatedNews;
	}

	public void setRelatedNews(String relatedNews) {
		this.relatedNews = relatedNews;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

package com.accumulate.entity;

import java.io.Serializable;

import javax.xml.crypto.Data;

/**
 * @author ylf
 * 
 *   学堂视频
 *
 */
@SuppressWarnings("serial")
public class Video implements Serializable{
	/**
	 *   视频id
	 */
	private int id;
	/**
	 * 视频标题
	 */
	private String title;
	/**
	 * 关键字
	 */
	private String keyWords;
	/**
	 * 描述
	 */
	private String descript;
	/**
	 * 分类id
	 */
	private int classId;
	/**
	 * 图片
	 */
	private String Images;
	/**
	 * 缩略图
	 */
	private String ImagesThumb;
	/**
	 * 视频URL
	 */
	private String VideoUrl;
	/**
	 * 视频日期
	 */
	private Data VideoDate;
	/**
	 * 点击量
	 */
	private int HitCount;
	/**
	 * 插入时间
	 */
	private String InsertDate;
	/**
	 * 描述信息
	 */
	private String body;
	/**
	 * 授课讲师id
	 */
	private int TearcherId;
	/**
	 * 评论数
	 */
	private int CommCount;
	/**
	 * 　是否首页显示　（１　首页　　１　非首页显示）
	 */
	private int IsIndex;
	/**
	 * 是否推荐　（　１　推荐　　　　０　非推荐　）
	 */
	private int IsTuijian;
	/**
	 * 是否置顶　（　１　置顶　　０　非置顶　）
	 */
	private int IsTop;
	/**
	 * 　是否公开课　（　１　是　　０　　不是　）
	 */
	private int IsPublic;
	/**
	 * 是否是本站视频　（　１　是　０　不是　）
	 */
	private int IsMySiteVideo;
	
	public Video(int id, String title) {
		this.id = id;
		this.title = title;
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
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	public String getImagesThumb() {
		return ImagesThumb;
	}
	public void setImagesThumb(String imagesThumb) {
		ImagesThumb = imagesThumb;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public Data getVideoDate() {
		return VideoDate;
	}
	public void setVideoDate(Data videoDate) {
		VideoDate = videoDate;
	}
	public int getHitCount() {
		return HitCount;
	}
	public void setHitCount(int hitCount) {
		HitCount = hitCount;
	}
	public String getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getTearcherId() {
		return TearcherId;
	}
	public void setTearcherId(int tearcherId) {
		TearcherId = tearcherId;
	}
	public int getCommCount() {
		return CommCount;
	}
	public void setCommCount(int commCount) {
		CommCount = commCount;
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
	public int getIsPublic() {
		return IsPublic;
	}
	public void setIsPublic(int isPublic) {
		IsPublic = isPublic;
	}
	public int getIsMySiteVideo() {
		return IsMySiteVideo;
	}
	public void setIsMySiteVideo(int isMySiteVideo) {
		IsMySiteVideo = isMySiteVideo;
	}
	
	
	
}

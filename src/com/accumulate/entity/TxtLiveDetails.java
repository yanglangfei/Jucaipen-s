package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */

@SuppressWarnings("serial")
public class TxtLiveDetails implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * 相关直播id
	 */
	private int relate_liveId;
	/**
	 * 相关标题
	 */
	private int relate_titleId;
	/**
	 * 内容
	 */
	private String bodys;
	/**
	 * 图片路径
	 */
	private String image;
	/**
	 * 直播类型
	 */
	private int liveType;
	/**
	 * 上传时间
	 */
	private String insertDate;
	/**
	 * 是否支付
	 */
	private int isPay;
	public TxtLiveDetails(int id, int relate_liveId, int relate_titleId,
			String bodys, String image, int liveType, String insertDate) {
		this.id = id;
		this.relate_liveId = relate_liveId;
		this.relate_titleId = relate_titleId;
		this.bodys = bodys;
		this.image = image;
		this.liveType = liveType;
		this.insertDate = insertDate;
	}
	
	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelate_liveId() {
		return relate_liveId;
	}
	public void setRelate_liveId(int relate_liveId) {
		this.relate_liveId = relate_liveId;
	}
	public int getRelate_titleId() {
		return relate_titleId;
	}
	public void setRelate_titleId(int relate_titleId) {
		this.relate_titleId = relate_titleId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLiveType() {
		return liveType;
	}
	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	
	

}

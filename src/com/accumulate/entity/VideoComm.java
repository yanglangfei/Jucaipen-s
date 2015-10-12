package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *    视频评论bean
 *
 */
@SuppressWarnings("serial")
public class VideoComm implements Serializable {
    /**
     *  评论id
     */
    private int id;
    /**
     *  评论视频id
     */
    private int videoId;
    /**
     *  评论用户id
     */
    private int userId;
    /**
     *  评论内容
     */
    private String bodys;
    /**
     *  点赞数量
     */
    private int goodCount;
    /**
     *  回复数量
     */
    private int replyCount;
    /**
     *  评论时间
     */
    private String insertDate;
    /**
     *  评论用户ip
     */
    private String ip;
    /**
     *  评论是否显示
     */
    private int isShow;
    
	public VideoComm(int id, int videoId, int userId, String bodys) {
		super();
		this.id = id;
		this.videoId = videoId;
		this.userId = userId;
		this.bodys = bodys;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
    
    
}

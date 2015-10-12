package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *   聊天表情
 *
 */
@SuppressWarnings("serial")
public class ChatFace implements Serializable{
     /**
     *   聊天表情id
     */
    private int id;
     /**
     * 聊天表情URL
     */
    private String faceUrl;
     /**
     * 聊天表情描述
     */
    private String title;
     /**
     * 排序id
     */
    private int pxId;
     
	public ChatFace() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFaceUrl() {
		return faceUrl;
	}
	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
     
}

package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *         表情列表
 * 
 */
@SuppressWarnings("serial")
public class ExpressionInfo implements Serializable {
	/**
	 * 表情id
	 */
	private int id;
	/**
	 * 分类id
	 */
	private int classId;
	/**
	 * 标题
	 */
	private String Title;
	/**
	 * 表情连接地址
	 */
	private String faceurl;
	/**
	 * 表情排序
	 */
	private int pxId;

	public ExpressionInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getFaceurl() {
		return faceurl;
	}

	public void setFaceurl(String faceurl) {
		this.faceurl = faceurl;
	}

	public int getPxId() {
		return pxId;
	}

	public void setPxId(int pxId) {
		this.pxId = pxId;
	}

}

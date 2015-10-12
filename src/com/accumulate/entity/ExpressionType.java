package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *    表情分类信息
 */
@SuppressWarnings("serial")
public class ExpressionType implements Serializable {
	/**
	 *   表情分类id
	 */
	private int id;
	/**
	 *  分类名称
	 */
	private String className;
	/**
	 *  排序
	 */
	private int pxId;
	public ExpressionType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	

}

package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *    邮箱、短信模版
 *
 */
@SuppressWarnings("serial")
public class MessageModel implements Serializable{
	/**
	 *  模版id
	 */
	private int id;
	/**
	 * 模版类型
	 */
	private int modelType;
	/**
	 *  备注
	 */
	private String title;
	/**
	 *  模版内容
	 */
	private String modelContent;
	
	public MessageModel() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModelType() {
		return modelType;
	}
	public void setModelType(int modelType) {
		this.modelType = modelType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}
	

}

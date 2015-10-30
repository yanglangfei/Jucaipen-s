package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 * 提问分类
 */
@SuppressWarnings("serial")
public class AskClass implements Serializable{
	/**
	 * 分类id
	 */
	private int id;
	/**
	 * 分类名称
	 */
	private String className;
	
	public AskClass(int id, String className) {
		super();
		this.id = id;
		this.className = className;
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
	
	

}

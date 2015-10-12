package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *         视频分类
 * 
 */
@SuppressWarnings("serial")
public class VideoType implements Serializable {
	/**
	 *   视频id
	 */
	private int typeId;
	/**
	 *  上级分类id
	 */
	private int parentId;
	/**
	 *   关键字
	 */
	private String keyWord;
	/**
	 *   描述
	 */
	private String descript;
	/**
	 *  分类名称
	 */
	private String typeName;
	/**
	 *   排序id
	 */
	private int sortId;
	/**
	 * 是否删除（　１　删除　　０　正常　）
	 */
	private int isDelete;

	public VideoType(String typeName, int typeId) {
		this.typeName = typeName;
		this.typeId = typeId;
	}
	

	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


	public String getDescript() {
		return descript;
	}


	public void setDescript(String descript) {
		this.descript = descript;
	}


	public int getSortId() {
		return sortId;
	}


	public void setSortId(int sortId) {
		this.sortId = sortId;
	}


	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}

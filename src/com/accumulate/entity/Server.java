package com.accumulate.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YLF
 *   
 *
 */
@SuppressWarnings("serial")
public class Server implements Serializable{
	private int id;
	private int classId;
	private String title;
	private Date insertDate;
	private String sendUser;
	private String bodys;
	
	public Server(int id, int classId, String title, Date insertDate,
			String sendUser, String bodys) {
		this.id = id;
		this.classId = classId;
		this.title = title;
		this.insertDate = insertDate;
		this.sendUser = sendUser;
		this.bodys = bodys;
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
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	

}

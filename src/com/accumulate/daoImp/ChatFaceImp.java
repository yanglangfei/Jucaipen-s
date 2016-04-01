package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.ChatFaceDao;
import com.accumulate.entity.ChatFace;
import com.accumulate.utils.JdbcUtil;

public class ChatFaceImp implements ChatFaceDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ChatFace> chatFaces=new ArrayList<ChatFace>();

	public List<ChatFace> findAll() {
		//��ȡ�����������
		try {
			dbConn=JdbcUtil.connVideoSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT Id,FaceUrl,FaceTitle,PxId FROM Chat_Face");
			chatFaces=getChatFace(res);
			return chatFaces;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	

	public ChatFace findFaceById(int id) {
		//����id��ȡ�������
		try {
			dbConn=JdbcUtil.connVideoSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT Id,FaceUrl,FaceTitle,PxId FROM Chat_Face");
			chatFaces=getChatFace(res);
			if(chatFaces!=null&&chatFaces.size()>0){
				return chatFaces.get(0);
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
  
	
	private List<ChatFace> getChatFace(ResultSet result) {
		//��ȡ����������
		chatFaces.clear();
		try {
			while (result.next()) {
				int Id=result.getInt(1);
				String FaceUrl=result.getString(2);
				String FaceTitle=result.getString(3);
				int PxId=result.getInt(4);
				ChatFace face=new ChatFace();
				face.setId(Id);
				face.setPxId(PxId);
				face.setFaceUrl(FaceUrl);
				face.setTitle(FaceTitle);
				chatFaces.add(face);
			}
			return chatFaces;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, result);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

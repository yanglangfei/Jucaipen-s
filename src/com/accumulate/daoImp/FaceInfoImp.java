package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.FaceInfoDao;
import com.accumulate.entity.ExpressionInfo;
import com.accumulate.utils.JdbcUtil;

public class FaceInfoImp implements FaceInfoDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ExpressionInfo> eInfos = new ArrayList<ExpressionInfo>();

	public List<ExpressionInfo> findAllFaceInfo() {
		// 获取所有的表情信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_face");
			eInfos = getExpressionInfo(res);
			return eInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ExpressionInfo> findFaceInfoByTypeId(int typeId) {
		// 根据分类id获取对应表情信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_face WHERE ClassId="
					+ typeId);
			eInfos = getExpressionInfo(res);
			return eInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ExpressionInfo findFaceInfoById(int id) {
		//根据id获取单个表情信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_face WHERE Id="+id);
			eInfos=getExpressionInfo(res);
			if(eInfos.size()>0){
				return eInfos.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<ExpressionInfo> getExpressionInfo(ResultSet result) {
		// 获取表情信息
		eInfos.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int typeId = result.getInt("ClassId");
				String title = result.getString("Title");
				String faceurl = result.getString("faceurl");
				int pxId = result.getInt("PxId");
				ExpressionInfo info = new ExpressionInfo();
				info.setId(id);
				info.setTitle(title);
				info.setClassId(typeId);
				info.setFaceurl(faceurl);
				info.setPxId(pxId);
				eInfos.add(info);
			}
			return eInfos;
		} catch (Exception e) {
		}
		return null;
	}

}

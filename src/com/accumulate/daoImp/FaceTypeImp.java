package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.FaceTypeDao;
import com.accumulate.entity.ExpressionType;
import com.accumulate.utils.JdbcUtil;

public class FaceTypeImp implements FaceTypeDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ExpressionType> eTypes = new ArrayList<ExpressionType>();

	public List<ExpressionType> findAllFace() {
		// 获取所有表情分类
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_faceClass");
			eTypes = getExpressionType(res);
			return eTypes;
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

	public ExpressionType findFaceById(int id) {
		// 根据id 获取表情分类信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_faceClass WHERE Id=" + id);
			eTypes = getExpressionType(res);
			if (eTypes.size() > 0) {
				return eTypes.get(0);
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

	private List<ExpressionType> getExpressionType(ResultSet result) {
		// 获取表情列表
		eTypes.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String typeName = result.getString("ClassName");
				int pxId = result.getInt("PxId");
				ExpressionType type = new ExpressionType();
				type.setClassName(typeName);
				type.setId(id);
				type.setPxId(pxId);
				eTypes.add(type);
			}
			return eTypes;
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

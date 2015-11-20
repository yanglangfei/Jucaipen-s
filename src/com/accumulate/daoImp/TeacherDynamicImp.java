package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.TeacherDynamicDao;
import com.accumulate.entity.TeacherDynamic;
import com.accumulate.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 * 
 *         ½²Ê¦¶¯Ì¬
 */
public class TeacherDynamicImp implements TeacherDynamicDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<TeacherDynamic> dynamics = new ArrayList<TeacherDynamic>();

	public int insertDynamic(TeacherDynamic dynamic) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_Dynamic (DynamicFk_Id,DynamicType,InsertDate) VALUES ("
							+ dynamic.getRelateId()
							+ ","
							+ dynamic.getRelateType()
							+ ",'"
							+ dynamic.getInsertDate() + "')");
			return isSuccess;
		} catch (Exception e) {
		}
		return 0;
	}

	public List<TeacherDynamic> findAllDynamic() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Dynamic ORDER BY InsertDate DESC");
			dynamics = getDynamic(res);
			return dynamics;
		} catch (Exception e) {
		}
		return null;
	}

	public List<TeacherDynamic> findDynamicByType(int type) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Dynamic WHERE DynamicType="
							+ type + " ORDER BY InsertDate DESC");
			dynamics = getDynamic(res);
			return dynamics;
		} catch (Exception e) {
		}
		return null;
	}

	public TeacherDynamic findDynamicById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Dynamic WHERE Id="
					+ id);
			dynamics = getDynamic(res);
			if (dynamics.size() > 0) {
				return dynamics.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<TeacherDynamic> getDynamic(ResultSet result) {
		dynamics.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int relateId = result.getInt("DynamicFk_Id");
				int relateType = result.getInt("DynamicType");
				String insertDate = result.getString("InsertDate");
				TeacherDynamic dynamic = new TeacherDynamic(id, relateId,
						relateType, insertDate);
				dynamics.add(dynamic);
			}
			return dynamics;
		} catch (Exception e) {
		}
		return null;
	}

}

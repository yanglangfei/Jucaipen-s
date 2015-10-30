package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.TeacherAttentionDao;
import com.accumulate.entity.TeacherAttention;
import com.accumulate.utils.JdbcUtil;

public class TeacherAttentionImp implements TeacherAttentionDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<TeacherAttention> teacherAttentions = new ArrayList<TeacherAttention>();

	public int insertAttention(TeacherAttention attention) {
		// 添加关注
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_Attention(UserId,TearchId) VALUES ("
							+ attention.getUserId()
							+ ","
							+ attention.getTeacherId() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<TeacherAttention> findAllAttention() {
		// 查找所有的关注
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention ORDER BY Id");
			teacherAttentions = getAttention(res);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> findAttentionByUid(int userId) {
		// 查询当前用户下的所有
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention WHERE UserId="
							+ userId + " ORDER BY Id");
			teacherAttentions = getAttention(res);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> findAttentionBytid(int tId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention WHERE TearchId="
							+ tId + " ORDER BY Id");
			teacherAttentions = getAttention(res);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> findAttentionByUidAndTid(int uId, int tId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention WHERE UserId="
							+ uId + " and TearchId=" + tId + " ORDER BY Id");
			teacherAttentions = getAttention(res);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> getAttention(ResultSet result) {
		teacherAttentions.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				int teacherId = result.getInt("TearchId");
				TeacherAttention attention = new TeacherAttention(id, userId,
						teacherId);
				teacherAttentions.add(attention);
			}
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

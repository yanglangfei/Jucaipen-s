package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.TeacherDao;
import com.accumulate.entity.Teacher;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class TeacherImp implements TeacherDao {
	private List<Teacher> teachers;
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;

	/**
	 * @return 查询教师总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearcher "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/*
	 * 查询所有教师信息
	 */
	public List<Teacher> findAll(int page) {
		int totlePag = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPTearcher"
							+ " ) A " + "WHERE RowNumber > " + 15 * (page - 1));
			teachers = getTeachers(res, page, totlePag);
			return teachers;
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

	/*
	 * 根据id查询教师信息
	 */
	public Teacher findTeacher(int id) {
		Teacher t = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPTearcher where Id=" + id);
			teachers = getTeachers(res, -1, -1);
			if (teachers != null && teachers.size() > 0) {
				t = teachers.get(0);
			}
			return t;
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

	/**
	 * @param result
	 * @return
	 */
	/**
	 * @param result
	 * @return 获取教师信息
	 */
	public List<Teacher> getTeachers(ResultSet result, int page, int totlePage) {
		teachers = new ArrayList<Teacher>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.EQUITY_ID);
				String name = result.getString(SqlUtil.TEACHER_NAME);
				String photoUrl = result.getString(SqlUtil.TEACHER_PHOTO);
				String summary = result.getString(SqlUtil.TEACHER_SUMM);
				String bodys = result.getString(SqlUtil.TEACHER_BODYS);
				int sortId = result.getInt(SqlUtil.TEACHER_SORT);
				Teacher teacher = new Teacher(id, name, photoUrl, summary,
						bodys, sortId);
				teacher.setTotlePage(totlePage);
				teacher.setPage(page);
				teachers.add(teacher);
			}
			return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
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

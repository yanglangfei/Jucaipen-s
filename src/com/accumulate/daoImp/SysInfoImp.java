package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.SysInfoDao;
import com.accumulate.entity.SystemInfo;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class SysInfoImp implements SysInfoDao {
	private List<SystemInfo> infos;
	private ResultSet res;
	private Statement sta;
	private Connection dbConn;

	/**
	 * @return 查询信息总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPUser_Messge "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 获取所有信息
	 */
	public List<SystemInfo> findAll(int page) {
		int totlePage = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Messge"
							+ " ) A " + "WHERE RowNumber > " + 15 * (page - 1));
			infos = getInfos(res, page, totlePage);
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据id获取信息内容
	 */
	public SystemInfo findSystemInfo(int id) {
		SystemInfo info = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUser_Messge where Id="
					+ id);
			infos = getInfos(res, -1, -1);
			if (infos != null && infos.size() > 0) {
				info = infos.get(0);
			}
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * 查询不同类型的信息
	 */
	public List<SystemInfo> findInfoByType(int type, int page) {
		int totlePage = findTotlePager("where Types=" + type);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Messge"
							+ " where Types=" + type + " ) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			infos = getInfos(res, page, totlePage);
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据接受者查询信息
	 */
	public List<SystemInfo> findInfoByReceiver(int receiverId, int page) {
		int totlePage = findTotlePager("where ReceiveId=" + receiverId);
		String sql="SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Messge"
							+ " where ReceiveId=" + receiverId + ") A "
							+ "WHERE RowNumber > " + 15 * (page - 1);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery(sql);
			infos = getInfos(res, page, totlePage);
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据发送者查询信息
	 */
	public List<SystemInfo> findInfoBySender(int senderId, int page) {
		int totlePage = findTotlePager("where SendId=" + senderId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Message"
							+ "where SendId=" + senderId + " ) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			infos = getInfos(res, page, totlePage);
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据读取信息时间获取未读信息
	 */
	public List<SystemInfo> findInfoByIsread(String readDate, int page) {
		int totlePage = findTotlePager("where ReadDate=" + readDate);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Message"
							+ "where ReadDate=" + readDate + " ) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			infos = getInfos(res, page, totlePage);
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据发送时间获取信息
	 */
	public List<SystemInfo> findInfoBySendDate(String SendDate, int page) {
		int totlePage = findTotlePager("where SendDate=" + SendDate);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Message"
							+ "where SendDate=" + SendDate + " ) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			infos = getInfos(res, page, totlePage);
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return 获取所有的信息
	 */
	public List<SystemInfo> getInfos(ResultSet result, int page, int totlePage) {
		infos = new ArrayList<SystemInfo>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.NEWS_ID);
				int sendId = result.getInt(SqlUtil.SYSINFO_SENDID);
				int receiveId = result.getInt(SqlUtil.SYSINFO_RECEIVEID);
				String title = result.getString(SqlUtil.SYSINFO_TITLE);
				String bodys = result.getString(SqlUtil.SYSINFO_BODYS);
				String sendDate = result.getString(SqlUtil.SYSINFO_SENDDATE);
				String readDate = result.getString(SqlUtil.SYSINFO_READDATE);
				int type = result.getInt(SqlUtil.SYSINFO_TYPE);
				SystemInfo info = new SystemInfo(id, receiveId, sendId, title,
						bodys, sendDate, readDate, type);
				info.setTotlePage(totlePage);
				info.setPage(page);
				infos.add(info);
			}
			return infos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

}

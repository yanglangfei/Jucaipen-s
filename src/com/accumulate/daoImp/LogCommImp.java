package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.LogCommenDao;
import com.accumulate.entity.LogCommen;
import com.accumulate.utils.JdbcUtil;

public class LogCommImp implements LogCommenDao {
	private int isSuccess;
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<LogCommen> logCommens = new ArrayList<LogCommen>();
	
	/**
	 * @return 查询登录日志总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_LogCommen "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	public int insertLogComm(LogCommen logCommen) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_LogCommen "
							+ "(UserId,ParentId,LogId,Bodys,InsertDate,Good,IsShow,RepCount) VALUES ("
							+ logCommen.getUserId() + ","
							+ logCommen.getParentId() + ","
							+logCommen.getLogId()+",'"
							+ logCommen.getBodys() + "','"
							+ logCommen.getInsertDate() + "',"
							+ logCommen.getGoods() + ","
							+ logCommen.getIsShow() + ","
							+ logCommen.getRepCount() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public LogCommen findLogCommBuId(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LogCommen WHERE Id="
							+ id);
			logCommens = getLogComm(res,1,1);
			if (logCommens.size() > 0) {
				return logCommens.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogCommen> findAllComm() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LogCommen ORDER BY InsertDate DESC");
			logCommens = getLogComm(res,1,1);
			return logCommens;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogCommen> findLogCommByUserId(int uid) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LogCommen WHERE UserId="
							+ uid + " ORDER BY InsertDate DESC");
			logCommens = getLogComm(res,1,1);
			return logCommens;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogCommen> findLogCommByLogId(int logId,int page) {
		int totlePage=findTotlePager("WHERE LogId="+logId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPTearch_LogCommen"
							+ " where LogId=" + logId + " ) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			logCommens = getLogComm(res,page,totlePage);
			return logCommens;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogCommen> findLogCommByUidAndLogId(int uid, int logId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LogCommen WHERE UserId="
							+ uid
							+ "AND LogId="
							+ logId
							+ " ORDER BY InsertDate DESC");
			logCommens = getLogComm(res,1,1);
			return logCommens;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LogCommen> getLogComm(ResultSet result,int page,int totlePage) {
		logCommens.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				int parentId = result.getInt("ParentId");
				int logId = result.getInt("LogId");
				String bodys = result.getString("Bodys");
				String insertDate = result.getString("InsertDate");
				int goods = result.getInt("Good");
				int isShow = result.getInt("IsShow");
				int repCount = result.getInt("RepCount");
				LogCommen commen = new LogCommen(id, userId, parentId, logId,
						bodys, insertDate, goods, isShow, repCount);
				commen.setTotlePage(totlePage);
				commen.setPage(page);
				logCommens.add(commen);
			}
			return logCommens;
		} catch (Exception e) {
		}
		return null;
	}

}

package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.AskDao;
import com.accumulate.entity.Ask;
import com.accumulate.utils.JdbcUtil;

public class AskImp implements AskDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<Ask> asks = new ArrayList<Ask>();
	
	/**
	 * @return 查询提问总页数
	 */
	public int findTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_Ask "
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

	public List<Ask> findAllAsk(int page) {
		// 获取搜友提问信息
		try {
			int totlePage=findTotlePage("");
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY AskDate desc) AS RowNumber,* FROM JCPTearch_Ask) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			asks = getAsk(res,page,totlePage);
			return asks;
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

	public List<Ask> findLstAsk(int count) {
		// 获取最近几条提问
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + count
					+ " * FROM JCPTearch_Ask ORDER BY AskDate DESC");
			asks = getAsk(res,0,0);
			return asks;
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
	
	
	public int findAskNumByUId(int uId) {
		//根据用户id获取用户的提问数
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT COUNT (*) FROM JCPTearch_Ask WHERE UserId="+uId);
			while (res.next()) {
				int askNum=res.getInt(1);
				return askNum;
			}
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	

	public List<Ask> findAskByUserId(int userId) {
		// 根据用户id获取提问信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Ask WHERE UserId="
					+ userId + " ORDER BY AskDate DESC");
			asks = getAsk(res,0,0);
			return asks;
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

	public List<Ask> findAskByTeacherId(int teacherId,int page) {
		// 根据讲师id获取提问信息
		int totlePage=findTotlePage("WHERE TearcherId="+teacherId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY AskDate desc) AS RowNumber,* FROM JCPTearch_Ask" +
							" WHERE TearcherId="+teacherId+") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			asks = getAsk(res,page,totlePage);
			return asks;
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

	public List<Ask> findAskByClassId(int classId) {
		// 根据分类获取提问信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Ask WHERE ClassId="
					+ classId + " ORDER BY AskDate DESC");
			asks = getAsk(res,0,0);
			return asks;
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

	public List<Ask> findAskByAskState(int state) {
		// 根据提问状态获取提问信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Ask WHERE AskState="
							+ state + " ORDER BY AskDate DESC");
			asks = getAsk(res,0,0);
			return asks;
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

	public List<Ask> findAskByIsReply(int isReply) {
		// 根据提问回复状态获取提问信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Ask WHERE IsReply="
					+ isReply + " ORDER BY AskDate DESC");
			asks = getAsk(res,0,0);
			return asks;
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

	public Ask findAskById(int id) {
		// 根据提问id获取提问信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Ask WHERE Id=" + id
					+ " ORDER BY AskDate DESC");
			asks = getAsk(res,0,0);
			if (asks.size() > 0) {
				return asks.get(0);
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

	public int insertAsk(Ask ask) {
		// 添加提问
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_Ask"
							+ "(UserId,ParentId,AskBodys,ClassId,AskDate,AskState,Hits,IsReply,IP,TearcherId) "
							+ "VALUES(" + ask.getUserId() + ","
							+ ask.getParentId() + ",'" + ask.getAskBody()
							+ "'," + ask.getClassId() + ",'" + ask.getAskDate()
							+ "'," + ask.getAskState() + "," + ask.getHits()
							+ "," + ask.getIsReply() + ",'" + ask.getIp() + "',"
							+ ask.getTeacherId() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public List<Ask> getAsk(ResultSet result,int page,int totlePage) {
		asks.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				int parentId = result.getInt("ParentId");
				String bodys = result.getString("AskBodys");
				int classId = result.getInt("ClassId");
				String askDate = result.getString("AskDate");
				int askState = result.getInt("AskState");
				int hits = result.getInt("Hits");
				int isReply = result.getInt("IsReply");
				String ip = result.getString("IP");
				int teacherId = result.getInt("TearcherId");
				Ask ask = new Ask();
				ask.setTotlePage(totlePage);
				ask.setPage(page);
				ask.setId(id);
				ask.setUserId(userId);
				ask.setParentId(parentId);
				ask.setAskBody(bodys);
				ask.setClassId(classId);
				ask.setAskDate(askDate);
				ask.setTeacherId(teacherId);
				ask.setIp(ip);
				ask.setIsReply(isReply);
				ask.setHits(hits);
				ask.setAskState(askState);
				asks.add(ask);
			}
			return asks;
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

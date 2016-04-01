package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.FeedBackDao;
import com.accumulate.entity.FeedBack;
import com.accumulate.utils.JdbcUtil;

public class FeedBackImp implements FeedBackDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<FeedBack> feedBacks = new ArrayList<FeedBack>();

	public int insertFeedBack(FeedBack feedBack) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("INSERT INTO JCPTearch_Feedback "
					+ "(UserId,TrueName,MobileNum,Bodys,InsertDate,Ip,Types)"
					+ " VALUES (" + feedBack.getUserId() + ",'"
					+ feedBack.getTrueName() + "','" + feedBack.getMobileNum()
					+ "','" + feedBack.getBody() + "','"
					+ feedBack.getInsertDate() + "','" + feedBack.getIp()
					+ "'," + feedBack.getType() + ")");
			return isSuccess;
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

	public List<FeedBack> findAllFeedBack() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,UserId,TrueName,MobileNum,Bodys,InsertDate,Ip,Types FROM JCPTearch_Feedback ORDER BY InsertDate DESC");
			feedBacks = getFeedBack(res);
			return feedBacks;
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

	public List<FeedBack> findFeedBaceByUserId(int uId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,UserId,TrueName,MobileNum,Bodys,InsertDate,Ip,Types FROM JCPTearch_Feedback WHERE UserId="
							+ uId + " ORDER BY InsertDate DESC");
			feedBacks = getFeedBack(res);
			return feedBacks;
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

	public List<FeedBack> findFeedBackByType(int type) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,UserId,TrueName,MobileNum,Bodys,InsertDate,Ip,Types FROM JCPTearch_Feedback WHERE Types="
							+ type + " ORDER BY InsertDate DESC");
			feedBacks = getFeedBack(res);
			return feedBacks;
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

	public List<FeedBack> findFeedBackByUidAndType(int uId, int type) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,UserId,TrueName,MobileNum,Bodys,InsertDate,Ip,Types FROM JCPTearch_Feedback WHERE UserId="
							+ uId
							+ "AND Types="
							+ type
							+ " ORDER BY InsertDate DESC");
			feedBacks = getFeedBack(res);
			return feedBacks;
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

	public FeedBack findFeedBackById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT Id,UserId,TrueName,MobileNum,Bodys,InsertDate,Ip,Types FROM JCPTearch_Feedback WHERE Id="
					+ id);
			feedBacks = getFeedBack(res);
			if (feedBacks.size() > 0) {
				return feedBacks.get(0);
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

	public List<FeedBack> getFeedBack(ResultSet result) {
		feedBacks.clear();
		try {
			while (result.next()) {
				int id = result.getInt(1);
				int userId = result.getInt(2);
				String trueName = result.getString(3);
				String mobileNum = result.getString(4);
				String bodys = result.getString(5);
				String insertDate = result.getString(6);
				String ip = result.getString(7);
				int type = result.getInt(8);
				FeedBack feedBack = new FeedBack(id, userId, trueName,
						mobileNum, bodys, insertDate, ip, type);
				feedBacks.add(feedBack);
			}
			return feedBacks;
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

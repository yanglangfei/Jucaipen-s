package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.LiveInteractiveDao;
import com.accumulate.entity.LiveInteractive;
import com.accumulate.utils.JdbcUtil;

public class LiveInteractiveImp implements LiveInteractiveDao {
	private List<LiveInteractive> lInteractives = new ArrayList<LiveInteractive>();
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;

	
	/**
	 * @return 查询新闻总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta  
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_LiveInteractive "
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

	
	public int insertLiveInteractive(LiveInteractive interactive) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_LiveInteractive "
							+ "(LiveId,UserId,DeviceType,InsertDate,Bodys,IsPass,Ip,ParentId)"
							+ "VALUES (" + interactive.getLiveId() + ","
							+ interactive.getUserId() + ","
							+ interactive.getDeviceType() + ",'"
							+ interactive.getInsertDate() + "','"
							+ interactive.getBodys() + "',"
							+ interactive.getIsShow() + ",'"
							+ interactive.getIp() + "',"
							+ interactive.getParentaId() + ")");
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

	public List<LiveInteractive> findAll() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LiveInteractive ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res,1,1);
			return lInteractives;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<LiveInteractive> findByUserId(int userId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LiveInteractive WHERE UserId="
							+ userId + " ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res,1,1);
			return lInteractives;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<LiveInteractive> findByLiveId(int liveId,int page) {
	    int totlePage=findTotlePager(" WHERE LiveId="+liveId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LiveInteractive WHERE LiveId="
							+ liveId + " ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res,page,totlePage);
			return lInteractives;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<LiveInteractive> findByUidAndLiveId(int uId, int liveId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_LiveInteractive WHERE UserId="
							+ uId
							+ "AND LiveId="
							+ liveId
							+ " ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res,1,1);
			return lInteractives;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public LiveInteractive findById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_LiveInteractive");
			lInteractives = getLiveInteractive(res,1,1);
			if (lInteractives.size() > 0) {
				return lInteractives.get(0);
			}
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<LiveInteractive> getLiveInteractive(ResultSet result,int page,int totlePage) {
		lInteractives.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int liveId = result.getInt("LiveId");
				int userId = result.getInt("UserId");
				int deviceType = result.getInt("DeviceType");
				String insertDate = result.getString("InsertDate");
				String bodys = result.getString("Bodys");
				int isShow = result.getInt("IsPass");
				String ip = result.getString("Ip");
				int parentId = result.getInt("ParentId");
				LiveInteractive liInteractive = new LiveInteractive(id, liveId,
						userId, deviceType, insertDate, bodys, isShow, ip,
						parentId);
				liInteractive.setTotlePage(totlePage);
				liInteractive.setPage(page);
				lInteractives.add(liInteractive);
			}
			return lInteractives;
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

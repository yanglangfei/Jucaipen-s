package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.accumulate.dao.ServerQQDao;
import com.accumulate.entity.ServerQQ;
import com.accumulate.utils.JdbcUtil;

public class ServerQQImp implements ServerQQDao {

	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ServerQQ> servers = new ArrayList<ServerQQ>();

	public List<ServerQQ> findAllServer() {
		// 获取所有的表情信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM Chat_ServerQQ");
			servers = getServerQQInfo(res);
			return servers;
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

	public ServerQQ findServerById(int id) {
		// 获取所有的表情信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM Chat_ServerQQ WHERE Id=" + id);
			servers = getServerQQInfo(res);
			if (servers != null && servers.size() > 0) {
				return servers.get(0);
			} else {
				return null;
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

	public List<ServerQQ> findServerByRoomId(int roomId) {
		// 获取所有的表情信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM Chat_ServerQQ WHERE RoomId="
					+ roomId);
			servers = getServerQQInfo(res);
			return servers;
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

	private List<ServerQQ> getServerQQInfo(ResultSet result) {
		// 获取表情信息
		servers.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String title = result.getString("Title");
				int RoomId = result.getInt("RoomId");
				String QQ = result.getString("QQ");
				int pxId = result.getInt("PxId");
				ServerQQ qqs = new ServerQQ();
				qqs.setId(id);
				qqs.setTitle(title);
				qqs.setQqCode(QQ);
				qqs.setPxId(pxId);
				qqs.setRoomId(RoomId);
				servers.add(qqs);
			}
			return servers;
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

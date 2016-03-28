package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.AdverticeDao;
import com.accumulate.entity.Advertive;
import com.accumulate.utils.JdbcUtil;

public class AdverticeImp implements AdverticeDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Advertive> advertives = new ArrayList<Advertive>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accumulate.dao.AdverticeDao#findAll()
	 */
	public List<Advertive> findAll() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accumulate.dao.AdverticeDao#findAdByPid(int)
	 */
	public List<Advertive> findAdByPid(int pId) {
		advertives.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select Id,Pid,Title,LinkUrl,ImageUrl,PxId from JCPAd_Slide_Item where Pid="
					+ pId);
			while (res.next()) {
				int id = res.getInt(1);
				int pageId = res.getInt(2);
				String title = res.getString(3);
				String LinkUrl = res.getString(4);
				String ImageUrl = res.getString(5);
				int PxId = res.getInt(6);
				Advertive advertive = new Advertive(id, pageId, title, LinkUrl,
						ImageUrl, PxId);
				advertives.add(advertive);
			}
			return advertives;
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
	
	

}

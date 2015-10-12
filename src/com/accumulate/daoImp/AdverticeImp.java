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
			res = sta.executeQuery("select * from JCPAd_Slide_Item where Pid="
					+ pId);
			while (res.next()) {
				int id = res.getInt("Id");
				int pageId = res.getInt("pId");
				String title = res.getString("Title");
				String LinkUrl = res.getString("LinkUrl");
				String ImageUrl = res.getString("ImageUrl");
				int PxId = res.getInt("PxId");
				Advertive advertive = new Advertive(id, pageId, title, LinkUrl,
						ImageUrl, PxId);
				advertives.add(advertive);
			}
			return advertives;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

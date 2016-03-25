package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.NewsFavoritesDao;
import com.accumulate.entity.NewsFavorites;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class NewsFavoritesImp implements NewsFavoritesDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<NewsFavorites> newsFavorites;
	private int isSuccess;

	/**
	 * @return 查询收藏新闻总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPNews_Favorites "
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
	 * 收藏新闻资讯信息
	 */
	public int insertNewsFavorites(int uId, NewsFavorites newsFavorites) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("insert into JCPNews_Favorites ("
					+ SqlUtil.NEWSCOMM_UID + "," + SqlUtil.NEWSFAVORITES_NID
					+ "," + SqlUtil.NEWS_INSERT + ") values("
					+ newsFavorites.getuId() + "," + newsFavorites.getnId()
					+ ",'" + newsFavorites.getDate() + "')");
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

	/*
	 * 取消收藏新闻资讯信息
	 */
	public int cancelNewsFavorites(int uId, int nId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("delete from JCPNews_Favorites where UserId="
							+ uId + " and NewsId=" + nId);
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

	/*
	 * 
	 * 查询新闻是否收藏
	 */
	public NewsFavorites findNewsFavouritesByUidAndNid(int uId, int nId) {
		NewsFavorites newsFavorites = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id from JCPNews_Favorites where UserId="
							+ uId + " and NewsId=" + nId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				newsFavorites = new NewsFavorites();
				newsFavorites.setId(id);
			}
			return newsFavorites;
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
	 * 查询该用户收藏的所有新闻资讯信息
	 */
	public List<NewsFavorites> findNewsFavorites(int uId, int pager) {
		int totlePager = findTotlePager("Where UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC,InsertDate DESC) AS RowNumber,* FROM JCPNews_Favorites"
							+ " where UserId=" + uId + ") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsFavorites = getNewsFavorites(res, pager, totlePager);
			return newsFavorites;
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
	 * @return 获取收藏的新闻信息
	 */
	public List<NewsFavorites> getNewsFavorites(ResultSet result, int pager,
			int totlePager) {
		newsFavorites = new ArrayList<NewsFavorites>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.EQUITY_ID);
				int uId = result.getInt(SqlUtil.EQUITYFAVORITES_UID);
				int nId = result.getInt(SqlUtil.NEWSFAVORITES_NID);
				String insertDate = result
						.getString(SqlUtil.EQUITYFAVORITES_DATE);
				NewsFavorites nf = new NewsFavorites();
				nf.setTotlePager(totlePager);
				nf.setPager(pager);
				nf.setId(id);
				nf.setuId(uId);
				nf.setnId(nId);
				nf.setDate(insertDate);
				newsFavorites.add(nf);
			}
			return newsFavorites;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, result);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newsFavorites;

	}

}

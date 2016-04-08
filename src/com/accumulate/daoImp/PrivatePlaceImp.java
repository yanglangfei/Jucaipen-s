package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.PrivatePlaceDao;
import com.accumulate.entity.PrivatePlace;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class PrivatePlaceImp implements PrivatePlaceDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<PrivatePlace> places = new ArrayList<PrivatePlace>();

	/**
	 * @return 查询私募总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPSiMu "
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

	public List<PrivatePlace> findAll(int pager) {
		// 查询所有的私募信息
		int totlePager = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPSiMu) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1)+" ORDER BY Id DESC");
			places = getPrivatePlacew(res, pager, totlePager);
			return places;
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

	public PrivatePlace findPrivatePlaceById(int id) {
		PrivatePlace place = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPSiMu where Id=" + id);
			places = getPrivatePlacew(res, -1, -1);
			if (places != null && places.size() > 0) {
				place = places.get(0);
			}
			return place;
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

	public List<PrivatePlace> findPrivatePlaceByIsIndex(int isIndex) {
		return null;
	}

	public List<PrivatePlace> findPrivatePlaceByIsTop(int isTop) {
		return null;
	}

	public List<PrivatePlace> findPrivatePlaceByIsTuijian(int IsTuijian) {
		return null;
	}

	public List<PrivatePlace> getPrivatePlacew(ResultSet result, int pager,
			int totlePager) {
		places.clear();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.PRIVATEPLACE_ID);
				String title = result.getString(SqlUtil.PRIVATEPLACE_TITLE);
				String managerName = result
						.getString(SqlUtil.PRIVATEPLACE_MANAGERNAME);
				String linkPageUrl = result
						.getString(SqlUtil.PRIVATEPLACE_LINKURL);
				String managerImage = result
						.getString(SqlUtil.PRIVATEPLACE_MANAGERIMAGE);
				String menKan = result.getString(SqlUtil.PRIVATEPLACE_MENKAN);
				int grade = result.getInt(SqlUtil.PRIVATEPLACE_GRADE);
				String thisPrifit = result.getString(SqlUtil.PRIVATEPLACE_THISPRFIT);
				String lastPrifit = result.getString(SqlUtil.PRIVATEPLACE_LASTPRIFIT);
				String markReason = result.getString(SqlUtil.PRIVATEPLACE_MARKREASON);
				int isTop = result.getInt(SqlUtil.PRIVATEPLACE_ISTOP);
				int isIndex = result.getInt(SqlUtil.PRIVATEPLACE_ISINDEX);
				int isTuijian = result.getInt(SqlUtil.PRIVATEPLACE_ISTUIJIAN);
				PrivatePlace place = new PrivatePlace(id, title, managerName);
				place.setGrade(grade);
				place.setLinkPageUrl(linkPageUrl);
				place.setManagerImage(managerImage);
				place.setMenKan(menKan);
				place.setThisYearShouyi(thisPrifit);
				place.setLastYearShouyi(lastPrifit);
				place.setTuijianInfo(markReason);
				place.setIsIndex(isIndex);
				place.setIsTop(isTop);
				place.setIsTuijian(isTuijian);
				places.add(place);
			}
			return places;
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

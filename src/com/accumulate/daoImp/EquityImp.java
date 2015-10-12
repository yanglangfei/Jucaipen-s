package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.EquityDao;
import com.accumulate.entity.Equity;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class EquityImp implements EquityDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Equity> equities;

	/**
	 * @return 查询股权总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPGuquanItem "
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
	 * 查询所有股权信息
	 */
	public List<Equity> findAll(int pager) {
		int totlePager = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			if (dbConn != null) {
				sta = dbConn.createStatement();
				res = sta
						.executeQuery("SELECT TOP 15 * FROM "
								+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPGuquanItem) A "
								+ "WHERE RowNumber > " + 15 * (pager - 1));
				equities = getEquity(res, pager, totlePager);
				return equities;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equities;

	}

	/*
	 * 查询股权详细信息
	 */
	public Equity findEquity(int id) {
		Equity equity = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPGuquanItem where Id=" + id);
			equities = getEquity(res, -1, -1);
			if (equities != null && equities.size() > 0) {
				equity = equities.get(0);
			}
			return equity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 查询置顶股权
	 */
	public List<Equity> findByTop(int isTop) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			if (dbConn != null) {
				sta = dbConn.createStatement();
				res = sta
						.executeQuery("select top 15 * from JCPGuquanItem where Istop="
								+ isTop);
				equities = getEquity(res, -1, -1);
				return equities;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equities;

	}

	/*
	 * 查询推荐的股权信息
	 */
	public List<Equity> frindByRecomment(int isRecom, int pager) {
		int totlePager = findTotlePager("where Istuijian=" + isRecom);
		try {
			dbConn = JdbcUtil.connSqlServer();
			if (dbConn != null) {
				sta = dbConn.createStatement();
				res = sta
						.executeQuery("SELECT TOP 15 * FROM "
								+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPGuquanItem"
								+ " where Istuijian=" + isRecom + " ) A "
								+ "WHERE RowNumber > " + 15 * (pager - 1));
				equities = getEquity(res, pager, totlePager);
				return equities;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equities;

	}

	/*
	 * 查询首页显示的股权
	 */
	public List<Equity> findIndexEquity() {
		equities = new ArrayList<Equity>();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select top 2 "
							+ "Id,isNull(gufenjiancheng,'') gufenjiancheng,isNull(guquanimageurl,'') guquanimageurl,"
							+ "touzimenkan,isNull(nizhuanrangjiage,'') nizhuanrangjiage ,"
							+ "isNull(zhuanranggushu,'') zhuanranggushu,gufenmingcheng"
							+ " from JCPGuquanItem " + "order by Id desc");
			while (res.next()) {
				int id = res.getInt(SqlUtil.EQUITY_ID);
				String simpleName = res.getString(SqlUtil.EQUITY_SIMPLENAME);
				String investmentThreshold = res.getString(SqlUtil.EQUITY_IT);
				String transferNum = res.getString(SqlUtil.EQUITY_TRANSNUM);
				String equityImage = res.getString(SqlUtil.EQUITY_IMAGE);
				String ownName=res.getString(SqlUtil.EQUITY_NAME);
				String intend=res.getString(SqlUtil.EQUITY_INTENDSTRANSFER);
				Equity eq = new Equity();
				eq.setOwnName(ownName);
				eq.setInvestmentThreshold(investmentThreshold);
				eq.setSimpleName(simpleName);
				eq.setEquityImage(equityImage);
				eq.setId(id);
				eq.setTransferNum(transferNum);
				eq.setIntendsTransfer(intend);
				equities.add(eq);
			}
			return equities;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return 获取股权信息
	 */
	public List<Equity> getEquity(ResultSet result, int pager, int totlePager) {
		equities = new ArrayList<Equity>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.EQUITY_ID);
				String ownName=result.getString(SqlUtil.EQUITY_NAME);
				String simpleName = result.getString(SqlUtil.EQUITY_SIMPLENAME);
				String recommender = result.getString(SqlUtil.EQUITY_RECOMM);
				String netProfit = result.getString(SqlUtil.EQUITY_NETPROFIT);
				String equityCode = result.getString(SqlUtil.EQUITY_CODE);
				String bvps = result.getString(SqlUtil.EQUITY_BVPS);
				String investmentThreshold = result.getString(SqlUtil.EQUITY_IT);
				String profitRate = result.getString(SqlUtil.EQUITY_RAT);
				String equityImage = res.getString(SqlUtil.EQUITY_IMAGE);
				String transferNum=res.getString(SqlUtil.EQUITY_TRANSNUM);
				String intendsTransfer=res.getString(SqlUtil.EQUITY_INTENDSTRANSFER);
				Equity equitie = new Equity();
				equitie.setProfitRate(profitRate);
				equitie.setId(id);
				equitie.setOwnName(ownName);
				equitie.setIntendsTransfer(intendsTransfer);
				equitie.setTransferNum(transferNum);
				equitie.setEquityImage(equityImage);
				equitie.setSimpleName(simpleName);
				equitie.setRecommender(recommender);
				equitie.setNetProfit(netProfit);
				equitie.setEquityCode(equityCode);
				equitie.setInvestmentThreshold(investmentThreshold);
				equitie.setBvps(bvps);
				equitie.setTotlePager(totlePager);
				equitie.setPager(pager);
				equities.add(equitie);
			}
			return equities;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

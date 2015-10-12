package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.OrderEquityDao;
import com.accumulate.entity.OrderEquity;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class OrderEquityImp implements OrderEquityDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<OrderEquity> orderEquitys;
	private int isSuccess;

	/**
	 * @return 查询预约股权总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPGuquanItem_yuyue "
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
	 * 预定股权
	 */
	public int insertEquity(int uId, OrderEquity oe) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			System.out.println();
			isSuccess = sta.executeUpdate("insert into JCPGuquanItem_yuyue"
					+ "("
					+ SqlUtil.ORDER_UID
					+ ","
					+ SqlUtil.ORDER_UNAME
					+ ","
					+ SqlUtil.ORDER_MOBILE
					+ ","
					+ SqlUtil.ORDER_REMARK
					+ ","
					+ SqlUtil.ORDER_DATE
					+ ","
					+ SqlUtil.ORDER_TOUZI
					+ ","
					+ SqlUtil.ORDER_EID
					+ ","
					+ SqlUtil.EQUITYORDER_ORDERTYPE
					+ ","
					+ SqlUtil.ORDER_UIP
					+ ") "
					+ "values ("
					+ oe.getuId()
					+ ",'"
					+ oe.getTrueName()
					+ "','"
					+ oe.getMobileNum()
					+ "','"
					+ oe.getRemark()
					+ "','"
					+ oe.getInsertDate()
					+ "','"
					+ oe.getTouziMoney()
					+ "',"
					+ oe.geteId()
					+ ","
					+ oe.getOrderType() +",'"+oe.getuIp()+ "')");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	/*
	 * 取消预定股权
	 */
	public int cancelEquity(int uId, int eId, int oType) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("delete * from JCPGuquanItem_yuyue where UserId="
							+ uId
							+ " and ItemId="
							+ eId
							+ " and yuyuetype="
							+ oType);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 获取当前用户下所有预定的股权信息
	 */
	public List<OrderEquity> findOrderEquity(int uId, int pager) {
		int totlePager = findTotlePager("where UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER ( ORDER BY Id DESC,InsertDate DESC) AS RowNumber,* FROM JCPGuquanItem_yuyue"
							+ " WHERE UserId=" + uId + ") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			orderEquitys = getOrders(res, pager, totlePager);
			return orderEquitys;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @param res
	 * @return 获取股权预约信息
	 */
	public List<OrderEquity> getOrders(ResultSet res, int pager, int totlePager) {
		orderEquitys = new ArrayList<OrderEquity>();
		try {
			while (res.next()) {
				int id = res.getInt(SqlUtil.ORDER_ID);
				int uId = res.getInt(SqlUtil.ORDER_UID);
				int eId = res.getInt(SqlUtil.ORDER_EID);
				String trueName = res.getString(SqlUtil.ORDER_UNAME);
				String mobileNum = res.getString(SqlUtil.ORDER_MOBILE);
				String remark = res.getString(SqlUtil.ORDER_REMARK);
				String touziMoney = res.getString(SqlUtil.ORDER_TOUZI);
				String insertDate = res.getString(SqlUtil.ORDER_DATE);
				String uIp = res.getString(SqlUtil.ORDER_UID);
				int oType = res.getInt(SqlUtil.EQUITYORDER_ORDERTYPE);
				OrderEquity oe = new OrderEquity();
				oe.setTotlePager(totlePager);
				oe.setPager(pager);
				oe.setuId(id);
				oe.setuId(uId);
				oe.seteId(eId);
				oe.setOrderType(oType);
				oe.setTrueName(trueName);
				oe.setMobileNum(mobileNum);
				oe.setRemark(remark);
				oe.setTouziMoney(touziMoney);
				oe.setInsertDate(insertDate);
				oe.setuIp(uIp);
				orderEquitys.add(oe);
			}
			return orderEquitys;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

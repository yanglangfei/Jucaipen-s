package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.PayOrderDao;
import com.accumulate.entity.PayOrder;
import com.accumulate.utils.JdbcUtil;

/**
 * @author Administrator 订单信息
 * 
 * 
 *         "SELECT TOP 15 * FROM " +
 *         "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product"
 *         + " ) A " + "WHERE RowNumber > " + 15 * (pager - 1)
 */
public class PayOrderImp implements PayOrderDao {
	private List<PayOrder> payOrders = new ArrayList<PayOrder>();
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;

	/**
	 * @return 查询产品总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from Pay_order "
							+ condition);
			res.next();
			int totlePager = res.getInt(1);
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

	public List<PayOrder> findAllPayOrderList(int page) {
		// 获取全部的订单信息
		int totlePage = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order"
							+ " ) A " + "WHERE RowNumber > " + 15 * (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
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

	public List<PayOrder> findPayOrderByUid(int uId, int page) {
		// 根据用户ID获取订单信息
		int totlePage = findTotlePager("WHERE UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE UserId="
							+ uId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
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

	public List<PayOrder> findPayOrderByPayState(int payState, int page) {
		// 根据支付状态获取订单信息
		int totlePage = findTotlePager("WHERE PayType=" + payState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE PayType="
							+ payState + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
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

	public List<PayOrder> findPayOrderByOrderState(int orderState, int page) {
		// 根据订单状态获取订单信息
		int totlePage = findTotlePager("WHERE OrderType=" + orderState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE OrderType="
							+ orderState + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
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

	public List<PayOrder> findPayOrderByTeacherId(int teacherId, int page) {
		// 根据讲师ID获取订单信息
		int totlePage = findTotlePager("WHERE FromTearchId=" + teacherId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE FromTearchId="
							+ teacherId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
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

	public List<PayOrder> findPayOrderByProductState(int productState, int page) {
		// 根据商品信息获取订单信息
		int totlePage = findTotlePager("WHERE IsDelete=" + productState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE IsDelete="
							+ productState + " ) A " + "WHERE RowNumber > "
							+ 15 * (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
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

	public List<PayOrder> findLastPayOrder(int lastCount) {
		// 获取最近的几条订单
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + lastCount
					+ " * FROM Pay_order ORDER BY InsertDate DESC");
			payOrders = getPayOrder(res, 1, 1);
			return payOrders;
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

	public PayOrder findPayOrderById(int id) {
		// 根据ID获取订单信息
		PayOrder order = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT  * FROM Pay_order WHERE Id=" + id);
			payOrders = getPayOrder(res, 1, 1);
			if (payOrders.size() > 0) {
				order = payOrders.get(0);
				return order;
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

	public int changePayState(int payType, String payDate, String orderCode) {
		// 更新支付状态
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE Pay_order SET PayType="
					+ payType + ",PayDate='" + payDate + "' WHERE OrderCode='"
					+ orderCode + "'");
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

	public int addPayOrder(PayOrder payOrder) {
		// 添加订单信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO Pay_order "
							+ "(UserId,Title,OrderCode,AllMoney,PayMoney,InsertDate,PayModel,"
							+ "PayType,FromTearchId,IsDelete) VALUES ("
							+ payOrder.getUserId()+",'"+payOrder.getTitle()+"','"+payOrder.getOrderCode()
							+"','"+payOrder.getAllMoney()+"','"+payOrder.getPayMoney()+"','"+payOrder.getInsertDate()
							+"',"+payOrder.getPayModel()+","+payOrder.getPayState()+","+
							payOrder.getFromTeacherId()+","+payOrder.getIsDelete()+")");
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

	public List<PayOrder> getPayOrder(ResultSet result, int page, int totlePage) {
		payOrders.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				String trueName = result.getString("TrueName");
				String mobileNum = result.getString("MobileNum");
				int provinceId = result.getInt("FK_ProId");
				int cityId = result.getInt("FK_CityId");
				int areaId = result.getInt("FK_AareId");
				String address = result.getString("Address");
				String title = result.getString("Title");
				String orderCode = result.getString("OrderCode");
				String allMoney = result.getString("AllMoney");
				String payMoney = result.getString("PayMoney");
				String insertDate = result.getString("InsertDate");
				int payModel = result.getInt("PayModel");
				int payState = result.getInt("PayType");
				String payDate = result.getString("PayDate");
				int orderState = result.getInt("OrderType");
				int fromTeacherId = result.getInt("FromTearchId");
				int productState = result.getInt("IsDelete");
				PayOrder payOrder = new PayOrder();
				payOrder.setId(id);
				payOrder.setUserId(userId);
				payOrder.setTrueName(trueName);
				payOrder.setMobileNum(mobileNum);
				payOrder.setProvinceId(provinceId);
				payOrder.setCityId(cityId);
				payOrder.setAreaId(areaId);
				payOrder.setAddress(address);
				payOrder.setTitle(title);
				payOrder.setOrderCode(orderCode);
				payOrder.setAllMoney(allMoney);
				payOrder.setPayMoney(payMoney);
				payOrder.setInsertDate(insertDate);
				payOrder.setPayModel(payModel);
				payOrder.setPayState(payState);
				payOrder.setPayDate(payDate);
				payOrder.setOrderState(orderState);
				payOrder.setFromTeacherId(fromTeacherId);
				payOrder.setIsDelete(productState);
				payOrder.setTotlePage(totlePage);
				payOrder.setPage(page);
				payOrders.add(payOrder);
			}
			return payOrders;
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

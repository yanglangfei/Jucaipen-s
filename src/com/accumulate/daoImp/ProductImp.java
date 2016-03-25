package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.ProductDao;
import com.accumulate.entity.Product;
import com.accumulate.utils.JdbcUtil;

public class ProductImp implements ProductDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<Product> products;

	/**
	 * @return 查询产品总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Product "
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
	 * 查询所有产品信息
	 */
	public List<Product> findAll(int pager) {
		int totlePager = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product"
							+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			products = getProducts(res, pager, totlePager);
			return products;
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
	 * 根据id查询产品信息
	 */
	public Product findProduct(int id) {
		Product product = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Product where Id=" + id);
			products = getProducts(res, -1, -1);
			if (products != null && products.size() > 0) {
				product = products.get(0);
			}
			return product;
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

	public List<Product> findProductByTeacherId(int teacherId, int page) {
		// 根据讲师ID获取商品信息
		int totlePage = findTotlePager("WHERE TearchId=" + teacherId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE TearchId="
							+ teacherId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
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

	public List<Product> findProductByTypes(int types, int page) {
		// 根据商品类型获取商品信息
		int totlePage = findTotlePager("WHERE Types=" + types);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE Types="
							+ types + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
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

	public List<Product> findProductBySaleState(int saleState, int page) {
		// 根据销售状态获取商品信息
		int totlePage = findTotlePager("WHERE SaleType=" + saleState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE SaleType="
							+ saleState + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
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

	public List<Product> findProductByProductState(int isDeleted, int page) {
		// 根据商品状态获取商品信息
		int totlePage = findTotlePager("WHERE IsDelete=" + isDeleted);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE IsDelete="
							+ isDeleted + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
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

	public List<Product> findLastProduct(int lastCount) {
		// 获取最近上线的商品信息
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select TOP " + lastCount
					+ " * from JCP_Product order by Id DESC");
			products = getProducts(res, -1, -1);
			return products;
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
	 * @return 获取产品信息
	 */
	public List<Product> getProducts(ResultSet result, int pager, int totlePager) {
		products = new ArrayList<Product>();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String name = result.getString("ProductTitle");
				String price = result.getString("Price");
				String nowPrice = result.getString("NowPrice");
				int tearchId = result.getInt("TearchId");
				int types = result.getInt("Types");
				int xuYueYear = result.getInt("XuYueYear");
				int xuYueMonth = result.getInt("XuYueMonth");
				int xuYueDay = result.getInt("XuYueDay");
				int saleType = result.getInt("SaleType");
				int isDelete = result.getInt("IsDelete");
				int pxId = result.getInt("PxId");
				Product p = new Product(pager, totlePager, id, name, price,
						nowPrice, tearchId, types, xuYueYear, xuYueMonth,
						xuYueDay, saleType, isDelete, pxId);
				p.setTotlePager(totlePager);
				p.setPager(pager);
				products.add(p);
			}
			return products;
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

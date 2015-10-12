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

public class ProductDaoImp implements ProductDao {
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
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCP_Product"
							+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			products = getProducts(res, pager, totlePager);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
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
				String name = result.getString("ProductName");
				String price = result.getString("ProductPrice");
				String remark = result.getString("ProductRemark");
				int pxId = result.getInt("PxId");
				String ediByWeb = result.getString("EdiByWeb");
				Product p = new Product(id, name, price, remark, pxId, ediByWeb);
				p.setTotlePager(totlePager);
				p.setPager(pager);
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}

package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.accumulate.dao.OranizationDao;
import com.accumulate.entity.Organization;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class OranizationImp implements OranizationDao {
	private List<Organization> organizations;
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;

	/**
	 * @return  查询机构总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPJigou "+condition);
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
	 *  查询所有的机构信息
	 */
	public List<Organization> findAll(int pager) {
		int totlePager=findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPJigou) A "
					+ "WHERE RowNumber > " + 15 * (pager - 1));
			organizations = getOrganizations(res,pager,totlePager);
			return organizations;
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
	 *   根据id查询机构信息
	 */
	public Organization findOrganization(int id) {
		Organization o = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPJigou");
			organizations = getOrganizations(res,-1,-1);
			if (organizations != null && organizations.size() > 0) {
				o = organizations.get(0);
			}
			return o;
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
	 * @return   获取机构信息
	 */
	public List<Organization> getOrganizations(ResultSet result,int pager,int totlePager) {
		organizations = new ArrayList<Organization>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.EQUITY_ID);
				String name = result.getString(SqlUtil.ORAG_NAME);
				String nameEn = result.getString(SqlUtil.ORAG_NAMEEN);
				String simpleName = result.getString(SqlUtil.ORAG_SIMPLENAME);
				Date createDate = result.getDate(SqlUtil.ORAG_CREATEDATE);
				String quality = result.getString(SqlUtil.ORAG_TYPE);
				String investmentArea = result.getString(SqlUtil.ORAG_AREA);
				String logo = result.getString(SqlUtil.ORAG_LOGO);
				String descript = result.getString(SqlUtil.ORAG_BODYS);
				Date insertDate = result.getDate(SqlUtil.ORAG_INSERTDATE);
				int sortId = result.getInt(SqlUtil.PROVINCE_SORT);
				Organization organization = new Organization(id, name, nameEn,
						simpleName, createDate, quality, investmentArea, logo,
						descript, insertDate, sortId);
				organization.setTotlePager(totlePager);
				organization.setPager(pager);
				organizations.add(organization);
			}
			return organizations;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, result);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return organizations;

	}

}

package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.ProvinceDao;
import com.accumulate.entity.Province;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class ProvinceImp implements ProvinceDao {
	private List<Province> provinces;
	private ResultSet res;
	private Statement sta;
	private Connection dbConn;

	/**
	 * @return 查询省份总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPProvince "
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
	 * 查询所有省份信息
	 */
	public List<Province> findAll() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPProvince");
			provinces = getPriovinces(res,-1,-1);
			return provinces;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * 根据id查询省份信息
	 */
	public Province findProvince(int id) {
		Province p = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPProvince where Id=" + id);
			provinces = getPriovinces(res,-1,-1);
			if (provinces != null && provinces.size() > 0) {
				p = provinces.get(0);
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @param result
	 * @return 获取省份信息
	 */
	public List<Province> getPriovinces(ResultSet result,int pager,int totlePager) {
		provinces = new ArrayList<Province>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.PROVINCE_ID);
				String name = result.getString(SqlUtil.PROVINCE_Name);
				int sortId = result.getInt(SqlUtil.PROVINCE_SORT);
				Province province = new Province(id, name, sortId);
				province.setTotlePager(totlePager);
				province.setPager(pager);
				provinces.add(province);
			}
			return provinces;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}

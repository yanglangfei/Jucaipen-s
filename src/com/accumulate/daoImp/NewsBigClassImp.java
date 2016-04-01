package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.accumulate.dao.NewsBigDao;
import com.accumulate.entity.NewsBigClass;
import com.accumulate.utils.JdbcUtil;

public class NewsBigClassImp implements NewsBigDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<NewsBigClass> nList = new ArrayList<NewsBigClass>();

	public List<NewsBigClass> findAllBigClass() {
		// 获取一级分类所有信息
		nList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select 	Id,BigName,KeyWord,Description,TempleteName,FilePath,LinkUrl,PxId from JCPNewsBigClass");
			while (res.next()) {
				int id = res.getInt(1);
				String BigName = res.getString(2);
				String KeyWord = res.getString(3);
				String Description = res.getString(4);
				String TempleteName = res
						.getString(5);
				String FilePath = res.getString(6);
				String LinkUrl = res.getString(7);
				int sortId = res.getInt(8);
				NewsBigClass nBigClass = new NewsBigClass(id, BigName, KeyWord,
						Description, TempleteName, FilePath, sortId);
				nBigClass.setLinkUrl(LinkUrl);
				nList.add(nBigClass);
			}
			return nList;

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

	public List<NewsBigClass> findBigClassById(int id) {
		// 根据id 获取分类信息
		nList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select BigName,KeyWord,Description,TempleteName,FilePath,LinkUrl,PxId from JCPNewsBigClass where Id="
					+ id);
			while (res.next()) {
				String BigName = res.getString(1);
				String KeyWord = res.getString(2);
				String Description = res.getString(3);
				String TempleteName = res
						.getString(4);
				String FilePath = res.getString(5);
				String LinkUrl = res.getString(6);
				int sortId = res.getInt(7);
				NewsBigClass nBigClass = new NewsBigClass(id, BigName, KeyWord,
						Description, TempleteName, FilePath, sortId);
				nBigClass.setLinkUrl(LinkUrl);
				nList.add(nBigClass);
			}
			return nList;
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

}

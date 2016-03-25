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
import com.accumulate.utils.SqlUtil;

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
			res = sta.executeQuery("select * from JCPNewsBigClass");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String BigName = res.getString(SqlUtil.NEWONECLASS_BIGNAME);
				String KeyWord = res.getString(SqlUtil.NEWONECLASS_KEYWORD);
				String Description = res.getString(SqlUtil.NEWONECLASS_DESC);
				String TempleteName = res
						.getString(SqlUtil.NEWONECLASS_MODELNAME);
				String FilePath = res.getString(SqlUtil.NEWONECLASS_FILEPATH);
				String LinkUrl = res.getString(SqlUtil.NEWONECLASS_LINKURL);
				int sortId = res.getInt(SqlUtil.NEWONECLASS_SORTID);
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
			res = sta.executeQuery("select * from JCPNewsBigClass where Id="
					+ id);
			while (res.next()) {
				String BigName = res.getString(SqlUtil.NEWONECLASS_BIGNAME);
				String KeyWord = res.getString(SqlUtil.NEWONECLASS_KEYWORD);
				String Description = res.getString(SqlUtil.NEWONECLASS_DESC);
				String TempleteName = res
						.getString(SqlUtil.NEWONECLASS_MODELNAME);
				String FilePath = res.getString(SqlUtil.NEWONECLASS_FILEPATH);
				String LinkUrl = res.getString(SqlUtil.NEWONECLASS_LINKURL);
				int sortId = res.getInt(SqlUtil.NEWONECLASS_SORTID);
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

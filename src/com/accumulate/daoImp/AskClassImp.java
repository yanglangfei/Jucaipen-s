package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.AskClassDao;
import com.accumulate.entity.AskClass;
import com.accumulate.utils.JdbcUtil;

public class AskClassImp implements AskClassDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<AskClass> askClasss=new ArrayList<AskClass>();

	public List<AskClass> findAllClass() {
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_AskClass ORDER BY Id");
			askClasss=getAskClass(res);
			return askClasss;
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

	public AskClass findAskClassById(int id) {
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_AskClass WHERE Id="+id);
			askClasss=getAskClass(res);
			if(askClasss.size()>0){
				return askClasss.get(0);
			}
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
	
	public List<AskClass> getAskClass(ResultSet result){
		askClasss.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				String className=res.getString("ClassName");
				AskClass askClass=new AskClass(id, className);
				askClasss.add(askClass);
			}
			return askClasss;
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

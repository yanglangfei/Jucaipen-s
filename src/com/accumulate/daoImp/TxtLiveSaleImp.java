package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.TxtLiveSaleDao;
import com.accumulate.entity.TxtLiveSale;
import com.accumulate.utils.JdbcUtil;

public class TxtLiveSaleImp implements TxtLiveSaleDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<TxtLiveSale> slList=new ArrayList<TxtLiveSale>();
	

	public List<TxtLiveSale> findAllTxtLiveSale() {
		// 获取所有的销售信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
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

	public List<TxtLiveSale> findTxtLiveSaleByUid(int userId) {
		//根据用户id获取直播销售信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE UserId="+userId+" ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
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

	public List<TxtLiveSale> findTxtLiveSaleByTeacherId(int teacherId) {
		//根据讲师id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE TearchId="+teacherId+" ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
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

	public List<TxtLiveSale> findTxtLiveSaleByLiveId(int liveId) {
		//根据直播id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE LiveId="+liveId+" ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
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

	public TxtLiveSale findTxtLiveSaleByUiDAndLiveId(int uId, int liveId) {
		// 根据直播id和用户id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE LiveId="+liveId+" AND UserId="+uId);
		    slList=getTexLiveSales(res);
			if(slList.size()>0){
				return slList.get(0);
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

	public TxtLiveSale findTxtLiveSaleById(int id) {
		//根据id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE Id="+id+"");
		    slList=getTexLiveSales(res);
			if(slList.size()>0){
				return slList.get(0);
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

	public TxtLiveSale findTxtLiveSaleByOrderCode(String orderCode) {
		//根据订单号获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE OrderCode="+orderCode+" ");
		    slList=getTexLiveSales(res);
			if(slList.size()>0){
				return slList.get(0);
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

	public List<TxtLiveSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		// 获取用户最近几条信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP "+count +" FROM JCPTearch_TxtLive_Sale WHERE UserId="+uId+" ORDER BY InsertDate DESC");
		    slList=getTexLiveSales(res);
			return slList;
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
	
	public List<TxtLiveSale> getTexLiveSales(ResultSet result){
		slList.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				int userId=result.getInt("UserId");
				int teacherId=result.getInt("TearchId");
				String orderCode=result.getString("OrderCode");
				int liveId=result.getInt("LiveId");
				String insertDate=result.getString("InsertDate");
				TxtLiveSale sale=new TxtLiveSale(id, userId, teacherId, orderCode, liveId, insertDate);
				slList.add(sale);
			}
			return slList;
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

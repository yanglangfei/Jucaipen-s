package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.TxtLiveDetailsDao;
import com.accumulate.entity.TxtLiveDetails;
import com.accumulate.utils.JdbcUtil;

public class TxtLiveDetaileImp implements TxtLiveDetailsDao {
	private List<TxtLiveDetails> txtLiveDetails = new ArrayList<TxtLiveDetails>();
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private int isSuccess;

	public int insertTextDetaile(TxtLiveDetails details) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_TxtLiveDetails(FK_LiveId,FK_InterId,Bodys,Images,LiveType,InsertDate) VALUES("
							+ details.getRelate_liveId()
							+ ","
							+ details.getRelate_titleId()
							+ ",'"
							+ details.getBodys()
							+ "','"
							+ details.getImage()
							+ "',"
							+ details.getLiveType()
							+ ",'"
							+ details.getInsertDate() + "')");
			return isSuccess;
		} catch (Exception e) {
		}
		return 0;
	}

	public List<TxtLiveDetails> findTextDetaileByLiveId(int liveId) {
		try {
			txtLiveDetails.clear();
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,FK_LiveId,Bodys,InsertDate FROM JCPTearch_TxtLiveDetails WHERE FK_LiveId="
							+ liveId+" ORDER BY InsertDate DESC");
			while (res.next()) {
				int id=res.getInt(1);
				int relate_LiveId=res.getInt(2);
				String bodys=res.getString(3);
				String insertDate=res.getString(4);
				TxtLiveDetails diDetails=new TxtLiveDetails(id, relate_LiveId, -1, bodys, null, -1, insertDate);
				txtLiveDetails.add(diDetails);
			}
			return txtLiveDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TxtLiveDetails> findPullTextDetaileByLiveId(int liveId,int maxId) {
		try {
			txtLiveDetails.clear();
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,FK_LiveId,Bodys,InsertDate FROM JCPTearch_TxtLiveDetails WHERE FK_LiveId="
							+ liveId+"AND Id>"+maxId+" ORDER BY InsertDate DESC");
			while (res.next()) {
				int id=res.getInt(1);
				int relate_LiveId=res.getInt(2);
				String bodys=res.getString(3);
				String insertDate=res.getString(4);
				TxtLiveDetails diDetails=new TxtLiveDetails(id, relate_LiveId, -1, bodys, null, -1, insertDate);
				txtLiveDetails.add(diDetails);
			}
			return txtLiveDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TxtLiveDetails> findTextDetaileByTitleId(int titleId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_TxtLiveDetails WHERE FK_InterId="
							+ titleId+"ORDER InsertDate DESC");
			txtLiveDetails = getTexDetaile(res);
			return txtLiveDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TxtLiveDetails findTextDetaileById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_TxtLiveDetails WHERE Id="
							+ id);
			txtLiveDetails = getTexDetaile(res);
			if (txtLiveDetails.size() > 0) {
				return txtLiveDetails.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TxtLiveDetails> findTextDetaileByType(int type) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_TxtLiveDetails WHERE LiveType="
							+ type + " ORDER BY InsertDate DESC");
			txtLiveDetails = getTexDetaile(res);
			return txtLiveDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TxtLiveDetails> findAllTextDetaile() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_TxtLiveDetails ORDER BY InsertDate DESC");
			txtLiveDetails = getTexDetaile(res);
			return txtLiveDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TxtLiveDetails> getTexDetaile(ResultSet result) {
		txtLiveDetails.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int relateLiveId = result.getInt("FK_LiveId");
				int relateTitelId = result.getInt("FK_InterId");
				String bodys = result.getString("Bodys");
				String image = result.getString("Images");
				int liveType = result.getInt("LiveType");
				String insertDate = result.getString("InsertDate");
				TxtLiveDetails txDetails = new TxtLiveDetails(id, relateLiveId,
						relateTitelId, bodys, image, liveType, insertDate);
				txtLiveDetails.add(txDetails);
			}
			return txtLiveDetails;
		} catch (Exception e) {
		}
		return null;
	}

}

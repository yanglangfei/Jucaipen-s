package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.SigningDao;
import com.accumulate.entity.Signing;
import com.accumulate.utils.JdbcUtil;

public class SigningImp implements SigningDao {
	private int isSuccess;
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Signing> signings = new ArrayList<Signing>();

	public int insertSigin(Signing signing) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("INSERT INTO JCPTearch_Signing "
					+ "(UserId,TearchId,TrueName,MobileNum,InsertDate,"
					+ "StartDate,EndDate,QSName,Types,Ip,ComeType) VALUES("
					+ signing.getUserId()
					+ ","
					+ signing.getTeacherId()
					+ ",'"
					+ signing.getTrueName()
					+ "','"
					+ signing.getMobileNum()
					+ "','"
					+ signing.getInsertDate()
					+ "','"
					+ signing.getStartDate()
					+ "','"
					+ signing.getEndDate()
					+ "','"
					+ signing.getQSName()
					+ "',"
					+ signing.getState()
					+ ",'"
					+ signing.getIp()
					+ "',"
					+ signing.getComeType()
					+ ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Signing findSignById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Signing WHERE Id="
					+ id);
			signings = getSiging(res);
			if (signings.size() > 0) {
				return signings.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Signing> findAllSigin() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Signing  ORDER BY InsertDate DESC");
			signings = getSiging(res);
			return signings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Signing> findSignByUserId(int userId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Signing WHERE UserId="
							+ userId + " ORDER BY InsertDate DESC");
			signings = getSiging(res);
			return signings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Signing> findSiginByTeacherId(int teacherId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Signing WHERE TearchId="
							+ teacherId + " ORDER BY InsertDate DESC");
			signings = getSiging(res);
			return signings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Signing> findSiginByType(int type) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Signing WHERE Types="
							+ type + " ORDER BY InsertDate DESC");
			signings = getSiging(res);
			return signings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Signing> getSiging(ResultSet result) {
		signings.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				int teacherId = result.getInt("TearchId");
				String trueName = result.getString("TrueName");
				String mobileNum = result.getString("MobileNum");
				String insertDate = result.getString("InsertDate");
				String startDate = result.getString("StartDate");
				String endDate = result.getString("EndDate");
				String qsName = result.getString("QSName");
				int state = result.getInt("Types");
				String ip = result.getString("Ip");
				int comeFrom = result.getInt("ComeType");
				Signing signing = new Signing(id, userId, teacherId, trueName,
						mobileNum, insertDate, startDate, endDate, qsName,
						state, ip, comeFrom);
				signings.add(signing);
			}
			return signings;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.TxtLiveDao;
import com.accumulate.entity.TextLive;
import com.accumulate.utils.JdbcUtil;

public class TextLiveImp implements TxtLiveDao {
	private List<TextLive> textLives = new ArrayList<TextLive>();
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;

	/**
	 * @return 查询文字直播总页数
	 */
	public int findTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_TxtLive "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int insertTxtLive(TextLive textLive) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_TxtLive (Title,StartDate,EndDate,Goods,RenQi,IsYouke,TearchId,IsEnd) VALUES ('"
							+ textLive.getTitle()
							+ "','"
							+ textLive.getStartDate()
							+ "','"
							+ textLive.getEndDate()
							+ "',"
							+ textLive.getGoods()
							+ ","
							+ textLive.getMoods()
							+ ","
							+ textLive.getIsYouKe()
							+ ","
							+ textLive.getTeacherId()
							+ ","
							+ textLive.getIsEnd() + ")");
			return isSuccess;
		} catch (Exception e) {
		}
		return 0;
	}

	public TextLive findTextLiveById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_TxtLive WHERE Id="
					+ id);
			textLives = getTxtLive(res, 0, 0);
			if (textLives.size() > 0) {
				return textLives.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TextLive> findAllTextLive(int page) {
		try {
			int totlePage = findTotlePage("");
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY StartDate desc) AS RowNumber,* FROM JCPTearch_TxtLive) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			textLives = getTxtLive(res, page, totlePage);
			return textLives;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TextLive> findTxtLiveByTeacherIdAndLast(int teacherId, int count) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + count
					+ " * FROM JCPTearch_TxtLive WHERE TearchId=" + teacherId
					+ " ORDER BY StartDate DESC");
			textLives = getTxtLive(res, 0, 0);
			return textLives;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TextLive> findTextLiveByTeacherId(int teacherId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_TxtLive WHERE TearchId="
							+ teacherId + " ORDER BY StartDate DESC");
			textLives = getTxtLive(res, 0, 0);
			return textLives;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TextLive> findTextLiveByIsEnd(int isEnd) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_TxtLive WHERE IsEnd="
							+ isEnd + " ORDER BY StartDate DESC");
			textLives = getTxtLive(res, 0, 0);
			return textLives;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TextLive> getTxtLive(ResultSet result, int page, int totlePage) {
		textLives.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String title = result.getString("Title");
				String startDate = result.getString("StartDate");
				String endDate = result.getString("EndDate");
				int goods = result.getInt("Goods");
				int renqi = result.getInt("RenQi");
				int isYouKe = result.getInt("IsYouke");
				int teacherId = result.getInt("TearchId");
				int isEnd = result.getInt("IsEnd");
				TextLive textLive = new TextLive(id, title, startDate, endDate,
						goods, renqi, isYouKe, teacherId, isEnd);
				textLive.setPage(page);
				textLive.setTotlePage(totlePage);
				textLives.add(textLive);
			}
			return textLives;
		} catch (Exception e) {
		}
		return null;
	}

}

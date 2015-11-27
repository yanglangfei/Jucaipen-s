package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.HotIdeaDao;
import com.accumulate.entity.HotIdea;
import com.accumulate.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 * 
 *         日志，热门观点 -----------------------JCPTearch_LiveLog ---按点击量排列
 */
public class HotIdeaImp implements HotIdeaDao {
	private List<HotIdea> ideas = new ArrayList<HotIdea>();
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private int isSuccess;

	/**
	 * @return 查询新闻总页数
	 */
	public int findTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_LiveLog "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int addHit(int ideaId, int hits) {
		// 添加点赞数
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPTearch_LiveLog SET Hits="
					+ hits + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public int addComment(int ideaId, int commCount) {
		// 添加评论数
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("UPDATE JCPTearch_LiveLog SET Commens="
							+ commCount + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public int addGood(int ideaId, int googs) {
		// 添加点赞数
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPTearch_LiveLog SET Goods="
					+ googs + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public HotIdea findGoodAndHitAndComm(int id) {
		// 获取点赞数、点击数和评论数
		HotIdea idea = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Goods,Commens,Hits FROM JCPTearch_LiveLog WHERE Id="
							+ id);
			while (res.next()) {
				int goods = res.getInt("Goods");
				int comms = res.getInt("Commens");
				int hits = res.getInt("Hits");
				idea = new HotIdea();
				idea.setId(id);
				idea.setHits(hits);
				idea.setCommens(comms);
				idea.setGoods(goods);
				return idea;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<HotIdea> findAllHotIdea(int page) {
		ideas.clear();
		try {
			int totlePage = findTotlePage("");
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,InsertDate,Title,Bodys,Hits,TearchId FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCPTearch_LiveLog) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(1);
				String insertDate = res.getString(2);
				String title = res.getString(3);
				String body = res.getString(4);
				int hits = res.getInt(5);
				int teacherId = res.getInt(6);
				HotIdea idea = new HotIdea();
				idea.setId(id);
				idea.setTotlePgae(totlePage);
				idea.setPage(page);
				idea.setInsertDate(insertDate);
				idea.setBodys(body);
				idea.setHits(hits);
				idea.setTitle(title);
				idea.setTeacherId(teacherId);
				ideas.add(idea);
			}
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HotIdea> findIdeaByCount(int count) {
		ideas.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "
							+ count
							+ " Id,ISNULL (Title,'') Title,ISNULL (Bodys,'') Bodys,ISNULL (LogImg,'') LogImg FROM JCPTearch_LiveLog  WHERE LEN(LogImg)>0 ORDER BY InsertDate DESC");
			while (res.next()) {
				int id = res.getInt("Id");
				String title = res.getString("Title");
				String bodys = res.getString("Bodys");
				String logImage = res.getString("LogImg");
				HotIdea idea = new HotIdea();
				idea.setId(id);
				idea.setLogImage(logImage);
				idea.setBodys(bodys);
				idea.setTitle(title);
				ideas.add(idea);
			}
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HotIdea> findIdeaByTeacherId(int teacherId, int page) {
		try {
			int totlePage = findTotlePage("WHERE TearchId=" + teacherId);
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCPTearch_LiveLog"
							+ " WHERE TearchId=" + teacherId + " )A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			ideas = getHotIdea(res, page, totlePage);
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public HotIdea findIdeaById(int id) {
		ideas.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Title,Bodys,InsertDate,Goods,TearchId FROM JCPTearch_LiveLog WHERE Id="
							+ id + " ORDER BY InsertDate DESC");
			while (res.next()) {
				String title = res.getString(1);
				String body = res.getString(2);
				String insertDate = res.getString(3);
				int goods = res.getInt(4);
				int teacherId = res.getInt(5);
				HotIdea idea = new HotIdea();
				idea.setId(id);
				idea.setBodys(body);
				idea.setTitle(title);
				idea.setInsertDate(insertDate);
				idea.setGoods(goods);
				idea.setTeacherId(teacherId);
				return idea;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HotIdea> getHotIdea(ResultSet result, int page, int totlePage) {
		ideas.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String title = result.getString("Title");
				String bodys = result.getString("Bodys");
				int goods = result.getInt("Goods");
				int hits = result.getInt("Hits");
				int comms = result.getInt("Commens");
				int classId = result.getInt("ClassId");
				String keyWord = result.getString("KeyWord");
				String insertDate = result.getString("InsertDate");
				int teacherId = result.getInt("TearchId");
				String logImage = result.getString("LogImg");
				HotIdea idea = new HotIdea();
				idea.setPage(page);
				idea.setTotlePgae(totlePage);
				idea.setId(id);
				idea.setBodys(bodys);
				idea.setTitle(title);
				idea.setGoods(goods);
				idea.setHits(hits);
				idea.setCommens(comms);
				idea.setClassId(classId);
				idea.setKeyWord(keyWord);
				idea.setInsertDate(insertDate);
				idea.setTeacherId(teacherId);
				idea.setLogImage(logImage);
				ideas.add(idea);
			}
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}

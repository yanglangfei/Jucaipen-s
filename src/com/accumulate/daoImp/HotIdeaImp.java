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
		return 0;

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
			// TODO: handle exception
		}
		return 0;
	}

	public int addComment(int ideaId, int commCount) {
		//添加评论数
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPTearch_LiveLog SET Commens="
					+ commCount + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int addGood(int ideaId, int googs) {
		//添加点赞数
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPTearch_LiveLog SET Goods="
					+ googs + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return 0;
	}

	public HotIdea findGoodAndHitAndComm(int id) {
		//获取点赞数、点击数和评论数
		HotIdea idea=null;
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT Goods,Commens,Hits FROM JCPTearch_LiveLog");
			while (res.next()) {
				int goods=res.getInt(1);
				int comms=res.getInt(2);
				int hits=res.getInt(3);
				idea=new HotIdea();
				idea.setId(id);
				idea.setHits(hits);
				idea.setCommens(comms);
				idea.setGoods(goods);
			}
			return idea;
		} catch (Exception e) {
		}
		return null;
	}

	public List<HotIdea> findAllHotIdea(int page) {
		try {
			int totlePage = findTotlePage("");
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Hits desc) AS RowNumber,* FROM JCPTearch_LiveLog) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			ideas = getHotIdea(res, page, totlePage);
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
							+ " Id,ISNULL (Title,'') Title,ISNULL (Bodys,'') Bodys,ISNULL (LogImg,'') LogImg FROM JCPTearch_LiveLog ORDER BY Hits DESC");
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
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Hits desc) AS RowNumber,* FROM JCPTearch_LiveLog"
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
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_LiveLog WHERE Id="
					+ id + " ORDER BY Hits DESC");
			ideas = getHotIdea(res, 0, 0);
			if (ideas.size() > 0) {
				return ideas.get(0);
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

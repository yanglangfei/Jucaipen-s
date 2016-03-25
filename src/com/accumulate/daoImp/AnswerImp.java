package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.AnswerDao;
import com.accumulate.entity.Answer;
import com.accumulate.utils.JdbcUtil;

public class AnswerImp implements AnswerDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<Answer> answers = new ArrayList<Answer>();
	
	

	/**
	 * @return 查询新闻评论总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_Answer "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
			   JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	public int insertAnswer(Answer answer) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_Answer"
							+ "(AnswerBody,TearcherId,AnswerDate,PingJia,AskId,Pingfen)"
							+ "VALUES ('" + answer.getAnswerBody() + "',"
							+ answer.getTeacherId() + ",'"
							+ answer.getAnswerDate() + "','"
							+ answer.getRemark() + "'," + answer.getAskId()
							+ "," + answer.getPingFen() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public Answer findAnswerById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Answer WHERE Id="
					+ id);
			answers = getAnswer(res,1,1);
			if (answers.size() > 0) {
				return answers.get(0);
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

	public List<Answer> findAnswerByLast(int count) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "+count+" * FROM JCPTearch_Answer ORDER BY AnswerDate DESC");
			answers = getAnswer(res,1,1);
			return answers;
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
	
	
	public List<Answer> findAllAnswer(int page) {
		int totlePage=findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER ( ORDER BY AnswerDate DESC) AS RowNumber,* FROM JCPTearch_Answer"
							+") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			answers = getAnswer(res,page,totlePage);
			return answers;
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

	public List<Answer> findAnswerByTeacherId(int teacherId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Answer WHERE TearcherId="
							+ teacherId + " ORDER BY AnswerDate DESC");
			answers = getAnswer(res,1,1);
			return answers;
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

	public Answer findAnswerByAskId(int askId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT AnswerBody,TearcherId FROM JCPTearch_Answer WHERE AskId="
							+ askId + " ORDER BY AnswerDate DESC");
			while (res.next()) {
				String answerBody=res.getString(1);
				int teacherId=res.getInt(2);
				Answer answer=new Answer();
				answer.setAnswerBody(answerBody);
				answer.setTeacherId(teacherId);
				return answer;
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

	public List<Answer> findAnswerByTeacherAndLast(int teacherId, int count) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + count
					+ " * FROM JCPTearch_Answer WHERE TearcherId=" + teacherId
					+ " ORDER BY AnswerDate DESC");
			answers = getAnswer(res,1,1);
			return answers;
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

	public List<Answer> getAnswer(ResultSet result,int page,int totlePage) {
		answers.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String answerBody = result.getString("AnswerBody");
				int teacherId = result.getInt("TearcherId");
				String answerDate = result.getString("AnswerDate");
				String remark = result.getString("PingJia");
				int askId = result.getInt("AskId");
				int scroe = result.getInt("Pingfen");
				Answer answer = new Answer();
				answer.setPage(page);
				answer.setTotlePage(totlePage);
				answer.setId(id);
				answer.setAnswerBody(answerBody);
				answer.setTeacherId(teacherId);
				answer.setAnswerDate(answerDate);
				answer.setRemark(remark);
				answer.setAskId(askId);
				answer.setPingFen(scroe);
				answers.add(answer);
			}
			return answers;
		} catch (Exception e) {
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

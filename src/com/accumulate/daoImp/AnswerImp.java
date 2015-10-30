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
		}
		return -1;
	}

	public Answer findAnswerById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCPTearch_Answer WHERE Id="
					+ id);
			answers = getAnswer(res);
			if (answers.size() > 0) {
				return answers.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Answer> findAnswerByLast(int count) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "+count+" * FROM JCPTearch_Answer ORDER BY AnswerDate DESC");
			answers = getAnswer(res);
			return answers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Answer> findAllAnswer() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Answer ORDER BY AnswerDate DESC");
			answers = getAnswer(res);
			return answers;
		} catch (SQLException e) {
			e.printStackTrace();
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
			answers = getAnswer(res);
			return answers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Answer findAnswerByAskId(int askId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Answer WHERE AskId="
							+ askId + " ORDER BY AnswerDate DESC");
			answers = getAnswer(res);
			if (answers.size() > 0) {
				return answers.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			answers = getAnswer(res);
			return answers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Answer> getAnswer(ResultSet result) {
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
			// TODO: handle exception
		}
		return null;
	}

}

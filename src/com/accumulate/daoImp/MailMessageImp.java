package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accumulate.dao.MailMessageDao;
import com.accumulate.entity.MailMessage;
import com.accumulate.utils.JdbcUtil;

public class MailMessageImp implements MailMessageDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;

	public int insertMessage(MailMessage mailMessage) {
		// 发送邮件
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int upDateMessageType(int type) {
		//修改邮件状态
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

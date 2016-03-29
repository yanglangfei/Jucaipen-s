package com.accumulate.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author YLF
 * 
 *         ���ݿ⹤����
 * 
 */
public class JdbcUtil {
	/*
	 * SqlServer �������ݿ�
	 */
	private static final String SQLSERVER_DRIVER_TEST = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL_TEST = "jdbc:sqlserver://192.168.1.233; DatabaseName=JCPData";
	private static final String SQLSERVER_UNAME_TEST = "sa";
	private static final String SQLSERVER_UPWD_TEST = "111111";
	
	/**
	 *   SqlServer ��Ƶ���ݿ�
	 */
	private static final String SQLSERVER_DRIVER_VIDEO="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL_VIDEO="jdbc:sqlserver://121.41.46.228; DatabaseName=ChatRoom";
	private static final String SQLSERVER_UNAME_VIDEO="chat";
	private static final String SQLSERVER_UPWD_VIDEO="cHat2013";
	
	/*
	 * SqlServer ��ʽ���ݿ�
	 * 
	 */
	private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL = "jdbc:sqlserver://121.41.46.228; DatabaseName=JCPData";
	private static final String SQLSERVER_UNAME = "jcp";
	private static final String SQLSERVER_UPWD = "jCp#)2016";
	
	
	
	/*
	 * ����MySql ���ݿ�
	 * 
	 */
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://121.40.227.121:3306/jucaipen";
	private static final String MYSQL_UNAME = "jucaipen";
	private static final String MYSQL_UPWD = "jucaipen168";
	@SuppressWarnings("unused")
	private static final String MYSQL_ENCODING = "useUnicode=true&characterEncoding=UTF8";
	private static Connection dbConn;
	private static boolean isNormal;
	
	
	/**
	 *  Derby ���ݿ�������Ϣ
	 */
	private static final String DERBY_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DERBY_URL="jdbc:derby://121.40.227.121:1521/APP;create=true";
	private static final String DERBY_UNAME="jucaipen168";
	private static final String DERBY_PWD="jucaipen168";

	/**
	 * @return ����sqlServer ��ʽ���ݿ�
	 */
	public static Connection connSqlServer() {
		try {
			Class.forName(SQLSERVER_DRIVER).newInstance();
			Properties p=new Properties();
			p.put("user", SQLSERVER_UNAME);
			p.put("password", SQLSERVER_UPWD);
			p.put("defaultRowPrefetch", "30");
			p.put("defaultBatchValue", "5");
			dbConn=DriverManager.getConnection(SQLSERVER_URL, p);
			return dbConn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	/**
	 * @return   ����sqlServer �������ݿ�
	 */
	public static Connection connTestSqlServer(){
		try {
			Class.forName(SQLSERVER_DRIVER_TEST).newInstance();
			Properties p=new Properties();
			p.put("user", SQLSERVER_UNAME_TEST);
			p.put("password", SQLSERVER_UPWD_TEST);
			p.put("defaultRowPrefetch", "30");
			p.put("defaultBatchValue", "5");
			dbConn=DriverManager.getConnection(SQLSERVER_URL_TEST, p);
			dbConn = DriverManager.getConnection(SQLSERVER_URL_TEST,
					SQLSERVER_UNAME_TEST, SQLSERVER_UPWD_TEST);
			return dbConn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	/**
	 * @return   ����sqlServer Video���ݿ�
	 */
	public static Connection connVideoSqlServer(){
		try {
			Class.forName(SQLSERVER_DRIVER_VIDEO).newInstance();
			Properties p=new Properties();
			p.put("user", SQLSERVER_UNAME_VIDEO);
			p.put("password", SQLSERVER_UPWD_VIDEO);
			p.put("defaultRowPrefetch", "30");
			p.put("defaultBatchValue", "5");
			dbConn = DriverManager.getConnection(SQLSERVER_URL_VIDEO,p);
			return dbConn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public void connDerby(){
		try {
			Class.forName(DERBY_DRIVER).newInstance();
			Properties p=new Properties();
			p.put("user", DERBY_UNAME);
			p.put("password", DERBY_PWD);
			p.put("defaultRowPrefetch", "30");
			p.put("defaultBatchValue", "5");
			dbConn=DriverManager.getConnection(DERBY_URL,p);
			Statement sta=dbConn.createStatement();
			ResultSet res=sta.executeQuery("SELECT ID FROM APKINFO");
			while (res.next()) {
				//int id=res.getInt("ID");
			}
		} catch (Exception e) {
		}
	}

	/**
	 * @return ����mySql ���ݿ�
	 */
	public static Connection connMySql() {
		try {
			Class.forName(MYSQL_DRIVER).newInstance();
			Properties p=new Properties();
			p.put("user", MYSQL_UNAME);
			p.put("password", MYSQL_UPWD);
			p.put("defaultRowPrefetch", "30");
			p.put("defaultBatchValue", "5");
			dbConn = DriverManager.getConnection(MYSQL_URL,p);
			return dbConn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static Connection isConnectNormalSql(){
		isNormal=true;
		if(isNormal){
			return connSqlServer();
		}else {
			return connTestSqlServer();
		}
	}
	
	
	/**
	 * @param s
	 * @param conn
	 * @param r
	 * @throws SQLException  �ر����ݿ�
	 */
	public static  void closeConn(Statement s,Connection conn,ResultSet r) throws SQLException{
		if(s!=null){
			s.close();
		}
		if(r!=null){
			r.close();
		}
		if(conn!=null){
			conn.close();
		}
	}

}

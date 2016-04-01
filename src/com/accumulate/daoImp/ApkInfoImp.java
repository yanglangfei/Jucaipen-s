package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.ApkInfoDao;
import com.accumulate.entity.ApkInfo;
import com.accumulate.utils.JdbcUtil;

public class ApkInfoImp implements ApkInfoDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ApkInfo> infos = new ArrayList<ApkInfo>();
	private int isSuccess;

	
	/*
	 * 
	 *  ��ȡ���APK��Ϣ��id
	 */
	public int querrtMaxId() {
		try {
			dbConn = JdbcUtil.connMySql();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select max(Id) from versionInfo");
			while (res.next()) {
				int maxId = res.getInt(1);
				return maxId;
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

		return 0;
	}

	/*
	 * 
	 * ��ȡ����apk�汾��
	 */
	public ApkInfo findApkInfoById(int id) {
		ApkInfo apkInfo = null;
		try {
			dbConn = JdbcUtil.connMySql();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  versionCode,apkUrl FROM versionInfo ORDER BY versionCode DESC LIMIT 0,1");
			while (res.next()) {
				int versionCode = res.getInt(1);
				String apkPath = res.getString(2);
				apkInfo = new ApkInfo();
				apkInfo.setApkPath(apkPath);
				apkInfo.setVersionCode(versionCode);
			}
			return apkInfo;
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

	/*
	 * ��ȡȫ��APK�汾��Ϣ
	 */
	public List<ApkInfo> findAll() {
		infos.clear();
		try {
			dbConn = JdbcUtil.connMySql();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT Id,pkgName,versionCode,versionName,apkUrl FROM versionInfo");
			while (res.next()) {
				int id = res.getInt(1);
				String pkgName = res.getString(2);
				int versionCode = res.getInt(3);
				String versionName = res.getString(4);
				String apkUrl = res.getString(5);
				ApkInfo info = new ApkInfo();
				info.setId(id);
				info.setPkgName(pkgName);
				info.setVersionCode(versionCode);
				info.setVsionName(versionName);
				info.setApkPath(apkUrl);
				infos.add(info);
			}
			return infos;
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

	/*
	 * ���APK�汾��Ϣ
	 */
	public int insertApkInfo(ApkInfo info) {
		try {
			dbConn = JdbcUtil.connMySql();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO versionInfo ( Id ,pkgName,versionCode,versionName,apkUrl,updateDate ) VALUES ("
							+ info.getId()
							+ ",'"
							+ info.getPkgName()
							+ "',"
							+ info.getVersionCode()
							+ ",'"
							+ info.getVsionName()
							+ "','"
							+ info.getApkPath()
							+ "','" + info.getUpdateDate() + "')");
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
		return 0;
	}

	/*
	 * ɾ��APK�汾��Ϣ
	 */
	public int deleteApkInfo() {
		try {
			dbConn = JdbcUtil.connMySql();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("DELETE  versionInfo WHERE");
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
		return 0;
	}

}

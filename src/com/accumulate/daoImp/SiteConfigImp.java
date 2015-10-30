package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.accumulate.dao.SiteConfigDao;
import com.accumulate.entity.SiteConfig;
import com.accumulate.utils.JdbcUtil;

public class SiteConfigImp implements SiteConfigDao {
	
	private SiteConfig config;
	private Connection dbConn;
	private Statement state;
	private ResultSet res;

	public SiteConfig findSiteConfig() {
		//获取配置信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			state=dbConn.createStatement();
			res=state.executeQuery("SELECT * FROM JCPSiteConfig");
			while (res.next()) {
				String siteName=res.getString("SiteTitle");
				int askNum=res.getInt("JCPAskNum");
				config=new SiteConfig();
				config.setAskNum(askNum);
				config.setSiteName(siteName);
			}
			return config;
		} catch (Exception e) {
		}
		return null;
	}

}

package com.accumulate.service;

import com.accumulate.dao.SiteConfigDao;
import com.accumulate.daoImp.SiteConfigImp;
import com.accumulate.entity.SiteConfig;

/**
 * @author YLF
 * 
 *
 */
public class SiteConfigSer{

	/**
	 * @return   获取配置信息
	 */
	public static SiteConfig findSiteConfig() {
		SiteConfigDao dao=new SiteConfigImp();
		return dao.findSiteConfig();
	}
}

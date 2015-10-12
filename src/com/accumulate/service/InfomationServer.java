package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.SysInfoDao;
import com.accumulate.daoImp.SysInfoImp;
import com.accumulate.entity.SystemInfo;

public class InfomationServer {
	/**
	 * @return 查询全部信息
	 */
	public static List<SystemInfo> getInfos(int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return 查询单个信息
	 */
	public static SystemInfo getInfo(int id) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findSystemInfo(id);
	}

}

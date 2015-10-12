package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LogDao;
import com.accumulate.daoImp.LogImp;
import com.accumulate.entity.LoginLog;

public class LogServer {
	/**
	 * @param userId
	 * @return 根据用户id查询登录日志
	 */
	public static List<LoginLog> findLogByUser(int userId, int pager) {
		LogDao dao = new LogImp();
		return dao.findLogByUser(userId, pager);
	}

	/**
	 * @param id
	 * @return 根据日志id，查询登录日志信息
	 */
	public static LoginLog findLogById(int id) {
		LogDao dao = new LogImp();
		return dao.findLog(id);
	}

	/**
	 * @param log
	 * @return  添加登录日志
	 */
	public static int insertLog(LoginLog log) {
		LogDao dao = new LogImp();
		return dao.insertLog(log);
	}

}

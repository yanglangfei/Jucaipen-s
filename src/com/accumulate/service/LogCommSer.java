package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LogCommenDao;
import com.accumulate.daoImp.LogCommImp;
import com.accumulate.entity.LogCommen;

public class LogCommSer{

	/**
	 * @param logCommen
	 * @return  添加日志评论
	 */
	public static int insertLogComm(LogCommen logCommen) {
		LogCommenDao dao=new LogCommImp();
		return dao.insertLogComm(logCommen);
	}

	/**
	 * @param id
	 * @return  根据id查询日志评论内容
	 */
	public static LogCommen findLogCommBuId(int id) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommBuId(id);
	}

	/**
	 * @return  查询所有的日志评论
	 */
	public static List<LogCommen> findAllComm() {
		LogCommenDao dao=new LogCommImp();
		return dao.findAllComm();
	}

	/**
	 * @param uid
	 * @return  根据用户id查询日志评论
	 */
	public static List<LogCommen> findLogCommByUserId(int uid) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByUserId(uid);
	}

	/**
	 * @param logId
	 * @return  根据日志id查询日志评论
	 */
	public static List<LogCommen> findLogCommByLogId(int logId) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByLogId(logId);
	}

	/**
	 * @param uid
	 * @param logId
	 * @return  根据用户id、日志id查询日志评论
	 */
	public static List<LogCommen> findLogCommByUidAndLogId(int uid, int logId) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByUidAndLogId(uid, logId);
	}

}

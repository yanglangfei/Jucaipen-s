package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.LogCommen;

public interface LogCommenDao {
	/**
	 * @param logCommen
	 * @return  添加日志评论
	 */
	public int insertLogComm(LogCommen logCommen);
	/**
	 * @param id
	 * @return 根据id获取日志评论详细信息
	 */
	public LogCommen findLogCommBuId(int id);
	/**
	 * @return 获取所有日志评论信息
	 */
	public List<LogCommen> findAllComm();
	/**
	 * @param uid
	 * @return  根据用户id获取日志评论信息
	 */
	public List<LogCommen> findLogCommByUserId(int uid);
	/**
	 * @param logId
	 * @return 根据日志id获取日志评论信息
	 */
	public List<LogCommen> findLogCommByLogId(int logId);
	/**
	 * @param uid
	 * @param logId
	 * @return  根据用户id、日志id查询日志评论
	 */
	public List<LogCommen> findLogCommByUidAndLogId(int uid,int logId);
}

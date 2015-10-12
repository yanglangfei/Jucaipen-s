package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.LoginLog;

/**
 * @author YLF
 * 
 *   登录日志操作类
 *
 */
public interface LogDao {
	/**
	 * @param log
	 * @return  添加登录日志
	 */
	public int insertLog(LoginLog log);
	/**
	 * @param id
	 * @return  删除登录日志
	 */
	public int deleteLog(int id);
	/**
	 * @param id
	 * @return  根据id查找登录日志
	 */
	public LoginLog findLog(int id);
	/**
	 * @param userId
	 * @return  查找当前用户下所有的登录日志信息
	 */
	public List<LoginLog> findLogByUser(int userId,int pager);

}

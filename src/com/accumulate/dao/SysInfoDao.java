package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.SystemInfo;

public interface SysInfoDao {
	/**
	 * @return  查询所有的系统消息
	 */
	public List<SystemInfo> findAll(int page);
	/**
	 * @param id
	 * @return 查询指定的系统消息
	 */
	public SystemInfo findSystemInfo(int id);
	/**
	 * @param type
	 * @return   根据类型获取所有的信息
	 */
	public List<SystemInfo> findInfoByType(int type,int page);
	/**
	 * @param receiverId
	 * @return  查询接受者所有的信息
	 */
	public List<SystemInfo> findInfoByReceiver(int receiverId,int page);
	/**
	 * @param senderId
	 * @return   查询发送者所有发送的信息
	 */
	public List<SystemInfo> findInfoBySender(int senderId,int page);
	/**
	 * @param readDate
	 * @return  根据信息读取时间获取所有已读/未读信息
	 */
	public List<SystemInfo> findInfoByIsread(String readDate,int page);
	/**
	 * @param SendDate
	 * @return   根据发送时间获取信息
	 */
	public List<SystemInfo> findInfoBySendDate(String SendDate,int page);
	
	/**
	 * @param userId
	 * @return   通过用户id获取系统消息
	 */
	public List<SystemInfo> findAllSystemInfoByUserId(int userId,int page);

}

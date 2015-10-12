package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ReadInfo;

public interface ReadInfoDao {
	/**
	 * @return 获取所有读取信息记录
	 */
	public List<ReadInfo> findAll(int page);
	/**
	 * @param id
	 * @return 获取指定读取的信息
	 */
	public ReadInfo findReadInfo(int id);
	/**
	 * @param userId
	 * @return  查询指定用户读取的所有信息
	 */
	public List<ReadInfo> findReadInfoByUser(int userId,int page);
	/**
	 * @param readDate
	 * @return   根据读取时间查询读取的信息
	 */
	public List<ReadInfo> findReadInfoByReadDate(String readDate,int page);

}

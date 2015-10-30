package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Signing;

public interface SigningDao {
	
	/**
	 * @param signing
	 * @return  添加签约
	 */
	public int insertSigin(Signing signing);
	/**
	 * @param id
	 * @return  根据id获取签约详细信息
	 */
	public Signing findSignById(int id);
	/**
	 * @return 获取所有签约信息
	 */
	public List<Signing> findAllSigin();
	/**
	 * @param userId
	 * @return  根据用户id获取签约信息
	 */
	public List<Signing> findSignByUserId(int userId);
	/**
	 * @param teacherId
	 * @return  根据教师id获取签约信息
	 */
	public List<Signing> findSiginByTeacherId(int teacherId);
	/**
	 * @param type
	 * @return  根据签约类型获取签约信息
	 */
	public List<Signing> findSiginByType(int type);

}

package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.TeacherAttention;

public interface TeacherAttentionDao {
	
	/**
	 * @return 添加关注
	 */
	public int insertAttention(TeacherAttention attention);
	/**
	 * @return 获取所有的关注信息
	 */
	public List<TeacherAttention> findAllAttention();
	/**
	 * @param userId
	 * @return 根据用户id查询关注信息
	 */
	public List<TeacherAttention> findAttentionByUid(int userId);
	/**
	 * @param tId
	 * @return 根据讲师id查询关注信息
	 */
	public List<TeacherAttention> findAttentionBytid(int tId);
	/**
	 * @param uId
	 * @param tId
	 * @return 根据用户id、讲师id获取关注的信息
	 */
	public List<TeacherAttention> findAttentionByUidAndTid(int uId,int tId);
	

}

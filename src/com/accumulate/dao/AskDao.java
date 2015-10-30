package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Ask;

/**
 * @author Administrator
 *
 *  获取提问信息
 *  
 */
public interface AskDao {
	
	/**
	 * @param condition
	 * @return   获取咨询信息总页数
	 */
	public int findTotlePage(String condition);
	
	/**
	 * @return  获取所有提问信息
	 */
	public List<Ask> findAllAsk(int page);
	
	/**
	 * @param count
	 * @return 获取最近的几条提问
	 */
	public List<Ask> findLstAsk(int count);
	
	/**
	 * @param userId
	 * @return  获取当前用户下的所有提问
	 */
	public List<Ask> findAskByUserId(int userId);
	/**
	 * @param teacherId
	 * @return 获取当前讲师下的所有提问
	 */
	public List<Ask> findAskByTeacherId(int teacherId);
	
	/**
	 * @param classId
	 * @return 根据分类查询提问信息
	 */
	public List<Ask> findAskByClassId(int classId);
	/**
	 * @param state
	 * @return  通过状态，查询提问信息 2不显示1为显示
	 */
	public List<Ask> findAskByAskState(int state);
	/**
	 * @param isReply
	 * @return 根据回复状态查询提问信息 2未回复；1已回复
	 */
	public List<Ask> findAskByIsReply(int isReply);
	
	/**
	 * @param id
	 * @return 根据id查询提问信息
	 */
	public Ask findAskById(int id);
	/**
	 * @param ask
	 * @return 添加问题
	 */
	public int insertAsk(Ask ask);

}

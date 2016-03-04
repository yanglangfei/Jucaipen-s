package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.TextLive;

public interface TxtLiveDao {
	
	/**
	 * @param textLive
	 * @return   添加文字直播信息
	 */
	public int insertTxtLive(TextLive textLive);
	
	/**
	 * @param condition
	 * @return  获取文字直播总页数
	 */
	public int findTotlePage(String condition);

	/**
	 * @param id
	 * @return  根据id获取直播信息
	 */
	public TextLive findTextLiveById(int id);
	/**
	 * @return  获取全部直播信息
	 */
	public List<TextLive>findAllTextLive(int page);
	/**
	 * @return   获取全部最新推送的直播信息
	 */
	public List<TextLive> findAllNewTextLivesByPush();
	
	/**
	 * @param teacherId
	 * @return  根据讲师id获取直播信息
	 */
	public List<TextLive> findTextLiveByTeacherId(int teacherId);
	
	/**
	 * @param teacherId
	 * @return   根据讲师id获取文字直播是否免费
	 */
	public TextLive findIsPayByTeacherId(int teacherId);
	/**
	 * @param isEnd
	 * @return   根据是否结束获取直播信息
	 */
	public List<TextLive> findTextLiveByIsEnd(int isEnd);
	
	/**
	 * @param teacherId
	 * @param count
	 * @return   获取讲师最近的几次直播
	 */
	public List<TextLive> findTxtLiveByTeacherIdAndLast(int teacherId,int count);
	/**
	 * @param lastId
	 * @return   通过当前直播id，获取最近的直播信息
	 */
	public List<TextLive> findNewLiveByLastId(int lastId);
	/**
	 * @param count
	 * @return   获取最近几条要推送的消息
	 */
	public List<TextLive> findLastPushLive(int count);
}

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
	 * @param teacherId
	 * @return  根据讲师id获取直播信息
	 */
	public List<TextLive> findTextLiveByTeacherId(int teacherId);
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
}

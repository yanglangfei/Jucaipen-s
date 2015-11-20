package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.LiveInteractive;

/**
 * @author Administrator
 *
 *
 *   直播互动
 */
public interface LiveInteractiveDao {
	
	/**
	 * @param interactive
	 * @return  添加互动
	 */
	public int insertLiveInteractive(LiveInteractive interactive);
	
	/**
	 * @return  获取所有互动
	 */
	public List<LiveInteractive> findAll();
	/**
	 * @param userId
	 * @return  根据用户id获取用户互动
	 */
	public List<LiveInteractive> findByUserId(int userId);
	/**
	 * @param liveId
	 * @return  根据直播id获取直播互动信息
	 */
	public List<LiveInteractive> findByLiveId(int liveId,int page);
	/**
	 * @param uId
	 * @param liveId
	 * @return 根据用户id 直播id获取直播互动信息
	 */
	public List<LiveInteractive> findByUidAndLiveId(int uId,int liveId);
	/**
	 * @param id
	 * @return 根据id获取直播互动详细信息
	 */
	public LiveInteractive findById(int id);
	

}

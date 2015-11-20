package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LiveInteractiveDao;
import com.accumulate.daoImp.LiveInteractiveImp;
import com.accumulate.entity.LiveInteractive;

public class LiveInteractiveSer{

	/**
	 * @param interactive
	 * @return  添加直播互动
	 */
	public static int insertLiveInteractive(LiveInteractive interactive) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.insertLiveInteractive(interactive);
	}

	/**
	 * @return  获取所有直播互动
	 */
	public static List<LiveInteractive> findAll() {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findAll();
	}

	/**
	 * @param userId
	 * @return  根据用户id获取直播互动
	 */
	public static List<LiveInteractive> findByUserId(int userId) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findByUserId(userId);
	}

	/**
	 * @param liveId
	 * @return  根据直播id获取直播互动
	 */
	public static List<LiveInteractive> findByLiveId(int liveId,int page) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findByLiveId(liveId,page);
	}

	public List<LiveInteractive> findByUidAndLiveId(int uId, int liveId) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findByUidAndLiveId(uId, liveId);
	}

	/**
	 * @param id
	 * @return  根据id获取直播互动详细信息
	 */
	public LiveInteractive findById(int id) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findById(id);
	}

}

package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LiveInteractiveDao;
import com.accumulate.daoImp.LiveInteractiveImp;
import com.accumulate.entity.LiveInteractive;

public class LiveInteractiveSer{
	
	
	/**
	 * @param tId
	 * @return   ���ݱ���id  ��ȡ��������
	 */
	public static LiveInteractive findLiveInteractiveByTitleId(int tId){
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findLiveInteractiveByTitleId(tId);
	}

	/**
	 * @param interactive
	 * @return  ���ֱ������
	 */
	public static int insertLiveInteractive(LiveInteractive interactive) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.insertLiveInteractive(interactive);
	}

	/**
	 * @return  ��ȡ����ֱ������
	 */
	public static List<LiveInteractive> findAll() {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findAll();
	}

	/**
	 * @param userId
	 * @return  �����û�id��ȡֱ������
	 */
	public static List<LiveInteractive> findByUserId(int userId) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findByUserId(userId);
	}

	/**
	 * @param liveId
	 * @return  ����ֱ��id��ȡֱ������
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
	 * @return  ����id��ȡֱ��������ϸ��Ϣ
	 */
	public LiveInteractive findById(int id) {
		LiveInteractiveDao dao=new LiveInteractiveImp();
		return dao.findById(id);
	}

}

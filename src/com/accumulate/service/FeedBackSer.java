package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.FeedBackDao;
import com.accumulate.daoImp.FeedBackImp;
import com.accumulate.entity.FeedBack;

public class FeedBackSer{

	/**
	 * @param feedBack
	 * @return  添加意见
	 */
	public int insertFeedBack(FeedBack feedBack) {
		FeedBackDao dao=new FeedBackImp();
		return dao.insertFeedBack(feedBack);
	}

	/**
	 * @return  获取所有意见
	 */
	public List<FeedBack> findAllFeedBack() {
		FeedBackDao dao=new FeedBackImp();
		return dao.findAllFeedBack();
	}

	/**
	 * @param uId
	 * @return  根据用户id查询意见信息
	 */
	public List<FeedBack> findFeedBaceByUserId(int uId) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBaceByUserId(uId);
	}

	/**
	 * @param type
	 * @return  根据意见状态查询意见信息
	 */
	public List<FeedBack> findFeedBackByType(int type) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBackByType(type);
	}

	/**
	 * @param uId
	 * @param type
	 * @return 根据用户id、意见状态查询意见
	 */
	public List<FeedBack> findFeedBackByUidAndType(int uId, int type) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBackByUidAndType(uId, type);
	}

	/**
	 * @param id
	 * @return  根据id 查询意见详细信息
	 */
	public FeedBack findFeedBackById(int id) {
		FeedBackDao dao=new FeedBackImp();
		return dao.findFeedBackById(id);
	}

}

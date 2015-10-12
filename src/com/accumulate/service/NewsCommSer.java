package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.NewsCommDao;
import com.accumulate.daoImp.NewsCommImp;
import com.accumulate.entity.NewsComment;

public class NewsCommSer {
	/**
	 * @param uId
	 * @param nId
	 * @return 添加新闻评论
	 */
	public static int insertNewsComm(int uId, NewsComment comment) {
		NewsCommDao dao = new NewsCommImp();
		return dao.insertNewsComm(uId, comment);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return 取消新闻评论
	 */
	public static int cancelNewsComm(int uId, int nId) {
		NewsCommDao dao = new NewsCommImp();
		return dao.cancelNewsComm(uId, nId);
	}

	/**
	 * @param uId
	 * @return 查询当前用户下的所有新闻评论
	 */
	public static List<NewsComment> findNewsCommByUser(int uId,int type, int pager) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findNewsComment(uId,type, pager);
	}

	
	/**
	 * @param uId
	 * @return 查询当前用户下的所有新闻回复
	 */
	public static List<NewsComment> findNewsCommResByUser(int uId,int type, int pager) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findNewsCommentRes(uId, type, pager);
	}
	
	/**
	 * @param nId
	 * @return 查询当前新闻下所有的评论
	 */
	public static List<NewsComment> findNewsCommByNews(int nId, int pager) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findCommenByNews(nId, pager);
	}

	/**
	 * @param nId
	 * @return 查询当前新闻下所有的评论
	 */
	public static List<NewsComment> findCommByTypeId(int pager, int id, int type) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findCommentByTypeId(pager, id, type);
	}

	/**
	 * @param id
	 * @return 查询该评论的详细内容
	 */
	public static NewsComment findNewsCommById(int id) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findComment(id);
	}

	/**
	 * @param cId
	 * @param goodNum
	 * @return 修改赞数
	 */
	public static int updateComment(int cId, int goodNum) {
		NewsCommDao dao = new NewsCommImp();
		return dao.updateCommentGoods(cId, goodNum);
	}
}

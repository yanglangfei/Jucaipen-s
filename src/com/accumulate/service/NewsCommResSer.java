package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.NewsCommResDao;
import com.accumulate.daoImp.NewsCommResImp;
import com.accumulate.entity.NewsCommRes;

public class NewsCommResSer {
	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  添加评论回复
	 */
	public static boolean insertCommRes(int uId, int nId, int cId) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.insertNewsRes(uId, nId, cId);
	}

	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  取消评论回复
	 */
	public static boolean cancelCommRes(int uId, int nId, int cId) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.cancleNewsRes(uId, nId, cId);
	}

	/**
	 * @param uId
	 * @return  查询当前用户下所有的评论回复
	 */
	public static List<NewsCommRes> findCommResByUser(int uId,int pager) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResByUser(uId,pager);
	}

	/**
	 * @param nId
	 * @return  查询该新闻下所有的评论回复
	 */
	public static List<NewsCommRes> findCommResByNews(int nId,int pager) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResByNews(nId,pager);
	}

	/**
	 * @param cId
	 * @return 查询当前评论下的回复
	 */
	public static List<NewsCommRes> findCommResByComm(int cId,int pager) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResByCommen(cId,pager);
	}

	/**
	 * @param id
	 * @return  查询回复详细内容
	 */
	public static  NewsCommRes findCommResById(int id) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResInfo(id);
	}
	/**
	 * @param nId
	 * @param cId
	 * @return  查询当前新闻下该评论下的所有回复信息
	 */
	public static List<NewsCommRes> findCommRes(int nId,int cId,int pager){
		NewsCommResDao dao=new NewsCommResImp();
		return dao.findComm(nId, cId,pager);
	}

}

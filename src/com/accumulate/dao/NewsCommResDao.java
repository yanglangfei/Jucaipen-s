package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.NewsCommRes;

/**
 * @author ylf
 * 
 *  新闻评论回应
 */
public interface NewsCommResDao {
	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  添加新闻回复
	 */
	public boolean insertNewsRes(int uId,int nId,int cId);
	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  取消新闻回应
	 */
	public boolean cancleNewsRes(int uId,int nId,int cId);
	/**
	 * @param uId
	 * @return  查询当前用户下所有的评论回应
	 */
	public List<NewsCommRes> findResByUser(int uId,int pager);
	/**
	 * @param nId
	 * @return  查询当前新闻下所有的回复
	 */
	public List<NewsCommRes> findResByNews(int nId,int pager);
	/**
	 * @param cId
	 * @return  查询当前评论下的所有回复
	 */
	public List<NewsCommRes> findResByCommen(int cId,int pager);
	/**
	 * @param id
	 * @return 查询新闻评论详细信息
	 */
	public NewsCommRes findResInfo(int id);
	/**
	 * @param nId
	 * @param cId
	 * @return  查询指定新闻下评论下的回复
	 */
	public List<NewsCommRes> findComm(int nId,int cId,int pager);

}

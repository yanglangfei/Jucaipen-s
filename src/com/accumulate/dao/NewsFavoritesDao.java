package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.NewsFavorites;

/**
 * @author ylf
 * 
 *   收藏新闻
 *
 */
public interface NewsFavoritesDao {
	/**
	 * @param uId
	 * @param nId
	 * @return  添加收藏新闻
	 */
	public int insertNewsFavorites(int uId,NewsFavorites newsFavorites);
	/**
	 * @param uId
	 * @param nId
	 * @return 取消收藏新闻
	 */
	public int cancelNewsFavorites(int uId,int nId);
	/**
	 * @param uId
	 * @return  查询当前用户下所有的新闻收藏
	 */
	public List<NewsFavorites> findNewsFavorites(int uId,int pager);
	/**
	 * @param uId
	 * @param nId
	 * @return  根据用户id、新闻id查询收藏信息
	 */
	public NewsFavorites findNewsFavouritesByUidAndNid(int uId,int nId);

}

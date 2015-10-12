package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.EquityFavorites;

/**
 * @author ylf
 * 
 *   收藏、喜爱股权
 *
 */
public interface  EquityFavoritesDao {
	/**
	 * @param uId
	 * @param nId
	 * @return   添加收藏的股权
	 */
	public int insertFavoritesEquity(int uId,EquityFavorites equityFavorites);
	/**
	 * @param uId
	 * @param nId
	 * @return   取消收藏的股权
	 */
	public int cancelFavoritesEquity(int uId,int eId);
	/**
	 * @param uId
	 * @return  查询当前用户下的所有收藏股权
	 */
	public List<EquityFavorites> findFavoritesEquity(int uId,int pager);
	/**
	 * @param id
	 * @return  根据id查询收藏的股权
	 */
	public EquityFavorites findEquityFavById(int id);
	/**
	 * @param uId
	 * @param eId
	 * @return  查询股权是否收藏
	 */
	public EquityFavorites findEquityIsCollect(int uId,int eId);
	
	

}

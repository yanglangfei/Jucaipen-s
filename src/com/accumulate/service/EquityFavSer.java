package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.EquityFavoritesDao;
import com.accumulate.daoImp.EquityFavoritesImp;
import com.accumulate.entity.EquityFavorites;

/**
 * @author Administrator 收藏股权服务
 */
public class EquityFavSer {
	/**
	 * @param uId
	 * @param nId
	 * @return 收藏股权
	 */
	public static int insertEquity(int uId, EquityFavorites equityFavorites) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.insertFavoritesEquity(uId, equityFavorites);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return 取消收藏股权
	 */
	public static int cancelEquity(int uId, int nId) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.cancelFavoritesEquity(uId, nId);
	}

	/**
	 * @param uId
	 * @param page
	 * @return 查询当前用户下所有收藏的股权信息
	 */
	public static List<EquityFavorites> findEquityByUid(int uId, int page) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.findFavoritesEquity(uId, page);
	}

	/**
	 * @param eId
	 * @return 根据id查询收藏的股权的详细信息
	 */
	public static EquityFavorites findEquityById(int eId) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.findEquityFavById(eId);
	}

	/**
	 * @param uId
	 * @param eId
	 * @return  查询股权是否被收藏
	 */
	public static EquityFavorites findEquityIsCollect(int uId, int eId) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.findEquityIsCollect(uId, eId);
	}

}

package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.TxtLiveSaleDao;
import com.accumulate.daoImp.TxtLiveSaleImp;
import com.accumulate.entity.TxtLiveSale;

/**
 * @author Administrator
 *   文字直播销售信息
 */
public class TxtLiveSaleServer{

	/**
	 * @return   获取所有的文字直播购买信息
	 */
	public static List<TxtLiveSale> findAllTxtLiveSale() {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findAllTxtLiveSale();
	}

	/**
	 * @param userId
	 * @return   根据用户id获取购买信息
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByUid(int userId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByUid(userId);
	}

	/**
	 * @param teacherId
	 * @return   根据讲师id获取购买信息
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByTeacherId(int teacherId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByTeacherId(teacherId);
	}

	/**
	 * @param liveId
	 * @return   根据直播id获取购买信息
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByLiveId(int liveId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByLiveId(liveId);
	}

	/**
	 * @param uId
	 * @param liveId
	 * @return   获取用户指定的直播购买信息
	 */
	public static TxtLiveSale findTxtLiveSaleByUiDAndLiveId(int uId, int liveId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByUiDAndLiveId(uId, liveId);
	}

	/**
	 * @param id
	 * @return  根据id获取购买信息
	 */
	public static TxtLiveSale findTxtLiveSaleById(int id) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleById(id);
	}

	/**
	 * @param orderCode
	 * @return   根据订单号获取购买信息
	 */
	public static TxtLiveSale findTxtLiveSaleByOrderCode(String orderCode) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByOrderCode(orderCode);
	}
	/**
	 * @param uId
	 * @param count
	 * @return   获取用户最近的几条购买记录
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByUserLastCount(uId, count);
	}

}

package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.TxtLiveSale;

public interface TxtLiveSaleDao {
	/**
	 * @return  获取全部的销售信息
	 */
	public List<TxtLiveSale> findAllTxtLiveSale();
	/**
	 * @param userId
	 * @return    获取用户购买的信息
	 */
	public List<TxtLiveSale> findTxtLiveSaleByUid(int userId);
	/**
	 * @param teacherId
	 * @return   根据讲师获取销售信息
	 */
	public List<TxtLiveSale> findTxtLiveSaleByTeacherId(int teacherId);
	/**
	 * @param liveId
	 * @return   根据直播id获取销售信息
	 */
	public List<TxtLiveSale> findTxtLiveSaleByLiveId(int liveId);
	/**
	 * @param uId
	 * @param liveId
	 * @return   获取用户购买的特定直播信息
	 */
	public TxtLiveSale findTxtLiveSaleByUiDAndLiveId(int uId,int liveId);
	/**
	 * @param id
	 * @return   根据id获取购买信息
	 */
	public TxtLiveSale findTxtLiveSaleById(int id);
	
	/**
	 * @param orderCode
	 * @return   根据订单号获取购买的直播信息
	 */
	public TxtLiveSale findTxtLiveSaleByOrderCode(String orderCode);
	/**
	 * @param uId
	 * @param count
	 * @return   获取用户最近购买的文字直播记录
	 */
	public List<TxtLiveSale> findTxtLiveSaleByUserLastCount(int uId,int count);



}

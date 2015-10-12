package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.OrderEquity;

/**
 * @author ylf
 * 
 *    预约股权
 *
 */
public interface OrderEquityDao {
	/**
	 * @param uId
	 * @param eId
	 * @return   预约股权
	 */
	public int insertEquity(int uId,OrderEquity oe);
	/**
	 * @param uId
	 * @param eId
	 * @return   取消预约股权
	 */
	public int cancelEquity(int uId,int eId,int oType);
	/**
	 * @param uId
	 * @return   查询当前用户预约的所有股权
	 */
	public List<OrderEquity> findOrderEquity(int uId,int pager);
}

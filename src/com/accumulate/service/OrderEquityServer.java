package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.OrderEquityDao;
import com.accumulate.daoImp.OrderEquityImp;
import com.accumulate.entity.OrderEquity;

public class OrderEquityServer {
	/**
	 * @param id
	 * @param userId
	 * @return  预约股权
	 */
	public static int insertOrder(int uId,OrderEquity oe){
		OrderEquityDao dao=new OrderEquityImp();
		return dao.insertEquity(uId, oe);
	}
	/**
	 * @param id
	 * @param userId
	 * @return  取消预约股权
	 */
	public static int cancenOrder(int id,int userId,int oType){
		OrderEquityDao dao=new OrderEquityImp();
		return dao.cancelEquity(userId, id,oType);
	}
	/**
	 * @param userId
	 * @return  查询当前用户下所有的预约股权
	 */
	public static List<OrderEquity> findOrder(int userId,int pager){
		OrderEquityDao dao=new OrderEquityImp();
		return dao.findOrderEquity(userId,pager);
	}

}

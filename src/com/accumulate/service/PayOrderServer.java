package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.PayOrderDao;
import com.accumulate.daoImp.PayOrderImp;
import com.accumulate.entity.PayOrder;

public class PayOrderServer {

	/**
	 * @return 获取全部的订单信息
	 */
	public static List<PayOrder> findAllPayOrderList(int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findAllPayOrderList(page);
	}

	/**
	 * @param uId
	 * @return 根据用户ID获取订单信息
	 */
	public static List<PayOrder> findPayOrderByUid(int uId, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByUid(uId, page);
	}

	/**
	 * @param payState
	 * @return 根据支付状态获取订单信息
	 */
	public static List<PayOrder> findPayOrderByPayState(int payState, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByPayState(payState, page);
	}

	/**
	 * @param orderState
	 * @return 根据订单状态获取订单信息
	 */
	public static List<PayOrder> findPayOrderByOrderState(int orderState, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByOrderState(orderState, page);
	}

	/**
	 * @param teacherId
	 * @return 根据讲师ID获取订单信息
	 */
	public static List<PayOrder> findPayOrderByTeacherId(int teacherId, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByTeacherId(teacherId, page);
	}

	/**
	 * @param productState
	 * @return 根据商品状态获取订单信息
	 */
	public static List<PayOrder> findPayOrderByProductState(int productState, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByProductState(productState, page);
	}

	/**
	 * @param lastCount
	 * @return 获取最近几个订单
	 */
	public static List<PayOrder> findLastPayOrder(int lastCount) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findLastPayOrder(lastCount);
	}

	/**
	 * @param id
	 * @return 根据ID获取订单信息
	 */
	public static PayOrder findPayOrderById(int id) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderById(id);
	}
	
	/**
	 * @param id
	 * @return 添加订单信息
	 */
	public static int addPayOrder(PayOrder payOrder) {
		PayOrderDao dao = new PayOrderImp();
		return dao.addPayOrder(payOrder);
	}
	
	/**
	 * @param lastCount
	 * @return 修改订单支付状态
	 */
	public static int changePayState(int payType,String payDate,String orderCode) {
		PayOrderDao dao = new PayOrderImp();
		return dao.changePayState(payType, payDate, orderCode);
	}

}

package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.PayOrder;

/**
 * @author Administrator
 * 
 * 
 *         订单信息
 */
public interface PayOrderDao {

	/**
	 * @return 获取订单列表
	 */
	public List<PayOrder> findAllPayOrderList(int page);

	/**
	 * @param uId
	 * @return 根据用户ID，获取订单信息
	 */
	public List<PayOrder> findPayOrderByUid(int uId, int page);

	/**
	 * @param payState
	 * @return 根据付款状态获取订单信息
	 */
	public List<PayOrder> findPayOrderByPayState(int payState, int page);

	/**
	 * @param orderState
	 * @return 根据订单状态获取订单信息
	 */
	public List<PayOrder> findPayOrderByOrderState(int orderState, int page);

	/**
	 * @param teacherId
	 * @return 根据讲师ID获取订单信息
	 */
	public List<PayOrder> findPayOrderByTeacherId(int teacherId, int page);

	/**
	 * @param productState
	 * @return 根据商品状态获取订单信息
	 */
	public List<PayOrder> findPayOrderByProductState(int productState, int page);

	/**
	 * @param lastCount
	 * @return 获取最近几条订单信息
	 */
	public List<PayOrder> findLastPayOrder(int lastCount);

	/**
	 * @param id
	 * @return 根据ID获取订单信息
	 */
	public PayOrder findPayOrderById(int id);
	
	
	/**
	 * @param payOrder
	 * @return   添加订单信息
	 */
	public int addPayOrder(PayOrder payOrder);
	
	/**
	 * @param payType
	 * @param payDate
	 * @return    改变支付状态
	 */
	public int changePayState(int payType,String payDate,String orderCode);
}

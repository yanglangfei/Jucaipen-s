package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.PayProduct;

/**
 * @author Administrator
 * 
 * 
 *         订单详细信息
 */
public interface PayProductDao {

	/**
	 * @return 获取订单详细信息列表
	 */
	public List<PayProduct> findAllPayProductList(int page);

	/**
	 * @param uId
	 * @return 根据用户ID，获取订单详细信息
	 */
	public List<PayProduct> findPayProductByUid(int uId,int page);

	/**
	 * @param productId
	 * @return 根据商品ID获取订单信息
	 */
	public List<PayProduct> findPayProductByProductId(int productId,int page);

	/**
	 * @param orderId
	 * @return 根据订单ID获取订单详细信息
	 */
	public PayProduct findPayProductByOrderId(String orderId);

	/**
	 * @param isDeleted
	 * @return 根据IsDelete
	 */
	public List<PayProduct> findPayProductByIsDeleted(int isDeleted,int page);

	/**
	 * @param productType
	 * @return 根据商品类型获取订单详细信息
	 */
	public List<PayProduct> findPayProductByProductType(int productType,int page);

	/**
	 * @param id
	 * @return 根据ID获取订单详细信息
	 */
	public PayProduct findPayProductById(int id);

	/**
	 * @param lastCount
	 * @return 获取最近几条订单详细信息
	 */
	public List<PayProduct> findLastPayProduct(int lastCount);
	
	
	/**
	 * @param payProduct
	 * @return   添加订单信息
	 */
	public int addPayProductInfo(PayProduct payProduct);

}

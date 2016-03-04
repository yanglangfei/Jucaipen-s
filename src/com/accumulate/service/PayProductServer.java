package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.PayProductDao;
import com.accumulate.daoImp.PayProductImp;
import com.accumulate.entity.PayProduct;

public class PayProductServer {

	/**
	 * @return 获取全部订单信息
	 */
	public static List<PayProduct> findAllPayProductList(int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findAllPayProductList(page);
	}

	/**
	 * @param uId
	 * @return 根据用户ID获取订单详细信息
	 */
	public static List<PayProduct> findPayProductByUid(int uId, int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByUid(uId, page);
	}

	/**
	 * @param productId
	 * @return 根据商品ID获取订单详细信息
	 */
	public static List<PayProduct> findPayProductByProductId(int productId, int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByProductId(productId, page);
	}

	/**
	 * @param orderId
	 * @return 根据订单ID获取订单详细信息
	 */
	public static PayProduct findPayProductByOrderId(String orderId) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByOrderId(orderId);
	}

	/**
	 * @param isDeleted
	 * @return 根据状态获取订单详细信息
	 */
	public static List<PayProduct> findPayProductByIsDeleted(int isDeleted, int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByIsDeleted(isDeleted, page);
	}

	/**
	 * @param productType
	 * @return 根据商品类型获取订单详细信息
	 */
	public static List<PayProduct> findPayProductByProductType(int productType,
			int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByProductType(productType, page);
	}

	/**
	 * @param id
	 * @return 根据ID获取订单详细信息
	 */
	public static PayProduct findPayProductById(int id) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductById(id);
	}

	/**
	 * @param lastCount
	 * @return 获取最近几条订单详细信息
	 */
	public static List<PayProduct> findLastPayProduct(int lastCount) {
		PayProductDao dao = new PayProductImp();
		return dao.findLastPayProduct(lastCount);
	}
	
	/**
	 * @param lastCount
	 * @return 添加订单详细信息
	 */
	public static int addPayProductInfo(PayProduct payProduct) {
		PayProductDao dao = new PayProductImp();
		return dao.addPayProductInfo(payProduct);
	}
	

}

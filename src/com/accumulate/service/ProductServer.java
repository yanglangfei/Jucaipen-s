package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ProductDao;
import com.accumulate.daoImp.ProductImp;
import com.accumulate.entity.Product;

public class ProductServer {
	/**
	 * @return 查询所有产品
	 */
	public static List<Product> findALL(int pager) {
		ProductDao dao = new ProductImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return 根据id查询产品信息
	 */
	public static Product findProduct(int id) {
		ProductDao dao = new ProductImp();
		return dao.findProduct(id);
	}

	/**
	 * @param teacherId
	 * @return 根据讲师ID获取商品信息
	 */
	public List<Product> findProductByTeacherId(int teacherId, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductByTeacherId(teacherId, page);
	}

	/**
	 * @param types
	 * @return 根据商品分类获取商品信息
	 */
	public List<Product> findProductByTypes(int types, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductByTypes(types, page);
	}

	/**
	 * @param saleState
	 * @return 根据销售状态获取商品信息
	 */
	public List<Product> findProductBySaleState(int saleState, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductBySaleState(saleState, page);
	}

	/**
	 * @param isDeleted
	 * @return 根据商品状态获取商品信息
	 */
	public List<Product> findProductByProductState(int isDeleted, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductByProductState(isDeleted, page);
	}

	/**
	 * @param lastCount
	 * @return 获取最近几条商品信息
	 */
	public List<Product> findLastProduct(int lastCount) {
		ProductDao dao = new ProductImp();
		return dao.findLastProduct(lastCount);
	}

}

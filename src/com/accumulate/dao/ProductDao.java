package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Product;

public interface ProductDao {
	/**
	 * @return   查询所有产品信息
	 */
	public List<Product> findAll(int pager);

	/**
	 * @param id
	 * @return   根据id查询产品信息
	 */
	public Product findProduct(int id);
	/**
	 * @param teacherId
	 * @return   根据讲师ID获取商品信息
	 */
	public List<Product> findProductByTeacherId(int teacherId,int page);
	/**
	 * @param types
	 * @return   根据商品类型获取商品信息
	 */
	public List<Product> findProductByTypes(int types,int page);
	
	/**
	 * @param saleState
	 * @return  根据销售状态获取商品信息
	 */
	public List<Product> findProductBySaleState(int saleState,int page);
	
	/**
	 * @param isDeleted
	 * @return  根据商品状态获取商品信息
	 */
	public List<Product> findProductByProductState(int isDeleted,int page);
	
	/**
	 * @param lastCount
	 * @return  获取最近上线的几件商品
	 */
	public List<Product> findLastProduct(int lastCount);

}

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

}

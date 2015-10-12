package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ProductDao;
import com.accumulate.daoImp.ProductDaoImp;
import com.accumulate.entity.Product;

public class ProductServer {
	/**
	 * @return  查询所有产品
	 */
	public static List<Product> findALL(int pager){
		ProductDao dao=new ProductDaoImp();
		return dao.findAll(pager);
	}
	/**
	 * @param id
	 * @return  根据id查询产品信息
	 */
	public static Product findProduct(int id){
		ProductDao dao=new ProductDaoImp();
		return dao.findProduct(id);
	}

}

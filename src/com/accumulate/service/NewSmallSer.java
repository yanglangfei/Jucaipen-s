package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.NewSmallDao;
import com.accumulate.daoImp.NewSmallImp;
import com.accumulate.entity.NewsSmallClass;

public class NewSmallSer {
	/**
	 * @return 获取所有的新闻二级分类信息
	 */
	public static List<NewsSmallClass> findAll() {
		NewSmallDao dao = new NewSmallImp();
		return dao.findAllSmallClass();
	}

	/**
	 * @param id
	 * @return 根据id 获取二级分类详细信息
	 */
	public static NewsSmallClass findNewSmallById(int id) {
		NewSmallDao dao = new NewSmallImp();
		return dao.findSmallClassById(id);
	}

	/**
	 * @param bigId
	 * @return   根据一级分类查询下边的二级分类信息
	 */
	public static List<NewsSmallClass> findNewSmallByByBigId(int bigId) {
		NewSmallDao dao = new NewSmallImp();
		return dao.findSmallClassByBigId(bigId);
	}
	
	/**
	 * @param id
	 * @param bigId
	 * @return   根据一二级分类id获取分类信息
	 */
	public static NewsSmallClass findSmallClassBySidAndBigId(int id,int bigId){
		NewSmallDao dao=new NewSmallImp();
		return dao.findSmallClassBySidAndBigId(id, bigId);
	}

}

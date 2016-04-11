package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.NewsSmallClass;

public interface NewSmallDao {
	/**
	 * @return   获取所有二级分类信息
	 */
	public List<NewsSmallClass>  findAllSmallClass();
	/**
	 * @param bigId
	 * @return    根据一级分类获取二级分类信息
	 */
	public List<NewsSmallClass>  findSmallClassByBigId(int bigId);
	/**
	 * @param id
	 * @return   根据id获取二级分类信息
	 */
	public NewsSmallClass findSmallClassById(int id);
	
	
	/**
	 * @param id
	 * @param bigId
	 * @return  根据一二级分类id获取分类信息
	 */
	public NewsSmallClass findSmallClassBySidAndBigId(int id,int bigId);

}

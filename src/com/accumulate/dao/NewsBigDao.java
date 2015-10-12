package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.NewsBigClass;

public interface NewsBigDao {
	/**
	 * @return   获取所有的一级分类信息
	 */
	public List<NewsBigClass>  findAllBigClass();
	/**
	 * @param id
	 * @return   通过id 查询一级分类详细信息
	 */
	public List<NewsBigClass> findBigClassById(int id);

}

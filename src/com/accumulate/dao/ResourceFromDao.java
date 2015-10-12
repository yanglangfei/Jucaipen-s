package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ResourceSources;

public interface ResourceFromDao {
	/**
	 * @return  查询所有信息来源
	 */
	public List<ResourceSources> findAll(int pager);
	/**
	 * @param id
	 * @return  查询指定信息来源
	 */
	public ResourceSources findResourceSources(int id);

}

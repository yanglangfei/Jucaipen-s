package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Organization;

public interface OranizationDao {
	/**
	 * @return 查询所有机构
	 */
	public List<Organization> findAll(int pager);
	/**
	 * @param id
	 * @return  查询指定的机构
	 */
	public Organization findOrganization(int id);

}

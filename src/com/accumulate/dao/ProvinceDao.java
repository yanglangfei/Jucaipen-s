package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Province;

public interface ProvinceDao {
	/**
	 * @return  查询所有省份信息
	 */
	public List<Province> findAll();
	/**
	 * @param id
	 * @return  根据id查询省份信息
	 */
	public Province findProvince(int id);

}

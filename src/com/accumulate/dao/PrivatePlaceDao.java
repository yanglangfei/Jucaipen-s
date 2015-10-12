package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.PrivatePlace;

public interface PrivatePlaceDao {
	/**
	 * @return   获取所有的私募信息
	 */
	public List<PrivatePlace> findAll(int pager);
	/**
	 * @param id
	 * @return   根据id查询私募详细信息
	 */
	public PrivatePlace findPrivatePlaceById(int id);
	/**
	 * @param isIndex
	 * @return   查询是否首页显示的私募信息
	 */
	public List<PrivatePlace>  findPrivatePlaceByIsIndex(int isIndex);
	/**
	 * @param isTop
	 * @return   查询置顶的私募信息
	 */
	public List<PrivatePlace> findPrivatePlaceByIsTop(int isTop);
	/**
	 * @param IsTuijian
	 * @return  查询是否推荐的私募信息
	 */
	public List<PrivatePlace> findPrivatePlaceByIsTuijian(int IsTuijian);

}

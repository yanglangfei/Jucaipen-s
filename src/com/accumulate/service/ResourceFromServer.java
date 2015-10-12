package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ResourceFromDao;
import com.accumulate.daoImp.ResourceFromImp;
import com.accumulate.entity.ResourceSources;

public class ResourceFromServer {
	/**
	 * @return   获取所有资讯来源信息
	 */
	public static List<ResourceSources> getResourceSources(int pager) {
		ResourceFromDao dao = new ResourceFromImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return   根据id获取资讯来源信息
	 */
	public static ResourceSources getRSources(int id) {
		ResourceFromDao dao = new ResourceFromImp();
		return dao.findResourceSources(id);
	}
}

package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.PrivatePlaceDao;
import com.accumulate.daoImp.PrivatePlaceImp;
import com.accumulate.entity.PrivatePlace;

public class PrivatePlaceSer {
	/**
	 * @param pager
	 * @return   获取所有私募信息
	 */
	public static List<PrivatePlace> findAll(int pager) {
		PrivatePlaceDao dao = new PrivatePlaceImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return  根据id获取私募信息
	 */
	public static PrivatePlace findPrivatePlaceById(int id) {
		PrivatePlaceDao dao = new PrivatePlaceImp();
		return dao.findPrivatePlaceById(id);
	}

}

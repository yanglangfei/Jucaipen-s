package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.AreaDao;
import com.accumulate.daoImp.AreaImp;
import com.accumulate.entity.Area;


public class AreaServer {
	/**
	 * @param pId
	 * @param cId
	 * @return   查询省市下的所有区信息
	 */
	public static List<Area> getAreas(int pId,int cId){
		AreaDao dao=new AreaImp();
		return dao.findAreas(pId, cId);
	}
	/**
	 * @param id
	 * @return  查询单个区的信息
	 */
	public static Area getArea(int id){
		AreaDao dao=new AreaImp();
		return dao.findArea(id);
	}

}

package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.EquityDao;
import com.accumulate.daoImp.EquityImp;
import com.accumulate.entity.Equity;

/**
 * @author ylf
 * 
 *         股权服务类
 */
public class EquityServer {
	/**
	 * @return  获取所有股权信息
	 */
	public static List<Equity> findAll(int pager) {
		EquityDao dao = new EquityImp();
		return dao.findAll(pager);
	}
	/**
	 * @return  获取首页股权信息
	 */
	public static List<Equity> findIndex(){
		EquityDao dao=new EquityImp();
		return dao.findIndexEquity();
	}
	/**
	 * @param id
	 * @return  根据id获取指定的股权信息
	 */
	public static Equity findEquity(int id){
		EquityDao dao=new EquityImp();
		return dao.findEquity(id);
	}
	/**
	 * @param istop
	 * @return  获取置顶股权信息
	 */
	public static List<Equity> findTopEquity(int istop){
		EquityDao dao=new EquityImp();
		return dao.findByTop(istop);
	}
	/**
	 * @param isRecom
	 * @return  获取推荐的股权信息
	 */
	public static List<Equity> findRecommenEquity(int isRecom,int pager){
		EquityDao dao=new EquityImp();
		return dao.frindByRecomment(isRecom,pager);
	}

}

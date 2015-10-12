package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Equity;

/**
 * @author ylf 股权操作
 * 
 */
public interface EquityDao {
	/**
	 * @return 查询所有股权
	 */
	public List<Equity> findAll(int pager);
	/**
	 * @param id
	 * @return  查询股权详细信息
	 */
	public Equity findEquity(int id);

	/**
	 * @return 查询置顶股权
	 */
	public List<Equity> findByTop(int isTop);

	/**
	 * @param isRecom
	 *            查询推荐股权
	 * @return
	 */
	public List<Equity> frindByRecomment(int isRecom,int pager);
	/**
	 * @return  查询首页显示的新闻
	 */
	public List<Equity> findIndexEquity();

}

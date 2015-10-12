package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ReadInfoDao;
import com.accumulate.daoImp.ReadInfoImp;
import com.accumulate.entity.ReadInfo;

public class ReadInfoServer {
	/**
	 * @return  获取全部读取信息
	 */
	public List<ReadInfo> findAll(int page){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findAll(page);
	}
	/**
	 * @param id
	 * @return  根据id获取读取的信息
	 */
	public ReadInfo findInfoById(int id){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findReadInfo(id);
	}
	/**
	 * @param userId
	 * @param page 根据用户查询读取信息
	 * @return   
	 */
	public List<ReadInfo> findInfoByUser(int userId,int page){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findReadInfoByUser(userId,page);
	}
	/**
	 * @param readDate
	 * @param page
	 * @return   根据读取时间查询读取时间
	 */
	public List<ReadInfo> findInfoByReadDate(String readDate,int page){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findReadInfoByReadDate(readDate,page);
	}

}

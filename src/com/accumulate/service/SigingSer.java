package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.SigningDao;
import com.accumulate.daoImp.SigningImp;
import com.accumulate.entity.Signing;

public class SigingSer{

	/**
	 * @param signing
	 * @return  签约
	 */
	public static int insertSigin(Signing signing) {
		SigningDao dao=new SigningImp();
		return dao.insertSigin(signing);
	}

	/**
	 * @param id
	 * @return  根据id获取签约详细信息
	 */
	public static Signing findSignById(int id) {
		SigningDao dao=new SigningImp();
		return dao.findSignById(id);
	}

	/**
	 * @return 获取所有签约信息
	 */
	public static List<Signing> findAllSigin() {
		SigningDao dao=new SigningImp();
		return dao.findAllSigin();
	}

	/**
	 * @param userId
	 * @return  根据用户id获取签约信息
	 */
	public static List<Signing> findSignByUserId(int userId) {
		SigningDao dao=new SigningImp();
		return dao.findSignByUserId(userId);
	}

	/**
	 * @param teacherId
	 * @return  根据讲师id获取签约信息
	 */
	public static List<Signing> findSiginByTeacherId(int teacherId) {
		SigningDao dao=new SigningImp();
		return dao.findSiginByTeacherId(teacherId);
	}

	/**
	 * @param type
	 * @return  根据签约状态获取签约信息
	 */
	public static List<Signing> findSiginByType(int type) {
		SigningDao dao=new SigningImp();
		return dao.findSiginByType(type);
	}

}

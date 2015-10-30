package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.FamousTeacherDao;
import com.accumulate.daoImp.FamousTeacherImp;
import com.accumulate.entity.FamousTeacher;

public class FamousTeacherSer {

	/**
	 * @return 获取所有讲师信息
	 */
	public static List<FamousTeacher> findAllFamousTeacher(int page) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findAllFamousTeacher(page);
	}

	/**
	 * @return  获取首页统计数据  （人气    观点   回答数   粉丝数）
	 */
	public static List<FamousTeacher> findIndexData() {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findIndexData();
	}

	/**
	 * @param count
	 * @return 获取推荐的讲师信息
	 */
	public static List<FamousTeacher> findFamousTeacherByIndex(int count) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherByIndex(count);
	}

	/**
	 * @param id
	 * @return 根据id查询讲师信息
	 */
	public static FamousTeacher findFamousTeacherById(int id) {
		FamousTeacherDao dao = new FamousTeacherImp();
		return dao.findFamousTeacherById(id);
	}

}

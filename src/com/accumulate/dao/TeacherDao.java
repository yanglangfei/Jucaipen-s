package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Teacher;

public interface TeacherDao {
	/**
	 * @return  查询所有教师
	 */
	public List<Teacher> findAll(int page);
	/**
	 * @param id
	 * @return 查询指定的教师
	 */
	public Teacher findTeacher(int id);

}

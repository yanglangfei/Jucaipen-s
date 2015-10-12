package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ExpressionType;

public interface FaceTypeDao {
	
	/**
	 * @return   获取所有表情
	 */
	public List<ExpressionType> findAllFace();
	
	/**
	 * @param id
	 * @return   通过分类id获取分类信息
	 */
	public ExpressionType findFaceById(int id);

}

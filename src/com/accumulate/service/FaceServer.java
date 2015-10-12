package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.FaceInfoDao;
import com.accumulate.daoImp.FaceInfoImp;
import com.accumulate.entity.ExpressionInfo;

/**
 * @author YLF
 * 
 *         表情信息
 * 
 */
public class FaceServer {

	/**
	 * @return 获取所有表情信息
	 */
	public static List<ExpressionInfo> findAllFaceInfo() {
		FaceInfoDao dao = new FaceInfoImp();
		return dao.findAllFaceInfo();
	}

	/**
	 * @param typeId
	 * @return 根据分类id获取对应的表情包
	 */
	public static List<ExpressionInfo> findFaceInfoByTypeId(int typeId) {
		FaceInfoDao dao = new FaceInfoImp();
		return dao.findFaceInfoByTypeId(typeId);
	}

	/**
	 * @param id
	 * @return 根据id获取对应表情信息
	 */
	public static ExpressionInfo findFaceInfoById(int id) {
		FaceInfoDao dao = new FaceInfoImp();
		return dao.findFaceInfoById(id);
	}

}

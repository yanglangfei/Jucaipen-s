package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.VideoTypeDao;
import com.accumulate.daoImp.VideoTypeImp;
import com.accumulate.entity.VideoType;

public class VideoTypeSer {
	/**
	 * @return 获取所有视频分类信息
	 */
	public static List<VideoType> findAll() {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return 根据id 查询分类信息
	 */
	public static VideoType findTypeById(int id) {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findTypeById(id);
	}

	/**
	 * @param parentId
	 * @return   根据一级分类id查询下边二级分类的信息
	 */
	public static List<VideoType> findVideoTypeByParentId(int parentId) {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findTypeByTypeId(parentId);
	}
}

package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.VideoType;

public interface VideoTypeDao {
	/**
	 * @return  获取全部视频分类信息
	 */
	public List<VideoType> findAll();
	/**
	 * @param id
	 * @return   根据id 获取视频分类信息
	 */
	public VideoType findTypeById(int id);
	/**
	 * @param isDelete
	 * @return   查询视频分类是否删除
	 */
	public List<VideoType> findTypeByIsDelete(int isDelete);
	
	/**
	 * @param parentId
	 * @return  根据一级分类id查询二级分类
	 */
	public List<VideoType> findTypeByTypeId(int parentId);

}

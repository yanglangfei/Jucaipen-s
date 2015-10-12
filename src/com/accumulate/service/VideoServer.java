package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.VideoDao;
import com.accumulate.daoImp.VideoImp;
import com.accumulate.entity.Video;

public class VideoServer {
	/**
	 * @return 查询所有视频信息
	 */
	public static List<Video> findAll() {
		VideoDao dao = new VideoImp();
		return dao.findAll();
	}

	/**
	 * @param classId
	 * @return 根据分类id 查询相应视频
	 */
	public static List<Video> findVideoByClassId(int classId) {
		VideoDao dao = new VideoImp();
		return dao.findVideoByClassId(classId);
	}

	/**
	 * @param id
	 * @return 根据id 查询视频详细信息
	 */
	public static Video findVideoById(int id) {
		VideoDao dao = new VideoImp();
		return dao.findVideoById(id);
	}

	/**
	 * @param isIndex
	 * @return   查询首页视频
	 */
	public static List<Video> findVideoByIsIndex(int isIndex) {
		VideoDao dao = new VideoImp();
		return dao.findVideoByIsIndex(isIndex);
	}
	/**
	 * @param isIndex
	 * @param classId
	 * @return   查询首页下的分类信息
	 */
	public static List<Video> findVideoByIsIndexId(int isIndex,int classId){
		VideoDao dao=new VideoImp();
		return dao.findVideoByIndexId(isIndex, classId);
	}
	/**
	 * @param id
	 * @return  通过id获取视频播放资源
	 */
	public static Video findVideoResourceById(int id){
		VideoDao dao=new VideoImp();
		return dao.findVideoRecouresById(id);
	}

}

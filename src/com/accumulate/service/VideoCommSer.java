package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.VideoCommDao;
import com.accumulate.daoImp.VideoCommImp;
import com.accumulate.entity.VideoComm;

public class VideoCommSer {

	/**
	 * @param uId
	 * @return 根据用户id查询当前用户下的视频评论信息
	 */
	public static List<VideoComm> findVideoCommByUid(int uId) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommByUid(uId);
	}

	/**
	 * @param videoId
	 * @return 根据视频id ，查询当前视频下的评论信息
	 */
	public static List<VideoComm> findVideoCommByVid(int videoId) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommByVid(videoId);
	}

	/**
	 * @param isShow
	 * @return 查询是否显示的视频评论
	 */
	public static List<VideoComm> findVideoByIsShow(int isShow) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommByIsShow(isShow);
	}

	/**
	 * @param id
	 * @return 根据id，查询视频评论详细信息
	 */
	public static VideoComm findVideoCommById(int id) {
		VideoCommDao dao = new VideoCommImp();
		return dao.findVideoCommById(id);
	}

	/**
	 * @return 查询所有的视频评论
	 */
	public static List<VideoComm> findAll() {
		VideoCommDao dao = new VideoCommImp();
		return dao.findAll();
	}

}

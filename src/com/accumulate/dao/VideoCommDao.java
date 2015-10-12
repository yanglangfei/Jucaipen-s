package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.VideoComm;

public interface VideoCommDao {
	
	/**
	 * @return  查询所有视频评论
	 */
	public List<VideoComm> findAll();
	/**
	 * @param uId
	 * @return  根据用户id查询所有视频评论
	 */
	public List<VideoComm>  findVideoCommByUid(int uId);
	/**
	 * @param videoId
	 * @return    查询当前视频下的所有评论
	 */
	public List<VideoComm> findVideoCommByVid(int videoId);
	/**
	 * @param id
	 * @return   根据id查询视频评论详细信息
	 */
	public VideoComm findVideoCommById(int id);
	/**
	 * @param isShow
	 * @return   查询显示、不显示的视频评论
	 */
	public List<VideoComm> findVideoCommByIsShow(int isShow);

}

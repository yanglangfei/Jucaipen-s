package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Video;

public interface VideoDao {
	/**
	 * @return  获取所有视频
	 */
	public List<Video> findAll();
	/**
	 * @return  根据分类id 获取视频
	 */
	public List<Video> findVideoByClassId(int classId);
	/**
	 * @param id
	 * @return   根据id 获取视频详细信息
	 */
	public Video findVideoById(int id);
	/**
	 * @param isIndex
	 * @return  查询首页、非首页视频信息
	 */
	public List<Video> findVideoByIsIndex(int isIndex);
	/**
	 * @param iisIndex
	 * @param classId
	 * @return   查询首页分类下的视频
	 */
	public List<Video> findVideoByIndexId(int isIndex,int classId);
	/**
	 * @param isRecomm
	 * @return    查询推荐、不推荐视频
	 */
	public List<Video> findVideoByIsReComm(int isRecomm);
	/**
	 * @param isRecomm
	 * @param classId
	 * @return    查询推荐的分类视频
	 */
	public List<Video> findVideoByIsRecommId(int isRecomm,int classId);
	/**
	 * @param isTop
	 * @return   查询置顶、不置顶视频
	 */
	public List<Video> findVideoByIsTop(int isTop);
	/**
	 * @param isTop
	 * @param classId
	 * @return   查询分类的置顶视频
	 */
	public List<Video> findVideoByIsTopId(int isTop,int classId);
	/**
	 * @param isPublic
	 * @return   查询是否是公开课
	 */
	public List<Video> findVideoByIsPublic(int isPublic);
	/**
	 * @param isPublic
	 * @param classId
	 * @return   查询分类下的公开视频
	 */
	public List<Video> findVideoByIsPublicId(int isPublic ,int classId);
	/**
	 * @param isMySite
	 * @return  查询是否是本站视频
	 */
	public List<Video> findVideoByIsMySite(int isMySite);
	/**
	 * @param isMySit
	 * @param classId
	 * @return   查询本站的分类视频
	 */
	public List<Video> findVideoByMySitId(int isMySit,int classId);
	/**
	 * @param id
	 * @return  通过id 获取视频资源
	 */
	public Video findVideoRecouresById(int id);

}

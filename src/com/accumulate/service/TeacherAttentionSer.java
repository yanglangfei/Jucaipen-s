package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.TeacherAttentionDao;
import com.accumulate.daoImp.TeacherAttentionImp;
import com.accumulate.entity.TeacherAttention;

/**
 * @author Administrator
 *
 *
 *  关注
 */
public class TeacherAttentionSer {

	/**
	 * @return 添加关注
	 */
	public static int insertAttention(TeacherAttention attention) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.insertAttention(attention);
	}
	/**
	 * @param teacherId
	 * @param userId
	 * @return   取消关注
	 */
	public static int cancleAttention(int teacherId,int userId){
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.cancleAttention(teacherId, userId);
	}

	/**
	 * @return 获取所有的关注
	 */
	public static List<TeacherAttention> findAllAttention() {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAllAttention();
	}

	/**
	 * @param userId
	 * @return  查询当前用户下的关注
	 */
	public static List<TeacherAttention> findAttentionByUid(int userId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionByUid(userId);
	}

	/**
	 * @param tId
	 * @return  根据讲师id查询关注信息
	 */
	public static List<TeacherAttention> findAttentionBytid(int tId,int page) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionBytid(tId,page);
	}

	/**
	 * @param uId
	 * @param tId
	 * @return 查询当前
	 */
	public static TeacherAttention findAttentionByUidAndTid(int uId, int tId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionByUidAndTid(uId, tId);
	}

}

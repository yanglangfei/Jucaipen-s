package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.HotIdeaDao;
import com.accumulate.daoImp.HotIdeaImp;
import com.accumulate.entity.HotIdea;

public class HotIdeaServ{

	/**
	 * @return ��ѯ���е����Ź۵�
	 */
	public static List<HotIdea> findAllHotIdea(int page) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.findAllHotIdea(page);
	}

	/**
	 * @param count
	 * @return ��ѯ����ļ������Ź۵�
	 */
	public static List<HotIdea> findIdeaByCount(int count) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.findIdeaByCount(count);
	}

	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ѯ���ǹ۵�
	 */
	public static List<HotIdea> findIdeaByTeacherId(int teacherId,int page) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.findIdeaByTeacherId(teacherId,page);
	}

	/**
	 * @param id
	 * @return   ͨ��id��ȡ���Ź۵���Ϣ
	 */
	public static HotIdea findIdeaById(int id) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.findIdeaById(id);
	}

	/**
	 * @param ideaId
	 * @param hits
	 * @return  ����id���ӵ�����
	 */
	public static int addHit(int ideaId, int hits) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.addHit(ideaId, hits);
	}

	/**
	 * @param ideaId
	 * @param commCount
	 * @return  ����id ����������
	 */
	public static int addComment(int ideaId, int commCount) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.addComment(ideaId, commCount);
	}

	/**
	 * @param ideaId
	 * @param googs
	 * @return  ����id���ӵ�����
	 */
	public static int addGood(int ideaId, int googs) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.addGood(ideaId, googs);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ���������������������
	 */
	public static HotIdea findGoodAndHitAndComm(int id) {
		HotIdeaDao dao=new HotIdeaImp();
		return dao.findGoodAndHitAndComm(id);
	}

	
	
	

}
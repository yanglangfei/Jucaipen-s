package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.AskDao;
import com.accumulate.daoImp.AskImp;
import com.accumulate.entity.Ask;

public class AskSer{

	/**
	 * @return ��ȡ��������
	 */
	public static List<Ask> findAllAsk(int page) {
		AskDao dao=new AskImp();
		return dao.findAllAsk(page);
	}

	/**
	 * @param count
	 * @return  ��ȡ�����������
	 */
	public static List<Ask> findLstAsk(int count) {
		AskDao dao=new AskImp();
		return dao.findLstAsk(count);
	}

	/**
	 * @param userId
	 * @return �����û�id��ȡ������Ϣ
	 */
	public static List<Ask> findAskByUserId(int userId) {
		AskDao dao=new AskImp();
		return dao.findAskByUserId(userId);
	}

	/**
	 * @param teacherId
	 * @return ���ݽ�ʦid��ȡ������Ϣ
	 */
	public static List<Ask> findAskByTeacherId(int teacherId) {
		AskDao dao=new AskImp();
		return dao.findAskByTeacherId(teacherId);
	}

	/**
	 * @param classId
	 * @return ���ݷ���id��ȡ������Ϣ
	 */
	public static List<Ask> findAskByClassId(int classId) {
		AskDao dao=new AskImp();
		return dao.findAskByClassId(classId);
	}

	/**
	 * @param state
	 * @return ��������״̬��ȡ������Ϣ
	 */
	public static List<Ask> findAskByAskState(int state) {
		AskDao dao=new AskImp();
		return dao.findAskByAskState(state);
	}

	/**
	 * @param isReply
	 * @return �������ʻظ�״̬��ȡ������Ϣ
	 */
	public static List<Ask> findAskByIsReply(int isReply) {
		AskDao dao=new AskImp();
		return dao.findAskByIsReply(isReply);
	}

	/**
	 * @param id
	 * @return ��������id��ȡ������ϸ��Ϣ
	 */
	public static Ask findAskById(int id) {
		AskDao dao=new AskImp();
		return dao.findAskById(id);
	}

	/**
	 * @param ask
	 * @return ����������Ϣ
	 */
	public static int insertAsk(Ask ask) {
		AskDao dao=new AskImp();
		return dao.insertAsk(ask);
	}

}
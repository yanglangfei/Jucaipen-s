package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Ask;

/**
 * @author Administrator
 *
 *  ��ȡ������Ϣ
 *  
 */
public interface AskDao {
	
	/**
	 * @param condition
	 * @return   ��ȡ��ѯ��Ϣ��ҳ��
	 */
	public int findTotlePage(String condition);
	
	/**
	 * @return  ��ȡ����������Ϣ
	 */
	public List<Ask> findAllAsk(int page);
	
	/**
	 * @param count
	 * @return ��ȡ����ļ�������
	 */
	public List<Ask> findLstAsk(int count);
	
	/**
	 * @param userId
	 * @return  ��ȡ��ǰ�û��µ���������
	 */
	public List<Ask> findAskByUserId(int userId);
	/**
	 * @param teacherId
	 * @return ��ȡ��ǰ��ʦ�µ���������
	 */
	public List<Ask> findAskByTeacherId(int teacherId);
	
	/**
	 * @param classId
	 * @return ���ݷ����ѯ������Ϣ
	 */
	public List<Ask> findAskByClassId(int classId);
	/**
	 * @param state
	 * @return  ͨ��״̬����ѯ������Ϣ 2����ʾ1Ϊ��ʾ
	 */
	public List<Ask> findAskByAskState(int state);
	/**
	 * @param isReply
	 * @return ���ݻظ�״̬��ѯ������Ϣ 2δ�ظ���1�ѻظ�
	 */
	public List<Ask> findAskByIsReply(int isReply);
	
	/**
	 * @param id
	 * @return ����id��ѯ������Ϣ
	 */
	public Ask findAskById(int id);
	/**
	 * @param ask
	 * @return ��������
	 */
	public int insertAsk(Ask ask);

}
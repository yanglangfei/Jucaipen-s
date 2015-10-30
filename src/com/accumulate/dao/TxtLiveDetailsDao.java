package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.TxtLiveDetails;

public interface TxtLiveDetailsDao {
	
	/**
	 * @param details
	 * @return  ��������ֱ����ϸ����
	 */
	public int insertTextDetaile(TxtLiveDetails details);

	/**
	 * @param id
	 * @return ����id��ȡֱ����ϸ��Ϣ
	 */
	public TxtLiveDetails findTextDetaileById(int id);
	/**
	 * @param type
	 * @return  �������ͻ�ȡֱ����ϸ��Ϣ
	 */
	public List<TxtLiveDetails> findTextDetaileByType(int type);
	/**
	 * @return  ��ȡ����ֱ����ϸ��Ϣ
	 */
	public List<TxtLiveDetails> findAllTextDetaile();
	/**
	 * @param liveId
	 * @return  ����ֱ��id��ѯֱ����ϸ��Ϣ
	 */
	public List<TxtLiveDetails> findTextDetaileByLiveId(int liveId);
	/**
	 * @param titleId
	 * @return   ���ݱ���id��ȡ����ֱ����Ϣ
	 */
	public List<TxtLiveDetails> findTextDetaileByTitleId(int titleId);
}
package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.TxtLiveDetailsDao;
import com.accumulate.daoImp.TxtLiveDetaileImp;
import com.accumulate.entity.TxtLiveDetails;

public class TxtLiveDetaileSer{
	
	
	/**
	 * @param details
	 * @return  ��������ֱ����ϸ����
	 */
	public static int insertTextDetaile(TxtLiveDetails details){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.insertTextDetaile(details);
	}

	/**
	 * @param id
	 * @return   ����id��ȡ����ֱ����ϸ����
	 */
	public static TxtLiveDetails findTextDetaileById(int id) {
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileById(id);
	}
	
	/**
	 * @param liveId
	 * @return  ����ֱ��id��ȡ����ֱ����ϸ����
	 */
	public static List<TxtLiveDetails> findTextDetaileByLiveId(int liveId){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileByLiveId(liveId);
	}
	
	
	/**
	 * @param titleId
	 * @return  ���ݱ���id��ȡ����ֱ����ϸ����
	 */
	public static List<TxtLiveDetails> findTextDetaileByTitleId(int titleId){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileByTitleId(titleId);
	}

	/**
	 * @param type
	 * @return  ����״̬��ȡ����ֱ����ϸ����
	 */
	public static List<TxtLiveDetails> findTextDetaileByType(int type) {
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileByType(type);
	}

	/**
	 * @return  ��ȡ���е�����ֱ����ϸ��Ϣ
	 */
	public static List<TxtLiveDetails> findAllTextDetaile() {
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findAllTextDetaile();
	}

}
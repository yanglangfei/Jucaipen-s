package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.TxtLiveDao;
import com.accumulate.daoImp.TextLiveImp;
import com.accumulate.entity.TextLive;

public class TxtLiveSer{
	
	/**
	 * @param textLive
	 * @return  ��������ֱ��
	 */
	public static int insertTextLive(TextLive textLive){
		TxtLiveDao dao=new TextLiveImp();
		return dao.insertTxtLive(textLive);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ����ֱ����ϸ����
	 */
	public static TextLive findTextLiveById(int id) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTextLiveById(id);
	}

	/**
	 * @return  ��ȡ���е��ı�ֱ��
	 */
	public static List<TextLive> findAllTextLive(int page) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findAllTextLive(page);
	}

	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦ��ȡ����ֱ��
	 */
	public static List<TextLive> findTextLiveByTeacherId(int teacherId) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTextLiveByTeacherId(teacherId);
	}

	/**
	 * @param isEnd
	 * @return   ��������ֱ��״̬��ȡ����ֱ������
	 */
	public static List<TextLive> findTextLiveByIsEnd(int isEnd) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTextLiveByIsEnd(isEnd);
	}
	
	/**
	 * @param teacherId
	 * @param count
	 * @return  ��ȡ��ʦ����ļ���ֱ����Ϣ
	 */
	public static List<TextLive> findTxtLiveByTeacherIdAndLast(int teacherId,int count){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTxtLiveByTeacherIdAndLast(teacherId, count);
	}

}
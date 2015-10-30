package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.MobileMessageDao;
import com.accumulate.daoImp.MobileMessageImp;
import com.accumulate.entity.MobileMessage;

public class MobileMessageSer{

	/**
	 * @param message
	 * @return  ���Ӷ���
	 */
	public static int insertMessage(MobileMessage message) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.insertMessage(message);
	}

	/**
	 * @param id
	 * @param message
	 * @return  �޸Ķ�����֤״̬
	 */
	public static int upDateMessageType(int id, MobileMessage message) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.upDateMessageType(id, message);
	}

	/**
	 * @param telPhone
	 * @return  �����ֻ��Ż�ȡ���н��ܶ���
	 */
	public static List<MobileMessage> findMobileMessgageByMobileNum(String telPhone) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.findMobileMessgageByMobileNum(telPhone);
	}

	/**
	 * @param count
	 * @param mobile
	 * @return �����ֻ��Ż�ȡ������ܵ��ļ�������
	 */
	public static List<MobileMessage> findMobileMessageByMobileNumLast(int count,
			String mobile) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.findMobileMessageByMobileNumLast(count, mobile);
	}}
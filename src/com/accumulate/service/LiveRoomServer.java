package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LiveRoomDao;
import com.accumulate.daoImp.LiveRoomImp;
import com.accumulate.entity.ChatRoom;

/**
 * @author Administrator ֱ����
 */
public class LiveRoomServer {

	/**
	 * @return ��ȡ����ֱ�����б�
	 */
	public static List<ChatRoom> getRoomList() {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getRoomList();
	}

	/**
	 * @param id
	 * @return   ����id ��ȡֱ������Ƶ��Ϣ        
	 */
	public static ChatRoom getRoomLiveUrl(int id) {
		LiveRoomDao dao = new LiveRoomImp();
		return dao.getLiveUrl(id);
	}

}

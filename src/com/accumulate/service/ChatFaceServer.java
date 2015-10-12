package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ChatFaceDao;
import com.accumulate.daoImp.ChatFaceImp;
import com.accumulate.entity.ChatFace;

/**
 * @author Administrator
 * 
 * 
 *         聊天表情
 */
public class ChatFaceServer {

	/**
	 * @return 获取所有聊天表情
	 */
	public static List<ChatFace> findAllFace() {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return  根据id查询表情信息
	 */
	public static ChatFace findFaceById(int id) {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findFaceById(id);
	}

}

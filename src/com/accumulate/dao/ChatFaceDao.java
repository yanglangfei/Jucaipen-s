package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ChatFace;

/**
 * @author Administrator
 *
 *
 *   聊天表情
 */
public interface ChatFaceDao {
	
	/**
	 * @return  获取所有聊天表情
	 */
	public List<ChatFace> findAll();
	
	/**
	 * @param id
	 * @return  根据id查询聊天表情
	 */
	public ChatFace findFaceById(int id);

}

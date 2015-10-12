package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ChatRoom;

/**
 * @author YLF
 * 
 *   直播室
 *
 */
public interface LiveRoomDao {
	
	/**
	 * @return   获取所有房间名称
	 */
	public List<ChatRoom> getRoomList();
	/**
	 * @param id
	 * @return  根据id 获取房间详细信息
	 */
	public ChatRoom getRoomInfo(int id);
	
	/**
	 * @param id
	 * @return  根据id 获取视频播放URL
	 */
	public ChatRoom  getLiveUrl(int id);
	
	/**
	 * @return   获取所有房间信息
	 */
	public List<ChatRoom> getAllRoom();

}

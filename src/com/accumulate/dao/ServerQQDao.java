package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ServerQQ;


/**
 * @author Administrator
 *
 *  在线客服
 * 
 */
public interface ServerQQDao {
	
	/**
	 * @return  获取所有客服
	 */
	public List<ServerQQ> findAllServer();
	/**
	 * @param id
	 * @return  根据id查询客服信息
	 */
	public ServerQQ findServerById(int id);
	
	/**
	 * @param roomId
	 * @return   根据房间id查询客服
	 */
	public List<ServerQQ> findServerByRoomId(int roomId);

}

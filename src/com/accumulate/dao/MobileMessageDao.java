package com.accumulate.dao;

import com.accumulate.entity.MobileMessage;

/**
 * @author YLF
 * 
 *    手机短信
 *
 */
public interface MobileMessageDao {
	
	/**
	 * @param message
	 * @return  发送短信
	 */
	public int insertMessage(MobileMessage message);
	
	/**
	 * @param type
	 * @return  改变短信状态
	 */
	public int upDateMessageType(int type);

}

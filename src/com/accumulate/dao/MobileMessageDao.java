package com.accumulate.dao;

import java.util.List;

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
	 * @return  根据id改变短信状态
	 */
	public int upDateMessageType(int id,MobileMessage message);
	
	/**
	 * @param telPhone
	 * @return  通过手机号查询短信
	 */
	public List<MobileMessage> findMobileMessgageByMobileNum(String telPhone);
	
	/**
	 * @param count
	 * @param mobile
	 * @return  根据手机号查询最近的短信内容
	 */
	public List<MobileMessage> findMobileMessageByMobileNumLast(int count,String mobile);

}

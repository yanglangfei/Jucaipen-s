package com.accumulate.dao;

import com.accumulate.entity.MailMessage;

/**
 * @author YLF
 * 
 *    邮件消息
 *
 */
public interface MailMessageDao {
	
	/**
	 * @param mailMessage
	 * @return  发送邮件信息
	 */
	public int insertMessage(MailMessage mailMessage);
	
	
	/**
	 * @param type
	 * @return   改变邮件信息状态
	 */
	public int upDateMessageType(int type);

}

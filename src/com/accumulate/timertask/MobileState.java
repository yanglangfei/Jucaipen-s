package com.accumulate.timertask;

import java.util.TimerTask;

import com.accumulate.entity.MobileMessage;
import com.accumulate.service.MobileMessageSer;

/**
 * @author Administrator
 *
 *
 *  ÐÞ¸Ä¶ÌÐÅ×´Ì¬
 */
public class MobileState extends TimerTask{
	private MobileMessage message;
	private String msgId;

	public MobileState(MobileMessage message) {
		this.message=message;
		msgId=message.getMsgid();
		message.setMsgType(3);
	}

	@Override
	public void run() {
		MobileMessageSer.upDateMessageFailType(msgId, message);
	}

}

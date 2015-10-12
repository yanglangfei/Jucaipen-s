package com.accumulate.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;

public class XinGeUtil {
	private static final String APP_KEY = "10f91058cbe939b1972867e74860af07";
	private static final int APP_ID=2100139212;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
	private Map<String, Object> custom = new HashMap<String, Object>();
	private static Message message;
	private static XinGeUtil xUtil;
	private XinGeUtil() {
		
	}

	public static XinGeUtil getInstance() {
		if (xUtil == null) {
			message = new Message();
			message.setType(Message.TYPE_MESSAGE);
			Style style = new Style(1);
			style = new Style(3, 1, 0, 1, 0);
			message.setStyle(style);
			TimeInterval acceptTime1 = new TimeInterval(0, 0, 23, 59);
			message.addAcceptTime(acceptTime1);
			xUtil = new XinGeUtil();
		}
		return xUtil;
	}

	// 向所有设备推送消息所有设备
	public JSONObject pushAccountDevice(String msg,String account) {
		XingeApp xinge = new XingeApp(APP_ID, APP_KEY);
		custom.clear();
		custom.put("chatMessage", msg);
		message.setCustom(custom);
		message.setContent("1");
		JSONObject ret = xinge.pushSingleAccount(XingeApp.DEVICE_ANDROID, account, message);
		return ret;
	}

}

package com.accumulate.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.NotyPopLoadTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class GePushUtils {
	private static final  String appKey="7ZpsKKg0TT6fqcZDLfE066";
	private static final String masterSecret="Ty1d91F73470oBqx0ozpB9";
	private static final String appId="fcsfpKg6TT63rs47CRxG42";
	private static GePushUtils utiles=new GePushUtils();
	private static IGtPush push;
	private GePushUtils(){
		
	}
	/**
	 * @return  实例化对象
	 */
	public static GePushUtils getInstance(){
		init();
		return utiles;
	}
	
	
	/**
	 *   初始化推送
	 */
	public static  void init(){
		try {
			if(push==null){
				push = new IGtPush(appKey, masterSecret);
			}
			push.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 *   所有设备推送通知
	 */
	public void pushAllDev(String title,String text){
		AppMessage appMessage=new AppMessage();
		NotificationTemplate template=new NotificationTemplate();
		template.setAppId(appId);
		template.setAppkey(appKey);
		template.setTitle(title);
		template.setText(text);
		appMessage.setData(template);
		appMessage.setOffline(true);
		appMessage.setOfflineExpireTime(1000*600);
		IPushResult res=push.pushMessageToApp(appMessage);
		System.out.println("res:"+res.getResponse().toString());
	}
	
	
	/**
	 * @param msg   推送聊天透传消息
	 */
	public void sendMsg(String msg,String clientId){
		SingleMessage message=new SingleMessage();
		TransmissionTemplate template=new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appKey);
		Target tag=new Target();
		tag.setAppId(appId);
		tag.setClientId(clientId);
		template.setTransmissionContent(msg);
		List<String> appIds=new ArrayList<String>();
		appIds.add(appId);  
		message.setData(template);
		message.setOffline(true);
		message.setOfflineExpireTime(1000*600);
		IPushResult res=push.pushMessageToSingle(message, tag);
		System.out.println("res:"+res.getResponse().toString());
	}
	
	public static void main(String[] args) {
		init();
	}
	
	/**
	 * @param msgType    初始化推送消息类型
	 */
	public void initMessage(int msgType){
		if(msgType==0){
			//指定应用群推送
			AppMessage appMessage=new AppMessage();
		}else if(msgType==1){
			//列表推送消息
			ListMessage listMessage=new ListMessage();
		}else{
			//单推消息
			SingleMessage singleMessage=new SingleMessage();
		}
	}
	
	/**
	 * @param tempType   初始化推送模版
	 */
	public void initTemp(int tempType){
		if(tempType==0){
			//点击通知到App模版
		    NotificationTemplate notificationTemplate=new NotificationTemplate();	
		}else if(tempType==1){
			//点击通知到链接模版
			LinkTemplate linkTemplate=new LinkTemplate();
		}else if(tempType==2){
			//透传模版
			TransmissionTemplate transmissionTemplate=new TransmissionTemplate();
		}else{
			//通知栏弹框下载模版
			NotyPopLoadTemplate notyPopLoadTemplate=new NotyPopLoadTemplate();
		}
		
	}
	

}

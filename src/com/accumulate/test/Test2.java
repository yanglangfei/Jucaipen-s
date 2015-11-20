package com.accumulate.test;

import java.util.Date;
import java.util.Timer;

import org.json.JSONObject;

import com.accumulate.timertask.NewTextLiveTasker;
import com.accumulate.utils.XinGeUtil;
import com.tencent.xinge.XingeApp;

public class Test2 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		NewTextLiveTasker main=new NewTextLiveTasker();
		timer.scheduleAtFixedRate(main, new Date(), 60000*60*24);
		/*JSONObject res=XingeApp.pushTokenAndroid(XinGeUtil.APP_ID, XinGeUtil.APP_KEY, "hello", "world", "6ec803bf5d17d124456cbe2b0b9957e368bc0222");
		JSONObject res=XingeApp.pushAllAndroid(XinGeUtil.APP_ID, XinGeUtil.APP_KEY, "≤‚ ‘", "≤‚ ‘–≈∏Î");
		System.out.println("res:"+res.toString());*/
	}

}

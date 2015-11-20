package com.accumulate.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

import com.accumulate.utils.XinGeUtil;
import com.tencent.xinge.XingeApp;

public class Test {
	
	private static String time="2015-10-30 10:20:17.000";
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	public static void main(String[] args) {/*
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			service.execute(new Runnable() {
				public void run() {
					String name = Thread.currentThread().getName();
					System.out.println("正在执行线程:" + name + " p:" + index);

				}
			});
		}
	*/
	/*XingeApp xing=new XingeApp(XinGeUtil.APP_ID, XinGeUtil.APP_KEY);
	JSONObject devCount=xing.queryDeviceCount();
	System.out.println("devCount:"+devCount);
	JSONObject TAGE=xing.queryTags();
	System.out.println("TAG:"+TAGE);*/
		/*String str="20151118154456,0 1001118154456693600";
		System.out.println("str:"+str.split(",")[0]);
		String ret=str.split(",")[1];
		System.out.println("ret_code："+ret.split(" ")[0]);
		System.out.println("ret_code："+ret.split(" ")[1]);*/
		ExecutorService service=Executors.newScheduledThreadPool(3);
		for(int i=0;i<10;i++){
			final int p=i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			service.execute(new Runnable() {
				
				public void run() {
					String name=Thread.currentThread().getName();
					System.out.println("当前线程:"+name+"  p:"+p);
					
				}
			});
			
		}
		
	}

}

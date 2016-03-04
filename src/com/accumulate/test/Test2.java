package com.accumulate.test;

import java.util.Date;
import java.util.Timer;
import com.accumulate.timertask.NewTextLiveTasker;

public class Test2 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		NewTextLiveTasker main=new NewTextLiveTasker();
		timer.scheduleAtFixedRate(main, new Date(), 60000*60*24);
	}

}

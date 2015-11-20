package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Friends;
import com.accumulate.timertask.NewTextLiveTasker;

/**
 * @author Administrator
 * 
 *    推送文字直播信息
 *    
 *
 */
@SuppressWarnings("serial")
public class PushTextLive extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		initNewLive();
	}

	
	private void initNewLive() {
		Timer timer=new Timer();
		NewTextLiveTasker tasker=new NewTextLiveTasker();
		timer.scheduleAtFixedRate(tasker, new Date(), 60000*60*24);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    response.setCharacterEncoding("UTF-8");
	}

}

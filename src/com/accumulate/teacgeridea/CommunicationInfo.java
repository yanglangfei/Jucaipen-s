package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.LiveInteractive;
import com.accumulate.entity.User;
import com.accumulate.service.LiveInteractiveSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *  获取直播交流信息
 */
@SuppressWarnings("serial")
public class CommunicationInfo extends HttpServlet {
	private String result;
	private List<LiveInteractive> interactives;
	private List<User> users=new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String liveId=request.getParameter("liveId");
		String page=request.getParameter("page");
		if(StringUtil.isInteger(page)){
			//page 参数正常
			int p=Integer.parseInt(page);
			if(StringUtil.isInteger(liveId)){
				//直播id正常
				int lId=Integer.parseInt(liveId);
				initCommunicationData(lId,p);
				result=JsonUtil.getLiveInterationList(interactives,users);
			}else {
				//直播id参数异常
				result=JsonUtil.getRetMsg(1,"直播id参数数字格式化异常");
			}
		}else {
			result=JsonUtil.getRetMsg(2,"分页参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	private void initCommunicationData(int lId,int page) {
		// 初始化直播互动信息
		users.clear();
		interactives=LiveInteractiveSer.findByLiveId(lId,page);
		if(interactives.size()>0){
			for(LiveInteractive liInteractive :interactives){
				int uId=liInteractive.getUserId();
				User user=UserServer.findUserNikNameById(uId);
				users.add(user);
			}
		}
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}

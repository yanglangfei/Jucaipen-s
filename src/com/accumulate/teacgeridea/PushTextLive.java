package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.utils.StringUtil;
import com.accumulate.utils.XinGeUtil;

/**
 * @author Administrator
 * 
 *    推送文字直播信息
 *    
 *         推送TAG   userName   or    deveId
 *
 */
@SuppressWarnings("serial")
public class PushTextLive extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String maxId=request.getParameter("liveId");
		if(StringUtil.isInteger(maxId)){
			//最大直播id正常
			int liveId=Integer.parseInt(maxId);
			if(liveId>0){
				initNewLive();
			}else {
				
			}
			
		}else {
			
		}
		
		out.flush();
		out.close();
	}

	
	private void initNewLive() {
		//获取最新的文字直播
		//XinGeUtil.getInstance().pushAccountDevice(msg, account);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}

}

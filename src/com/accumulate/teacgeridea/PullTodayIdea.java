package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TxtLiveDetails;
import com.accumulate.service.TxtLiveDetaileSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *   实时更新今日观点数据
 *   
 *       liveId  直播id
 *       maxId   最大的观点ID
 */
@SuppressWarnings("serial")
public class PullTodayIdea extends HttpServlet {

	private List<TxtLiveDetails> todayIdeas;
	private String result;
	




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String maxId=request.getParameter("maxId");
		String liveId=request.getParameter("liveId");
		if(StringUtil.isInteger(maxId)){
			//querryType数字格式化正常
			int mId=Integer.parseInt(maxId);
			if(StringUtil.isInteger(liveId)){
				int lId=Integer.parseInt(liveId);
				initTodayIdeasDataByLiveId(mId,lId);
				result = JsonUtil.getTodayIdeasByLiveId(todayIdeas);
			}else {
				//liveId 数字格式化异常
				result=JsonUtil.getRetMsg(1,"liveId数字格式化异常");
			}
		}else {
			//maxId 数字格式化异常
			result=JsonUtil.getRetMsg(2, "maxId 参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	
	private void initTodayIdeasDataByLiveId(int mId, int lId) {
		// 获取实时更新的今日观点
		todayIdeas=TxtLiveDetaileSer.findPullTextDetaileByLiveId(lId, mId);
	}




	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doGet(request, response);
	}

}

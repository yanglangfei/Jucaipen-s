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
 *   ʵʱ���½��չ۵�����
 *   
 *       liveId  ֱ��id
 *       maxId   ���Ĺ۵�ID
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
			//querryType���ָ�ʽ������
			int mId=Integer.parseInt(maxId);
			if(StringUtil.isInteger(liveId)){
				int lId=Integer.parseInt(liveId);
				initTodayIdeasDataByLiveId(mId,lId);
				result = JsonUtil.getTodayIdeasByLiveId(todayIdeas);
			}else {
				//liveId ���ָ�ʽ���쳣
				result=JsonUtil.getRetMsg(1,"liveId���ָ�ʽ���쳣");
			}
		}else {
			//maxId ���ָ�ʽ���쳣
			result=JsonUtil.getRetMsg(2, "maxId �������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	
	private void initTodayIdeasDataByLiveId(int mId, int lId) {
		// ��ȡʵʱ���µĽ��չ۵�
		todayIdeas=TxtLiveDetaileSer.findPullTextDetaileByLiveId(lId, mId);
	}




	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doGet(request, response);
	}

}

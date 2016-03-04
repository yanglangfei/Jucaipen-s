package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.LogCommen;
import com.accumulate.entity.User;
import com.accumulate.service.LogCommSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         ����id��ȡ���Ź۵������б�
 * 
 */
@SuppressWarnings("serial")
public class IdeaCommList extends HttpServlet {
	private String result;
	private List<LogCommen> comms;
	private List<User> users = new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ideaId = request.getParameter("ideaId");
		String page=request.getParameter("page");
		if (StringUtil.isInteger(ideaId)) {
			int id = Integer.parseInt(ideaId);
			if(StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				initHotIdeaCommList(id,p);
				result = JsonUtil.getIdeaCommList(comms,users);
			}else {
				result=JsonUtil.getRetMsg(2,"ҳ���������ָ�ʽ���쳣");
			}
			
		} else {
			result = JsonUtil.getRetMsg(1, "���Ź۵�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initHotIdeaCommList(int id,int page) {
		// ��ʼ�����Ź۵������б�
		users.clear();
		comms = LogCommSer.findLogCommByLogId(id,page);
		if (comms.size() > 0) {
			for (LogCommen comm : comms) {
				int uId = comm.getUserId();
				User user = UserServer.findUserNikNameById(uId);
				users.add(user);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

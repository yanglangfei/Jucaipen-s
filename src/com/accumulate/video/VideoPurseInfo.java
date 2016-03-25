package com.accumulate.video;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *   ��ȡֱ���乺����Ϣ �Ƿ����ֱ����
 */
@SuppressWarnings("serial")
public class VideoPurseInfo extends HttpServlet {

	private User user;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			initUserPurseInfo(uId);
			if(user!=null){
				result = JsonUtil.getPurshInfo(user);
			}else{
				result=JsonUtil.getRetMsg(1, "��ȡ�û���Ϣʧ��");
			}
		} else {
               result=JsonUtil.getRetMsg(2,"�û�ID���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initUserPurseInfo(int userId) {
        user=UserServer.findUserPurshInfo(userId);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

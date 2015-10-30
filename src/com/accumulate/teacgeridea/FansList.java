package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TeacherAttention;
import com.accumulate.entity.User;
import com.accumulate.service.TeacherAttentionSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ��˿�б�
 * 
 */
@SuppressWarnings("serial")
public class FansList extends HttpServlet {

	private List<TeacherAttention> attentions;
	private List<User> users = new ArrayList<User>();
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isInteger(teacherId)) {
			// ��ʦid���ָ�ʽ����ȷ
			int tId = Integer.parseInt(teacherId);
			initTeacherFansData(tId);
			result = JsonUtil.getAttentionList(users);
		} else {
			result = JsonUtil.getRetMsg(1, "��ʦid���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initTeacherFansData(int tId) {
		// ��ʼ����ʦ��˿����
		attentions = TeacherAttentionSer.findAttentionBytid(tId);
		if (attentions != null && attentions.size() > 0) {
			for (TeacherAttention attention : attentions) {
				int uId = attention.getUserId();
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
package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.HotIdea;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.HotIdeaServ;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         ���ݽ�ʦid��ȡ���Ź۵�   
 */
@SuppressWarnings("serial")
public class HotIdeaByTeacher extends HttpServlet {
	private String result;
	private List<HotIdea> ideas;
	private FamousTeacher teachers;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId = request.getParameter("teacherId");
		String page = request.getParameter("page");
		if (StringUtil.isInteger(teacherId)) {
			int tId = Integer.parseInt(teacherId);
			if (StringUtil.isInteger(page)) {
				int p = Integer.parseInt(page);
				initHotIdeas(tId, p);
				result = JsonUtil.getInvestmentIdeaListByTeacherId(ideas,
						teachers);
			} else {
				result = JsonUtil.getRetMsg(2, "ҳ���������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "��ʦid�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initHotIdeas(int tId, int page) {
		// ��ʼ����ʦ���Ź۵���Ϣ
		ideas = HotIdeaServ.findIdeaByTeacherId(tId, page);
		teachers = FamousTeacherSer.findFamousTeacherById(tId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

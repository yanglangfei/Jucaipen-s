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
 *         根据讲师id获取热门观点   
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
				result = JsonUtil.getRetMsg(2, "页数参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "讲师id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initHotIdeas(int tId, int page) {
		// 初始化讲师热门观点信息
		ideas = HotIdeaServ.findIdeaByTeacherId(tId, page);
		teachers = FamousTeacherSer.findFamousTeacherById(tId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

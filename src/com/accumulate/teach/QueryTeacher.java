package com.accumulate.teach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Teacher;
import com.accumulate.service.TeacherServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author ylf
 * 
 *         查询教师信息
 * 
 */
@SuppressWarnings("serial")
public class QueryTeacher extends HttpServlet {
	private List<Teacher> teachers;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String page = request.getParameter("page");
		if (StringUtil.isInteger(page)) {
			teachers = TeacherServer.getTeachers(Integer.parseInt(page));
			result = JsonUtil.getObject(teachers);
		} else {
			result = JsonUtil.getRetMsg(1, "参数格式化异常");
		}

		out.print(result);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

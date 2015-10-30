package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *  找名家
 */
@SuppressWarnings("serial")
public class FindFamousTeacher extends HttpServlet {
	private String result;
	private List<FamousTeacher> teachers;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String page=request.getParameter("page");
		if(StringUtil.isInteger(page)){
			int p=Integer.parseInt(page);
			findTeacherList(p);
			result=JsonUtil.getFindTeacherList(teachers);
		}else {
			result=JsonUtil.getRetMsg(1,"页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	private void findTeacherList(int page) {
		//找名家
		teachers=FamousTeacherSer.findAllFamousTeacher(page);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}

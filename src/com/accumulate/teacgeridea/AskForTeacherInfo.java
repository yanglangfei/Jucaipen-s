package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Answer;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.service.AnswerSer;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *   通过提问id获取讲师信息
 */
@SuppressWarnings("serial")
public class AskForTeacherInfo extends HttpServlet {


	private FamousTeacher teacher;
	private String result;
	private Answer answer;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String askId=request.getParameter("askId");
		if(StringUtil.isInteger(askId)){
			int id=Integer.parseInt(askId);
			iniTeacherInfo(id);
			result=JsonUtil.getFamousInfo(teacher,answer);
		}else {
			result=JsonUtil.getRetMsg(1,"提问id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void iniTeacherInfo(int id) {
		answer = AnswerSer.findAnswerByAskId(id);
		if(answer!=null){
			int teacherId=answer.getTeacherId();
			teacher = FamousTeacherSer.findFamousTeacherById(teacherId);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}

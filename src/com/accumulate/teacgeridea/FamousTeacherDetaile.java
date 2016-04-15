package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.TextLive;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.TxtLiveSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;
/**
 * @author Administrator
 * 
 * 
 *         名师详细信息      
 */
@SuppressWarnings("serial")
public class FamousTeacherDetaile extends HttpServlet {
	private String result;
	private FamousTeacher teacher;
	private List<TextLive> txtLives;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isInteger(teacherId)) {
			int id = Integer.parseInt(teacherId);
			if (id > 0) {
				initTeacherDetaile(id);
				result = JsonUtil.getFamousTeacherDetaile(teacher, txtLives);
			} else { 
				result = JsonUtil.getRetMsg(2, "讲师id不符合要求");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}


	private void initTeacherDetaile(int id) {
		teacher = FamousTeacherSer.findFamousTeacherById(id);
		if (teacher != null) {
			txtLives = TxtLiveSer.findTxtLiveByTeacherIdAndLast(id, 1);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

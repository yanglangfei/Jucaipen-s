package com.accumulate.teach;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Teacher;
import com.accumulate.entity.Video;
import com.accumulate.service.TeacherServer;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author ylf
 * 
 *         根据视频查询教师详细信息
 *         
 *            --id   视频id
 * 
 */
@SuppressWarnings("serial")
public class TeacherInfo extends HttpServlet {
	private String result;
	private Teacher teacher;
	private Video video;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Id = request.getParameter("id");
		if (StringUtil.isInteger(Id)) {
			int id = Integer.parseInt(Id);
			intitVideoInfo(id);
			result = JsonUtil.getObject(teacher);
		} else {
			result =JsonUtil.getRetMsg(1,"视频id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void intitVideoInfo(int id) {
		// 初始化视频信息
		video=VideoServer.findVideoById(id);
		int teacherId=video.getTearcherId();
		initTeacher(teacherId);
		
	}

	private void initTeacher(int teacherId) {
		//初始化教师信息
		teacher=TeacherServer.getTeacher(teacherId);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

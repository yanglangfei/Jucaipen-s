package com.accumulate.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Video;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;

/**
 * @author YLF
 * 
 *         Ñ§ÌÃÊ×Ò³ ---
 *               classId =2 -----isIndex=1;£¨parentId=2£©
 * 
 */
@SuppressWarnings("serial")
public class IndexSchool extends HttpServlet {
	private String result;      
	private List<Video> sTvs;  

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initData();
		result = JsonUtil.getIndexVideoList(sTvs);
		out.print(result); 
		out.flush();
		out.close();
	}

	private void initData() {
		sTvs = VideoServer.findVideoByClassIdLast(2, 0);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

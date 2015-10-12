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
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         根据学堂分类id 获取对应的学堂信息
 * 
 */
@SuppressWarnings("serial")
public class SchoolList extends HttpServlet {
	private List<Video> tvs;

	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("typeId");
		if (StringUtil.isInteger(typeId)) {
			int id = Integer.parseInt(typeId);
			initData(id);
			result = JsonUtil.getVideoList(tvs);
		} else {
			result = JsonUtil.getRetMsg(1, "分类参数格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int id) {
		tvs = VideoServer.findVideoByClassId(id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

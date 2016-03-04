package com.accumulate.teach;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Video;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;

/**
 * @author ylf
 * 
 *         首页在线教学视频 indexId=1 classId=3 (parentId=1)
 * 
 */
@SuppressWarnings("serial") 
public class IndexTeach extends HttpServlet {
	private List<Video> tvs = new ArrayList<Video>();
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initData();
		result = JsonUtil.getIndexVideoList(tvs);
		out.print(result);
		out.close();
	}
 
	private void initData() {    
		// 获取直播数据
		tvs.clear();
		tvs = VideoServer.findVideoByClassIdLast(2, 1);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

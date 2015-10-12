package com.accumulate.video;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Video;
import com.accumulate.service.VideoServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *   获取视频详情
 */
@SuppressWarnings("serial")
public class VideoDetaile extends HttpServlet {

	private Video video;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String videoId = request.getParameter("videoId");
		if (StringUtil.isInteger(videoId)) {
			int id = Integer.parseInt(videoId);
			initVideoDetaile(id);
			if(video!=null){
			result = JsonUtil.getVideoDetaile(video);
			}else{
				result=JsonUtil.getRetMsg(3,"获取视频详细信息失败");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "视频id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initVideoDetaile(int id) {
		// 获取视频详细信息
		video = VideoServer.findVideoById(id);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

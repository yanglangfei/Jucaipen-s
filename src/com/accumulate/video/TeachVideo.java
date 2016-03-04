package com.accumulate.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.ChatRoom;
import com.accumulate.service.LiveRoomServer;
import com.accumulate.utils.JsonUtil;

/**
 * @author YLF
 * 
 *   根据分类，获取直播视频列表
 *
 */
   
@SuppressWarnings("serial")
public class TeachVideo extends HttpServlet {

	private String result;
	private List<ChatRoom> rooms;   

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initData();
		if(rooms!=null){
			result=JsonUtil.getRoomList(rooms);
		}else {
			result=JsonUtil.getRetMsg(1,"获取数据异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData() {
		rooms=LiveRoomServer.getRoomList();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.accumulate.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.ChatFace;
import com.accumulate.service.ChatFaceServer;
import com.accumulate.utils.JsonUtil;

/**
 * @author Administrator
 * 
 * 
 *         查询聊天表情
 */

@SuppressWarnings("serial")
public class QuerryChatFace extends HttpServlet {
	private List<ChatFace> chatFaces;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initChatFace();
		result = JsonUtil.getChatFaceList(chatFaces);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initChatFace() {
		// 初始化聊天表情
		chatFaces = ChatFaceServer.findAllFace();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

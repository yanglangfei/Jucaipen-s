package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.accumulate.utils.XinGeUtil;

/**
 * @author Administrator
 * 
 * 
 *         网页推送消息
 * 
 *         all 1 全部设备 2 指定TAG设备 3 指定TOKEN设备 msgType 新闻 直播 系统通知 版本更新
 */
@SuppressWarnings("serial")
public class WebPushInfo extends HttpServlet {
	private String result;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msgType = request.getParameter("msgType");
		String all = request.getParameter("all");
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		String tagName = request.getParameter("tagName");
		String tokenName = request.getParameter("tokenName");
		if ("1".equals(all)) {
			// 全部设备
			result = pushAllDevMsg(msgType, title, message);
		} else if ("2".equals(all)) {
			// 指定TAG
			result = pushTagDevMsg(msgType, tagName, title, message);
		} else if ("3".equals(all)) {
			// 指定TOKEN
			result = pushTokenDevMsg(msgType, tokenName, title, message);
		} else {
			result = "未知异常";
		}
		out.print("<html>");
		out.print("<head>");
		out.print("<head/>");
		out.print("<body>");
		out.print("<div style='margin-top: 20%;text-align: center;' >" + result
				+ "</div>");
		out.print("<body/>");
		out.print("</html>");
		out.flush();
		out.close();
	}

	private String pushTokenDevMsg(String msgType, String title,
			String tokenName, String message) {
		// 发送指定Token设备消息
		JSONObject res = XinGeUtil.getInstance(false).pushTokenDevMsg(
				tokenName, title, message);
		return res.toString();
	}

	private String pushTagDevMsg(String msgType, String tagName, String title,
			String message) {
		// 发送指定Tag设备消息
		JSONObject res = XinGeUtil.getInstance(false).pushTagDevMsg(tagName,
				title, message);
		return res.toString();
	}

	private String pushAllDevMsg(String msgType, String title, String message) {
		// 发送全部设备指定消息
		JSONObject res = XinGeUtil.getInstance(false).pushAllDevMsg(title,
				message);
		return res.toString();

	}

}

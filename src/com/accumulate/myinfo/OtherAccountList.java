package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *   获取第三方账号信息
 * 
 */
@SuppressWarnings("serial")
public class OtherAccountList extends HttpServlet {
	private User user;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				querryOtherAccount(uId);
				if (user != null) {
					result = JsonUtil.getOtherAccountList(user);
				} else {
					result = JsonUtil.getRetMsg(1, "获取信息异常");
				}
			} else {
				result = JsonUtil.getRetMsg(5, "当前用户还没登录");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "用户id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void querryOtherAccount(int uId) {
		// 查询第三方账号信息
		user = UserServer.querryOtherAccount(uId);

	}

}

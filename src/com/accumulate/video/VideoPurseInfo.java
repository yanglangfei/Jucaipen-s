package com.accumulate.video;

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
 *   获取直播间购买信息 是否进入直播间
 */
@SuppressWarnings("serial")
public class VideoPurseInfo extends HttpServlet {

	private User user;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			initUserPurseInfo(uId);
			if(user!=null){
				result = JsonUtil.getPurshInfo(user);
			}else{
				result=JsonUtil.getRetMsg(1, "获取用户信息失败");
			}
		} else {
               result=JsonUtil.getRetMsg(2,"用户ID数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initUserPurseInfo(int userId) {
        user=UserServer.findUserPurshInfo(userId);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *  查询用户登录状态
 */
@SuppressWarnings("serial")
public class QuerryIsLogin extends HttpServlet {
	private String result;
	private String serverToken;

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
		String userId=request.getParameter("userId");
		String clientToken=request.getParameter("clientToken");
		if(StringUtil.isInteger(userId)){
			if(StringUtil.isNotNull(clientToken)){
				int uId=Integer.parseInt(userId);
				querryUserToken(uId);
				if(clientToken.equals(serverToken)){
					//token验证通过
					result=JsonUtil.getRetMsg(0, "用户登录");
				}else {
					//token验证失败
					result=JsonUtil.getRetMsg(1,"用户token信息验证失败");
				}
			}else {
				  result=JsonUtil.getRetMsg(2,"token信息为空");
			}
		}else {
			result=JsonUtil.getRetMsg(1,"用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param token   根据用户id查询用户登录token信息
	 */
	private void querryUserToken(int uId) {
		serverToken=UserServer.findUserTokenById(uId);
	}

}

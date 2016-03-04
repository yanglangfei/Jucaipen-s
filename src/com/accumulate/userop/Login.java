package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.LoginUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         登录
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {
	private String result;
    private User user;
	private String userName;
	private Map<String, String> param = new HashMap<String, String>();
	private static final String LOGIN_PATH = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=Login";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// clientAddress = request.getRemoteAddr();
		if (!StringUtil.isNotNull(userName)) {
			result = JsonUtil.getRetMsg(1, "用户名不能为空");     
		} else if (!StringUtil.isNotNull(password)) {
			result = JsonUtil.getRetMsg(2, "密码不能为空");
		} else {
			// md5Pwd = MD5Util.MD5(password);
			// user = UserServer.loginUser(userName);
			// if (user != null) {
			// 用户名存在
			// String pwd = user.getPassword();
			// if (pwd.equals(md5Pwd)) {
			// 密码正确
			// int uId = user.getId();
			param.clear();
			param.put("username", userName);
			param.put("pwd", password);
			String jsonArray = LoginUtil.sendHttpPost(LOGIN_PATH, param);
			if (jsonArray != null) {
				JSONObject object = new JSONObject(jsonArray);
				boolean isLogin = object.getBoolean("IsLogin");
				String msg=object.getString("Msg");
				if (isLogin) {
					// 登录成功
					int userId=object.getInt("ActionId");
					querrryUserInfo(userId);
					result=JsonUtil.getLoginResult(user);
				}else {
					result=JsonUtil.getRetMsg(4,msg);
				}
			}else {
				result=JsonUtil.getRetMsg(3, "系统繁忙，请稍后重试");
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}
	/*
	 * 
	 * 修改登录状态
	 * 
	 * private void upDateLoginState(int uId, String token) {
	 * UserServer.updateLoginToken(uId, token);
	 * 
	 * }
	 * 
	 * private void handleLoginResult(int res, String pwd, int uId) { // 处理登录结果
	 * LoginLog log = new LoginLog(); log.setLoginDate(sdf.format(new Date()));
	 * log.setLoginResult(res); log.setUserId(uId); log.setUserName(userName);
	 * log.setPassword(pwd); if (res == 0) { log.setRemark("登录失败：密码错误"); } else
	 * { log.setRemark("登录成功"); } log.setLoginIp(clientAddress);
	 * LogServer.insertLog(log);
	 * 
	 * }
	 */

	private void querrryUserInfo(int userId) {
		user=UserServer.findLoginInfoById(userId);
		
	}

}

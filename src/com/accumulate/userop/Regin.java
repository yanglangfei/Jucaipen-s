package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.LoginUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         注册
 * 
 */
@SuppressWarnings("serial")
public class Regin extends HttpServlet {
	private static final String REGIN_PATH = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=Reg";
	private String result;
	private Map<String, String> param = new HashMap<String, String>();
	private String reginIp;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String telPhone = request.getParameter("telPhone");
		String password = request.getParameter("password");
		reginIp = request.getRemoteAddr();
		String reptPwd = request.getParameter("retPwd");
		String actionCode = request.getParameter("actionCode");
		if (!StringUtil.isNotNull(userName)) {
			result = JsonUtil.getRetMsg(1, "账号不能为空");
		} else if (!StringUtil.isNotNull(password)) {
			result = JsonUtil.getRetMsg(2, "密码不能为空");
		} else if (!StringUtil.isNotNull(reptPwd)) {
			result = JsonUtil.getRetMsg(3, "确认密码不能为空");
		} else if (!StringUtil.isMobileNumber(telPhone)) {
			result = JsonUtil.getRetMsg(4, "非法手机号");
		} else if (!password.equals(reptPwd)) {
			result = JsonUtil.getRetMsg(5, "两次密码不一致");
		} else {
			if (StringUtil.isNotNull(actionCode)) {
				param.clear();
				param.put("username", userName);
				param.put("mobilenum", telPhone);
				param.put("pwd", password);
				param.put("pwd_sure", reptPwd);
				param.put("actioncode", actionCode);
				param.put("ip",reginIp);
				param.put("regfrom",5+"");
				String logJson = LoginUtil.sendHttpPost(REGIN_PATH, param);
				if(logJson!=null){
					result=logJson;
				}else {
					result=JsonUtil.getRetMsg(7, "系统繁忙，请稍后重试");
				}
			} else {
				result = JsonUtil.getRetMsg(6, "验证码不能为空");
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}
}

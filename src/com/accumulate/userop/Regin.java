package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.MD5Util;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         注册
 * 
 */
@SuppressWarnings("serial")
public class Regin extends HttpServlet {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String result;
	private User user;
	private User u;
	private String md5Pwd;
	private String reginDate;
	private String password;
	private String userName;
	private String telPhone;
	private int isSuccess;
	private String reginIp;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		userName = request.getParameter("userName");
		telPhone = request.getParameter("telPhone");
		password = request.getParameter("password");
		reginIp=request.getRemoteAddr();
		String reptPwd = request.getParameter("retPwd");
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
			user = UserServer.findUserByAccount(userName);
			if (user != null) {
				// 用户名已经存在
				result = JsonUtil.getRetMsg(6, "用户名已被注册");
			} else {
				user=UserServer.findUserByTelPhone(telPhone);
				if(user!=null){
					//手机号已被绑定
					result=JsonUtil.getRetMsg(8, "手机号已被注册");
				}else {
					isSuccess = reginInfo();
					if (isSuccess == 1) {
						// 注册成功
						result = JsonUtil.getRetMsg(0, "注册成功");
					} else {
						// 注册失败
						result = JsonUtil.getRetMsg(7, "注册失败");
					}
				}
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private int reginInfo() {
		// 用户名不存在
		md5Pwd = MD5Util.MD5(password);
		reginDate=sdf.format(new Date());
		u = new User();
		u.setRegIp(reginIp);
		u.setPassword(md5Pwd);
		u.setUserName(userName);
		u.setMobileNum(telPhone);
		u.setRegDate(reginDate);
		return UserServer.insertUser(u);

	}

}

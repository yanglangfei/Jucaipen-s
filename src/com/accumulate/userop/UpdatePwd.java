package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.MD5Util;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         修改密码
 * 
 */
@SuppressWarnings("serial")
public class UpdatePwd extends HttpServlet {
	private int isSuccess;
	private String result;
	private String md5NewPwd;
	private String md5OldPwd;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String repPwd = request.getParameter("repPwd");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if(uId>0){
				if (StringUtil.isPassword(oldPwd) && StringUtil.isPassword(newPwd)
						&& StringUtil.isPassword(repPwd)) {
						// 查询并判断旧密码是否正确
						String pwd = initOldPwd(uId);
						md5OldPwd=MD5Util.MD5(oldPwd);
						if (pwd!=null&&pwd.equals(md5OldPwd)) {
							// 判断新密码与确认密码是否一致
							if (newPwd.equals(repPwd)) {
								// 修改密码操作
							    md5NewPwd=MD5Util.MD5(newPwd);
								isSuccess = updatePwd(uId,md5NewPwd);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "密码修改成功");
								} else {
									result = JsonUtil.getRetMsg(6, "密码修改失败");
								}
							} else {
								result = JsonUtil.getRetMsg(4, "两次密码不一致");
							}
						} else {
							result = JsonUtil.getRetMsg(5, "密码输入有误");
						}
				} else {
					result = JsonUtil.getRetMsg(3, "密码必须是6-23位字母、数字、字符");
				}
				
			}else {
				result=JsonUtil.getRetMsg(2,"当前用户还没登录");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "参数用户id格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private int updatePwd(int uId,String md5Pwd) {
		// 修改密码
		isSuccess = UserServer.updatePassword(uId, md5Pwd);
		return isSuccess;
	}

	private String initOldPwd(int uId) {
		// 查询用户密码
		return UserServer.findPasswordById(uId);
	}

}

package com.accumulate.userop;

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
 * @author YLF
 * 
 * 
 *         绑定第三方账号 ---------------解除 userId 绑定账号的用户id accountType 绑定账号类型 ----0
 *         QQ -----1 微信 -----2 新浪 accountId 绑定账号的id
 * 
 */
@SuppressWarnings("serial")
public class UpdateOtherAccount extends HttpServlet {
	private String result;
	private int isSuccess;

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
		String accountType = request.getParameter("accountType");
		String accountId = request.getParameter("accountId").trim();
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(accountType)) {
					int type = Integer.parseInt(accountType);
					if (type == 0 || type == 1 || type == 2) {
						User u = checkAccountIsBind(type, accountId);
						//用户不存在    --绑定       
						if ((accountId==null||accountId.trim().equals(""))||u == null) {
							insertOtherAccount(uId, type, accountId);
							if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "账号保存成功");
							} else {
								result = JsonUtil.getRetMsg(1, "账号保存失败");
							}
						} else {
							result = JsonUtil.getRetMsg(7, "该账号已绑定");
						}
					} else {
						result = JsonUtil.getRetMsg(6, "账号类型参数必须为0或1或2");
					}

				} else {
					result = JsonUtil.getRetMsg(3, "账号类型参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(5, "当前用户还没登录");
			}

		} else {
			result = JsonUtil.getRetMsg(4, "用户id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param type
	 * @param accountId
	 * 
	 *            验证账号是否绑定
	 */
	private User checkAccountIsBind(int type, String accountId) {
		User user;
		if (type == 0) {
			// qq
			user = UserServer.findUserByQQId(accountId);
		} else if (type == 1) {
			// 微信
			user = UserServer.findUserByWeixinId(accountId);
		} else if (type == 2) {
			// 新浪
			user = UserServer.findUserBySinaId(accountId);
		} else {
			user = new User();
		}
		return user;

	}

	private void insertOtherAccount(int uId, int type, String accountId) {
		// 修改第三方账号id
		isSuccess = UserServer.updateAccountId(uId, type, accountId);

	}

}

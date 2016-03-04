package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.SystemInfo;
import com.accumulate.service.SystemInfoSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         消息中心， type 1----收件箱 2----发件箱
 * 
 */
@SuppressWarnings("serial")
public class InfoCenter extends HttpServlet {
	private String result;
	private List<SystemInfo> infos = new ArrayList<SystemInfo>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String pager = request.getParameter("pager");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(pager)) {
					int page = Integer.parseInt(pager);
					initSystemInfoByUserId(uId, page);
					result = JsonUtil.getObject(infos);
				} else {
					result = JsonUtil.getRetMsg(3, "页数参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(6, "当前用户还没登录");
			}

		} else {
			result = JsonUtil.getRetMsg(2, "用户id参数格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initSystemInfoByUserId(int uId, int page) {
		// 根据用户id获取系统信息
		infos.clear();
		infos = SystemInfoSer.findInfoByUserId(uId, page);

	}

}

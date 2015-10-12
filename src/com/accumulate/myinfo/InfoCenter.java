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
		String typeId = request.getParameter("type");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(typeId)) {
					int type = Integer.parseInt(typeId);
					if (StringUtil.isInteger(pager)) {
						int page = Integer.parseInt(pager);
						if (type == 1) {
							// 查询收件箱信息
							initReceiveBoxInfo(uId, page);
							result = JsonUtil.getObject(infos);
						} else if (type == 2) {
							// 查询发件箱信息
							initDataSendBoxInfo(uId, page);
							result = JsonUtil.getObject(infos);
						}
					} else {
						result = JsonUtil.getRetMsg(3, "页数参数数字格式化异常");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "信息分类参数格式化异常");
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

	private void initDataSendBoxInfo(int uId, int page) {
		// 查询发件箱信息
		infos.clear();
		infos = SystemInfoSer.findInfoBySendId(uId, page);
	}

	private void initReceiveBoxInfo(int uId, int page) {
		// 查询收件箱信息
		infos.clear();
		infos = SystemInfoSer.findInfoByReceiveId(uId, page);

	}

}

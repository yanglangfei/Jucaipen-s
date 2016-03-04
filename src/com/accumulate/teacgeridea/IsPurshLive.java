package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TxtLiveSale;
import com.accumulate.service.TxtLiveSaleServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         获取用户购买信息
 */
@SuppressWarnings("serial")
public class IsPurshLive extends HttpServlet {
	private String result;
	private TxtLiveSale sale;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String liveId = request.getParameter("liveId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(liveId)) {
					int lId = Integer.parseInt(liveId);
					initPurshInfo(uId, lId);
					if (sale == null) {
						result = JsonUtil.getRetMsg(4, "用户还没购买该直播");
					} else {
						result = JsonUtil.getRetMsg(0, "用户已经购买该直播");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "直播id数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "用户没登录");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initPurshInfo(int uId, int lId) {
		// 初始化购买信息
		sale = TxtLiveSaleServer.findTxtLiveSaleByUiDAndLiveId(uId, lId);

	}

}

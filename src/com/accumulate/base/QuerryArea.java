package com.accumulate.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Area;
import com.accumulate.service.AreaServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取区信息
 * 
 */
@SuppressWarnings("serial")
public class QuerryArea extends HttpServlet {
	private String result;
	private List<Area> areas = new ArrayList<Area>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String cityId = request.getParameter("cityId");
		if (StringUtil.isInteger(cityId)) {
			int cId = Integer.parseInt(cityId);
			initAreaData(cId);
			result = JsonUtil.getObject(areas);
		} else {
			result = JsonUtil.getRetMsg(1, "城市id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAreaData(int cId) {
		// 初始化区信息
		areas = AreaServer.getAreas(0, cId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

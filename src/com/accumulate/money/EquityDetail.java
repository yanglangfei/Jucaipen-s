package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Equity;
import com.accumulate.service.EquityServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         
 *         股权详细信息
 * 
 */
@SuppressWarnings("serial")
public class EquityDetail extends HttpServlet {
	private String result;
	private Equity equity;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String equityId = request.getParameter("equityId");
		if (StringUtil.isInteger(equityId)) {
			int id = Integer.parseInt(equityId);
			initData(id);
			result = JsonUtil.getObject(equity);
		} else {
			result = JsonUtil.getRetMsg(1, "股权id参数格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int id) {
		equity = EquityServer.findEquity(id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

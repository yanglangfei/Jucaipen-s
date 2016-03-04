package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.OrderUtils;
/**
 * @author Administrator
 * 
 * 
 *         获取订单号
 */
@SuppressWarnings("serial")
public class GetOrderCode extends HttpServlet {
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String code = OrderUtils.getOrderCode(3);
		if (code != null && !code.equals("")) {
			result = JsonUtil.getRetMsg(0, code);
		} else {
			result = JsonUtil.getRetMsg(1, "订单号生成失败");
		}
		out.print(result);
		out.flush();
		out.close();
	}

}

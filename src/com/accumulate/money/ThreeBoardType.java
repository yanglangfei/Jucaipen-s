package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsSmallClass;
import com.accumulate.service.NewServer;
import com.accumulate.service.NewSmallSer;
import com.accumulate.utils.JsonUtil;

/**
 * @author Administrator
 *
 *
 *   获取新三板分类信息   bigId  10
 */
@SuppressWarnings("serial")
public class ThreeBoardType extends HttpServlet {

	private List<NewsSmallClass> smallClass;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initTypeInfo();
		result = JsonUtil.getNewsType(smallClass);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initTypeInfo() {
		smallClass = NewSmallSer.findNewSmallByByBigId(10);
		
	}

	

}

package com.accumulate.finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsSmallClass;
import com.accumulate.service.NewSmallSer;
import com.accumulate.utils.JsonUtil;

/**
 * @author YLF
 * 
 *         获取财经种类 -----bigId=6
 * 
 */
@SuppressWarnings("serial")
public class FinalSort extends HttpServlet {
	private String result;
	private List<NewsSmallClass> fts;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initData();
		result = JsonUtil.getNewsType(fts);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData() {
		fts = NewSmallSer.findNewSmallByByBigId(6);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

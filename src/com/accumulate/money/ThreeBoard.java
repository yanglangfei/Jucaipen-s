package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.News;
import com.accumulate.service.NewServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         新三板列表信息 bigId=10
 * 
 */
@SuppressWarnings("serial")
public class ThreeBoard extends HttpServlet {
	private String result;
	private List<News> news;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pager = request.getParameter("pager");
		if (StringUtil.isInteger(pager)) {
			int page = Integer.parseInt(pager);
			initData(page);
			result = JsonUtil.getNewsList(news);
		} else {
			result = JsonUtil.getRetMsg(1, "页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int page) {
		// 获取新三板信息
		news = NewServer.queryNewsByBigId(10, page);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

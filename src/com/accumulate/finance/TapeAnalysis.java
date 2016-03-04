package com.accumulate.finance;

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
 * @author ylf
 * 
 * 
 *         根据分类id 获取分类数据
 *         
 *          big    6     small  19    名师专栏
 *                 6            6     大盘分析
 *                 6            7     板块分析
 *                 6            8     新股中心
 *                 6            9     投资教育
 *                 6           10     财经新闻
 *                 6           11     收盘点评
 *                 6           20     今日头条
 * 
 */
@SuppressWarnings("serial")
public class TapeAnalysis extends HttpServlet {
	private List<News> news;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String bigId = request.getParameter("bigId");
		String smallId = request.getParameter("smallId");
		String pager = request.getParameter("pager");
		if (StringUtil.isInteger(bigId)) {
			int bId = Integer.parseInt(bigId);
			if (StringUtil.isInteger(smallId)) {
				int sId = Integer.parseInt(smallId);
				if (StringUtil.isInteger(pager)) {
					int page = Integer.parseInt(pager);
					initData(bId, sId, page);
					result = JsonUtil.getNewsList(news);
				} else {
					result = JsonUtil.getRetMsg(3, "页数参数数字格式化异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "二级分类参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "一级分类参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int bId, int sId, int page) {
		// 获取财经信息
		news = NewServer.queryNewsById(bId, sId, page);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

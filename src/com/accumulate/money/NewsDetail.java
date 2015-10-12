package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.News;
import com.accumulate.entity.ResourceSources;
import com.accumulate.service.NewServer;
import com.accumulate.service.ResourceFromServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         新闻详细信息
 * 
 */
@SuppressWarnings("serial")
public class NewsDetail extends HttpServlet {
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private String result;
	private News news;
	private ResourceSources source;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String NewsId = request.getParameter("id");
		if (StringUtil.isInteger(NewsId)) {
			int id = Integer.parseInt(NewsId);
			initData(id);
			if(news!=null){
				result = JsonUtil.getObject(news);
			}else {
				result=JsonUtil.getRetMsg(5,"该资讯不存在");
			}
			//int hitCount=news.getHits();
			//addHits(hitCount+1,id);
			//点击数增加
		} else {
			result = JsonUtil.getRetMsg(1, "新闻id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void addHits(int hits,int id) {
		//增加点击数
		NewServer.upDateHits(hits, id);
		
	}

	private void initData(int id) {
		news = NewServer.findNewsById(id);
		if(news!=null){
			int fromId=news.getComeFrom();
			source = ResourceFromServer.getRSources(fromId);
			if(source!=null){
				news.setFrom(source.getFromName());
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

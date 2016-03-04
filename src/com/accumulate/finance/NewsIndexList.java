package com.accumulate.finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.News;
import com.accumulate.entity.NewsSmallClass;
import com.accumulate.service.NewServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *    根据分类id获取首页关注信息
 */
@SuppressWarnings("serial")
public class NewsIndexList extends HttpServlet {
	private String result;
	private List<News> news;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String bigId=request.getParameter("bigId");
	    String smallId=request.getParameter("smallId");
	    if(StringUtil.isInteger(bigId)){
	    	int bId=Integer.parseInt(bigId);
	    	if(StringUtil.isInteger(smallId)){
	    		int sId=Integer.parseInt(smallId);
	    		initIndexNews(bId,sId);
	    		result=JsonUtil.getNewsList(news);
	    	}else {
	    		result=JsonUtil.getRetMsg(1,"smallId分类参数数字格式化异常");
			}
	    	
	    }else {
    		result=JsonUtil.getRetMsg(1,"bigId分类参数数字格式化异常");

		}
		out.print(result);
		out.flush();
		out.close();
	}


	private void initIndexNews(int bId, int sId) {
		news=NewServer.findIndexNewsById(bId, sId, 2);
		
	}


}

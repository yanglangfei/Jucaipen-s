package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.News;
import com.accumulate.entity.NewsComment;
import com.accumulate.service.NewServer;
import com.accumulate.service.NewsCommSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         查询评论列表
 */
@SuppressWarnings("serial")    
public class MyRemark extends HttpServlet {
	private String result;
	private List<NewsComment> comments = new ArrayList<NewsComment>();
	private List<News> news=new ArrayList<News>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pager = request.getParameter("pager");
		String userId = request.getParameter("userId");
		if (StringUtil.isInteger(pager)) {
			int page = Integer.parseInt(pager);
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if(uId>0){
					initData(uId, page);
					result = JsonUtil.getCommentList(comments,news);
				}else {
					result=JsonUtil.getRetMsg(5,"当前用户还没登录");
				}
				
			} else {
				result = JsonUtil.getRetMsg(1, "用户id数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int uId, int page) {
		// 获取评论数据
		comments.clear();
		news.clear();
		comments = NewsCommSer.findNewsCommByUser(uId,0, page);
		for(NewsComment nc: comments){
			int nId=nc.getnId();
			News n=NewServer.findNewsById(nId);
			if(n!=null){
				news.add(n);
			}
		}
	}

}

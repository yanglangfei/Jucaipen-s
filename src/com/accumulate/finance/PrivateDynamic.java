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
 * @author Administrator
 *
 *
 *   私募动态
 *        whichPage   0  首页
 *                    1  全部     page
 *                      
 */
@SuppressWarnings("serial")
public class PrivateDynamic extends HttpServlet {

    private String result;
	private List<News> news;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String whichPage=request.getParameter("whichPage");
		if(StringUtil.isInteger(whichPage)){
			int which=Integer.parseInt(whichPage);            
			if(which==0){
				//获取首页私募动态
				initIndexPrivateDate();
				result=JsonUtil.getIndexNewsList(news);
			}else if(which==1){
				//获取全部私募动态
				String pager=request.getParameter("pager");
				if(StringUtil.isInteger(pager)){
					int page=Integer.parseInt(pager);
					initAllPrivateDate(page);
					result=JsonUtil.getNewsList(news);
				}else {
					result=JsonUtil.getRetMsg(3,"页数参数数字格式化异常");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"分类参数不符合要求");
			}
			
		}else {
			result=JsonUtil.getRetMsg(1,"分类参数数字格式化异常");
		}
	    out.print(result);
		out.flush();
		out.close();
	}

	private void initAllPrivateDate(int page) {
		//获取全部私募动态信息
		news=NewServer.queryNewsById(2, 12, page);
	}

	private void initIndexPrivateDate() {
		// 初始化首页私募动态
		news=NewServer.findIndexNewsById(2, 12,4);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}

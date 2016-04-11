package com.accumulate.money;

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
import com.accumulate.service.NewSmallSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�������
 * 
 */
@SuppressWarnings("serial")
public class RelateArticle extends HttpServlet {
	private String result;
	private List<News> news;
	private List<String> names=new ArrayList<String>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String newsId = request.getParameter("id");
		if (StringUtil.isInteger(newsId)) {
			int id = Integer.parseInt(newsId);
			initReleData(id);
			if(news!=null){
				result=JsonUtil.getIndxKnownList(news,names);
			}else {
				result=JsonUtil.getRetMsg(0, "�����쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "����id�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initReleData(int nId) {
		// ��ʼ������
	    news=NewServer.findLastNews(6);
	    if(news!=null){
	    	for(News n : news){
	    		int smallId=n.getSmallId();
	    		int bigId=n.getBigId();
	    		NewsSmallClass nsc=NewSmallSer.findSmallClassBySidAndBigId(smallId, bigId);
	    	    if(nsc!=null){
	    	    	names.add(nsc.getSamllName());
	    	    }else{
	    	    	names.add(null);
	    	    }
	    	}
	    }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

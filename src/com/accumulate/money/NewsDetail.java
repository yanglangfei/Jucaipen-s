package com.accumulate.money;
import java.io.IOException;
import java.io.PrintWriter;
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
 *         ������ϸ��Ϣ
 * 
 */
@SuppressWarnings("serial")
public class NewsDetail extends HttpServlet {
//	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
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
				result=JsonUtil.getRetMsg(5,"����Ѷ������");
			}
			//int hitCount=news.getHits();
			//addHits(hitCount+1,id);
			//���������
		} else {
			result = JsonUtil.getRetMsg(1, "����id�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

/*	private void addHits(int hits,int id) {
		//���ӵ����
		NewServer.upDateHits(hits, id);
		
	}*/

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

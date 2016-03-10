package com.accumulate.finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.News;
import com.accumulate.entity.NewsSmallClass;
import com.accumulate.service.NewServer;
import com.accumulate.service.NewSmallSer;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author Administrator
 *
 *
 *   获取财经信息
 */
@SuppressWarnings("serial")
public class ThreeBoardIndex extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		result=initThreeBoardInfo();
		out.print(result);
		out.flush();
		out.close();
	}

	private String initThreeBoardInfo() {
		JsonArray array=new JsonArray();
		 List<NewsSmallClass> type = NewSmallSer.findNewSmallByByBigId(10);
		 for(int i=0;i<type.size();i++){
			 JsonObject obj1=new JsonObject();
			NewsSmallClass tp=type.get(i);
			String name = tp.getSamllName();
			int sId=tp.getId();
			int bId=tp.getBigId();
			obj1.addProperty("smallId", sId);
			obj1.addProperty("bigId", bId);
			obj1.addProperty("name",name);
			JsonArray arr1=new JsonArray();
			List<News> items=NewServer.findIndexNewsById(bId, sId, 2);
	        for(int j=0;j<items.size();j++){
	        	JsonObject obj2=new JsonObject();
	        	News n = items.get(j);
	        	int id=n.getId();
	        	String desc=n.getDescript();
	        	String title = n.getTitle();
	        	obj2.addProperty("title", title);
	        	obj2.addProperty("id", id);
	        	obj2.addProperty("desc", desc);
	        	arr1.add(obj2);
	        }
	        obj1.add("item", arr1);
	        array.add(obj1);
	}
		 return array.toString();

}
}

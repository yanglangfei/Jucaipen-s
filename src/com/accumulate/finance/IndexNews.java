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
 *         ��ҳ������Ϣ type ----1 �ƾ���Ϣ��bigId=6�� ----2 ������ ��Ϣ (bigId=10)
 * 
 */
@SuppressWarnings("serial")
public class IndexNews extends HttpServlet {
	private List<News> news;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("type");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (type == 1) {
				initFinalNewsData(type);
			} else if (type == 2) {
				initThreeBoardData(type);
			}
			result = JsonUtil.getIndexNewsList(news);
		} else {
			result = JsonUtil.getRetMsg(1, "�������Ͳ������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initThreeBoardData(int type) {
		// ��ȡ��������Ϣ
		news = NewServer.queryNewsByIndexIsImage(10);

	}

	private void initFinalNewsData(int type) {
		// ��ȡ�ƾ���Ϣ
		news = NewServer.queryNewsByIndexShow(6);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

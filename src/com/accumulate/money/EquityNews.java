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
 *         ��ȨҪ�� ------bigId=2 smallId=1 type ----1 ��ҳ ��Ĭ������ �� 2������ȫ����
 * 
 */
@SuppressWarnings("serial")
public class EquityNews extends HttpServlet {
	private List<News> news;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if (StringUtil.isInteger(type)) {
			int tp = Integer.parseInt(type);
			if (tp == 1) {
				news = NewServer.findIndexNewsById(2, 1,3);
				result = JsonUtil.getIndxEquityNewsList(news);
			} else if (tp == 2) {
				String pager = request.getParameter("pager");
				if (StringUtil.isInteger(pager)) {
					news = NewServer.queryNewsById(2, 1,
							Integer.parseInt(pager));
					if (news != null && news.size() > 0) {
						result = JsonUtil.getObject(news);
					} else {
						result = JsonUtil.getRetMsg(2, "���޹�ȨҪ����Ϣ");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "ҳ��������ʽ���쳣");
				}

			}

		} else {
			result = JsonUtil.getRetMsg(3, "���Ͳ������ָ�ʽ���쳣");

		}

		out.print(result);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

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
 *         ���ݷ���id ��ȡ��������
 *         
 *          big    6     small  19    ��ʦר��
 *                 6            6     ���̷���
 *                 6            7     ������
 *                 6            8     �¹�����
 *                 6            9     Ͷ�ʽ���
 *                 6           10     �ƾ�����
 *                 6           11     ���̵���
 *                 6           20     ����ͷ��
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
					result = JsonUtil.getRetMsg(3, "ҳ���������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "��������������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "һ������������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData(int bId, int sId, int page) {
		// ��ȡ�ƾ���Ϣ
		news = NewServer.queryNewsById(bId, sId, page);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

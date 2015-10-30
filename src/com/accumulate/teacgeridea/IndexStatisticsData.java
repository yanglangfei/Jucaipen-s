package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.utils.JsonUtil;

/**
 * @author Administrator
 * 
 * 
 *         首页统计数据 （人气 回答 观点 粉丝）
 */
@SuppressWarnings("serial")
public class IndexStatisticsData extends HttpServlet {
	private String result;
	private List<FamousTeacher> teachers;
	private int renQi;
	private int answerCount;
	private int ideas;
	private int fans;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initIndexDate();
		result = JsonUtil.getIndexStatisticsData(renQi, answerCount, ideas,
				fans);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIndexDate() {
		renQi=0;
		fans=0;
		answerCount=0;
		ideas=0;
		teachers = FamousTeacherSer.findIndexData();
		if (teachers.size() > 0) {
			for (FamousTeacher teacher : teachers) {
				renQi += teacher.getLiveFans();
				fans += teacher.getFans();
				answerCount += teacher.getAnswerCount();
				ideas += teacher.getArticleCount();
			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

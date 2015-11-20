package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TextLive;
import com.accumulate.entity.TxtLiveDetails;
import com.accumulate.service.TxtLiveDetaileSer;
import com.accumulate.service.TxtLiveSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;
import com.accumulate.utils.TimeUtils;

/**
 * @author Administrator querryType 0
 *                     根据关联id 获取 1 根据讲师id获取
 * 
 *         今日观点 根据关联ID查询
 */
@SuppressWarnings("serial")
public class TodayIdeas extends HttpServlet {

	private List<TxtLiveDetails> todayIdeas;
	private String result;
	private List<TextLive> txtLives;
	private ArrayList<List<TxtLiveDetails>> txtArray = new ArrayList<List<TxtLiveDetails>>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String querryType = request.getParameter("querryType");
		if (StringUtil.isInteger(querryType)) {
			int type = Integer.parseInt(querryType);
			if (type == 0) {
				// 根据直播id获取
				String liveId = request.getParameter("liveId");
				if (StringUtil.isInteger(liveId)) {
					int id = Integer.parseInt(liveId);
					initTodayIdeasDataByLiveId(id);
					result = JsonUtil.getTodayIdeasByLiveId(todayIdeas);
				} else {
					result = JsonUtil.getRetMsg(1, "直播ID参数数字格式化异常");
				}
			} else if (type == 1) {
				// 根据讲师id获取
				String teacherId = request.getParameter("teacherId");
				if (StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					initTodayIdeaByTeacherId(tId);
					result = JsonUtil.getTodayIdeasList(txtArray);
				} else {
					result = JsonUtil.getRetMsg(4, "讲师id数字格式化异常");
				}

			} else {
				result = JsonUtil.getRetMsg(2, "分类参数不符合要求");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "分类参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initTodayIdeaByTeacherId(int teacherId) {
		txtArray.clear();
		// 根据讲师id初始化今日观点信息
		txtLives = TxtLiveSer.findTextLiveByTeacherId(teacherId);
		if (txtLives.size() > 0) {
			for (TextLive textLive : txtLives) {
				int liveId = textLive.getId();
				String startDate = textLive.getStartDate();
				boolean isToday = TimeUtils.compareDate(startDate);
				if (isToday) {
					todayIdeas = TxtLiveDetaileSer
							.findTextDetaileByLiveId(liveId);
					txtArray.add(todayIdeas);
				}

			}
		}

	}

	private void initTodayIdeasDataByLiveId(int liveId) {
		// 通过直播id初始化今日观点数据
		todayIdeas = TxtLiveDetaileSer.findTextDetaileByLiveId(liveId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

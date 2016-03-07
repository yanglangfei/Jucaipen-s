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

/**
 * @author Administrator querryType 0
 *                     ���ݹ���id ��ȡ 1 ���ݽ�ʦid��ȡ
 * 
 *         ���չ۵� ���ݹ���ID��ѯ
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
				// ����ֱ��id��ȡ
				String liveId = request.getParameter("liveId");
				if (StringUtil.isInteger(liveId)) {
					int id = Integer.parseInt(liveId);
					initTodayIdeasDataByLiveId(id);
					result = JsonUtil.getTodayIdeasByLiveId(todayIdeas);
				} else {
					result = JsonUtil.getRetMsg(1, "ֱ��ID�������ָ�ʽ���쳣");
				}
			} else if (type == 1) {
				// ���ݽ�ʦid��ȡ
				String teacherId = request.getParameter("teacherId");
				if (StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					initTodayIdeaByTeacherId(tId);
					result = JsonUtil.getTodayIdeasList(txtArray);
				} else {
					result = JsonUtil.getRetMsg(4, "��ʦid���ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(2, "�������������Ҫ��");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "����������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initTodayIdeaByTeacherId(int teacherId) {
		txtArray.clear();
		// ���ݽ�ʦid��ʼ�����չ۵���Ϣ
		txtLives = TxtLiveSer.findTextLiveByTeacherId(teacherId);
		if (txtLives.size() > 0) {
			for (TextLive textLive : txtLives) {
				int liveId = textLive.getId();
				int isEnd=textLive.getIsEnd();
				//String startDate = textLive.getStartDate();
				//boolean isToday = TimeUtils.compareDate(startDate);
				if (isEnd==0) {
					todayIdeas = TxtLiveDetaileSer
							.findTextDetaileByLiveId(liveId);
					txtArray.add(todayIdeas);
				}

			}
		}

	}

	private void initTodayIdeasDataByLiveId(int liveId) {
		// ͨ��ֱ��id��ʼ�����չ۵�����
		todayIdeas = TxtLiveDetaileSer.findTextDetaileByLiveId(liveId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

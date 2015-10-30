package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.HotIdea;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.HotIdeaServ;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ���Ź۵��б� whichPage 0 ��ҳ ֻ��ȡ����������� 1 ��ȡȫ������  ��Ͷ�ʹ۵㣩
 * 
 */
@SuppressWarnings("serial")
public class HotIdeasList extends HttpServlet {
	private List<HotIdea> hotIdeas;
	private String result;
	private List<FamousTeacher> teachers=new ArrayList<FamousTeacher>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String which = request.getParameter("whichPage");
		if (StringUtil.isInteger(which)) {
			int whichPage = Integer.parseInt(which);
			if (whichPage == 0) {
				//��ҳ����
				initIndexHotIdeaData();
				result = JsonUtil.getIndexHotIdeaList(hotIdeas);
			} else if (whichPage == 1) {
				//ȫ������
				String page = request.getParameter("page");
				if (StringUtil.isInteger(page)) {
					//ҳ����������
					int p = Integer.parseInt(page);
					initAllHotIdeasData(p);
					result = JsonUtil.getAllHotIdeaList(hotIdeas,teachers);
				} else {
					//ҳ�������쳣
					result = JsonUtil.getRetMsg(2, "��ҳ�������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(3, "whichPage����������Ҫ��");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "whichPage�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAllHotIdeasData(int p) {
		// ��ҳ��ѯ��������
		hotIdeas = HotIdeaServ.findAllHotIdea(p);
		if(hotIdeas.size()>0){
			for(HotIdea idea :hotIdeas){
				int teacherId=idea.getTeacherId();
				FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
				teachers.add(teacher);
			}
		}

	}

	private void initIndexHotIdeaData() {
		// ��ȡ��ҳ����
		hotIdeas = HotIdeaServ.findIdeaByCount(3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}



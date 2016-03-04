package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Ask;
import com.accumulate.entity.User;
import com.accumulate.service.AskSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �������� isAll 0 ��ȡȫ������ 1 ���ݽ�ʦid��ȡ����
 * 
 */
@SuppressWarnings("serial")
public class AskForTeacher extends HttpServlet {
	private String result;
	private List<Ask> askList;
	private List<User> users = new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String isAll = request.getParameter("isAll");
		String pager = request.getParameter("page");
		if (StringUtil.isInteger(pager)) {
			// page��������
			int page = Integer.parseInt(pager);
			if (StringUtil.isInteger(isAll)) {
				int all = Integer.parseInt(isAll);
				if (all == 0) {
					// ��ȡȫ������
					initAllAskList(page);
					result = JsonUtil.getAskList(askList, users);
				} else if (all == 1) {
					// ���ݽ�ʦid��ȡ
					String teacherId = request.getParameter("teacherId");
					if (StringUtil.isInteger(teacherId)) {
						// page��������
						int tId = Integer.parseInt(teacherId);
						initAskListForTeacher(tId, page);
						result = JsonUtil.getAskList(askList, users);
					} else {
						// page�����쳣
						result = JsonUtil.getRetMsg(3, "��ʦid�������ָ�ʽ���쳣");
					}
				} else {
					// �����쳣
					result = JsonUtil.getRetMsg(2, "isALL����������Ҫ��");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "isAll�������ָ�ʽ���쳣");
			}
		} else {
			// page�����쳣
			result = JsonUtil.getRetMsg(3, "ҳ���������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAskListForTeacher(int tId, int page) {
		// ͨ����ʦid��ʼ��������Ϣ
		users.clear();
		askList = AskSer.findAskByTeacherId(tId, page);
		if (askList.size() > 0) {
			for (Ask ask : askList) {
				int uId = ask.getUserId();
				User user = UserServer.findUserNikNameById(uId);
				if(user!=null){
				users.add(user);
				}else{
					user=new User();
					user.setUserName("null");
					user.setFaceImage("");
					users.add(user);
				}
			}
		}

	}

	private void initAllAskList(int page) {
		// ��ʼ��ȫ��������Ϣ
		users.clear();
		askList = AskSer.findAllAsk(page);
		if (askList.size() > 0) {
			for (Ask ask : askList) {
				int uId = ask.getUserId();
				User user = UserServer.findUserNikNameById(uId);
				if (user != null) {
					users.add(user);
				}else{
					user=new User();
					user.setUserName("null");
					user.setFaceImage("");
					users.add(user);
				}
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.HotIdea;
import com.accumulate.service.HotIdeaServ;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ���Ź۵����
 * 
 */
@SuppressWarnings("serial")
public class HotIdeaGoods extends HttpServlet {
	private String result;
	private int isSuccess;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String ideaId = request.getParameter("ideaId");
		if (StringUtil.isInteger(userId)) {
			//int uId = Integer.parseInt(userId);
			if (StringUtil.isInteger(ideaId)) {
				int iId = Integer.parseInt(ideaId);
				isSuccess = insertGoogs(iId);
				if(isSuccess==1){
					result=JsonUtil.getRetMsg(0, "���޳ɹ�");
				}else {
					result=JsonUtil.getRetMsg(3,"����ʧ��");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "�۵�id�������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private int insertGoogs(int iId) {
		// ��ӵ���
		HotIdea idea = HotIdeaServ.findGoodAndHitAndComm(iId);
		int goods = idea.getGoods();
		return HotIdeaServ.addGood(iId, goods + 1);

	}

}

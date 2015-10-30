package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Ask;
import com.accumulate.service.AskSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         ��ѯ��ʦ
 */
@SuppressWarnings("serial")
public class AskQuestion extends HttpServlet {
	private int isSuccess;
	private String result;
	private String ip;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		String askType = request.getParameter("questionType");
		String userId = request.getParameter("userId");
		String askBodys = request.getParameter("askBodys");
		String teacherId = request.getParameter("teacherId");
		ip = request.getRemoteAddr();
		if (StringUtil.isInteger(userId)) {
			// �û�id��ʽ��ȷ
			int uId = Integer.parseInt(userId);
			if (StringUtil.isInteger(teacherId)) {
				// ��ʦid���ָ�ʽ����ȷ
				int tId = Integer.parseInt(teacherId);
				if (StringUtil.isInteger(askType)) {
					// �����������ָ�ʽ����ȷ
					if(StringUtil.isNotNull(askBodys)){
					int type = Integer.parseInt(askType);
					createAskModel(uId, tId, type, askBodys);
					if (isSuccess == 1) {
						result = JsonUtil.getRetMsg(0, "��ѯ��Ϣ�ύ�ɹ�");
					} else {
						result = JsonUtil.getRetMsg(1, "��ѯ��Ϣ�ύʧ��");
					}
					}else {
						result=JsonUtil.getRetMsg(5,"��ѯ���ݲ���Ϊ��");
					}
				} else {
					// �����������ָ�ʽ���쳣
					result = JsonUtil.getRetMsg(2, "��ѯ����������ָ�ʽ���쳣");
				}
			} else {
				// ��ʦid���ָ�ʽ���쳣
				result = JsonUtil.getRetMsg(3, "��ʦid���ָ�ʽ���쳣");
			}
		} else {
			// �û�id���ָ�ʽ���쳣
			result = JsonUtil.getRetMsg(4, "�û�id���ָ�ʽ���쳣");
		}

		out.print(result);
		out.flush();
		out.close();
	}

	private void createAskModel(int uId, int tId, int type, String askBodys) {
		Ask ask = new Ask();
		ask.setUserId(uId);
		ask.setTeacherId(tId);
		ask.setClassId(type);
		ask.setAskBody(askBodys);
		ask.setAskDate(sdf.format(new Date()));
		ask.setHits(0);
		ask.setIp(ip);
		ask.setIsReply(2);
		ask.setParentId(0);
		ask.setAskState(2);
		isSuccess = AskSer.insertAsk(ask);

	}

}
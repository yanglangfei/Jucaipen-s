package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.LogCommen;
import com.accumulate.service.LogCommSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         commType 0 ���� 1 �ظ�
 * 
 *         ��� ���Ź۵�����
 */
@SuppressWarnings("serial")
public class AddIdeaComm extends HttpServlet {
	private String result;
	private int isSuccess;
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
		String commType = request.getParameter("commType");
		String userId = request.getParameter("userId");
		String ideaId = request.getParameter("ideaId");
		String commBody = request.getParameter("commBodys");
		if (StringUtil.isInteger(userId)) {
			// �û�id����
			int uId = Integer.parseInt(userId);
			if(uId>0){
				if (StringUtil.isInteger(ideaId)) {
					// �۵�id����
					int iId = Integer.parseInt(ideaId);
					if (StringUtil.isInteger(commType)) {
						int type = Integer.parseInt(commType);
						if (StringUtil.isNotNull(commBody)) {
							if (type == 0) {
								// ��������
								insertIdeaComm(0, uId, iId, commBody);
							} else {
								// �ظ�����
								String commId = request.getParameter("commId");
								if (StringUtil.isInteger(commId)) {
									int cId = Integer.parseInt(commId);
									insertIdeaComm(cId, uId, iId, commBody);
								} else {
									result = JsonUtil.getRetMsg(6, "�ظ�������id���ֻ��쳣");
									out.print(result);
									return;
								}
							}
							if (isSuccess == 1) {
								// ������۳ɹ�
								result = JsonUtil.getRetMsg(0, "������۳ɹ�");
							} else {
								// �������ʧ��
								result = JsonUtil.getRetMsg(3, "�������ʧ��");
							}

						} else {
							result = JsonUtil.getRetMsg(4, "�������ݲ���Ϊ��");
						}

					} else {
						result = JsonUtil.getRetMsg(5, "����id���ֻ��쳣");
					}

				} else {
					result = JsonUtil.getRetMsg(1, "���Ź۵�id���ָ�ʽ���쳣");
				}
				
			}else {
				result=JsonUtil.getRetMsg(7, "����û��¼");
			}
			
		} else {
			result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void insertIdeaComm(int commId, int uId, int iId, String commBody) {
		// �������
		LogCommen commen = new LogCommen(0, uId, commId, iId, commBody,
				sdf.format(new Date()), 0, 0, 0);
		isSuccess = LogCommSer.insertLogComm(commen);

	}

}

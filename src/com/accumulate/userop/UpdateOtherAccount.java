package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;
import com.google.gson.JsonNull;

/**
 * @author YLF
 * 
 * 
 *         �󶨵������˺� ---------------��� userId ���˺ŵ��û�id accountType ���˺����� ----0
 *         QQ -----1 ΢�� -----2 ���� accountId ���˺ŵ�id
 * 
 */
@SuppressWarnings("serial")
public class UpdateOtherAccount extends HttpServlet {
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
		String accountType = request.getParameter("accountType");
		String accountId = request.getParameter("accountId").trim();
		if (StringUtil.isInteger(userId )) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(accountType)) {
					int type = Integer.parseInt(accountType);
					if (type == 0 || type == 1 || type == 2) {
						User u = checkAccountIsBind(type, accountId,uId);
						//�û�������    --��       
						if ((accountId!=null&&accountId.length()>0)&&u == null) {
							insertOtherAccount(uId, type, accountId);
							//���˺�
							if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "�˺ű���ɹ�");
							} else {
								result = JsonUtil.getRetMsg(1, "�˺ű���ʧ��");
							}
						}else if((accountId==null||accountId.length()<=0)&&u!= null){
							insertOtherAccount(uId, type, accountId);
							//����˺�
							if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "�˺Ž���ɹ�");
							} else {
								result = JsonUtil.getRetMsg(1, "�˺Ž��ʧ��");
							}
						}else if((accountId!=null&&accountId.length()>0)&&u!= null){
							//�˺��Ѿ���
							if(u.getId()==uId){
							result = JsonUtil.getRetMsg(7, "���˺��Ѱ�");
							}else{
								result=JsonUtil.getRetMsg(10,"���˺��ѱ������û���");
							}
						}else if((accountId==null||accountId.length()<=0)&&u== null){
							//�˺��Ѿ����
							result = JsonUtil.getRetMsg(8, "���˺��ѽ��");
						}else {
							result = JsonUtil.getRetMsg(9, "����ʧ��");
						}
					} else {
						result = JsonUtil.getRetMsg(6, "�˺����Ͳ�������Ϊ0��1��2");
					}

				} else {
					result = JsonUtil.getRetMsg(3, "�˺����Ͳ������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(5, "��ǰ�û���û��¼");
			}

		} else {
			result = JsonUtil.getRetMsg(4, "�û�id�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param type
	 * @param accountId
	 * 
	 *            ��֤�˺��Ƿ��
	 */
	private User checkAccountIsBind(int type, String accountId,int uId) {
		User user=null;
		if (type == 0) {
			// qq
			user = UserServer.findUserByQQId(accountId);
		} else if (type == 1) {
			// ΢��
			user = UserServer.findUserByWeixinId(accountId);
		} else if (type == 2) {
			// ����
			user = UserServer.findUserBySinaId(accountId);
		}
		return user;

	}

	private void insertOtherAccount(int uId, int type, String accountId) {
		// �޸ĵ������˺�id
		isSuccess = UserServer.updateAccountId(uId, type, accountId);

	}

}

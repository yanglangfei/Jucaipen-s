package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.service.UserServer;
import com.accumulate.utils.GePushUtils;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.MD5Util;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �޸�����
 * 
 */
@SuppressWarnings("serial")
public class UpdatePwd extends HttpServlet {
	private int isSuccess;
	private String result;
	private String md5NewPwd;
	private String md5OldPwd;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String repPwd = request.getParameter("repPwd");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if(uId>0){
				if (StringUtil.isPassword(oldPwd) && StringUtil.isPassword(newPwd)
						&& StringUtil.isPassword(repPwd)) {
						// ��ѯ���жϾ������Ƿ���ȷ
						String pwd = initOldPwd(uId);
						md5OldPwd=MD5Util.MD5(oldPwd);
						if (pwd!=null&&pwd.equals(md5OldPwd)) {
							// �ж���������ȷ�������Ƿ�һ��
							if (newPwd.equals(repPwd)) {
								// �޸��������
							    md5NewPwd=MD5Util.MD5(newPwd);
								isSuccess = updatePwd(uId,md5NewPwd);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "�����޸ĳɹ�");
								} else {
									result = JsonUtil.getRetMsg(6, "�����޸�ʧ��");
								}
							} else {
								result = JsonUtil.getRetMsg(4, "�������벻һ��");
							}
						} else {
							result = JsonUtil.getRetMsg(5, "������������");
						}
				} else {
					result = JsonUtil.getRetMsg(3, "���������6-23λ��ĸ�����֡��ַ�");
				}
				
			}else {
				result=JsonUtil.getRetMsg(2,"��ǰ�û���û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "�����û�id��ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private int updatePwd(int uId,String md5Pwd) {
		// �޸�����
		isSuccess = UserServer.updatePassword(uId, md5Pwd);
		return isSuccess;
	}

	private String initOldPwd(int uId) {
		// ��ѯ�û�����
		return UserServer.findPasswordById(uId);
	}

}

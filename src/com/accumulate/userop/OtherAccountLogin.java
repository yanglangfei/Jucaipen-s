package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.LoginLog;
import com.accumulate.entity.User;
import com.accumulate.service.LogServer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         �������˺ŵ�¼ accountType ---�������˺����� accountId ---�������˺�id
 * 
 */
@SuppressWarnings("serial")
public class OtherAccountLogin extends HttpServlet {
	private User user;
	private String result;
	private String uuid;
	private int uId;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String clientAddress;

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
		String accountType = request.getParameter("accountType");
		String accountId = request.getParameter("accountId");
		clientAddress = request.getRemoteAddr();
		if (StringUtil.isInteger(accountType)) {
			int type = Integer.parseInt(accountType);
			if (StringUtil.isNotNull(accountId)) {
				loginUser(type, accountId);
				if (user != null) {  
					result = JsonUtil.getLoginResult(user);
					uuid = UUID.randomUUID().toString();
					uId = user.getId();
					upDateLoginState(user.getId(), uuid);
					handleLoginResult(1, user);
				} else {
					// δ�󶨵ĵ�������¼
					result = JsonUtil.getRetMsg(3, "���˻�δ��");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "�˺�id����Ϊ��");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "�˺����Ͳ������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void handleLoginResult(int i, User user) {
		// �����¼���
		LoginLog log = new LoginLog();
		log.setLoginDate(sdf.format(new Date()));
		log.setUserId(uId);
		log.setUserName(user.getUserName());
		log.setPassword(user.getPassword());
		log.setRemark("��¼�ɹ�");
		log.setLoginIp(clientAddress);
		 LogServer.insertLog(log);

	}

	private void upDateLoginState(int id, String uuid) {
		 UserServer.updateLoginToken(uId, uuid);

	}

	private void loginUser(int type, String accountId) {
		// ���õ������˺ŵ�¼����
		user = UserServer.otherAccountLogin(type, accountId);

	}

}

package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.LoginUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         ��¼
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {
	private String result;
    private User user;
	private String userName;
	private Map<String, String> param = new HashMap<String, String>();
	private static final String LOGIN_PATH = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=Login";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// clientAddress = request.getRemoteAddr();
		if (!StringUtil.isNotNull(userName)) {
			result = JsonUtil.getRetMsg(1, "�û�������Ϊ��");     
		} else if (!StringUtil.isNotNull(password)) {
			result = JsonUtil.getRetMsg(2, "���벻��Ϊ��");
		} else {
			// md5Pwd = MD5Util.MD5(password);
			// user = UserServer.loginUser(userName);
			// if (user != null) {
			// �û�������
			// String pwd = user.getPassword();
			// if (pwd.equals(md5Pwd)) {
			// ������ȷ
			// int uId = user.getId();
			param.clear();
			param.put("username", userName);
			param.put("pwd", password);
			String jsonArray = LoginUtil.sendHttpPost(LOGIN_PATH, param);
			if (jsonArray != null) {
				JSONObject object = new JSONObject(jsonArray);
				boolean isLogin = object.getBoolean("IsLogin");
				String msg=object.getString("Msg");
				if (isLogin) {
					// ��¼�ɹ�
					int userId=object.getInt("ActionId");
					querrryUserInfo(userId);
					result=JsonUtil.getLoginResult(user);
				}else {
					result=JsonUtil.getRetMsg(4,msg);
				}
			}else {
				result=JsonUtil.getRetMsg(3, "ϵͳ��æ�����Ժ�����");
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}
	/*
	 * 
	 * �޸ĵ�¼״̬
	 * 
	 * private void upDateLoginState(int uId, String token) {
	 * UserServer.updateLoginToken(uId, token);
	 * 
	 * }
	 * 
	 * private void handleLoginResult(int res, String pwd, int uId) { // �����¼���
	 * LoginLog log = new LoginLog(); log.setLoginDate(sdf.format(new Date()));
	 * log.setLoginResult(res); log.setUserId(uId); log.setUserName(userName);
	 * log.setPassword(pwd); if (res == 0) { log.setRemark("��¼ʧ�ܣ��������"); } else
	 * { log.setRemark("��¼�ɹ�"); } log.setLoginIp(clientAddress);
	 * LogServer.insertLog(log);
	 * 
	 * }
	 */

	private void querrryUserInfo(int userId) {
		user=UserServer.findLoginInfoById(userId);
		
	}

}

package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.LiveInteractive;
import com.accumulate.service.LiveInteractiveSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         ��ӽ�����Ϣ
 */
@SuppressWarnings("serial")
public class AddExChange extends HttpServlet {
	private String result;
	private int isSuccess;     
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
		PrintWriter out = response.getWriter  ();
		ip = request.getRemoteAddr();
		String userId = request.getParameter("userId");
		String liveId = request.getParameter("liveId");
		String bodys = request.getParameter("bodys");
		System.out.println("bodys:"+bodys);
		if (StringUtil.isInteger(userId)) {
			// �û�id����
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(liveId)) {
					// ֱ��id����
					if (StringUtil.isNotNull(bodys)) {
						int lId = Integer.parseInt(liveId);
						insertLiveExchange(uId, lId, bodys, ip);
						if (isSuccess == 1) {
							result = JsonUtil.getRetMsg(0, "��ӽ�����Ϣ�ɹ�");
						} else {

							result = JsonUtil.getRetMsg(3, "��ӽ�����Ϣʧ��");
						}
					} else {

						result = JsonUtil.getRetMsg(4, "�������ݲ���Ϊ��");
					}

				} else {
					result = JsonUtil.getRetMsg(1, "ֱ��id�������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(5, "����û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void insertLiveExchange(int uId, int lId, String bodys, String ip) {
		// ��ӽ�����Ϣ
		LiveInteractive interactive = new LiveInteractive(0, lId, uId, 5,
				sdf.format(new Date()), bodys, 1, ip, 0);
		isSuccess = LiveInteractiveSer.insertLiveInteractive(interactive);
	}

}

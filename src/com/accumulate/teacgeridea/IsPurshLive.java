package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TxtLiveSale;
import com.accumulate.entity.User;
import com.accumulate.service.TxtLiveSaleServer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         ��ȡ�û�������Ϣ
 */
@SuppressWarnings("serial")
public class IsPurshLive extends HttpServlet {
	private String result;
	private TxtLiveSale sale;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String liveId = request.getParameter("liveId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(liveId)) {
					int lId = Integer.parseInt(liveId);
				    boolean isPush = initPurshInfo(uId, lId);
					if (!isPush) {
						result = JsonUtil.getRetMsg(4, "�û���û�����ֱ��");
					} else {
						result = JsonUtil.getRetMsg(0, "�û��Ѿ������ֱ��");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "ֱ��id���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û�û��¼");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private boolean initPurshInfo(int uId, int lId) {
		// ��ʼ��������Ϣ
		User user = UserServer.isManagerOrServer(uId);
		if(user!=null){
			int sId=user.getServerId();
			int mId=user.getIsRoomManager();
			if(sId<=0&&mId<=0){
				sale = TxtLiveSaleServer.findTxtLiveSaleByUiDAndLiveId(uId, lId);
				if(sale!=null){
					//����
					return true;
				}else{
					return false;
				}
			}else{
				//����Ա
				return true;
			}
		}
		return false;

	}

}

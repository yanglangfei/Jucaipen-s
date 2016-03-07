package com.accumulate.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.MessageObject;
import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.thread.ReceiverDateThread;
import com.accumulate.utils.HttpUtils;
import com.accumulate.utils.JsonUtil;

/**
 * @author YLF
 * 
 *         ת��������Ϣ
 */
@SuppressWarnings("serial")
public class ChatMessage extends HttpServlet {
	private MessageObject msgObject;
	private String result;
	private Map<Integer, ReceiverDateThread> threads = new HashMap<Integer, ReceiverDateThread>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {      
		doPost(request, response);
	}
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,  IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String messageObject = request.getParameter("messageObject");
		if (messageObject!=null&&messageObject.length() > 0) {
			msgObject = JsonUtil.parseMessage(messageObject);
			int msgType = msgObject.getMsgType();      
			int fromId = msgObject.getFromUser();
			int roomId = msgObject.getRoomId();
			int isManager = msgObject.getIsManager();
			String userName = msgObject.getFronName();
			int isServer = msgObject.getIsServer();
			if ((roomId == 1) || (roomId != 1 && userName != null)) {
				if (msgType == 0 || msgType == 1) {
					// ����״̬
					upDateUserState(msgType, fromId);
					// ���ߡ� ������Ϣ
					if (msgType == 0) {
						// �����̣߳�ѭ����ȡ��Ϣ����ת�����û�
						String position = HttpUtils.getChatTopCount(isManager,roomId,isServer);
						if (position != null) {
							int p = Integer.parseInt(position);
							ReceiverDateThread reThread = new ReceiverDateThread(
									userName, isManager, p, roomId, fromId,isServer);
							reThread.stopTask(false);
							threads.put(fromId, reThread);
							reThread.start();
						}
					} else {
						// �ر��߳� --�ͷ���Դ
						threads.get(fromId).stopTask(true);
					}
				} else if (msgType == 2) {
					// ������Ϣ
					int toId = msgObject.getToUser();
					if (toId > 0) {
						User toUser = initUserInfo(toId);
						if (toUser != null) {
							msgObject.setToName(toUser.getNickName());
						}
					}
					// ������Ϣ
					// ���������Ϣ��PC ��
					HttpUtils.sendChatMessage(msgObject.getMessage(), userName,
							fromId, roomId);
				}
			} else {
				result = JsonUtil.getRetMsg(2, "������Ϣ��id�쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "��Ϣ������Ϊ��");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param msgType
	 * @param uId
	 *            �����û�����״̬
	 */
	private void upDateUserState(int msgType, int uId) {
		int state;
		// �����û�����״̬
		if (msgType == 0) {
			state = 1;
		} else {
			state = 0;
		}
		UserServer.updateUserIsLiveRoom(state, uId);
	}

	/**
	 * @param uId
	 * @return ��ȡ�û����������Ϣ
	 */
	private User initUserInfo(int uId) {
		User user = UserServer.findUserNikNameById(uId);
		if (user != null) {
			user.setId(uId);
		}
		return user;

	}

}

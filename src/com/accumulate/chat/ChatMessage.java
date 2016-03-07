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
 *         转发聊天信息
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
					// 更新状态
					upDateUserState(msgType, fromId);
					// 上线、 下线消息
					if (msgType == 0) {
						// 启动线程，循环获取信息，并转发给用户
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
						// 关闭线程 --释放资源
						threads.get(fromId).stopTask(true);
					}
				} else if (msgType == 2) {
					// 聊天消息
					int toId = msgObject.getToUser();
					if (toId > 0) {
						User toUser = initUserInfo(toId);
						if (toUser != null) {
							msgObject.setToName(toUser.getNickName());
						}
					}
					// 发送消息
					// 添加聊天消息到PC 端
					HttpUtils.sendChatMessage(msgObject.getMessage(), userName,
							fromId, roomId);
				}
			} else {
				result = JsonUtil.getRetMsg(2, "发送信息者id异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "消息对象不能为空");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param msgType
	 * @param uId
	 *            更新用户在线状态
	 */
	private void upDateUserState(int msgType, int uId) {
		int state;
		// 更新用户在线状态
		if (msgType == 0) {
			state = 1;
		} else {
			state = 0;
		}
		UserServer.updateUserIsLiveRoom(state, uId);
	}

	/**
	 * @param uId
	 * @return 获取用户聊天相关信息
	 */
	private User initUserInfo(int uId) {
		User user = UserServer.findUserNikNameById(uId);
		if (user != null) {
			user.setId(uId);
		}
		return user;

	}

}

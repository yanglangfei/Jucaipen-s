package com.accumulate.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.accumulate.entity.MessageObject;
import com.accumulate.utils.HttpUtils;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.XinGeUtil;

/**
 * @author Administrator
 * 
 * 
 *         topId roomId userId
 * 
 *         isManager 是否是管理员 1 是 0 不是
 * 
 *         子线程 ---获取聊天记录，并转发到客户端
 * 
 */
public class ReceiverDateThread extends Thread {

	private String path = "http://chat-data.jucaipen.com/ashx/chat_msg.ashx?action=getlist";
	private int topId;
	private int roomId;
	private int userId;
	private List<MessageObject> msgObject = new ArrayList<MessageObject>();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	private int isManager;
	private String userName;
	private boolean isStop;
	private JSONObject object;

	public ReceiverDateThread(String userName, int isManager, int topId,
			int roomId, int userId) {
		this.topId = topId;
		this.roomId = roomId;
		this.userId = userId;
		this.isManager = isManager;
		this.userName = userName;
	}

	public void stopTask(boolean flag) {
		this.isStop = flag;
	}

	@Override
	public void run() {
		while (!isStop) {
			try {
				// 获取PC端聊天消息
				String object = null;
				String data = HttpUtils.sendHttpPost(path, topId, roomId,
						userId);
				if (data != null && data.contains("MessBody")) {
					object = createChatRecoder(data);
					if (object != null && object.contains("message")) {
						// 消息不为空时，推送消息
						XinGeUtil.getInstance().pushAccountDevice(object,
								userName);
					}
				}
				Thread.sleep(3000);
				if (msgObject.size() > 0) {
					if (isManager == 1) {
						// 管理员 topId等于消息id
						this.topId = msgObject.get(msgObject.size() - 1)
								.getMsgId() + 1;
					} else {
						// 非管理员 topId 等于审核id
						this.topId = msgObject.get(msgObject.size() - 1)
								.getIsCheck() + 1;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param data
	 * @return 解析、封装消息
	 */
	private String createChatRecoder(String data) {
		try {
			JSONArray array = new JSONArray(data);
			if (array.length() > 0) {
				msgObject.clear();
				for (int i = 0; i < array.length(); i++) {
					object = array.getJSONObject(i);
					parseChatMessage(object);
				}
			}
			return JsonUtil.getPCChatMessage(msgObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private void parseChatMessage(JSONObject obj) {
		int id = obj.getInt("Id");
		int sendUserId = obj.getInt("SendUserId");
		String msgBody = obj.getString("MessBody");
		String SendUserName = obj.getString("SendUserName");
		String sendDate = obj.getString("SendDate");
		int isCheck = obj.getInt("Shenhe");
		if (!userName.equals(SendUserName)) {
			MessageObject msg = new MessageObject(2, sendUserId);
			msg.setMsgId(id);
			msg.setSendDate(sdf.format(new Date(sendDate)));
			msg.setFronName(SendUserName);
			msg.setMsgType(2);
			msg.setIsCheck(isCheck);
			msg.setChatType(0);
			msg.setToUser(-1);
			msg.setMessage(msgBody);
			msgObject.add(msg);
		}

	}

}

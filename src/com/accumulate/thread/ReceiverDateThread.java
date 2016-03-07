package com.accumulate.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import com.accumulate.entity.MessageObject;
import com.accumulate.utils.HttpUtils;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.XinGeUtil;

/**
 * @author Administrator
 *     ？  
 * 
 *         topId roomId userId
 * 
 *         isManager 是否是管理员 1 是 0 不是
 * 
 *         子线程 ---获取聊天记录，并转发到客户端
 * 
 */
public class ReceiverDateThread extends Thread {

	private String path = "http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getlist";
	private int topId;
	private int roomId;
	private int userId;
	private List<MessageObject> msgObject = new ArrayList<MessageObject>();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	private String userName;
	private boolean isStop;
	private JSONObject object;          
	private int isVip;
	
	
	
	/*发送消息接口：http://chat.jucaipe n.com/ashx/chat_msg.ashx?action=add

		需要传递参数：msgcontent（消息内容）、sendusername（发送人昵称）、fasongface（发送人头像）、SendUserId（发送人ID）、roomid（房间ID）、
			      jieshouname（接收人昵称）、jieshouid（接收人ID）、ReceiverNameId（接收人用户名）、sendusernameid（发送人用户名）、
			      userLevel（用户产品ID）、ReceiveLevel（接收产品ID）、ReceiveManger（接收用户是否为管理员）、SendManager（发送人是否为管	      理员，1为管理员0为普通用户）、
			      ReceiveServiceId（接收信息的服务ID）、SendServiceId（发送信息的服务ID）、MessType（消息类型，0为群聊，1为私信）、

  你  

		聊天记录接口：http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getlist

		需要传递参数：topId（显示最新十条消息）、roomid（房间ID）、userId（用户ID，游客用户ID为0）、isServer（0为普通用户或游客，1为管理员或客	      服）
				


		请求topId接口:http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getTopId

		需要传递参数：userType(用户是否为管理员)、topCount（显示条数）、roomId（房间id）、 isServer（是否为客服）、
        //387433

		表情列表接口：http://chat.jucaipen.com/ashx/addface.ashx
*/			

	public ReceiverDateThread(String userName, int isManager, int topId,
			int roomId, int userId, int isServer) {
		this.topId = topId;
		this.roomId = roomId;
		this.userId = userId;
		this.userName = userName;
		if(isServer!=0||isManager!=0){
			//是管理员或者客服
			isVip=1;
		}else if(isManager==0&&isServer==0){
			isVip=0;
		}
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
						userId,isVip);
				if (data != null && data.contains("MessBody")) {
					object = createChatRecoder(data);
					if (object != null && object.contains("message")) {
						// 消息不为空时，推送消息
						// GePushUtils.getInstance().sendMsg(object, userName);
						XinGeUtil.getInstance(true).pushAccountDevice(object, userName);
					}
				}
				Thread.sleep(3000);
				if (msgObject.size() > 0) {
					if (isVip == 1) {
						// 管理员 、客服 topId等于消息id
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
			String uuId=UUID.randomUUID().toString();
			msg.setUuId(uuId);
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

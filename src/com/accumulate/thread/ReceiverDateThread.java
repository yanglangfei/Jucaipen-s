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
 *     ��  
 * 
 *         topId roomId userId
 * 
 *         isManager �Ƿ��ǹ���Ա 1 �� 0 ����
 * 
 *         ���߳� ---��ȡ�����¼����ת�����ͻ���
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
	
	
	
	/*������Ϣ�ӿڣ�http://chat.jucaipe n.com/ashx/chat_msg.ashx?action=add

		��Ҫ���ݲ�����msgcontent����Ϣ���ݣ���sendusername���������ǳƣ���fasongface��������ͷ�񣩡�SendUserId��������ID����roomid������ID����
			      jieshouname���������ǳƣ���jieshouid��������ID����ReceiverNameId���������û�������sendusernameid���������û�������
			      userLevel���û���ƷID����ReceiveLevel�����ղ�ƷID����ReceiveManger�������û��Ƿ�Ϊ����Ա����SendManager���������Ƿ�Ϊ��	      ��Ա��1Ϊ����Ա0Ϊ��ͨ�û�����
			      ReceiveServiceId��������Ϣ�ķ���ID����SendServiceId��������Ϣ�ķ���ID����MessType����Ϣ���ͣ�0ΪȺ�ģ�1Ϊ˽�ţ���

  ��  

		�����¼�ӿڣ�http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getlist

		��Ҫ���ݲ�����topId����ʾ����ʮ����Ϣ����roomid������ID����userId���û�ID���ο��û�IDΪ0����isServer��0Ϊ��ͨ�û����οͣ�1Ϊ����Ա���	      ����
				


		����topId�ӿ�:http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getTopId

		��Ҫ���ݲ�����userType(�û��Ƿ�Ϊ����Ա)��topCount����ʾ��������roomId������id���� isServer���Ƿ�Ϊ�ͷ�����
        //387433

		�����б�ӿڣ�http://chat.jucaipen.com/ashx/addface.ashx
*/			

	public ReceiverDateThread(String userName, int isManager, int topId,
			int roomId, int userId, int isServer) {
		this.topId = topId;
		this.roomId = roomId;
		this.userId = userId;
		this.userName = userName;
		if(isServer!=0||isManager!=0){
			//�ǹ���Ա���߿ͷ�
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
				// ��ȡPC��������Ϣ
				String object = null;
				String data = HttpUtils.sendHttpPost(path, topId, roomId,
						userId,isVip);
				if (data != null && data.contains("MessBody")) {
					object = createChatRecoder(data);
					if (object != null && object.contains("message")) {
						// ��Ϣ��Ϊ��ʱ��������Ϣ
						// GePushUtils.getInstance().sendMsg(object, userName);
						XinGeUtil.getInstance(true).pushAccountDevice(object, userName);
					}
				}
				Thread.sleep(3000);
				if (msgObject.size() > 0) {
					if (isVip == 1) {
						// ����Ա ���ͷ� topId������Ϣid
						this.topId = msgObject.get(msgObject.size() - 1)
								.getMsgId() + 1;
					} else {
						// �ǹ���Ա topId �������id
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
	 * @return ��������װ��Ϣ
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

package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.MessageModel;
import com.accumulate.entity.MobileMessage;
import com.accumulate.service.MessageModelSer;
import com.accumulate.service.MobileMessageSer;
import com.accumulate.utils.HttpUtils;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.RandomUtils;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         验证手机号
 */
@SuppressWarnings("serial")
public class SendMobileCode extends HttpServlet {
	private String result;
	private String check_url = "http://222.73.117.158/msg/HttpBatchSendSM?account=jcpxxk&pswd=jCpshanghai2017&mobile=";
	private String msg;
	private String newMsg;
	private String ip;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int isSuccess;

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
		ip=request.getRemoteAddr();
		String mobileNum = request.getParameter("telPhone");
		if (StringUtil.isMobileNumber(mobileNum)) {
			initMessage();
			if (msg != null) {
				String code = RandomUtils.getRandomData(5);
				newMsg = msg.replace("{mobile_code}", code);
				String path = check_url + mobileNum + "&msg="
						+ URLEncoder.encode(newMsg, "UTF-8") + "&needstatus=true";
				result = HttpUtils.sendHttpGet(path);
				insertMobileMessage(mobileNum,code);
			}else {
				result=JsonUtil.getRetMsg(2,"短信发送失败");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "手机号错误");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void insertMobileMessage(String mobileNum, String code) {
		//添加短信记录
		MobileMessage message=new MobileMessage();
		message.setActionCode(code);
		message.setTelPhone(mobileNum);
		message.setSendIp(ip);
		message.setSendDate(sdf.format(new Date()));
		message.setMessageContent(newMsg);
		message.setMsgType(1);
		message.setSendDev(2);
		isSuccess=MobileMessageSer.insertMessage(message);
		new changeMsgState(message).start();
		
	}

	private void initMessage() {
		// 初始化短信内容
		MessageModel messageModel = MessageModelSer.findModelById(1);
		msg = messageModel.getModelContent();

	}
	class changeMsgState extends Thread{
		MobileMessage msg;
		String msgId;
		public changeMsgState(MobileMessage message) {
			message.setMsgType(3);
			msgId=message.getMsgid();
			this.msg=message;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000*3);
			//	MobileMessageSer.upDateMessageType(msgId, msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

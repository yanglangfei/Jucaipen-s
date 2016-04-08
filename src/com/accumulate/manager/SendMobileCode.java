package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.accumulate.entity.MessageModel;
import com.accumulate.entity.MobileMessage;
import com.accumulate.entity.User;
import com.accumulate.service.MessageModelSer;
import com.accumulate.service.MobileMessageSer;
import com.accumulate.service.UserServer;
import com.accumulate.timertask.MobileState;
import com.accumulate.utils.HttpUtils;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.LoginUtil;
import com.accumulate.utils.RandomUtils;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         msgId 1 其他短信验证 3 修改密码 验证手机号
 */
@SuppressWarnings("serial")
public class SendMobileCode extends HttpServlet {
	private String result;
	//加密手机号
	private String encrypePath = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();
	//发送验证码
	private String check_url = "http://222.73.117.158/msg/HttpBatchSendSM?account="+StringUtil.sendPhoneAccount+"&pswd="+StringUtil.sendPhonePwd+"&mobile=";
	private String msg;
	private String newMsg;
	private String ip;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		ip = request.getRemoteAddr();
		String mobileNum = request.getParameter("telPhone");
		String msgId = request.getParameter("msgId");
		if (msgId != null && StringUtil.isInteger(msgId)) {
			int id = Integer.parseInt(msgId);
			if (StringUtil.isMobileNumber(mobileNum)) {
				param.put("mobilenum", mobileNum);
				String telStr=LoginUtil.sendHttpPost(encrypePath, param);
				System.out.println("telStr:"+telStr);
				JSONObject obg=new JSONObject(telStr);
				boolean rest=obg.getBoolean("Result");
				if(rest){
					String tel=obg.getString("MobileNum");
					boolean isExist=checkIsExist(tel);
					if(isExist){
						result=JsonUtil.getRetMsg(4, "手机号已经注册");
					}else{
						initMessage(id);
						if (msg != null) {
							String code = RandomUtils.getRandomData(4);
							if (id == 3) {
								msg = StringUtil.replaceStr(msg);
								newMsg = msg.replace("{actioncode}", code);
							} else {
								newMsg = msg.replace("{mobile_code}", code);
							}
							String path = check_url + mobileNum + "&msg="
									+ URLEncoder.encode(newMsg, "UTF-8")
									+ "&needstatus=true";
							String res = HttpUtils.sendHttpGet(path);
							String resptime = res.split(",")[0];
							String tempStr = res.split(",")[1];
							String ret_code = tempStr.substring(0, 1);
							String mId = tempStr.substring(1, tempStr.length());
							if(Integer.parseInt(ret_code)==0){
								result = JsonUtil.getRetMsg(0, "短信发送成功");
								insertMobileMessage(mobileNum, code, res);
							}else{
								result=JsonUtil.getRetMsg(7, "短信发送异常");
							}
						} else {
							result = JsonUtil.getRetMsg(2, "短信发送失败");
						}
					}
				}else{
					result=JsonUtil.getRetMsg(6,"手机号出现异常");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "手机号格式错误");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "短信ID状态异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param mobileNum  监测手机号是否已经存在
	 */
	private boolean checkIsExist(String mobileNum) {
		User user = UserServer.findUserByTelPhone(mobileNum);
		if(user!=null){
			return true;
		}else{
			return false;
		}
		
	}

	private void insertMobileMessage(String mobileNum, String code,
			String results) {
		// 添加短信记录
		String resptime = results.split(",")[0];
		String tempStr = results.split(",")[1];
		String ret_code = tempStr.substring(0, 1);
		String msgId = tempStr.substring(1, tempStr.length());
		MobileMessage message = new MobileMessage();
		message.setActionCode(code);
		message.setTelPhone(mobileNum);
		message.setResptime(resptime);
		message.setMsgid(msgId);
		message.setRespstatus(Integer.parseInt(ret_code));
		message.setSendIp(ip);
		message.setSendDate(sdf.format(new Date()));
		message.setMessageContent(newMsg);
		message.setMsgType(1);
		message.setSendDev(2);
		isSuccess = MobileMessageSer.insertMessage(message);
		if (isSuccess == 1) {
			changeMsgState(message);
		}

	}

	private void changeMsgState(MobileMessage message) {
		// 三分钟后改变手机短信状态
		Timer timer = new Timer();
		MobileState state = new MobileState(message);
		timer.schedule(state, 60000 * 3);
	}

	private void initMessage(int id) {
		// 初始化短信内容
		MessageModel messageModel = MessageModelSer.findModelById(id);
		msg = messageModel.getModelContent();

	}

}

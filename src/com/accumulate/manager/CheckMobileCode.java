package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.MobileMessage;
import com.accumulate.entity.User;
import com.accumulate.service.MobileMessageSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *  验证手机激活码
 */
@SuppressWarnings("serial")
public class CheckMobileCode extends HttpServlet {
	private String result;
	private boolean isPassed;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String checkDate;
	private String msgId;

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
		checkDate = sdf.format(new Date());
		//用户真实姓名
		String trueName=request.getParameter("trueName");
		//用户id
		String userId=request.getParameter("userId");
		//用户手机号
		String mobileNum=request.getParameter("telPhone");
		//验证码
		String actionCode=request.getParameter("actionCode");
		//券商名称
		String qsName=request.getParameter("qsName");
		if(StringUtil.isInteger(userId)){
			//用户id数字格式化正常
			int uId=Integer.parseInt(userId);
			if(StringUtil.isMobileNumber(mobileNum)){
				if(StringUtil.isNotNull(qsName)){
				//手机号符合要求
				checkMobileCode(mobileNum,actionCode);
				if(isPassed){
					result=JsonUtil.getRetMsg(0, "验证码信息正确");
					insertUserInfo(uId,trueName,mobileNum);
				}else {
					result=JsonUtil.getRetMsg(3,"无效的验证码");
				}
				insertCheckInfo(mobileNum,checkDate,qsName);
				}else {
					result=JsonUtil.getRetMsg(4, "请选择券商");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"手机号不符合要求");
			}
		}else {
			result=JsonUtil.getRetMsg(1,"参数用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	private void insertUserInfo(int uId, String trueName, String mobileNum) {
		// 修改当前用户信息
		User u=new User();
		u.setTrueName(trueName);
		u.setMobileNum(mobileNum);
		UserServer.updateUserTrueNameAndTelById(mobileNum, u);
		
	}
	private void insertCheckInfo(String mobileNum, String checkDate,String qsName) {
		//修改短信激活状态
		MobileMessage mobileMessage=new MobileMessage();
		if(isPassed){
			mobileMessage.setMsgType(2);
			mobileMessage.setCheckDate(checkDate);
			mobileMessage.setRemark(qsName);
		}else {
			mobileMessage.setMsgType(3);
		}
		MobileMessageSer.upDateMessageType(msgId, mobileMessage);
		
	}
	private void checkMobileCode(String mobile, String actionCode) {
		try {
			// 验证手机验证码是否合法
			List<MobileMessage> mobileList = MobileMessageSer.findMobileMessageByMobileNumLast(1, mobile);
			if(mobileList.size()>0){
				String checkCode=mobileList.get(0).getActionCode();
				String sendDate=mobileList.get(0).getSendDate();
				msgId = mobileList.get(0).getMsgid();
				long sendTime=sdf.parse(sendDate).getTime();
				long currrentTime=System.currentTimeMillis();
				if((actionCode.equals(checkCode))&&((currrentTime-sendTime)<=(3*60*1000))){
					isPassed=true;
				}else {
					isPassed=false;
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

}

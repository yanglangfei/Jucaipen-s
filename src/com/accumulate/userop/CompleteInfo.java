package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         完善个人信息、编辑个人信息
 * 
 */
@SuppressWarnings("serial")
public class CompleteInfo extends HttpServlet {
	private String result;
	private User user;
	private int isSuccess;
	private int uId;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String nickName = request.getParameter("nikeName");
		String telPhone = request.getParameter("telPhone");
		String  sex=request.getParameter("sex");
		String email = request.getParameter("email");
		String bodys = request.getParameter("bodys");
		String birth = request.getParameter("birthday");
		String localProvince=request.getParameter("localProvince");
		String localCity=request.getParameter("localCity");
		String localArea=request.getParameter("localArea");
		if (!StringUtil.isInteger(id)) {
			result = JsonUtil.getRetMsg(1, "用户id数字格式化失败");
		} else {
			uId=Integer.parseInt(id);
			if(uId>0){
				if(StringUtil.isNotNull(telPhone)&&StringUtil.isMobileNumber(telPhone)){
					user=UserServer.findUserByTelPhone(telPhone);
					if(user!=null){
						//手机号已被绑定
						result=JsonUtil.getRetMsg(8,"手机号已被绑定");
						out.print(result);
						return ;
					}else {
						//手机号不为空完成信息
						user = new User();
						user.setMobileNum(telPhone);
					}
				}else {
					//手机号为空完成个人信息
					user = new User();
				}
				user.setId(Integer.parseInt(id));
				if (StringUtil.isNotNull(birth)) {
					user.setBirthday(birth);
				}
				if (StringUtil.isNotNull(bodys)) {
					user.setDescript(bodys);
				}
				if (StringUtil.isNotNull(email)) {
					user.setEmail(email);
				}
				if (StringUtil.isNotNull(nickName)) {
					user.setNickName(nickName);
				}
				if(StringUtil.isNotNull(sex)){
					user.setSex(sex);
				}
				if(StringUtil.isNotNull(localProvince)&&StringUtil.isInteger(localProvince)){
					user.setLocalProvince(Integer.parseInt(localProvince));
				}
				if(StringUtil.isNotNull(localCity)&&StringUtil.isInteger(localCity)){
					user.setLocalCity(Integer.parseInt(localCity));
				}
				if(StringUtil.isNotNull(localArea)&&StringUtil.isInteger(localArea)){
					user.setLocalArea(Integer.parseInt(localArea));
				}
				isSuccess = completeUserInfo(uId,user);
				if (isSuccess == 1) {
					result = JsonUtil.getRetMsg(0, "用户信息提交成功");
				} else {
					result = JsonUtil.getRetMsg(2, "用户信息提交失败");
				}
			}else {
				result=JsonUtil.getRetMsg(4,"当前用户还没登录");
			}
			
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private int completeUserInfo(int uId, User user) {
		return UserServer.updateUser(uId, user);
	}

}

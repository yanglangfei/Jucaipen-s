package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.TeacherAttention;
import com.accumulate.entity.User;
import com.accumulate.service.TeacherAttentionSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取粉丝列表
 * 
 */
@SuppressWarnings("serial")
public class FansList extends HttpServlet {

	private List<TeacherAttention> attentions;
	private List<User> users = new ArrayList<User>();
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId = request.getParameter("teacherId");
		String page=request.getParameter("page");
		if (StringUtil.isInteger(teacherId)) {
			// 讲师id数字格式化正确
			int tId = Integer.parseInt(teacherId);
			if(StringUtil.isInteger(page)){
				int p=Integer.parseInt(page);
				initTeacherFansData(tId,p);
				result = JsonUtil.getAttentionList(attentions,users);
			}else {
				result=JsonUtil.getRetMsg(2,"页数参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "讲师id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initTeacherFansData(int tId,int page) {
		// 初始化讲师粉丝数据
		users.clear();
		attentions = TeacherAttentionSer.findAttentionBytid(tId,page);
		if (attentions != null && attentions.size() > 0) {
			for (TeacherAttention attention : attentions) {
				int uId = attention.getUserId();
				User user = UserServer.findUserNikNameById(uId);
				users.add(user);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

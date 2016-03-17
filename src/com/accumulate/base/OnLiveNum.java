package com.accumulate.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.User;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@SuppressWarnings("serial")
public class OnLiveNum extends HttpServlet {

	private String result;
	private List<User> users;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String page=request.getParameter("page");
		String roomId=request.getParameter("roomId");
		if(StringUtil.isInteger(page)){
			int p=Integer.parseInt(page);
			if(StringUtil.isInteger(roomId)){
				int rId=Integer.parseInt(roomId);
				iniOnLineUserInfo(rId,p);
				if(users!=null&&users.size()>0){
					JsonArray array=new JsonArray();
					for(int i=0;i<users.size();i++){
						JsonObject object=new JsonObject();
						object.addProperty("userName", users.get(i).getUserName());
						array.add(object);
					}
					result=JsonUtil.getRetMsg(0, array.toString());
				}else{
				   result=JsonUtil.getRetMsg(3,"暂时无用户");	
				}
			}else{
				result=JsonUtil.getRetMsg(2,"房间ID数字格式化异常");
			}
		}else{
			result=JsonUtil.getRetMsg(1, "页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void iniOnLineUserInfo(int rId, int p) {
		users=UserServer.findOnLiveRoomUser(rId, p);
	}


}

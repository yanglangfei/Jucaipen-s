package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Ask;
import com.accumulate.entity.User;
import com.accumulate.service.AskSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *   最新提问   isAll   0 获取全部数据
 *                  1 根据讲师id获取数据 
 *
 */
@SuppressWarnings("serial")
public class AskForTeacher extends HttpServlet {
	private String result;
	private List<Ask> askList;
	private List<User> users=new ArrayList<User>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String isAll=request.getParameter("isAll");
		String pager=request.getParameter("page");
		if(StringUtil.isInteger(pager)){
			//page参数正常
			int page=Integer.parseInt(pager);
			if(StringUtil.isInteger(isAll)){
				int all=Integer.parseInt(isAll);
				if(all==0){
					//获取全部数据
					initAllAskList(page);
					result=JsonUtil.getAskList(askList,users);
				}else if(all==1){
					//根据讲师id获取
					String teacherId=request.getParameter("teacherId");
					if(StringUtil.isInteger(teacherId)){
						//page参数正常
						int tId=Integer.parseInt(teacherId);
						initAskListForTeacher(tId,page);
						result=JsonUtil.getAskList(askList, users);
					}else {
						//page参数异常
						result=JsonUtil.getRetMsg(3,"讲师id参数数字格式化异常");
					}
				}else {
					//参数异常
					result=JsonUtil.getRetMsg(2,"isALL参数不符合要求");
				}
				
			}else {
				result=JsonUtil.getRetMsg(1,"isAll参数数字格式化异常");
			}
		}else {
			//page参数异常
			result=JsonUtil.getRetMsg(3,"页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAskListForTeacher(int tId,int page) {
		//通过讲师id初始化提问信息
		users.clear();
		askList=AskSer.findAskByTeacherId(tId,page);
		if(askList.size()>0){
			for(Ask ask :askList){
				int uId=ask.getUserId();
				User user=UserServer.findUserNikNameById(uId);
				users.add(user);
			}
		}
		
	}

	private void initAllAskList(int page) {
		//初始化全部提问信息
		users.clear();
		askList=AskSer.findAllAsk(page);
		if(askList.size()>0){
			for(Ask ask :askList){
				int uId=ask.getUserId();
				User user=UserServer.findUserNikNameById(uId);
				users.add(user);
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doGet(request, response);
	}

}

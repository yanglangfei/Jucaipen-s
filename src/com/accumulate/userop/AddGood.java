package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsComment;
import com.accumulate.service.NewsCommSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *  添加赞
 */
@SuppressWarnings("serial")
public class AddGood extends HttpServlet {
	private NewsComment newsComment;
	private int goodCount;
	private int isSuccess;
	private String result;

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
		String userId=request.getParameter("userId");
		String commId=request.getParameter("commId");
		if(StringUtil.isInteger(userId)){
		    //int uId=Integer.parseInt(userId);
			if(StringUtil.isInteger(commId)){
				int cId=Integer.parseInt(commId);
				//查询评论的赞数
				querryGoodCount(cId);
				//添加赞 
				addGood(goodCount+1,cId);
				if(isSuccess==1){
					result=JsonUtil.getRetMsg(0,"点赞成功");
				}else {
					result=JsonUtil.getRetMsg(1,"点赞失败");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"评论id参数数字格式化异常");
			}
		}else {
			result=JsonUtil.getRetMsg(3,"用户id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void addGood(int good, int cId) {
		isSuccess=NewsCommSer.updateComment(cId, good);
		
	}

	private void querryGoodCount(int cId) {
		newsComment=NewsCommSer.findNewsCommById(cId);
		goodCount=newsComment.getGoodNum();
		
	}

}

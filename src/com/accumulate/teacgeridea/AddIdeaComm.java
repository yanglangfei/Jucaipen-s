package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.LogCommen;
import com.accumulate.service.LogCommSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *    添加 热门观点评论
 */
@SuppressWarnings("serial")
public class AddIdeaComm extends HttpServlet {
	private String result;
	private int isSuccess;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		String ideaId=request.getParameter("ideaId");
		String commBody=request.getParameter("commBodys");
		if(StringUtil.isInteger(userId)){
			//用户id正常
			int uId=Integer.parseInt(userId);
			if(StringUtil.isInteger(ideaId)){
				//观点id正常
				if(StringUtil.isNotNull(commBody)){
				int iId=Integer.parseInt(ideaId);
				insertIdeaComm(uId,iId,commBody);
				if(isSuccess==1){
					//添加评论成功
					result=JsonUtil.getRetMsg(0, "添加评论成功");
				}else {
					//添加评论失败
					result=JsonUtil.getRetMsg(3,"添加评论失败");
				}
				}else {
					result=JsonUtil.getRetMsg(4, "评论内容不能为空");
				}
			}else {
				result=JsonUtil.getRetMsg(1,"热门观点id数字格式化异常");
			}
		}else {
			result=JsonUtil.getRetMsg(2,"用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void insertIdeaComm(int uId, int iId, String commBody) {
		//添加评论
		LogCommen commen=new LogCommen(0, uId, 0, iId, commBody, sdf.format(new Date()), 0, 0, 0);
		isSuccess=LogCommSer.insertLogComm(commen);
	   
	}

}

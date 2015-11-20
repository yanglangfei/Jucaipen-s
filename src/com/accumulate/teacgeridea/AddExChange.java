package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.LiveInteractive;
import com.accumulate.service.LiveInteractiveSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *   添加交流信息
 */
@SuppressWarnings("serial")
public class AddExChange extends HttpServlet {
	private String result;
	private int isSuccess;
	private String ip;
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
		ip=request.getRemoteAddr();
		String userId=request.getParameter("userId");
		String liveId=request.getParameter("liveId");
		String bodys=request.getParameter("bodys");
		if(StringUtil.isInteger(userId)){
			//用户id正常
			int uId=Integer.parseInt(userId);
			if(uId>0){
				if(StringUtil.isInteger(liveId)){
					//直播id正常
					if(StringUtil.isNotNull(bodys)){
					int lId=Integer.parseInt(liveId);
					insertLiveExchange(uId,lId,bodys,ip);
					if(isSuccess==1){
						result=JsonUtil.getRetMsg(0, "添加交流信息成功");
					}else {
						result=JsonUtil.getRetMsg(3, "添加交流信息失败");
					}
					}else {
						result=JsonUtil.getRetMsg(4, "交流内容不能为空");
					}
					
				}else {
					result=JsonUtil.getRetMsg(1, "直播id参数数字格式化异常");
				}
			}else {
				result=JsonUtil.getRetMsg(5, "您还没登录");
			}
		}else {
			result=JsonUtil.getRetMsg(2,"用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	private void insertLiveExchange(int uId, int lId, String bodys, String ip) {
		//添加交流信息
		LiveInteractive interactive=new LiveInteractive(0, lId, uId, 5, sdf.format(new Date()), bodys, 1, ip, 0);
		isSuccess=LiveInteractiveSer.insertLiveInteractive(interactive);
	}

}

package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.TextLive;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.TxtLiveSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *    获取文字直播支付信息
 */
@SuppressWarnings("serial")
public class TxtLivePayInfo extends HttpServlet {
	private String result;
	private FamousTeacher teacher;
	private TextLive txtLive;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String liveId=request.getParameter("liveId");
		String teacherId=request.getParameter("teacherId");
		if(StringUtil.isInteger(teacherId)){
			int tId=Integer.parseInt(teacherId);
			if(StringUtil.isInteger(liveId)){     
				int lId=Integer.parseInt(liveId);   
				initPayInfo(tId,lId);
				result=JsonUtil.getPayInfo(teacher,txtLive);
			}else {
				result=JsonUtil.getRetMsg(2,"直播id数字格式化异常");
			}
		}else {
			result=JsonUtil.getRetMsg(1,"讲师id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initPayInfo(int tId, int lId) {
		//初始化支付信息
		teacher=FamousTeacherSer.findFamousTeacherById(tId);
		txtLive=TxtLiveSer.findTextLiveById(lId);
		
	}

}

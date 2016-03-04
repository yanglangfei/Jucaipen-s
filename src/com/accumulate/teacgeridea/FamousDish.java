package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
 *   名家看盘
 */
@SuppressWarnings("serial")   
public class FamousDish extends HttpServlet {
	private String result;
	private List<TextLive> txtLives;
	private List<FamousTeacher> famousTeachers=new ArrayList<FamousTeacher>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String page=request.getParameter("page");
		if(StringUtil.isInteger(page)){
			int p=Integer.parseInt(page);
			initDishData(p);
			result=JsonUtil.getTxtLiveList(txtLives,famousTeachers);
		}else {
			result=JsonUtil.getRetMsg(1,"页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	
	private void initDishData(int page) {
		famousTeachers.clear();
		txtLives=TxtLiveSer.findAllTextLive(page);
		if(txtLives.size()>0){
			for(TextLive textLive :txtLives){
				int teacherId=textLive.getTeacherId();
				FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
				famousTeachers.add(teacher);
			}
		}
	     
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doGet(request, response);
	}

}

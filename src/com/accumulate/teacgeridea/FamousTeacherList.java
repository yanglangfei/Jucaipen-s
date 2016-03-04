package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         推荐名师列表 0 首页 1 全部数据
 * 
 * 
 */
@SuppressWarnings("serial")
public class FamousTeacherList extends HttpServlet {
	private String result;
	private List<FamousTeacher> famousTeachers;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter   out = response.getWriter();
		String which = request.getParameter("whichPage");
		if (StringUtil.isInteger(which)) {
			int whichPage = Integer.parseInt(which);
			if(whichPage==0){
				//首页信息
				initIndexTeacherData();
				result = JsonUtil.getFamousTeacherList(famousTeachers);
			}else if(whichPage==1){
				//全部信息
				String page=request.getParameter("page");
				if(StringUtil.isInteger(page)){
					int p=Integer.parseInt(page);
					initAllTeacherData(p);
					result=JsonUtil.getFamousTeacherList(famousTeachers);
				}else {
					result=JsonUtil.getRetMsg(3,"页数参数数字格式化异常");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"whichPage 参数不符合要求");
			}
			
		}else {
			result=JsonUtil.getRetMsg(1,"whichPage参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAllTeacherData(int p) {
		//初始化讲师全部信息
		famousTeachers=FamousTeacherSer.findAllFamousTeacher(p);
		
	}

	private void initIndexTeacherData() {
		//初始化讲师首页信息
	    famousTeachers = FamousTeacherSer.findFamousTeacherByIndex(3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

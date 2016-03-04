package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.HotIdea;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.HotIdeaServ;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *  热门观点详细内容
 */
@SuppressWarnings("serial")
public class HotIdeaDetaile extends HttpServlet {     

	private HotIdea hotIdea;
	private FamousTeacher teacher;
	private String result;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ideaId=request.getParameter("ideaId");
		if(StringUtil.isInteger(ideaId)){
			//参数格式正确
			int id=Integer.parseInt(ideaId);
			initIdeaDetaileData(id);
			result=JsonUtil.getIdeaDetaile(hotIdea,teacher);
		}else {
			result=JsonUtil.getRetMsg(1,"参数格式化异常");
		}
	    out.print(result);
		out.flush();
		out.close();
	}

	
	private void initIdeaDetaileData(int id) {
		hotIdea = HotIdeaServ.findIdeaById(id);
		if(hotIdea!=null){
			int teacherId=hotIdea.getTeacherId();
			teacher = FamousTeacherSer.findFamousTeacherById(teacherId);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doGet(request, response);
	}

}

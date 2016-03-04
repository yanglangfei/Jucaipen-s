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
 *         �Ƽ���ʦ�б� 0 ��ҳ 1 ȫ������
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
				//��ҳ��Ϣ
				initIndexTeacherData();
				result = JsonUtil.getFamousTeacherList(famousTeachers);
			}else if(whichPage==1){
				//ȫ����Ϣ
				String page=request.getParameter("page");
				if(StringUtil.isInteger(page)){
					int p=Integer.parseInt(page);
					initAllTeacherData(p);
					result=JsonUtil.getFamousTeacherList(famousTeachers);
				}else {
					result=JsonUtil.getRetMsg(3,"ҳ���������ָ�ʽ���쳣");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"whichPage ����������Ҫ��");
			}
			
		}else {
			result=JsonUtil.getRetMsg(1,"whichPage�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAllTeacherData(int p) {
		//��ʼ����ʦȫ����Ϣ
		famousTeachers=FamousTeacherSer.findAllFamousTeacher(p);
		
	}

	private void initIndexTeacherData() {
		//��ʼ����ʦ��ҳ��Ϣ
	    famousTeachers = FamousTeacherSer.findFamousTeacherByIndex(3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

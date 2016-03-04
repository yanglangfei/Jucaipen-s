package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsComment;
import com.accumulate.entity.User;
import com.accumulate.service.NewsCommSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         ��ȡ���� params --
 *         typeId ---��ȡ���۷���    0   ��������   1  ��Ƶ����
 *         id ---����id
 * 
 */
@SuppressWarnings("serial")
public class QuerryComm extends HttpServlet {
	private List<NewsComment> nComments ;
	private List<User> users=new ArrayList<User>();
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId=request.getParameter("typeId");
		String id = request.getParameter("id");
		String pager = request.getParameter("pager");
		if(StringUtil.isInteger(typeId)){
			int type=Integer.parseInt(typeId);
			if (StringUtil.isInteger(id)) {
				int newsId = Integer.parseInt(id);
				if (StringUtil.isInteger(pager)) {
					int page = Integer.parseInt(pager);
					if(type==0||type==1){
						initNewsCommData(newsId, page,type);
						result = JsonUtil.getNewsCommList(nComments,users);	
					}else{
						result=JsonUtil.getRetMsg(4, "�������������0����1");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "����ҳ��id���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "��������id���ָ�ʽ���쳣");
			}
		}else {
			result=JsonUtil.getRetMsg(3,"���Ͳ������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initNewsCommData(int newsId, int page,int type) {
		// ��ʼ��������������
		nComments = NewsCommSer.findCommByTypeId(page, newsId, type);
		//�������ۻ�ȡ�����û���Ϣ
		users.clear();
		for(int i=0;i<nComments.size();i++){
			int userId=nComments.get(i).getuId();
			User user=UserServer.findUserById(userId);
			users.add(user);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

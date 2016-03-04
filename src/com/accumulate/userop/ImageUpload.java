package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

@SuppressWarnings("serial")
public class ImageUpload extends HttpServlet {
	private String result;
	private int isSuccess;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String imgFile=request.getParameter("imgFile");
		if(StringUtil.isInteger(userId)){
		     int uId=Integer.parseInt(userId);
		     if(uId>0){
		    	 //�û��ѵ�¼  
		    	 if(imgFile!=null&&imgFile.length()>0){
                    insertImageLogo(uId,imgFile);
                    if(isSuccess>0){
                    	result=JsonUtil.getRetMsg(0, "ͷ����³ɹ�");
                    }else{
                    	result=JsonUtil.getRetMsg(3,"ͷ�����ʧ��");
                    }
		    	 }else{
		    		 result=JsonUtil.getRetMsg(3,"�ļ�·������Ϊ��");
		    	 }
		     }else{
               result=JsonUtil.getRetMsg(2,"����û�е�¼");		    	 
		     }
			
		}else{
			result=JsonUtil.getRetMsg(1, "�û�ID���ָ�ʽ���쳣");
		}
	    out.print(result);	
		out.flush();
		out.close();
	}

	private void insertImageLogo(int id,String faceImage) {
		isSuccess=UserServer.updateUserLogo(id, faceImage);
		
	}

}

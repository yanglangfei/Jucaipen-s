package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Signing;
import com.accumulate.entity.User;
import com.accumulate.service.SigingSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         用户签约
 * 
 */
@SuppressWarnings("serial")
public class AddSigin extends HttpServlet {
	private String result;
	private String ip;
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
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		String statrtDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String qsName = request.getParameter("QsName");
		ip=request.getRemoteAddr();
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (StringUtil.isInteger(teacherId)) {
				int tId = Integer.parseInt(teacherId);
				initSigingData(uId, tId, statrtDate, endDate, qsName);
				if(isSuccess==1){
					result=JsonUtil.getRetMsg(0, "签约成功");
				}else {
					result=JsonUtil.getRetMsg(1, "签约失败");
				}
			}else {
				result=JsonUtil.getRetMsg(2,"讲师id数字格式化异常");
			}
		}
        out.print(result);
		out.flush();
		out.close();
	}

	private void initSigingData(int uId, int tId, String startDate,
			String endDate, String qsName) {
		    User user=UserServer.findUserById(uId);
		    String trueName=user.getTrueName();
		    String mobileNum=user.getMobileNum();
		    String insertDate=sdf.format(new Date());
		    Signing signing = new Signing(0, uId, tId, trueName,
				mobileNum, insertDate, startDate, endDate, qsName, 0, ip,
				3);
		   isSuccess=SigingSer.insertSigin(signing);

	}

}

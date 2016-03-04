package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.service.PayOrderServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *    支付订单
 */
@SuppressWarnings("serial")
public class PayOrder extends HttpServlet {
	private String result; 
	private static final String yyyyMMddHHmmss="yyyy-MM-dd HH:mm:ss";
	private SimpleDateFormat sdf=new SimpleDateFormat(yyyyMMddHHmmss);
	private int isSuccess;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String orderCode=request.getParameter("orderCode");
		if(StringUtil.isNotNull(orderCode)){
			int state=changePayState(orderCode);
			if(state==1){
				result=JsonUtil.getRetMsg(0, "支付状态更新成功");
			}else {          
				result=JsonUtil.getRetMsg(1, "支付状态更新失败");
			}
		}else {
			result=JsonUtil.getRetMsg(2, "订单编号参数不能为空");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	      
	
	
	private int changePayState(String orderCode) {
		isSuccess=PayOrderServer.changePayState(2, sdf.format(new Date()), orderCode);
		return isSuccess;
	}


}

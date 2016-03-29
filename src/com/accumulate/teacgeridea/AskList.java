package com.accumulate.teacgeridea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.accumulate.entity.Ask;
import com.accumulate.service.AskSer;
import com.accumulate.utils.JsonUtil;         
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *  提问列表  whichPage   0   首页数据
 *                    1   所有数据
 *       
 */
@SuppressWarnings("serial")
public class AskList extends HttpServlet {   
	private List<Ask> asks;
	private String result;
	private DataSource source;
	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String page=request.getParameter("page");
		if(StringUtil.isInteger(page)){
			int p=Integer.parseInt(page);
			initAskData(p);
			result=JsonUtil.getObject(asks);
		}else {
			result=JsonUtil.getRetMsg(1,"页数参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	
	
	private void initAskData(int page) {
		asks=AskSer.findAllAsk(page);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doGet(request, response);
	}

}

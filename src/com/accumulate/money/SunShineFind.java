package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.PrivatePlace;
import com.accumulate.service.PrivatePlaceSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         阳光私募 （私募动态）------ 参数 新闻分类id（bigId==3） ------列表页
 */
@SuppressWarnings("serial")
public class SunShineFind extends HttpServlet {
	private List<PrivatePlace> places;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pager = request.getParameter("pager");
		if (StringUtil.isInteger(pager)) {
			int page = Integer.parseInt(pager);
			initPrivateData(page);
			if (places != null && places.size() > 0) {
				result = JsonUtil.getObject(places);
			} else {
				result = JsonUtil.getRetMsg(1, "暂无阳光私募信息");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "页数参数格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initPrivateData(int page) {
		// 初始化私募信息
		places = PrivatePlaceSer.findAll(page);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

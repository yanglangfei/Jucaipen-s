package com.accumulate.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.City;
import com.accumulate.service.CityServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator 查询所有城市信息
 */

@SuppressWarnings("serial")
public class QuerryCity extends HttpServlet {
	private String result;
	private List<City> cities = new ArrayList<City>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String provinceId=request.getParameter("provinceId");
		if(StringUtil.isInteger(provinceId)){
			int pId=Integer.parseInt(provinceId);
			initCityInfo(pId);
			result = JsonUtil.getObject(cities);
		}else {
			result=JsonUtil.getRetMsg(1, "省份id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initCityInfo(int pId) {
		cities.clear();
		cities = CityServer.getCitys(pId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

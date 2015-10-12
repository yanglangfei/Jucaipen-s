package com.accumulate.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Province;
import com.accumulate.service.ProvinceServer;
import com.accumulate.utils.JsonUtil;

/**
 * @author Administrator
 * 
 *         查询省份信息
 * 
 */
@SuppressWarnings("serial")
public class QuerryProvince extends HttpServlet {
	private String result;
	private List<Province> provinces = new ArrayList<Province>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initProvinceInfo();
		result = JsonUtil.getObject(provinces);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initProvinceInfo() {
		provinces.clear();
		provinces = ProvinceServer.getProvinces();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

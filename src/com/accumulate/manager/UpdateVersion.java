package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.ApkInfo;
import com.accumulate.service.ApkInfoServer;
import com.accumulate.utils.JsonUtil;
/**
 * @author YLF
 * 
 *         更新apk版本信息
 * 
 */
@SuppressWarnings("serial")
public class UpdateVersion extends HttpServlet {
	private String result;
	private ApkInfo info;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initServerVersion();
		result = JsonUtil.getApkInfo(info);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initServerVersion() {
		// 获取服务器app最新版本号
		info = ApkInfoServer.findLastApkInfo(-1);
	}

}

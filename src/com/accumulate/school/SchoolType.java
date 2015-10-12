package com.accumulate.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.VideoType;
import com.accumulate.service.VideoTypeSer;
import com.accumulate.utils.JsonUtil;

/**
 * @author YLF
 * 
 *   获取学堂分类信息
 *     ---------parentId=2
 *
 */
@SuppressWarnings("serial")
public class SchoolType extends HttpServlet {
	private List<VideoType> fts;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initData();
		result = JsonUtil.getVideoTypeList(fts);
		out.print(result);
		out.flush();
		out.close();
	}

	private void initData() {
		//获取分类信息
		fts =VideoTypeSer.findVideoTypeByParentId(9);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

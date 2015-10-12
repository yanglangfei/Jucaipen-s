package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.EquityFavorites;
import com.accumulate.service.EquityFavSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         查询股权是否收藏
 * 
 */
@SuppressWarnings("serial")
public class QuerryEquityCollect extends HttpServlet {
	private EquityFavorites equityFavorites;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String equityId = request.getParameter("equityId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if(uId>0){
				if (StringUtil.isInteger(equityId)) {
					int eId = Integer.parseInt(equityId);
					querryEquityCollect(uId, eId);
					if (equityFavorites != null) {
						result = JsonUtil.getRetMsg(0, "股权已被收藏");
					} else {
						result = JsonUtil.getRetMsg(1, "股权未收藏");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "股权id参数数字格式化异常");
				}	
			}else {
				result=JsonUtil.getRetMsg(6,"当前用户还没登录");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "用户id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void querryEquityCollect(int uId, int eId) {
		// 查询指定的股权是否收藏
		equityFavorites = EquityFavSer.findEquityIsCollect(uId, eId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

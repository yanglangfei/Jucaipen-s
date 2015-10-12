package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 *         收藏、取消收藏股权
 * 
 *         type ----0 收藏股权 ----1 取消收藏股权
 * 
 */
@SuppressWarnings("serial")
public class CollectEquity extends HttpServlet {
	private EquityFavorites equityFavorites;
	private EquityFavorites ef;
	private int isSuccess;
	private String result;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		String typeId = request.getParameter("type");
		String userId = request.getParameter("userId");
		String equityId = request.getParameter("equityId");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId >0) {
					if (StringUtil.isInteger(equityId)) {
						int eId = Integer.parseInt(equityId);
						if (type == 0) {
							// 收藏股权
							querryEquityIsCollect(uId, eId);
							if (ef != null) {
								result = JsonUtil.getRetMsg(2, "股权已被收藏");
							} else {
								insertCollectEquity(uId, eId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "股权收藏成功");
								} else {
									result = JsonUtil.getRetMsg(1, "股权收藏失败");
								}
							}
						} else if (type == 1) {
							// 取消收藏股权
							querryEquityIsCollect(uId, eId);
							if (ef != null) {
								cancellCollectEquity(uId, eId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "股权收藏取消成功");
								} else {
									result = JsonUtil.getRetMsg(1, "股权收藏取消失败");
								}
							} else {
								result = JsonUtil.getRetMsg(2, "股权还未收藏");
							}
						}
					} else {
						result = JsonUtil.getRetMsg(5, "股权id参数数字格式化异常");
					}
				} else {
					result = JsonUtil.getRetMsg(6, "当前用户还没登录");
				}

			} else {
				result = JsonUtil.getRetMsg(4, "用户参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "类型参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void cancellCollectEquity(int uId, int eId) {
		// 取消股权收藏
		isSuccess = EquityFavSer.cancelEquity(uId, eId);

	}

	private void querryEquityIsCollect(int uId, int eId) {
		// 查询股权是否收藏
		ef = EquityFavSer.findEquityIsCollect(uId, eId);

	}

	private void insertCollectEquity(int uId, int eId) {
		// 收藏股权
		equityFavorites = new EquityFavorites();
		equityFavorites.setuId(uId);
		equityFavorites.seteId(eId);
		equityFavorites.setDate(sdf.format(new Date()));
		isSuccess = EquityFavSer.insertEquity(uId, equityFavorites);

	}

}

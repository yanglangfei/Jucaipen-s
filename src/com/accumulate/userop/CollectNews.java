package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsFavorites;
import com.accumulate.service.NewsFavoritesSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         收藏、取消收藏新闻
 * 
 *         type ----0 收藏 -----1 取消收藏
 * 
 */
@SuppressWarnings("serial")
public class CollectNews extends HttpServlet {
	private NewsFavorites newsFavorites;
	private NewsFavorites nf;
	private String result;
	private int isSuccess;
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
		String newsId = request.getParameter("newsId");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId>0) {
					if (StringUtil.isInteger(newsId)) {
						int nId = Integer.parseInt(newsId);
						if (type == 0) {
							// 收藏
							nf = newsIsCollect(uId, nId);
							if (nf != null) {
								result = JsonUtil.getRetMsg(1, "该新闻已被收藏");
							} else {
								insertNewsCollect(uId, nId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "新闻收藏成功");
								} else {
									result = JsonUtil.getRetMsg(2, "新闻收藏失败");
								}
							}
						} else if (type == 1) {
							// 取消 收藏
							nf = newsIsCollect(uId, nId);
							if (nf != null) {
								cancellNewsCollect(uId, nId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "新闻收藏取消成功");
								} else {
									result = JsonUtil.getRetMsg(2, "新闻收藏取消失败");
								}
							} else {
								result = JsonUtil.getRetMsg(1, "该新闻还未收藏");
							}
						}

					} else {
						result = JsonUtil.getRetMsg(5, "用户id参数格式化异常");
					}
				} else {
					result = JsonUtil.getRetMsg(6, "当前用户还没登录");
				}

			} else {
				result = JsonUtil.getRetMsg(4, "用户id参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "类型参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void cancellNewsCollect(int uId, int nId) {
		// 取消新闻收藏
		isSuccess = NewsFavoritesSer.cancelNews(uId, nId);
	}

	private NewsFavorites newsIsCollect(int uId, int nId) {
		// 判断新闻是否收藏
		return NewsFavoritesSer.findNewsIsCollect(uId, nId);

	}

	private void insertNewsCollect(int uId, int nId) {
		// 新闻收藏
		newsFavorites = new NewsFavorites();
		newsFavorites.setnId(nId);
		newsFavorites.setuId(uId);
		newsFavorites.setDate(sdf.format(new Date()));
		isSuccess = NewsFavoritesSer.insertNews(uId, newsFavorites);

	}

}

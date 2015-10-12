package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Equity;
import com.accumulate.entity.EquityFavorites;
import com.accumulate.entity.News;
import com.accumulate.entity.NewsFavorites;
import com.accumulate.service.EquityFavSer;
import com.accumulate.service.EquityServer;
import com.accumulate.service.NewServer;
import com.accumulate.service.NewsFavoritesSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         查询我的收藏
 * 
 *         type ----1 资讯收藏 ---2 股权收藏
 * 
 */
@SuppressWarnings("serial")
public class MyCollect extends HttpServlet {
	private String result;
	private List<NewsFavorites> nFavorites = new ArrayList<NewsFavorites>();
	private List<EquityFavorites> eqList = new ArrayList<EquityFavorites>();
	private List<News> news = new ArrayList<News>();
	private List<Equity> equities = new ArrayList<Equity>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String pager = request.getParameter("pager");
		String typeId = request.getParameter("type");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isInteger(typeId)) {
					int type = Integer.parseInt(typeId);
					if (StringUtil.isInteger(pager)) {
						int page = Integer.parseInt(pager);
						if (type == 1) {
							// 资讯收藏
							initNewsData(uId, page);
							result = JsonUtil.getNewsFavoritesList(nFavorites,
									news);
						} else if (type == 2) {
							// 股权收藏
							initEquityData(uId, page);
							if(eqList!=null&&equities!=null){
								result = JsonUtil.getEquityFavoritesList(eqList,
										equities);
							}else {
								result=JsonUtil.getRetMsg(7,"信息获取失败");
							}
							
						}
					} else {
						result = JsonUtil.getRetMsg(1, "参数页数数字格式化异常");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "参数收藏类型数字格式化异常");
				}

			} else {
				result = JsonUtil.getRetMsg(6, "当前用户还没登录");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "参数用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initEquityData(int uId, int page) {
		// 加载收藏股权信息
		eqList.clear();
		equities.clear();
		eqList = EquityFavSer.findEquityByUid(uId, page);
		for (EquityFavorites ef : eqList) {
			int eId = ef.geteId();
			Equity equity = EquityServer.findEquity(eId);
			if(equity!=null){
				equities.add(equity);
			}
		}

	}

	private void initNewsData(int uId, int page) {
		// 加载收藏资讯信息
		nFavorites.clear();
		news.clear();
		nFavorites = NewsFavoritesSer.findNewsFavoByUser(uId, page);
		for (NewsFavorites nf : nFavorites) {
			int newsId = nf.getnId();
			News n = NewServer.findNewsById(newsId);
			if(n!=null){
				news.add(n);
			}
		}
	}

}

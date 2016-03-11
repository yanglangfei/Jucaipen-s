package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.NewsComment;
import com.accumulate.service.NewsCommSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         添加评论----回复评论 
 *         typeId -----分类id 0 新闻评论，回复 1 视频评论，回复
 *         
 *         ParentId    0  评论      非0   回复
 */ 
@SuppressWarnings("serial")
public class RemarkNews extends HttpServlet {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private NewsComment newsComment;
	private int isSuccess;
	private String result;

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
		String typeId = request.getParameter("typeId");
		String userId = request.getParameter("userId");
		String classId = request.getParameter("classId"); 
		String newsId = request.getParameter("newsId");
		String bodys = request.getParameter("bodys");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if(uId>0){
				if (StringUtil.isInteger(classId)) {
					int cId = Integer.parseInt(classId);
					if (StringUtil.isInteger(newsId)) {
						int nId = Integer.parseInt(newsId);
						if (StringUtil.isNotNull(bodys)) {
							if (StringUtil.isInteger(typeId)) {
								int type = Integer.parseInt(typeId);
								if (type == 0 || type == 1) {
									insertRemark(uId, cId, nId, bodys,type);
									if (isSuccess == 1) {
										result = JsonUtil.getRetMsg(0, "评论发表成功");
									} else {
										result = JsonUtil.getRetMsg(1, "评论发表失败");
									}
								} else {
									result = JsonUtil.getRetMsg(4,
											"参数typeId必须为0或者1");
								}
							} else {
								result = JsonUtil.getRetMsg(5, "typeId参数数字格式化异常");
							}
						}
					} else {
						result = JsonUtil.getRetMsg(3, "新闻id参数数字格式化异常");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "新闻分类id参数数字格式化异常");
				}
				
			}else {
				result=JsonUtil.getRetMsg(7,"当前用户还没登录");
			}
		} else {
			result = JsonUtil.getRetMsg(6, "用户id参数数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param uId
	 * @param cId
	 * @param nId
	 * @param bodys
	 * 
	 *            添加评论
	 */
	private void insertRemark(int uId, int cId, int nId, String bodys,int commType) {
		newsComment = new NewsComment();
		newsComment.setuId(uId);
		newsComment.setBodys(bodys);
		newsComment.setnId(nId);
		newsComment.setInsertDate(sdf.format(new Date()));
		newsComment.setRepCount(0);
		newsComment.setGoodNum(0);
		newsComment.setCommType(commType);
		isSuccess = NewsCommSer.insertNewsComm(uId, newsComment);
	}

}

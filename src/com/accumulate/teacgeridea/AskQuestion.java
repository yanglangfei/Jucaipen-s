package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Ask;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.SiteConfig;
import com.accumulate.service.AskSer;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.SiteConfigSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         咨询名师
 */
@SuppressWarnings("serial")
public class AskQuestion extends HttpServlet {
	private int isSuccess;
	private String result;
	private String ip;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int totleAskNum;
	private int currentAskNum;
 
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
		String askType = request.getParameter("questionType");
		String userId = request.getParameter("userId");
		String askBodys = request.getParameter("askBodys");
		String teacherId = request.getParameter("teacherId");
		ip = request.getRemoteAddr();
		if (StringUtil.isInteger(userId)) {
			// 用户id格式正确
			int uId = Integer.parseInt(userId);

			if (StringUtil.isInteger(teacherId)) {
				// 讲师id数字格式化正确
				int tId = Integer.parseInt(teacherId);
				initMaxAskNum(uId, tId);
				// 判断提问数量是否超出限制的提问数
				if (currentAskNum < totleAskNum) {
					if (tId > 0) {
						if (StringUtil.isInteger(askType)) {
							// 提问类型数字格式化正确
							if (StringUtil.isNotNull(askBodys)) {
								int type = Integer.parseInt(askType);
								if (type > 0) {
									createAskModel(uId, tId, type, askBodys);
									if (isSuccess == 1) {
										result = JsonUtil.getRetMsg(0,
												"咨询信息提交成功");
									} else {
										result = JsonUtil.getRetMsg(1,
												"咨询信息提交失败");
									}
								} else {
									result = JsonUtil.getRetMsg(6, "分类id找不到");
								}
							} else {
								result = JsonUtil.getRetMsg(5, "咨询内容不能为空");
							}

						} else {
							// 提问类型数字格式化异常
							result = JsonUtil.getRetMsg(2, "咨询分类参数数字格式化异常");
						}

					} else {
						result = JsonUtil.getRetMsg(7, "讲师id异常");
					}

				} else {
					result = JsonUtil.getRetMsg(8, "您的提问数已经超出限制");
				}
			} else {
				// 讲师id数字格式化异常
				result = JsonUtil.getRetMsg(3, "讲师id数字格式化异常");
			}
		} else {
			// 用户id数字格式化异常
			result = JsonUtil.getRetMsg(4, "用户id数字格式化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initMaxAskNum(int uId, int tId) {
		// 获取最大提问数和当前已经提问的数量
		FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
		int askNum = teacher.getAskNum();
		if (askNum == 0) {
			SiteConfig config = SiteConfigSer.findSiteConfig();
			totleAskNum = config.getAskNum();
			currentAskNum = AskSer.findAskNumByUid(uId);
		} else {
			currentAskNum = askNum;
		}
	}

	private void createAskModel(int uId, int tId, int type, String askBodys) {
		Ask ask = new Ask();
		ask.setUserId(uId);
		ask.setTeacherId(tId);
		ask.setClassId(type);
		ask.setAskBody(askBodys);
		ask.setAskDate(sdf.format(new Date()));
		ask.setHits(0);
		ask.setIp(ip);
		ask.setIsReply(2);
		ask.setParentId(0);
		ask.setAskState(2);
		isSuccess = AskSer.insertAsk(ask);

	}

}

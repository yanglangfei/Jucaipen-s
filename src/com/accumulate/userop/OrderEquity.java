package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.service.OrderEquityServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         预约、取消股权
 * 
 *         type-----股权操作类型 （1 预定 2 取消预定）
 *         
 *         orderType=1  预约股权项目
 *         orderType=2  预约私募项目
 * 
 * 
 *         ----参数： userId(用户id) trueName(用户真实姓名) MobileNum(手机号) Remark(备注)
 *         TouziMoney(投资金额) ItemId(股份id)
 * 
 */
@SuppressWarnings("serial")
public class OrderEquity extends HttpServlet {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String result;
	private String orderDate;
	private int uId;
	private int eId;
	private int isSuccess;
	private com.accumulate.entity.OrderEquity oe;
	private int oType;
	private String ip;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String userId = request.getParameter("userId");
		String equityId = request.getParameter("equityId");
		String orderType=request.getParameter("orderType");
		ip = request.getRemoteAddr();
		if(StringUtil.isInteger(orderType)){
			oType=Integer.parseInt(orderType);
			if(oType==1||oType==2){
				if (StringUtil.isInteger(type)) {
					int tp = Integer.parseInt(type);
					if (StringUtil.isInteger(equityId)) {
						eId = Integer.parseInt(equityId);
						if (StringUtil.isInteger(userId)) {
							uId = Integer.parseInt(userId);
							if(uId>0){
								if (tp == 1) {
									// 预约股权
									com.accumulate.entity.OrderEquity oe = checkData(request,out);
									if(oe!=null){
										isSuccess = orderEquity(oe, uId);
										if (isSuccess == 1) {
											result = JsonUtil.getRetMsg(0, "预约股权成功");
										} else {
											result = JsonUtil.getRetMsg(8, "预约股权失败");
										}
									}
								} else if (tp == 2) {
									// 取消股权预约信息
									cancelEquity(eId, uId,oType);
								}
							}else {
								result=JsonUtil.getRetMsg(4,"当前用户还没登录");
							}
							
						} else {
							result = JsonUtil.getRetMsg(3, "用户id数字参数格式化异常");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "股权id数字格式化异常");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "类型参数数字格式化异常");
				}
			}else {
				result=JsonUtil.getRetMsg(5, "预约类型参数只能是1或者2");
			}
		}else {
			result=JsonUtil.getRetMsg(6, "预约类型参数数字格式化异常");
		}
		
		
		
		
		out.print(result);

		out.flush();
		out.close();
	}

	private com.accumulate.entity.OrderEquity checkData(
			HttpServletRequest request,PrintWriter out) {
		orderDate = sdf.format(new Date());
		String trueName = request.getParameter("trueName");
		String mobileNum = request.getParameter("telPhone");
		String remark = request.getParameter("remark");
		String touziMoney = request.getParameter("touziMoney");
		if (StringUtil.isNotNull(mobileNum)
				&& StringUtil.isMobileNumber(mobileNum)) {
			oe = new com.accumulate.entity.OrderEquity();
			oe.seteId(eId);
			oe.setuIp(ip);
			oe.setInsertDate(orderDate);
			oe.setMobileNum(mobileNum);
			oe.setuId(uId);
			oe.setTrueName(trueName);
			oe.setTouziMoney(touziMoney);
			oe.setOrderType(oType);
			oe.setRemark(remark);
			return oe;
		}else {
			result=JsonUtil.getRetMsg(5,"非法手机号");
			return null;
		}
	}

	private int cancelEquity(int eId, int uId,int oType) {
		// 取消预约股权信息
		return OrderEquityServer.cancenOrder(eId, uId,oType);
	}

	private int orderEquity(com.accumulate.entity.OrderEquity oe, int uId) {
		// 预约股权信息
		return OrderEquityServer.insertOrder(uId, oe);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

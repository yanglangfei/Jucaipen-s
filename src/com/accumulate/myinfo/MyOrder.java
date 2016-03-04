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
import com.accumulate.entity.OrderEquity;
import com.accumulate.entity.PrivatePlace;
import com.accumulate.service.EquityServer;
import com.accumulate.service.OrderEquityServer;
import com.accumulate.service.PrivatePlaceSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ѯ�ҵ�ԤԼ
 */
@SuppressWarnings("serial")
public class MyOrder extends HttpServlet {
	private List<OrderEquity> qList = new ArrayList<OrderEquity>();
	private String result;
	private List<String> orderName=new ArrayList<String>();

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
		String userId = request.getParameter("userId");
		String pager = request.getParameter("pager");
		if (StringUtil.isInteger(userId)) {
			int id = Integer.parseInt(userId);
			if (id > 0) {
				if (StringUtil.isInteger(pager)) {
					int page = Integer.parseInt(pager);
					initMyOrderInfo(id, page);
					if(qList!=null&&orderName!=null){
						result = JsonUtil.getMyOrderList(qList, orderName);
					}else {
						result=JsonUtil.getRetMsg(6, "��ȡ��Ϣʧ��");
					}
					
				} else {
					result = JsonUtil.getRetMsg(1, "ҳ��������ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(5, "��ǰ�û���û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(2, "�û�id������ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initMyOrderInfo(int id, int pager) {
		String name = "";
		qList = OrderEquityServer.findOrder(id, pager);
		for (OrderEquity oe : qList) {
			int eId=oe.geteId();
			int oType=oe.getOrderType();
			if(oType==1){
				//ԤԼ��Ȩ��Ŀ
				Equity equity = EquityServer.findEquity(eId);
				if(equity!=null){
					name=equity.getSimpleName();
				}else {
					name="";
				}
			}else if(oType==2){
				//ԤԼ˽ļ��Ȩ
				PrivatePlace pp=PrivatePlaceSer.findPrivatePlaceById(eId);
				if(pp!=null){
					name=pp.getTitle();
				}else {
					name="";
				}
			}else {
				name="";
			}
			orderName.add(name);
		}

	}

}

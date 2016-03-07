package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.LoginUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         完善个人信息、编辑个人信息
 * 
 */
@SuppressWarnings("serial")
public class CompleteInfo extends HttpServlet {
	// 修改个人信息
	private String upDatePath = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=Useredit";
	private String result;
//	private User user;
	private int province;
	private int city;
	private int area;
	private int uId;
	private Map<String, String> para = new HashMap<String, String>();

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
		String id = request.getParameter("id");
		String nickName = request.getParameter("nikeName");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String bodys = request.getParameter("bodys");
		String birth = request.getParameter("birthday");
		String localProvince = request.getParameter("localProvince");
		String localCity = request.getParameter("localCity");
		String localArea = request.getParameter("localArea");
		if (!StringUtil.isMail(email)) {
			result = JsonUtil.getRetMsg(9, "邮箱格式不符合要求");
			out.print(result);
			return;
		}
		if (!StringUtil.isInteger(id)) {
			result = JsonUtil.getRetMsg(1, "用户id数字格式化失败");
		} else {
			uId = Integer.parseInt(id);
			if (uId > 0) {
				para.put("userid", uId + "");
				if (StringUtil.isNotNull(birth)) {
					para.put("ages", birth);
				}
				if (StringUtil.isNotNull(bodys)) {
					para.put("resume", bodys);
				}
				if (StringUtil.isNotNull(email)) {
					para.put("email", email);
				}
				if (StringUtil.isNotNull(nickName)) {
					para.put("name", nickName);
				}
				if (StringUtil.isNotNull(sex)) {
					para.put("sex", sex);
				}
				if (StringUtil.isNotNull(localProvince)
						&& StringUtil.isInteger(localProvince)) {
					province = Integer.parseInt(localProvince);
				} else {
					province = 0;
				}
				if (StringUtil.isNotNull(localCity)
						&& StringUtil.isInteger(localCity)) {
					city = Integer.parseInt(localCity);
				} else {
					city = 0;
				}
				if (StringUtil.isNotNull(localArea)
						&& StringUtil.isInteger(localArea)) {
					area = Integer.parseInt(localArea);
				} else {
					area = 0;
				}
				para.put("address", province + "-" + city + "-" + area);
				result = completeUserInfo(uId, para);
			} else {
				result = JsonUtil.getRetMsg(4, "当前用户还没登录");
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}

	// 提交个人信息
	private String completeUserInfo(int uId, Map<String, String> p) {
		String resJson = LoginUtil.sendHttpPost(upDatePath, p);
		if (resJson!=null&&resJson.length() > 0) {
			JSONObject object = new JSONObject(resJson);
			boolean isRes = object.getBoolean("Result");
			if (isRes) {
				return JsonUtil.getRetMsg(0, "个人资料修改成功");
			}
			String msg = object.getString("Msg");
			return JsonUtil.getRetMsg(5, msg);
		}
		return JsonUtil.getRetMsg(6, "提交失败");
		
	}

}

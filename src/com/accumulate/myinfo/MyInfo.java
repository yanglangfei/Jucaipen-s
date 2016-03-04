package com.accumulate.myinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.Area;
import com.accumulate.entity.City;
import com.accumulate.entity.Province;
import com.accumulate.entity.User;
import com.accumulate.service.AreaServer;
import com.accumulate.service.CityServer;
import com.accumulate.service.ProvinceServer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.LoginUtil;
import com.accumulate.utils.StringUtil;
import com.accumulate.utils.TimeUtils;

/**
 * @author YLF
 * 
 *         个人资料查询
 * 
 */
@SuppressWarnings("serial")
public class MyInfo extends HttpServlet {
	//解析手机号   参数（mobilenum）
	private String parsePhoneNum="http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetDecryptMobileNum";
	private User user;
	private String result;
	private String localProvince;
	private String localCity;
	private String localArea;
	private int age;
	private Map<String, String> param=new HashMap<String, String>();
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		if (StringUtil.isInteger(id)) {
			int Id = Integer.parseInt(id);
			if(Id>0){
				initUserData(Id);
				if (user != null) {
					result = JsonUtil.getUserInfo(user,localProvince,localCity,localArea);
				} else {
					result = JsonUtil.getRetMsg(1, "用户信息不存在");
				}
			}else {
				result=JsonUtil.getRetMsg(5,"当前用户还没登录");
			}
			
		} else {
			result = JsonUtil.getRetMsg(2, "用户id数字化异常");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initUserData(int id) {
		user = UserServer.findUserById(id);
		String tel=user.getMobileNum();
		String birth=user.getBirthday();
		if(tel!=null){
			//解密
			param.put("mobilenum", tel);
			String resJson=LoginUtil.sendHttpPost(parsePhoneNum, param);
			org.json.JSONObject object=new org.json.JSONObject(resJson);
			boolean isParse=object.getBoolean("Result");
			if(isParse){
				String mobile=object.getString("MobileNum");
				user.setMobileNum(mobile);
			}
		}
		if(birth!=null){
			user.setBirthday(birth);
		    age=TimeUtils.getAge(birth);
		}
		user.setAge(age);
		int provinceId=user.getLocalProvince();
		int cityId=user.getLocalCity();
		int areaId=user.getLocalArea();
		if(provinceId!=0){
			//获取所在省份信息
			initProvinceInfo(provinceId);
		}else {
			localProvince="";
		}
		if(cityId!=0){
			//获取所在城市信息
			initCityInfo(cityId);
		}else {
			localCity="";
		}
		if(areaId!=0){
			//获取所在区域信息
			initAreaInfo(areaId);
		}else {
			localArea="";
		}
	}

	private void initAreaInfo(int areaId) {
		Area area=AreaServer.getArea(areaId);
		localArea=area.getName();
		
	}

	private void initCityInfo(int cityId) {
		City city=CityServer.getCity(cityId);
		localCity=city.getName();
		
	}

	private void initProvinceInfo(int provinceId) {
		Province province=ProvinceServer.getProvince(provinceId);
		localProvince=province.getName();
	}

}

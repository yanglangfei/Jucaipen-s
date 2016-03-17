package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *         用户
 * 
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	/**
	 * 对应用户表 ChatType 字段  （1   聚财盆用户    2   金刚用户   不能进直播间  必须扫二维码进入   0  普通用户）
	 */
	private int userType;
	/**
	 * 用户信息当前页
	 */
	private int page;
	/**
	 * 用户信息总页数
	 */
	private int totlePage;
	
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 用户账号
	 */
	private String userName;
	/**
	 * 用户年龄
	 */
	private int age;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * Email
	 */
	private String email;
	/**
	 * 用户头像
	 */
	private String faceImage;
	/**
	 * 手机号
	 */
	private String mobileNum;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 家乡（省）
	 */
	private int homeProvince;
	/**
	 * 家乡（市）
	 */
	private int homeCity;
	/**
	 * 家乡（区）
	 */
	private int homeArea;
	/**
	 * 所在省份
	 */
	private int localProvince;
	/**
	 * 所在城市
	 */
	private int localCity;
	/**
	 * 所在区
	 */
	private int localArea;
	/**
	 * 个人描述
	 */
	private String descript;
	/**
	 * 注册时间
	 */
	private String regDate;
	/**
	 * 帐号状态（0正常 1锁定 4删除）
	 */
	private int isLock;
	/**
	 * 绑定微博id
	 */
	private String weiBoId;
	/**
	 * qq绑定id
	 */
	private String qqId;
	/**
	 * 微信绑定id
	 */
	private String weiXinId;
	/**
	 * 是否完成邮箱验证（0 未完成 1 已完成）
	 */
	private int isChechEmail;
	/**
	 * 是否完成手机验证（0 未完成 1已完成）
	 */
	private int isChechMobile;
	/**
	 * 注册ip
	 */
	private String regIp;
	private int isFree;
	private String serverStartDate;
	private String serverEndDate;
	private int isStop;
	private int serverId;
	private int isRoomManager;
	private int buyProductId;
	
	
	
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	/**
	 * 注册来源  （1：网站PC；2：手机网站；3：直播室PC；4：直播室手机；5：APP）
	 */
	private int RegFrom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaceImage() {
		return faceImage;
	}

	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getHomeProvince() {
		return homeProvince;
	}

	public void setHomeProvince(int homeProvince) {
		this.homeProvince = homeProvince;
	}

	public int getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(int homeCity) {
		this.homeCity = homeCity;
	}

	public int getHomeArea() {
		return homeArea;
	}

	public void setHomeArea(int homeArea) {
		this.homeArea = homeArea;
	}

	public int getLocalProvince() {
		return localProvince;
	}

	public void setLocalProvince(int localProvince) {
		this.localProvince = localProvince;
	}

	public int getLocalCity() {
		return localCity;
	}

	public void setLocalCity(int localCity) {
		this.localCity = localCity;
	}

	public int getLocalArea() {
		return localArea;
	}

	public void setLocalArea(int localArea) {
		this.localArea = localArea;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getIsLock() {
		return isLock;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}

	public String getWeiBoId() {
		return weiBoId;
	}

	public void setWeiBoId(String weiBoId) {
		this.weiBoId = weiBoId;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String getWeiXinId() {
		return weiXinId;
	}

	public void setWeiXinId(String weiXinId) {
		this.weiXinId = weiXinId;
	}

	public int getIsChechEmail() {
		return isChechEmail;
	}

	public void setIsChechEmail(int isChechEmail) {
		this.isChechEmail = isChechEmail;
	}

	public int getIsChechMobile() {
		return isChechMobile;
	}

	public void setIsChechMobile(int isChechMobile) {
		this.isChechMobile = isChechMobile;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public int getIsFree() {
		return isFree;
	}

	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}

	public String getServerStartDate() {
		return serverStartDate;
	}

	public void setServerStartDate(String serverStartDate) {
		this.serverStartDate = serverStartDate;
	}

	public String getServerEndDate() {
		return serverEndDate;
	}

	public void setServerEndDate(String serverEndDate) {
		this.serverEndDate = serverEndDate;
	}

	public int getIsStop() {
		return isStop;
	}

	public void setIsStop(int isStop) {
		this.isStop = isStop;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public int getIsRoomManager() {
		return isRoomManager;
	}

	public void setIsRoomManager(int isRoomManager) {
		this.isRoomManager = isRoomManager;
	}

	public int getBuyProductId() {
		return buyProductId;
	}

	public void setBuyProductId(int buyProductId) {
		this.buyProductId = buyProductId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRegFrom() {
		return RegFrom;
	}

	public void setRegFrom(int regFrom) {
		RegFrom = regFrom;
	}
	

}

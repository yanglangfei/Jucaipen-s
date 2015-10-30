package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *    推荐名师
 */
@SuppressWarnings("serial")
public class FamousTeacher implements Serializable{
	/**
	 * 讲师当前页数
	 */
	private int page;
	/**
	 * 讲师总页数
	 */
	private int totlePage;
	/**
	 * 教师id
	 */
	private int id;
	/**
	 * 登录账号
	 */
	private String account;
	/**
	 * 登录密码
	 */
	private String loginPwd;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 头像
	 */
	private String headFace;
	/**
	 * 头衔
	 */
	private String level;
	/**
	 * 是否加V
	 */
	private int isV;
	/**
	 * 粉丝数量
	 */
	private int fans;
	/**
	 * 直播人气
	 */
	private int liveFans;
	/**
	 * 回复问题数
	 */
	private int answerCount;
	/**
	 * 日志数
	 */
	private int articleCount;
	/**
	 * 日志阅读量
	 */
	private int articleReadCount;
	/**
	 * 日志点赞数
	 */
	private int articleGood;
	/**
	 * 公告
	 */
	private String notice;
	/**
	 * 教师简介
	 */
	private String introduce;
	/**
	 * 擅长领域
	 */
	private String hoby;
	/**
	 * 手机号
	 */
	private String telPhone;
	/**
	 * 服务人数
	 */
	private int serverCount;
	/**
	 * 账号状态
	 */
	private int state;
	/**
	 * 加入时间
	 */
	private String joinDate;
	/**
	 * 最近登录时间
	 */
	private String lastLoginDate;
	/**
	 * 最近登录ip
	 */
	private String lastLoginIp;
	/**
	 * 直播互动是否需要审核
	 */
	private int liveGbookIsPass;
	private int userId;
	/*
	 * 提问人数 
	 */
	private int askNum;
	
	public FamousTeacher() {
		super();
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
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
	public String getHeadFace() {
		return headFace;
	}
	public void setHeadFace(String headFace) {
		this.headFace = headFace;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getIsV() {
		return isV;
	}
	public void setIsV(int isV) {
		this.isV = isV;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getLiveFans() {
		return liveFans;
	}
	public void setLiveFans(int liveFans) {
		this.liveFans = liveFans;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public int getArticleReadCount() {
		return articleReadCount;
	}
	public void setArticleReadCount(int articleReadCount) {
		this.articleReadCount = articleReadCount;
	}
	public int getArticleGood() {
		return articleGood;
	}
	public void setArticleGood(int articleGood) {
		this.articleGood = articleGood;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public int getServerCount() {
		return serverCount;
	}
	public void setServerCount(int serverCount) {
		this.serverCount = serverCount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public int getLiveGbookIsPass() {
		return liveGbookIsPass;
	}
	public void setLiveGbookIsPass(int liveGbookIsPass) {
		this.liveGbookIsPass = liveGbookIsPass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

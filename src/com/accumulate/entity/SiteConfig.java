package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *
 *   APP配置信息  接口调用配置
 */
@SuppressWarnings("serial")
public class SiteConfig implements Serializable{
	
	private String siteTitle;
	
	private String keyWord;
	
	private String descript;
	/**
	 * 站点是否关闭（0为正常，1为关闭）
	 */
	private int isClose;
	/**
	 *  站点关闭提示信息
	 */
	private String closeMsg;
	/**
	 * 是否停止注册（1为停止注册0为正常注册）
	 */
	private int isReg;
	/**
	 * 停止用户注册显示信息
	 */
	private String stopRegMsg;
	
	private String icp;
	/**
	 *   版权信息
	 */
	private String copyRight;
	/**
	 * 页面状态(0为动态,1为伪静态,2为静态)
	 */
	private int pageType;
	/**
	 * 评论状态（0无需审核，1需要审核）
	 */
	private int commType;
	/**
	 * 评论回复状态（0无需审核，1需要审核）
	 */
	private int commRespType;
	private String siteName;
	/**
	 *  预约通知邮箱
	 */
	private String orderNoticeEmail;
	/**
	 *  提问的最大数量
	 */
	private int askNum;
	public String getSiteTitle() {
		return siteTitle;
	}
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getIsClose() {
		return isClose;
	}
	public void setIsClose(int isClose) {
		this.isClose = isClose;
	}
	public String getCloseMsg() {
		return closeMsg;
	}
	public void setCloseMsg(String closeMsg) {
		this.closeMsg = closeMsg;
	}
	public int getIsReg() {
		return isReg;
	}
	public void setIsReg(int isReg) {
		this.isReg = isReg;
	}
	public String getStopRegMsg() {
		return stopRegMsg;
	}
	public void setStopRegMsg(String stopRegMsg) {
		this.stopRegMsg = stopRegMsg;
	}
	public String getIcp() {
		return icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public int getPageType() {
		return pageType;
	}
	public void setPageType(int pageType) {
		this.pageType = pageType;
	}
	public int getCommType() {
		return commType;
	}
	public void setCommType(int commType) {
		this.commType = commType;
	}
	public int getCommRespType() {
		return commRespType;
	}
	public void setCommRespType(int commRespType) {
		this.commRespType = commRespType;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getOrderNoticeEmail() {
		return orderNoticeEmail;
	}
	public void setOrderNoticeEmail(String orderNoticeEmail) {
		this.orderNoticeEmail = orderNoticeEmail;
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	

}

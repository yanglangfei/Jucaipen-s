package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *         股权
 */
@SuppressWarnings("serial")
public class Equity implements Serializable {
	/**
	 *  股权信息当前页
	 */
	private int pager;
	/**
	 *   股权信息总页数
	 */
	private int totlePager;
	
	/**
	 * 股权id
	 */
	private int id;
	/**
	 * 名称
	 */
	private String ownName;
	/**
	 * 简称
	 */
	private String simpleName;

	/**
	 * 推荐机构
	 */
	private String recommender;
	/**
	 * 股份代码
	 */
	private String equityCode;
	/**
	 * 股本总数
	 */
	private String capitalization;
	/**
	 * 转让股数-----投资年限
	 */
	private String transferNum;
	/**
	 * 拟转让价格
	 */
	private String intendsTransfer;
	/**
	 * 投资门槛
	 */
	private String investmentThreshold;
	/**
	 * 每股收益
	 */
	private String eps;
	/**
	 * 每股净资产
	 */
	private String bvps;
	/**
	 * 净利润
	 */
	private String netProfit;
	/**
	 * 挂牌地点
	 */
	private String onSite;
	/**
	 * 所属行业
	 */
	private String industry;
	/**
	 * 有限公司成立日期
	 */
	private String limitedDate;
	/**
	 * 股份公司成立日期
	 */
	private String corporationDate;
	/**
	 * 注册地
	 */
	private String domicile;
	/**
	 * 公司简介
	 */
	private String companyIntroduction;
	/**
	 * 退出方式
	 */
	private String exitWay;
	/**
	 * 是否推荐
	 */
	private int isRecomment;
	/**
	 * 是否置顶
	 */
	private int isTop;
	/**
	 * 资金流向
	 */
	private String fundFlow;
	/**
	 * 发行日期
	 */
	private String releaseDate;
	/**
	 * 产品状态
	 */
	private String productState;
	/**
	 * 资金流动情况
	 */
	private String cashFlow;
	/**
	 * 收益类型
	 */
	private String incomeType;
	/**
	 * 期限类型
	 */
	private String deadlineType;
	/**
	 * 投资方向
	 */
	private String investOrientat;
	/**
	 * 营业收入
	 */
	private String revenue;
	/**
	 * 营业收入增长率
	 */
	private String incomeRate;
	/**
	 * 利润增长率-----年收益
	 */
	private String profitRate;
	/**
	 *   股权图片URL
	 */
	private String equityImage;
    
	public String getEquityImage() {
		return equityImage;
	}

	public void setEquityImage(String equityImage) {
		this.equityImage = equityImage;
	}

	public String getOwnName() {
		return ownName;
	}

	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getEquityCode() {
		return equityCode;
	}

	public void setEquityCode(String equityCode) {
		this.equityCode = equityCode;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}

	public String getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(String capitalization) {
		this.capitalization = capitalization;
	}

	public String getIntendsTransfer() {
		return intendsTransfer;
	}

	public void setIntendsTransfer(String intendsTransfer) {
		this.intendsTransfer = intendsTransfer;
	}

	public String getInvestmentThreshold() {
		return investmentThreshold;
	}

	public void setInvestmentThreshold(String investmentThreshold) {
		this.investmentThreshold = investmentThreshold;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getBvps() {
		return bvps;
	}

	public void setBvps(String bvps) {
		this.bvps = bvps;
	}

	public String getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(String netProfit) {
		this.netProfit = netProfit;
	}

	public String getOnSite() {
		return onSite;
	}

	public void setOnSite(String onSite) {
		this.onSite = onSite;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLimitedDate() {
		return limitedDate;
	}

	public void setLimitedDate(String limitedDate) {
		this.limitedDate = limitedDate;
	}

	public String getCorporationDate() {
		return corporationDate;
	}

	public void setCorporationDate(String corporationDate) {
		this.corporationDate = corporationDate;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getCompanyIntroduction() {
		return companyIntroduction;
	}

	public void setCompanyIntroduction(String companyIntroduction) {
		this.companyIntroduction = companyIntroduction;
	}

	public String getExitWay() {
		return exitWay;
	}

	public void setExitWay(String exitWay) {
		this.exitWay = exitWay;
	}

	public int getIsRecomment() {
		return isRecomment;
	}

	public void setIsRecomment(int isRecomment) {
		this.isRecomment = isRecomment;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public String getFundFlow() {
		return fundFlow;
	}

	public void setFundFlow(String fundFlow) {
		this.fundFlow = fundFlow;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getCashFlow() {
		return cashFlow;
	}

	public void setCashFlow(String cashFlow) {
		this.cashFlow = cashFlow;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getDeadlineType() {
		return deadlineType;
	}

	public void setDeadlineType(String deadlineType) {
		this.deadlineType = deadlineType;
	}

	public String getInvestOrientat() {
		return investOrientat;
	}

	public void setInvestOrientat(String investOrientat) {
		this.investOrientat = investOrientat;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(String incomeRate) {
		this.incomeRate = incomeRate;
	}

	public String getProfitRate() {
		return profitRate;
	}

	public void setProfitRate(String profitRate) {
		this.profitRate = profitRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getPager() {
		return pager;
	}

	public void setPager(int pager) {
		this.pager = pager;
	}

	public int getTotlePager() {
		return totlePager;
	}

	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	

}

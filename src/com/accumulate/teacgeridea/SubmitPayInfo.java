package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.PayOrder;
import com.accumulate.entity.PayProduct;
import com.accumulate.service.PayOrderServer;
import com.accumulate.service.PayProductServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 * 
 *         �ύ������Ϣ ���� productType 1 ����ֱ�� 2 ǩԼ��ʦ originPrice userId teacherId
 *         liveId orderCode title allMoney payModel ֧����ʽ 1��֧������2��΢��֧����3���ױ�֧��
 */
@SuppressWarnings("serial")
public class SubmitPayInfo extends HttpServlet {
	private String result;
	private int isSuccess;
	private int isItemSuccess;
	private static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	private SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String productType = request.getParameter("productType");
		String orderCode = request.getParameter("orderCode");
		String productId = request.getParameter("productId");
		String newPrice = request.getParameter("newPrice");
		String title = request.getParameter("title");
		String payModel = request.getParameter("payModel");
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (StringUtil.isNotNull(orderCode)) {
				if (StringUtil.isInteger(productId)) {
					int pId = Integer.parseInt(productId);
					if (StringUtil.isNotNull(newPrice)) {
						if (StringUtil.isNotNull(title)) {
							if (StringUtil.isInteger(payModel)) {
								int pModel = Integer.parseInt(payModel);
								if (StringUtil.isInteger(teacherId)) {
									int tId = Integer.parseInt(teacherId);
									if (StringUtil.isInteger(productType)) {
										int pType = Integer
												.parseInt(productType);
										// pType
										if (pType == 1) {
											// 1 ����ֱ��
											// orderCode pId newPrice title
											// ptype uId pModel tId
											submitTxtLiveOrderInfo(orderCode,
													pId, newPrice, title,
													pType, uId, pModel, tId);
											if (isSuccess == 1
													&& isItemSuccess == 1) {
												result = JsonUtil.getRetMsg(0,
														"�����ύ�ɹ�");
											} else {
												result = JsonUtil.getRetMsg(1,
														"�����ύʧ��");
											}

										} else if (pType == 2) {
											// ��Լ��Ʒ
											// orderCode pId price newPrice
											// title xy xm xd ptype uId pModel
											// tId
											String originPrice = request
													.getParameter("originPrice");
											String xuYueYear = request
													.getParameter("xuYueYear");
											String xuYueMonth = request
													.getParameter("xuYueMonth");
											String xuYueDay = request
													.getParameter("xuYueDay");
											if (StringUtil
													.isNotNull(originPrice)) {

												if (StringUtil
														.isInteger(xuYueYear)) {

													int year = Integer
															.parseInt(xuYueYear);
													if (StringUtil
															.isInteger(xuYueMonth)) {
														int month = Integer
																.parseInt(xuYueMonth);
														if (StringUtil
																.isInteger(xuYueDay)) {
															int day = Integer
																	.parseInt(xuYueDay);
															submitSignOrderInfo(
																	orderCode,
																	pId,
																	originPrice,
																	newPrice,
																	title,
																	year,
																	month, day,
																	pType, uId,
																	pModel, tId);
															if (isSuccess == 1
																	&& isItemSuccess == 1) {
																result = JsonUtil
																		.getRetMsg(
																				0,
																				"�����ύ�ɹ�");
															} else {
																result = JsonUtil
																		.getRetMsg(
																				1,
																				"�����ύʧ��");
															}
														} else {
															result = JsonUtil
																	.getRetMsg(
																			13,
																			"��Լ�������ָ�ʽ���쳣");
														}

													} else {
														result = JsonUtil
																.getRetMsg(12,
																		"��Լ�������ָ�ʽ���쳣");
													}

												} else {
													result = JsonUtil
															.getRetMsg(11,
																	"��Լ�������ָ�ʽ���쳣");
												}

											} else {
												result = JsonUtil.getRetMsg(10,
														"ԭ�۲���Ϊ��");
											}

										} else {
											result = JsonUtil.getRetMsg(9,
													"��Ʒ���಻����Ҫ��");
										}
									} else {
										result = JsonUtil.getRetMsg(8,
												"��Ʒ����������ָ�ʽ���쳣");
									}

								} else {
									result = JsonUtil.getRetMsg(7,
											"��ʦid���ָ�ʽ���쳣");
								}

							} else {
								result = JsonUtil.getRetMsg(6, "֧����ʽ���ָ�ʽ���쳣");
							}

						} else {
							result = JsonUtil.getRetMsg(5, "�������ⲻ��Ϊ��");
						}

					} else {
						result = JsonUtil.getRetMsg(4, "�ּ۲�������Ϊ��");
					}

				} else {
					result = JsonUtil.getRetMsg(3, "��Ʒid�������ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(2, "�����Ų���Ϊ��");
			}

		} else {
			result = JsonUtil.getRetMsg(6, "�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param orderCode
	 * @param pId
	 * @param originPrice
	 * @param newPrice
	 * @param title
	 * @param year
	 * @param month
	 * @param day
	 * @param pType
	 * @param uId
	 * @param payModel
	 * @param tId
	 * 
	 *            ���ǩԼ������Ϣ
	 */
	private void submitSignOrderInfo(String orderCode, int pId,
			String originPrice, String newPrice, String title, int year,
			int month, int day, int pType, int uId, int payModel, int tId) {
		PayOrder payOrder = new PayOrder();
		payOrder.setUserId(uId);
		payOrder.setTitle(title);
		payOrder.setFromTeacherId(tId);
		payOrder.setAllMoney(newPrice);
		payOrder.setPayMoney(0 + "");
		payOrder.setPayModel(payModel);
		payOrder.setPayState(1);
		payOrder.setInsertDate(sdf.format(new Date()));
		payOrder.setFromTeacherId(tId);
		payOrder.setIsDelete(1);
		payOrder.setOrderCode(orderCode);
		isSuccess = PayOrderServer.addPayOrder(payOrder);
		PayProduct payProduct = new PayProduct();
		payProduct.setOrderId(orderCode);
		payProduct.setProductId(pId);
		payProduct.setPrice(originPrice);
		payProduct.setNowPrice(newPrice);
		payProduct.setBuyCount(0);
		payProduct.setAllMoney(newPrice);
		payProduct.setProductTitle(title);
		payProduct.setXuYueYear(year);
		payProduct.setXuYueMonth(month);
		payProduct.setXuYueDay(day);
		payProduct.setIsDelete(1);
		payProduct.setProductType(pType);
		payProduct.setUserId(uId);
		isItemSuccess = PayProductServer.addPayProductInfo(payProduct);
	}

	/**
	 * @param orderCode
	 * @param pId
	 * @param newPrice
	 * @param title
	 * @param pType
	 * @param uId
	 * @param pModel
	 * @param tId
	 * 
	 *            �ύ����ֱ����Ϣ
	 */
	private void submitTxtLiveOrderInfo(String orderCode, int pId,
			String newPrice, String title, int pType, int uId, int pModel,
			int tId) {
		PayOrder payOrder = new PayOrder();
		payOrder.setUserId(uId);
		payOrder.setTitle(title);
		payOrder.setFromTeacherId(tId);
		payOrder.setAllMoney(newPrice);
		payOrder.setPayMoney(0 + "");
		payOrder.setPayModel(pModel);
		payOrder.setPayState(1);
		payOrder.setInsertDate(sdf.format(new Date()));
		payOrder.setFromTeacherId(tId);
		payOrder.setIsDelete(1);
		payOrder.setOrderCode(orderCode);
		isSuccess = PayOrderServer.addPayOrder(payOrder);
		PayProduct payProduct = new PayProduct();
		payProduct.setOrderId(orderCode);
		payProduct.setProductId(pId);
		payProduct.setPrice(newPrice);
		payProduct.setNowPrice(newPrice);
		payProduct.setBuyCount(0);
		payProduct.setAllMoney(newPrice);
		payProduct.setProductTitle(title);
		payProduct.setXuYueYear(0);
		payProduct.setXuYueMonth(0);
		payProduct.setXuYueDay(0);
		payProduct.setIsDelete(1);
		payProduct.setProductType(pType);
		payProduct.setUserId(uId);
		isItemSuccess = PayProductServer.addPayProductInfo(payProduct);
	}

}

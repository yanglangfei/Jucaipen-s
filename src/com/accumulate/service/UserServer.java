package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.UserDao;
import com.accumulate.daoImp.UserImp;
import com.accumulate.entity.User;

public class UserServer {
	/**
	 * @return 查询所有的用户信息
	 */
	public static List<User> findUser(int page) {
		UserDao dao = new UserImp();
		return dao.findUser(page);

	}

	/**
	 * @param id
	 * @return 根据id查询用户
	 */
	public static User findUserById(int id) {
		UserDao dao = new UserImp();
		return dao.findUserById(id);
	}

	/**
	 * @param userName
	 * @return 根据用户名查询用户
	 */
	public static User findUserByAccount(String userName) {
		UserDao dao = new UserImp();
		return dao.findUserByAccount(userName);
	}

	/**
	 * @param userName
	 *            手机号或用户名
	 * @return 登录
	 */
	public static User loginUser(String userName) {
		UserDao dao = new UserImp();
		return dao.findUserByOther(userName);

	}

	/**
	 * @param user
	 * @return 注册新用户
	 */
	public static int insertUser(User user) {
		UserDao dao = new UserImp();
		return dao.reginUser(user);

	}

	/**
	 * @param uId
	 * @return 修改用户信息
	 */
	public static int updateUser(int uId, User user) {
		UserDao dao = new UserImp();
		return dao.updataUserById(uId, user);
	}

	/**
	 * @param uId
	 * @return 修改密码
	 */
	public static int updatePassword(int uId, String pwd) {
		UserDao dao = new UserImp();
		return dao.updataPasswordById(uId, pwd);
	}

	/**
	 * @param id
	 * @param faceImage
	 * @return  根据id修改用户头像URL
	 */
	public static int updateUserLogo(int id, String faceImage) {
		UserDao dao = new UserImp();
		return dao.updateUserLogoById(id, faceImage);
	}

	/**
	 * @param id
	 * @return 根据用户id查询用户密码
	 */
	public static String findPasswordById(int id) {
		UserDao dao = new UserImp();
		return dao.findPasswordById(id).getPassword();
	}
	
	
	/**
	 * @param tel
	 * @return   通过手机号查询用户信息  ---完善个人资料时验证手机号是否已经绑定
	 */
	public static User findUserByTelPhone(String tel){
		UserDao dao=new UserImp();
		return dao.findUserByTelPhone(tel);
	}
	
	
	/**
	 * @param qqId
	 * @return   通过qqId 查询用户信息  --绑定第三方账号时验证qq是否绑定
	 */
	public static User findUserByQQId(String qqId){
		UserDao dao=new UserImp();
		return dao.findUserByQqopenId(qqId);
	}
	
	
	/**
	 * @param weixinId
	 * @return   通过微信id 查询用户信息   --绑定第三方账号时验证微信账号是否绑定
	 */
	public static User findUserByWeixinId(String weixinId){
		UserDao dao=new UserImp();
		return dao.findUserByWeixinId(weixinId);
	}
	
	
	/**
	 * @param sinaId
	 * @return   通过新浪id查询用户信息    --绑定第三方账号时验证新浪账号是否已经绑定
	 */
	public static User  findUserBySinaId(String sinaId){
		UserDao dao=new UserImp();
		return dao.findUserBySinaId(sinaId);
		
	}
	
	/**
	 * @param id
	 * @return  根据用户id获取用户头像URL
	 */
	public static String findFaceImageById(int id){
		UserDao dao=new UserImp();
		return dao.querryFaceImage(id);
	}

	/**
	 * @param id
	 * @return 根据用户id查询用户昵称 --用于聊天
	 */
	public static User findUserNikNameById(int id) {
		UserDao dao = new UserImp();
		return dao.findUserInfoById(id);
	}

	/**
	 * @param id
	 *            当前用户id
	 * @param accountType
	 *            修改用户账号类型
	 * @param accountId
	 *            第三方账号id
	 * @return 修改用户绑定第三方账号id
	 */
	public static int updateAccountId(int id, int accountType, String accountId) {
		UserDao dao = new UserImp();
		return dao.upDataAccountId(id, accountType, accountId);
	}

	/**
	 * @param accountType
	 *            账号类型
	 * @param accountId
	 *            账号id
	 * @return 第三方账号登录 查询第三方账号是否存在
	 */
	public static User otherAccountLogin(int accountType, String accountId) {
		UserDao dao = new UserImp();
		return dao.otherAccountLogin(accountType, accountId);
	}

	/**
	 * @param id
	 * @return 查询当前用户下的第三方账号信息
	 */
	public static User querryOtherAccount(int id) {
		UserDao dao = new UserImp();
		return dao.querryOtherAccount(id);
	}

	/**
	 * @param isLive
	 * @param uId
	 * @return 修改用户是否在直播间
	 */
	public static int updateUserIsLiveRoom(int isLive, int uId) {
		UserDao dao = new UserImp();
		return dao.updateUserIsOnRoom(isLive, uId);
	}

	/**
	 * @param uId
	 * @return 查询用户登录token
	 */
	public static String findUserTokenById(int uId) {
		UserDao dao = new UserImp();
		return dao.querryUserIsLogin(uId);
	}

	/**
	 * @param uId
	 * @param token
	 * @return 更新用户token信息
	 */
	public static int updateLoginToken(int uId, String token) {
		UserDao dao = new UserImp();
		return dao.updateUserLoginToken(uId, token);
	}

}

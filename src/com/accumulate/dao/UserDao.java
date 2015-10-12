package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.User;

/**
 * @author ylf
 * 
 *         用户操作类
 */
public interface UserDao {
	/**
	 * @return 用户注册
	 */
	public int reginUser(User user);

	/**
	 * @return 查找所有用户
	 */
	public List<User> findUser(int page);

	/**
	 * @param id
	 * @return 通过id查询用户信息
	 */
	public User findUserById(int id);

	/**
	 * @param id
	 * @return 删除用户信息
	 */
	public int deleteUserById(int id);

	/**
	 * @param id
	 * @return 修改用户信息
	 */
	public int updataUserById(int id, User user);
	
	
	/**
	 * @param id
	 * @param logoPath
	 * @return  修改用户头像URL
	 */
	public int updateUserLogoById(int id ,String logoPath);

	/**
	 * @param account
	 * @return 查询该账号用户信息
	 */
	public User findUserByAccount(String userName);

	/**
	 * @param telPhone
	 * @return 通过手机号查询用户信息
	 */
	public User findUserByTelPhone(String telPhone);
	
	
	/**
	 * @param qqId
	 * @return  通过qqId 查询用户信息
	 */
	public User findUserByQqopenId(String qqId);
	
	/**
	 * @param wenxinId
	 * @return  通过微信id 查询用户信息
	 */
	public User findUserByWeixinId(String wenxinId);
	
	/**
	 * @param sinaId
	 * @return  通过新浪id 查询用户信息
	 */
	public User findUserBySinaId(String sinaId);

	/**
	 * @param userName
	 * @param telPhone
	 * @return 根据手机号或用户名查询用户
	 */
	public User findUserByOther(String userName);

	/**
	 * @param id
	 * @return 通过id查询用户密码
	 */
	public User findPasswordById(int id);

	/**
	 * @param id
	 * @param pwd
	 * @return 修改密码
	 */
	public int updataPasswordById(int id, String pwd);

	/**
	 * @param id
	 * @return根据id查询用户昵称 --用于聊天
	 */
	public User findUserInfoById(int id);

	/**
	 * @param accountId
	 * @return 修改第三方账号id
	 */
	public int upDataAccountId(int id,int accountType,String accountId);
	/**
	 * @param accountId
	 * @return 通过账号id 登录 程序
	 */
	public User otherAccountLogin(int accountType,String accountId);
	
	/**
	 * @param id
	 * @return   根据用户id 查询第三方账号
	 */
	public User querryOtherAccount(int id);
	
	/**
	 * @param isLiveRoom
	 * @return   更新用户是否在直播间
	 */
	public int updateUserIsOnRoom(int isLiveRoom,int uId);
	
	
	/**
	 * @param uId
	 * @return  获取用户登录token
	 */
	public String querryUserIsLogin(int uId);
	
	/**
	 * @param uId
	 * @param token
	 * @return  更新用户token信息
	 */
	public int updateUserLoginToken(int uId,String token);
	
	
	/**
	 * @param id
	 * @return  获取用户头像信息
	 */
	public String querryFaceImage(int id);

}

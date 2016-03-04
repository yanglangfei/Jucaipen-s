package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.UserDao;
import com.accumulate.entity.User;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

/**
 * @author ylf
 * 
 *         用户操作类实现
 * 
 */
public class UserImp implements UserDao {
	private Connection dbConn;
	private Statement sta;
	private int isSuccess;
	private ResultSet res;
	private List<User> users;

	/**
	 * @return 查询用户总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPUser "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 用户注册
	 */
	public int reginUser(User user) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("insert into " + SqlUtil.USER_TABLE
					+ "(" + SqlUtil.USER_NAME + "," + SqlUtil.USER_MOBILE + ","
					+ SqlUtil.USER_PASSWORD + "," + SqlUtil.USER_REGFROM + ","
					+ SqlUtil.USER_REGINDATE + "," + SqlUtil.USER_REGINIP
					+ ") values('" + user.getUserName() + "','"
					+ user.getMobileNum() + "','" + user.getPassword() + "',"
					+ 5 + ",'" + user.getRegDate() + "','" + user.getRegIp()
					+ "')");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 查询所有用户信息
	 */
	public List<User> findUser(int page) {
		int totlePage = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser"
							+ ") A " + "WHERE RowNumber > " + 15 * (page - 1));
			users = getUser(res, page, totlePage);
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据id查询用户信息
	 */
	public User findUserById(int id) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select RegFrom,ISNULL(UserName,'') UserName,ISNULL(NickName,'') NickName,ISNULL(Sex,'') Sex,ISNULL(MobileNum,'') MobileNum,LocaProvince,LocaCity,LocaEare,ISNULL(Email,'') Email,ISNULL(Bodys,'') Bodys,ISNULL(Birthday,'') Birthday,ISNULL(FaceImage,'') FaceImage from JCPUser where Id="
							+ id);
			while (res.next()) {
				String nickName = res.getString(SqlUtil.USER_NICKNAME);
				String sex = res.getString(SqlUtil.USER_SEX);
				String telPhone = res.getString(SqlUtil.USER_MOBILE);
				int localProvince = res.getInt(SqlUtil.USER_LOCALPROVINCE);
				int localCity = res.getInt(SqlUtil.USER_LOCALCITY);
				int localArea = res.getInt(SqlUtil.USER_LOCALAREA);
				String email = res.getString(SqlUtil.USER_EMAIL);
				String desc = res.getString(SqlUtil.USER_BODYS);
				String birthday = res.getString(SqlUtil.USER_BIRTH);
				String logo = res.getString(SqlUtil.USRE_FACEIMAGE);
				int RegFrom = res.getInt(SqlUtil.USER_REGFROM);
				String userName=res.getString(SqlUtil.USER_NAME);
				u = new User();
				u.setNickName(nickName);
				u.setSex(sex);
				u.setUserName(userName);
				u.setLocalProvince(localProvince);
				u.setMobileNum(telPhone);
				u.setBirthday(birthday);
				u.setLocalCity(localCity);
				u.setLocalArea(localArea);
				u.setDescript(desc);
				u.setEmail(email);
				u.setFaceImage(logo);
				u.setRegFrom(RegFrom);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 
	 * 获取用户头像
	 */
	public String querryFaceImage(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT FaceImage FROM JCPUser WHERE Id="
					+ id);
			while (res.next()) {
				String face = res.getString("FaceImage");
				return face;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 
	 * 获取用户登录token （验证用户身份）
	 */
	public String querryUserIsLogin(int uId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT LoginToken FROM JCPUser WHERE Id="
					+ uId);
			while (res.next()) {
				String token = res.getString("LoginToken");
				return token;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 
	 * 更新用户token信息
	 */
	public int updateUserLoginToken(int uId, String token) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPUser SET LoginToken='"
					+ token + "'" + "WHERE Id=" + uId);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//根据用户ID修改用户手机号
	public int updatePhoneById(int id, String tel) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPUser SET MobileNum='"
					+ tel + "'" + "WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateUserTrueNameAndTelById(String telPhone, User user) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPUser SET TrueName='"
					+ user.getTrueName() + "' WHERE MobileNum='" + telPhone
					+ "'");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 
	 * 修改用户头像URL
	 */
	public int updateUserLogoById(int id, String logoPath) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPUser SET FaceImage='"
					+ logoPath + "' WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 根据id查询用户密码
	 */
	public User findPasswordById(int id) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select PassWord from JCPUser where Id="
					+ id);
			res.next();
			String password = res.getString(SqlUtil.USER_PASSWORD);
			u = new User();
			u.setPassword(password);
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param id
	 * @return 根据id查询用户昵称---用于聊天
	 */
	public User findUserInfoById(int id) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select ISNULL (UserName,'') UserName,ISNULL (NickName,'') NickName,ISNULL (FaceImage,'') FaceImage from JCPUser where Id="
							+ id);
			while (res.next()) {
				String NickName = res.getString(SqlUtil.USER_NICKNAME);
				String userName = res.getString(SqlUtil.USER_NAME);
				String faceImage = res.getString(SqlUtil.USRE_FACEIMAGE);
				u = new User();
				u.setId(id);
				u.setFaceImage(faceImage);
				u.setUserName(userName);
				u.setNickName(NickName);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 删除用户信息
	 */
	public int deleteUserById(int id) {
		return 0;
	}

	/*
	 * 修改用户信息密码
	 */
	public int updataPasswordById(int id, String md5Pwd) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("update JCPUser set PassWord='"
					+ md5Pwd + "' where Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 修改用户信息
	 */
	public int updataUserById(int id, User user) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("update JCPUser set NickName='"
					+ user.getNickName() + "',MobileNum='"
					+ user.getMobileNum() + "',Sex='" + user.getSex()
					+ "',Bodys='" + user.getDescript() + "',Email='"
					+ user.getEmail() + "',Birthday='" + user.getBirthday()
					+ "',LocaProvince=" + user.getLocalProvince()
					+ ",LocaCity=" + user.getLocalCity() + ",LocaEare="
					+ user.getLocalArea() + " WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 
	 * 更新用户是否在直播间 （1 是 0 否）
	 */
	public int updateUserIsOnRoom(int isLiveRoom, int uId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPUser SET IsLiveRoom="
					+ isLiveRoom + " WHERE Id=" + uId);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * 根据账号查询用户信息
	 */
	public User findUserByAccount(String userName) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUser where UserName='"
					+ userName + "'");
			users = getUser(res, -1, -1);
			if (users != null && users.size() > 0) {
				u = users.get(0);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int upDataAccountId(int id, int accountType, String accountId) {
		// 修改用户的第三方账号信息-----accountType 0 (QQ) 1 (微信) 2 (新浪)
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			if (accountType == 0) {
				isSuccess = sta.executeUpdate("UPDATE JCPUser SET QQOpenId='"
						+ accountId + "' WHERE Id=" + id);
			} else if (accountType == 1) {
				isSuccess = sta.executeUpdate("UPDATE JCPUser SET WeiXinId='"
						+ accountId + "' WHERE Id=" + id);
			} else if (accountType == 2) {
				isSuccess = sta.executeUpdate("UPDATE JCPUser SET WeiboId='"
						+ accountId + "' WHERE Id=" + id);
			}
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User otherAccountLogin(int accountType, String accountId) {
		// 第三方账号登录 -----accountType 0 (QQ) 1 (微信) 2 (新浪)
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			if (accountType == 0) {
				res = sta.executeQuery("SELECT * FROM JCPUser WHERE QQOpenId='"
						+ accountId + "'");
			} else if (accountType == 1) {
				res = sta.executeQuery("SELECT * FROM JCPUser WHERE WeiXinId='"
						+ accountId + "'");
			} else if (accountType == 2) {
				res = sta.executeQuery("SELECT * FROM JCPUser WHERE WeiboId='"
						+ accountId + "'");
			}
			users = getUser(res, -1, -1);
			if (users != null && users.size() > 0) {
				u = users.get(0);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User querryOtherAccount(int id) {
		// 查询第三方账号
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT ISNULL(QQOpenId,'') QQOpenId,ISNULL(WeiXinId,'') WeiXinId,ISNULL(WeiboId,'') WeiboId FROM JCPUser WHERE Id="
							+ id);
			while (res.next()) {
				String QQOpenId = res.getString(SqlUtil.USER_QQID);
				String WeiXinId = res.getString(SqlUtil.USER_WEIXINID);
				String WeiboId = res.getString(SqlUtil.USER_SINAID);
				User user = new User();
				user.setQqId(QQOpenId);
				user.setWeiXinId(WeiXinId);
				user.setWeiBoId(WeiboId);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据手机号查询用户信息
	 */
	public User findUserByTelPhone(String telPhone) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUser where MobileNum='"
					+ telPhone + "'");
			users = getUser(res, -1, -1);
			if (users != null && users.size() > 0) {
				u = users.get(0);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据qqId 查询用户信息
	 */
	public User findUserByQqopenId(String qqId) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select Id from JCPUser where QQOpenId='"
					+ qqId + "'");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				u = new User();
				u.setId(id);
				return u;
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据微信Id 查询用户信息
	 */
	public User findUserByWeixinId(String wenxinId) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUser where WeiXinId='"
					+ wenxinId + "'");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				u = new User();
				u.setId(id);
				return u;
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据新浪Id 查询用户信息
	 */
	public User findUserBySinaId(String sinaId) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUser where WeiboId='"
					+ sinaId + "'");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				u = new User();
				u.setId(id);
				return u;
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据手机号和用户名查询用户信息 ----登录
	 */
	public User findUserByOther(String userName) {
		User u = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPUser where MobileNum='"
					+ userName + "' or  UserName= '" + userName + "'");
			users = getUser(res, -1, -1);
			if (users != null && users.size() > 0) {
				u = users.get(0);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 获取登录成功后的信息
	 * 
	 */
	public User findLoginInfoById(int id) {
		User user = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT UserName,IsRoomManager,BuyProductId,ServerId,RegDate FROM JCPUser WHERE Id="
							+ id);
			while (res.next()) {
				String userName=res.getString(1);
				int isRoom=res.getInt(2);
				int productId=res.getInt(3);
				int serverId=res.getInt(4);
				String reginDate=res.getString(5);
				user=new User();
				user.setUserName(userName);
				user.setRegDate(reginDate);
				user.setBuyProductId(productId);
				user.setIsRoomManager(isRoom);
				user.setServerId(serverId);
				user.setId(id);
				return user;
			}
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * @param res
	 * @return 获取用户信息
	 */
	public List<User> getUser(ResultSet res, int page, int totlePage) {
		users = new ArrayList<User>();
		try {
			while (res.next()) {
				String password = res.getString(SqlUtil.USER_PASSWORD);
				String UserName = res.getString(SqlUtil.USER_NAME);
				String birthday = res.getString(SqlUtil.USER_BIRTH);
				int userId = res.getInt(SqlUtil.NEWS_ID);
				String sex = res.getString(SqlUtil.USER_SEX);
				String trueName = res.getString(SqlUtil.USER_TRUENAME);
				String nickName = res.getString(SqlUtil.USER_NICKNAME);
				String mobileNum = res.getString(SqlUtil.USER_MOBILE);
				String faceImage = res.getString(SqlUtil.USRE_FACEIMAGE);
				String email = res.getString(SqlUtil.USER_EMAIL);
				String descript = res.getString(SqlUtil.USER_BODYS);
				int localProvince = res.getInt(SqlUtil.USER_LOCALPROVINCE);
				int localCity = res.getInt(SqlUtil.USER_LOCALCITY);
				int localArea = res.getInt(SqlUtil.USER_LOCALAREA);
				int homeProvince = res.getInt(SqlUtil.USER_HOMEPROVINCE);
				int homeCity = res.getInt(SqlUtil.USER_HOMECITY);
				int homeArea = res.getInt(SqlUtil.USER_HOMEAREA);
				String RegDate = res.getString(SqlUtil.USER_REGINDATE);
				int ServerId = res.getInt("ServerId");
				int IsRoomManager = res.getInt("IsRoomManager");
				int BuyProductId = res.getInt("BuyProductId");
				User user = new User();
				user.setId(userId);
				user.setIsRoomManager(IsRoomManager);
				user.setBuyProductId(BuyProductId);
				user.setServerId(ServerId);
				user.setRegDate(RegDate);
				user.setPassword(password);
				user.setUserName(UserName);
				user.setBirthday(birthday);
				user.setSex(sex);
				user.setTrueName(trueName);
				user.setNickName(nickName);
				user.setMobileNum(mobileNum);
				user.setFaceImage(faceImage);
				user.setEmail(email);
				user.setDescript(descript);
				user.setLocalProvince(localProvince);
				user.setLocalCity(localCity);
				user.setLocalArea(localArea);
				user.setHomeProvince(homeProvince);
				user.setHomeCity(homeCity);
				user.setHomeArea(homeArea);
				user.setTotlePage(totlePage);
				user.setPage(page);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

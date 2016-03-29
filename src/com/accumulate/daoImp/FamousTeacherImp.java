package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.FamousTeacherDao;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *
 *  获取名师信息
 */
public class FamousTeacherImp implements FamousTeacherDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<FamousTeacher> teachers=new ArrayList<FamousTeacher>();
	
	
	/**
	 * @return 查询新闻总页数
	 */
	public int findTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}
	
	public List<FamousTeacher> findIndexData() {
		teachers.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  Fans,LiveRenQi,HuiDaCount,ArticleCount from JCPTearch");
			while (res.next()) {
				int fans=res.getInt(1);
				int renQi=res.getInt(2);
				int answerCount=res.getInt(3);
				int articleCount=res.getInt(4);
				FamousTeacher teacher=new FamousTeacher();
				teacher.setFans(fans);
				teacher.setAnswerCount(answerCount);
				teacher.setArticleCount(articleCount);
				teacher.setLiveFans(renQi);
				teachers.add(teacher);
			}
			return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}


	public List<FamousTeacher> findAllFamousTeacher(int page) {
		try {
			int totlePage=findTotlePage("");
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY LiveRenQi DESC) AS RowNumber,* FROM JCPTearch) A "
					+ "WHERE RowNumber > " + 15 * (page - 1));
			teachers=getTeacher(res,page,totlePage);
			return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public List<FamousTeacher> findFamousTeacherByIndex(int count) {
		teachers.clear();
		try {
			dbConn=JdbcUtil.connSqlServer();      
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP "+count+" Id,IsV,NickName,HeadFace,TouXian,Jianjie FROM JCPTearch ORDER BY LiveRenQi DESC");
			while (res.next()) {
				int id=res.getInt(1);   
				int isV=res.getInt(2);
				String nickName=res.getString(3);
				String headFace=res.getString(4);
				String touxian=res.getString(5);
				String introduce=res.getString(6);
				FamousTeacher famousTeacher=new FamousTeacher();
				famousTeacher.setId(id);
				famousTeacher.setIsV(isV);
				famousTeacher.setNickName(nickName);
				famousTeacher.setHeadFace(headFace);
				famousTeacher.setLevel(touxian);
				famousTeacher.setIntroduce(introduce);
				teachers.add(famousTeacher);
			}
			return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	public FamousTeacher findFamousTeacherById(int id) {
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch WHERE Id="+id);
			teachers=getTeacher(res,0,0);
			if(teachers.size()>0){
				return teachers.get(0);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public List<FamousTeacher> getTeacher(ResultSet result,int page,int totlePage){
		teachers.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				String account=result.getString("Account");
				String loginPwd=result.getString("LoginPass");
				String trueName=result.getString("TrueName");
				String nickName=result.getString("NickName");
				String headFace=result.getString("HeadFace");
				String touxian=result.getString("TouXian");
				int isV=result.getInt("IsV");
				int fans=result.getInt("Fans");
				int liveRenQi=result.getInt("LiveRenQi");
				int answerCount=result.getInt("HuiDaCount");
				int articleCount=result.getInt("ArticleCount");
				int articleReadCount=result.getInt("ArticleReadCount");
				int articleGood=result.getInt("ArticleGood");
				String notice=result.getString("Notice");
				String introduce=result.getString("Jianjie");
				String hoby=result.getString("ShanChang");
				String telPhone=result.getString("MobileNum");
				int serviceNum=result.getInt("QianYueCount");
				//int state=result.getInt("State");
				String joinDate=result.getString("JoinDate");
				//String lastLoginDate=result.getString("LastLoginDate");
				//String lastLoginIp=result.getString("LastLoginIp");
				int liveGbookIsPass=result.getInt("LiveGbookIsPass");
				float  yearPrice=result.getFloat("YearPrice");
				float motnPrice=result.getFloat("MonthPrice");
				float quarterPrice=result.getFloat("QuarterPrice");
				float dayPrice=result.getFloat("DayPrice");
				//int userId=result.getInt("UserId");
				int askNum=result.getInt("AskNum");
				FamousTeacher teacher=new FamousTeacher();
				teacher.setPage(page);
				teacher.setTotlePage(totlePage);
				teacher.setId(id);
				teacher.setAccount(account);
				teacher.setAnswerCount(answerCount);
				teacher.setLoginPwd(loginPwd);
				teacher.setArticleCount(articleCount);
				teacher.setTrueName(trueName);
				teacher.setTelPhone(telPhone);
				teacher.setNickName(nickName);
				teacher.setHeadFace(headFace);
				teacher.setLevel(touxian);
				teacher.setIntroduce(introduce);
				teacher.setIsV(isV);
				teacher.setYaerPrice(yearPrice);
				teacher.setMothPrice(motnPrice);
				teacher.setQulaterPrice(quarterPrice);
				teacher.setDayPrice(dayPrice);
				teacher.setFans(fans);
				teacher.setLiveFans(liveRenQi);
				teacher.setHoby(hoby);
				teacher.setArticleReadCount(articleReadCount);
				teacher.setArticleGood(articleGood);
				teacher.setNotice(notice);
				teacher.setServerCount(serviceNum);
				teacher.setJoinDate(joinDate);
				teacher.setLiveGbookIsPass(liveGbookIsPass);
				teacher.setAskNum(askNum);
				teachers.add(teacher);
			}
			return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, result);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}


}

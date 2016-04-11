package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.VideoCommDao;
import com.accumulate.entity.VideoComm;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class VideoCommImp implements VideoCommDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<VideoComm> vList = new ArrayList<VideoComm>();

	public List<VideoComm> findAll() {
		// 查询所有的视频评论
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen");
			vList = getVideoComm(res);
			return vList;
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

	public List<VideoComm> findVideoCommByUid(int uId) {
		// 根据用户id查询视频评论
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where UserId="
					+ uId);
			vList = getVideoComm(res);
			return vList;
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

	public List<VideoComm> findVideoCommByVid(int videoId) {
		// 根据视频id 查询当前视频下的所有评论
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();  
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where VideoId="
					+ videoId);
			vList = getVideoComm(res);
			return vList;
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

	public VideoComm findVideoCommById(int id) {
		// 根据id查询视频评论详细内容
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where Id=" + id);
			vList = getVideoComm(res);
			return vList.get(0);
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

	public List<VideoComm> findVideoCommByIsShow(int isShow) {
		// 查询是否显示的视频评论
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where IsShow="
					+ isShow);
			vList = getVideoComm(res);
			return vList;
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

	private List<VideoComm> getVideoComm(ResultSet result) {
		// 获取评论信息
		vList.clear();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.VIDEOCOMM_ID);
				int videoId = result.getInt(SqlUtil.VIDEOCOMM_VIDEOID);
				int userId = result.getInt(SqlUtil.VIDEOCOMM_USERID);
				String bodys = result.getString(SqlUtil.VIDEOCOMM_BODYS);
				int goodCount = result.getInt(SqlUtil.VIDEOCOMM_GOODCOUNT);
				int replyCount = result.getInt(SqlUtil.VIDEOCOMM_REPLYCOUNT);
				String insertDate = result
						.getString(SqlUtil.VIDEOCOMM_INSERTDATE);
				String ip = result.getString(SqlUtil.VIDEOCOMM_IP);
				int isShow = result.getInt(SqlUtil.VIDEOCOMM_ISSHOW);
				VideoComm videoComm = new VideoComm(id, videoId, userId, bodys);
				videoComm.setGoodCount(goodCount);
				videoComm.setReplyCount(replyCount);
				videoComm.setIsShow(isShow);
				videoComm.setIp(ip);
				videoComm.setInsertDate(insertDate);
				vList.add(videoComm);
			}
			return vList;
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

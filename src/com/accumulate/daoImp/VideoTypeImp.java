package com.accumulate.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accumulate.dao.VideoTypeDao;
import com.accumulate.entity.VideoType;
import com.accumulate.utils.JdbcUtil;
import com.accumulate.utils.SqlUtil;

public class VideoTypeImp implements VideoTypeDao {
	private Connection dbConn;
	private ResultSet res;
	private java.sql.Statement sta;
	private List<VideoType> fts;

	public List<VideoType> findAll() {
		fts = new ArrayList<VideoType>();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select Id,ClassName  from JCPVideoClass");
			while (res.next()) {
				int id = res.getInt(1);
				String typeName = res.getString(2);
				VideoType vt = new VideoType(typeName, id);
				fts.add(vt);
			}
			return fts;
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

	public VideoType findTypeById(int id) {
		VideoType ft = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPVideoClass");
			fts = getFinalType(res);
			if (fts != null && fts.size() > 0) {
				ft = fts.get(0);
			}
			return ft;
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

	public List<VideoType> getFinalType(ResultSet result) {
		fts = new ArrayList<VideoType>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.VIDEOCLASS_ID);
				String name = result.getString(SqlUtil.VIDEOCLASS_CLASSNAME);
				int parentId = res.getInt(SqlUtil.VIDEOCLASS_PARENTID);
				String keyWord = res.getString(SqlUtil.VIDEOCLASS_KEYWORD);
				String descript = res.getString(SqlUtil.VIDEOCLASS_DESC);
				int sortId = res.getInt(SqlUtil.VIDEOCLASS_SORTID);
				int isDelete = res.getInt(SqlUtil.VIDEOCLASS_ISDELETE);
				VideoType ft = new VideoType(name, id);
				ft.setDescript(descript);
				ft.setIsDelete(isDelete);
				ft.setKeyWord(keyWord);
				ft.setParentId(parentId);
				ft.setSortId(sortId);
				fts.add(ft);
			}
			return fts;
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

	public List<VideoType> findTypeByIsDelete(int isDelete) {
		return null;
	}
	
	/*
	 * 根据上级分类查询二级分类
	 * 
	 */

	public List<VideoType> findTypeByTypeId(int parentId) {
		fts = new ArrayList<VideoType>();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,ParentId,ClassName from JCPVideoClass where ParentId="
							+ parentId);
			while (res.next()) {
				int id = res.getInt(1);
				int pId = res.getInt(2);
				String className = res.getString(3);
				VideoType videoType = new VideoType(className, id);
				videoType.setParentId(pId);
				fts.add(videoType);
			}
			return fts;
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

}

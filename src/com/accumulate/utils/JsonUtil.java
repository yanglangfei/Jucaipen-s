package com.accumulate.utils;

import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.junit.Test;

import com.accumulate.entity.Answer;
import com.accumulate.entity.ApkInfo;
import com.accumulate.entity.Ask;
import com.accumulate.entity.AskClass;
import com.accumulate.entity.ChatFace;
import com.accumulate.entity.ChatRoom;
import com.accumulate.entity.Equity;
import com.accumulate.entity.EquityFavorites;
import com.accumulate.entity.ExpressionInfo;
import com.accumulate.entity.ExpressionType;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.HotIdea;
import com.accumulate.entity.LiveInteractive;
import com.accumulate.entity.LogCommen;
import com.accumulate.entity.MessageObject;
import com.accumulate.entity.NewsCommRes;
import com.accumulate.entity.NewsSmallClass;
import com.accumulate.entity.OrderEquity;
import com.accumulate.entity.PrivatePlace;
import com.accumulate.entity.TextLive;
import com.accumulate.entity.TxtLiveDetails;
import com.accumulate.entity.VideoType;
import com.accumulate.entity.News;
import com.accumulate.entity.NewsComment;
import com.accumulate.entity.NewsFavorites;
import com.accumulate.entity.User;
import com.accumulate.entity.Video;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * @author ylf
 * 
 *         gson解析、封装json数据
 */
public class JsonUtil {
	/**
	 * @param json
	 *            解析json
	 */
	public void parseJson() {
		String json = "[{'name':'张三'},{'name':'李四'}]";
		Gson gson = new Gson();
		List<User> user = gson.fromJson(json, new TypeToken<List<User>>() {
		}.getType());
		System.out.println("  ..." + user.get(0).getBirthday());

	}

	/**
	 * @param news
	 * @return 封装json数据
	 */
	public static String getObject(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}

	/**
	 * @param news
	 * @return 封装首页财经信息
	 */
	public static String getIndexNewsList(List<News> news) {
		JsonArray array = new JsonArray();
		for (News n : news) {
			JsonObject object = new JsonObject();
			object.addProperty("id", n.getId());
			object.addProperty("title", n.getTitle());
			object.addProperty("imageThumb", n.getImagesThumb());
			object.addProperty("descript", n.getDescript());
			array.add(object);
		}
		return array.toString();

	}

	/**
	 * @param equities
	 * @return 封装首页理财信息
	 */
	public static String getIndexFinalList(List<Equity> equities) {
		JsonArray array = new JsonArray();
		for (Equity e : equities) {
			JsonObject object = new JsonObject();
			object.addProperty("id", e.getId());
			object.addProperty("ownName", e.getOwnName());
			object.addProperty("simpleName", e.getSimpleName());
			object.addProperty("investmentThreshold",
					e.getInvestmentThreshold());
			object.addProperty("transferNum", e.getTransferNum());
			object.addProperty("intendsTransfe", e.getIntendsTransfer());
			object.addProperty("equityUrl", e.getEquityImage());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param sTvs
	 * @return 封装首页学堂视频信息 、教学视频信息
	 */
	public static String getIndexVideoList(List<Video> sTvs) {
		JsonArray array = new JsonArray();
		for (Video st : sTvs) {
			JsonObject object = new JsonObject();
			object.addProperty("id", st.getId());
			object.addProperty("title", st.getTitle());
			object.addProperty("url", st.getImagesThumb());
			object.addProperty("resourceUrl", st.getVideoUrl());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param ret_code
	 *            返回码
	 * @param err_msg
	 *            返回备注信息
	 * @return 常规返回值
	 */
	public static String getRetMsg(int ret_code, String err_msg) {
		JsonObject object = new JsonObject();
		object.addProperty("ret_code", ret_code);
		object.addProperty("err_msg", err_msg);
		return object.toString();
	}

	/**
	 * @param news
	 * @return 返回首页、股权要闻
	 */
	public static String getIndxEquityNewsList(List<News> news) {
		JsonArray array = new JsonArray();
		for (News ns : news) {
			JsonObject object = new JsonObject();
			object.addProperty("id", ns.getId());
			object.addProperty("title", ns.getTitle());
			object.addProperty("descript", ns.getDescript());
			object.addProperty("newsImage", ns.getImageUrl());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param news
	 * @return 返回首页股权知识
	 */
	public static String getIndxKnownList(List<News> news) {
		JsonArray array = new JsonArray();
		for (News ns : news) {
			JsonObject object = new JsonObject();
			object.addProperty("id", ns.getId());
			object.addProperty("title", ns.getTitle());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param news
	 * @return 返回阳光私募信息列表
	 */
	public static String getSunFindList(List<Equity> equities) {
		JsonArray array = new JsonArray();
		for (Equity e : equities) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", e.getPager());
			object.addProperty("totlePager", e.getTotlePager());
			object.addProperty("id", e.getId());
			object.addProperty("simpleName", e.getSimpleName());
			object.addProperty("investmentThreshold",
					e.getInvestmentThreshold());
			object.addProperty("imageUrl", e.getEquityImage());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param news
	 * @return 返回大盘分析数据列表
	 */
	public static String getTapeList(List<News> news) {
		JsonArray array = new JsonArray();
		for (News n : news) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", n.getPager());
			object.addProperty("totlePager", n.getTotlePager());
			object.addProperty("id", n.getId());
			object.addProperty("title", n.getTitle());
			object.addProperty("descript", n.getDescript());
			object.addProperty("imageUrl", n.getImageUrl());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param tvs
	 * @return 返回视频列表
	 */
	public static String getVideoList(List<Video> tvs) {
		JsonArray array = new JsonArray();
		for (Video tv : tvs) {
			JsonObject object = new JsonObject();
			object.addProperty("id", tv.getId());
			object.addProperty("title", tv.getTitle());
			object.addProperty("imageUrl", tv.getImagesThumb());
			object.addProperty("isMySiteVideo", tv.getIsMySiteVideo());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @return 返回评论列表
	 */
	public static String getCommentList(List<NewsComment> comments,
			List<News> news) {
		JsonArray array = new JsonArray();
		for (int i = 0; i < news.size(); i++) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", comments.get(i).getPager());
			object.addProperty("totlePager", comments.get(i).getTotlePager());
			object.addProperty("id", comments.get(i).getId());
			object.addProperty("newsId", news.get(i).getId());
			object.addProperty("newsTitle", news.get(i).getTitle());
			object.addProperty("body", comments.get(i).getBodys());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param nFavorites
	 * @return 返回收藏新闻列表
	 */
	public static String getNewsFavoritesList(List<NewsFavorites> nFavorites,
			List<News> news) {
		JsonArray array = new JsonArray();
		for (int i = 0; i < news.size(); i++) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", nFavorites.get(i).getPager());
			object.addProperty("totlePager", nFavorites.get(i).getTotlePager());
			object.addProperty("id", nFavorites.get(i).getId());
			object.addProperty("newsId", news.get(i).getId());
			object.addProperty("title", news.get(i).getTitle());
			object.addProperty("time", nFavorites.get(i).getDate());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param news
	 * @return 返回新闻列表
	 */
	public static String getNewsList(List<News> news) {
		JsonArray array = new JsonArray();
		for (News ns : news) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", ns.getPager());
			object.addProperty("totlePager", ns.getTotlePager());
			object.addProperty("id", ns.getId());
			object.addProperty("title", ns.getTitle());
			object.addProperty("imageThumb", ns.getImagesThumb());
			object.addProperty("descripte", ns.getDescript());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param fts
	 * @return 获取视频分类信息
	 */
	public static String getVideoTypeList(List<VideoType> fts) {
		JsonArray array = new JsonArray();
		for (VideoType ft : fts) {
			JsonObject object = new JsonObject();
			object.addProperty("typeId", ft.getTypeId());
			object.addProperty("typeName", ft.getTypeName());
			array.add(object);
		}

		return array.toString();
	}

	/**
	 * @param fts
	 * @return 返回新闻分类信息
	 */
	public static String getNewsType(List<NewsSmallClass> fts) {
		JsonArray array = new JsonArray();
		for (NewsSmallClass nsc : fts) {
			JsonObject object = new JsonObject();
			object.addProperty("bigId", nsc.getBigId());
			object.addProperty("smallId", nsc.getId());
			object.addProperty("typeName", nsc.getSamllName());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param nComments
	 * @param users
	 * @return 获取新闻评论信息
	 */
	public static String getNewsCommList(List<NewsComment> nComments,
			List<User> users) {
		JsonArray array = new JsonArray();
		for (int i = 0; i < nComments.size(); i++) {
			JsonObject object = new JsonObject();
			object.addProperty("id", nComments.get(i).getId());
			object.addProperty("newsId", nComments.get(i).getnId());
			object.addProperty("goodCount", nComments.get(i).getGoodNum());
			object.addProperty("replyCount", nComments.get(i).getRepCount());
			object.addProperty("userName", users.get(i).getNickName());
			object.addProperty("userLogo", StringUtil.JCP_PATH
					+ users.get(i).getFaceImage());
			object.addProperty("insertDate", nComments.get(i).getInsertDate());
			object.addProperty("body", nComments.get(i).getBodys());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param places
	 * @return 返回私募列表数据
	 */
	public static String getPrivatePlaceList(List<PrivatePlace> places) {

		return null;
	}

	/**
	 * @param newsCommRes
	 * @return 获取新闻评论回复信息
	 */
	public static String getNewsCommResList(List<NewsCommRes> newsCommRes) {
		JsonArray array = new JsonArray();
		for (int i = 0; i < newsCommRes.size(); i++) {
			JsonObject object = new JsonObject();
			object.addProperty("id", newsCommRes.get(i).getId());
			object.addProperty("bodys", newsCommRes.get(i).getBodys());
			object.addProperty("insertDate", newsCommRes.get(i).getInsertDate());
			array.add(object);
		}
		return array.toString();
	}

	@Test
	public void name() {

	}

	/**
	 * @param id
	 * @return 返回登录结果
	 */
	public static String getLoginResult(User user) {
		JsonObject object = new JsonObject();
		object.addProperty("ret_code", 0);
		object.addProperty("userId", user.getId());
		object.addProperty("buyProductId", user.getBuyProductId());
		object.addProperty("isServer", user.getServerId());
		object.addProperty("isManager", user.getIsRoomManager());
		object.addProperty("reginDate", user.getRegDate());
		object.addProperty("userName",user.getUserName());
		object.addProperty("err_msg", "登录成功");
		return object.toString();
	}

	/**
	 * @param user
	 * @param localArea
	 * @param localCity
	 * @param localProvince
	 * @return 返回用户信息
	 */
	public static String getUserInfo(User user, String localProvince,
			String localCity, String localArea) {
		JsonObject object = new JsonObject();
		object.addProperty("userName", user.getNickName());
		object.addProperty("telPhone", user.getMobileNum());
		object.addProperty("sex", user.getSex());
		object.addProperty("birthday", user.getBirthday());
		object.addProperty("email", user.getEmail());
		object.addProperty("localProvince", localProvince);
		object.addProperty("localCity", localCity);
		object.addProperty("localArea", localArea);
		object.addProperty("descript", user.getDescript());
		object.addProperty("faceImage", user.getFaceImage());
		object.addProperty("reginFrom", user.getRegFrom());
		return object.toString();
	}

	/**
	 * @param qList
	 * @param equities
	 * @return 查询我的股权预约
	 */
	public static String getMyOrderList(List<OrderEquity> qList,
			List<String> orderName) {
		JsonArray array = new JsonArray();
		for (int i = 0; i < qList.size(); i++) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", qList.get(i).getPager());
			object.addProperty("totlePager", qList.get(i).getTotlePager());
			object.addProperty("id", qList.get(i).getId());
			object.addProperty("trueName", qList.get(i).getTrueName());
			object.addProperty("mobileNum", qList.get(i).getMobileNum());
			object.addProperty("remark", qList.get(i).getRemark());
			object.addProperty("insertDate", qList.get(i).getInsertDate());
			object.addProperty("touziMoney", qList.get(i).getTouziMoney());
			object.addProperty("equityName", orderName.get(i));
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param eqList
	 * @param equities
	 * @return 查询我的收藏股权信息
	 */
	public static String getEquityFavoritesList(List<EquityFavorites> eqList,
			List<Equity> equities) {
		JsonArray array = new JsonArray();
		for (int i = 0; i < equities.size(); i++) {
			JsonObject object = new JsonObject();
			object.addProperty("pager", eqList.get(i).getPager());
			object.addProperty("totlePager", eqList.get(i).getTotlePager());
			object.addProperty("id", eqList.get(i).geteId());
			object.addProperty("simpleName", equities.get(i).getSimpleName());
			object.addProperty("equityCode", equities.get(i).getEquityCode());
			object.addProperty("investmentThreshold", equities.get(i)
					.getInvestmentThreshold());
			object.addProperty("intendsTransfer", equities.get(i)
					.getIntendsTransfer());
			object.addProperty("eId", equities.get(i).getId());
			object.addProperty("transferNum", equities.get(i).getTransferNum());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param video
	 * @return 获取视频资源信息
	 */
	public static String getVideoResourceData(Video video) {
		JsonObject object = new JsonObject();
		object.addProperty("title", video.getTitle());
		object.addProperty("videoUrl", video.getVideoUrl());
		object.addProperty("id", video.getId());
		return object.toString();
	}

	/**
	 * @param info
	 * @return 获取最新apk版本信息
	 */
	public static String getApkInfo(ApkInfo info) {
		JsonObject object = new JsonObject();
		object.addProperty("ret_code", 0);
		object.addProperty("versionCode", info.getVersionCode());
		object.addProperty("apkUrl", info.getApkPath());
		return object.toString();
	}

	/**
	 * @param messageObject
	 * @return 解析上线 、下线消息 msgType 0 上线 1 下线 chatType 0 公聊 1 私聊
	 * 
	 *         msgType    0 文本信息     txt 1 图片信息  image 2 图文混排  txt image 
	 */
	public static MessageObject parseMessage(String messageObject) {
		MessageObject msg;
		try {
			org.json.JSONObject object = new org.json.JSONObject(messageObject);
			int messageType = object.getInt("msgType");
			int fromUser = object.getInt("fromUser");
			int roomId = object.getInt
					("roomId");
			int isManager=object.getInt("isManager");
			int isServer=object.getInt("isServer");
			String userName=object.getString("userName");
			msg = new MessageObject(messageType, fromUser);
			msg.setRoomId(roomId);
			msg.setFronName(userName);
			msg.setIsManager(isManager);
			msg.setIsServer(isServer);
			if (messageType == 2) {
				// 聊天消息
				int chatType = object.getInt("chatType");
				String message = object.getString("message");
				int toUser = object.getInt("toUser");
				msg.setChatType(chatType);
				msg.setRoomId(roomId);
				msg.setMessage(message);
				msg.setToUser(toUser);
			}
			return msg;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param user
	 *            (手机端) 封装消息 0 上线 1 下线
	 */
	public static String getChatMessage(MessageObject msgObject) {
		JsonArray array=new JsonArray();
		JsonObject obj=new JsonObject();
		obj.addProperty("isPC", 1);
		JsonObject object = new JsonObject();
		object.addProperty("id",-1);
		object.addProperty("fromId", msgObject.getFromUser());
		object.addProperty("fromUser", msgObject.getFronName());
		object.addProperty("msgType", msgObject.getMsgType());
		object.addProperty("sendDate", TimeUtils.format(new Date(),"HH:mm"));
		int msgType = msgObject.getMsgType();
		if (msgType == 2) {
			object.addProperty("chatType", msgObject.getChatType());
			object.addProperty("toUser", msgObject.getToName());
			object.addProperty("message", msgObject.getMessage());
			object.addProperty("isCheck",0);
		}
		array.add(obj);
		array.add(object);
		return array.toString();
	}

	/**
	 * @param user
	 *            获取PC端聊天信息
	 */
	public static String getPCChatMessage(List<MessageObject> msgArray) {
		JsonArray array = new JsonArray();
		JsonObject obj1=new JsonObject();
		obj1.addProperty("isPC", 0);
		array.add(obj1);
		for (MessageObject obj : msgArray) {
			JsonObject object = new JsonObject();
			object.addProperty("id", obj.getMsgId());
			object.addProperty("fromId", obj.getFromUser());
			object.addProperty("fromUser", obj.getFronName());
			object.addProperty("msgType", obj.getMsgType());
			object.addProperty("sendDate",obj.getSendDate());
			int msgType = obj.getMsgType();
			if (msgType == 2) {
				object.addProperty("isCheck",obj.getIsCheck());
				object.addProperty("chatType", obj.getChatType());
				object.addProperty("toUser", obj.getToName());
				object.addProperty("message", obj.getMessage());
			}
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param rooms
	 *            @ return 获取房间列表
	 */
	public static String getRoomList(List<ChatRoom> rooms) {
		JsonArray array = new JsonArray();
		for (ChatRoom room : rooms) {
			JsonObject object = new JsonObject();
			object.addProperty("id", room.getId());
			object.addProperty("roomName", room.getRoomName());
			object.addProperty("IsStopYouke", room.getIsStopYouke());
			object.addProperty("ShiTingDay", room.getShiTingDay());
			object.addProperty("RoomFace", room.getRoomFace());
			object.addProperty("UserLevel", room.getUserLevel());
			array.add(object);
		}
		return array.toString();

	}

	/**
	 * @param room
	 * @return 获取直播间详细信息
	 */
	public static String getRoomDetaile(ChatRoom room) {
		JsonObject object = new JsonObject();
		object.addProperty("videoUrl", HtmlUtils.parseWeb(room.getLiveUrl()));
		return object.toString();
	}

	/**
	 * @param user
	 * @return 返回用户第三方账号id
	 */
	public static String getOtherAccountList(User user) {
		JsonObject object = new JsonObject();
		object.addProperty("ret_code", 0);
		object.addProperty("qqId", user.getQqId());
		object.addProperty("weixinId", user.getWeiXinId());
		object.addProperty("sinaId", user.getWeiBoId());
		return object.toString();
	}

	/**
	 * @param video
	 * @return 获取视频详情
	 */
	public static String getVideoDetaile(Video video) {
		JsonObject object = new JsonObject();
		object.addProperty("id", video.getId());
		object.addProperty("title", video.getTitle());
		object.addProperty("keyWord", video.getKeyWords());
		object.addProperty("hitCount", video.getHitCount());
		object.addProperty("insertDate", video.getInsertDate());
		object.addProperty("descript", video.getDescript());
		return object.toString();
	}

	/**
	 * @param types
	 * @return 获取表情分类信息
	 */
	public static String getExpressionType(List<ExpressionType> types) {
		JsonArray array = new JsonArray();
		for (ExpressionType type : types) {
			JsonObject object = new JsonObject();
			object.addProperty("id", type.getId());
			object.addProperty("typeName", type.getClassName());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param infos
	 * @return 获取表情包下对应的表情
	 */
	public static String getExpressionInfo(List<ExpressionInfo> infos) {
		JsonArray array = new JsonArray();
		for (ExpressionInfo info : infos) {
			JsonObject object = new JsonObject();
			object.addProperty("id", info.getId());
			object.addProperty("typeId", info.getClassId());
			object.addProperty("title", info.getTitle());
			object.addProperty("faceUrl", info.getFaceurl());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param chatFaces
	 * @return 获取所有聊天表情
	 */
	public static String getChatFaceList(List<ChatFace> chatFaces) {
		JsonArray array = new JsonArray();
		for (ChatFace face : chatFaces) {
			JsonObject object = new JsonObject();
			object.addProperty("id", face.getId());
			object.addProperty("title", face.getTitle());
			object.addProperty("faceUrl", face.getFaceUrl());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param hotIdeas
	 * @return  返回热门观点
	 */
	public static String getIndexHotIdeaList(List<HotIdea> hotIdeas) {
		JsonArray array=new JsonArray();
		for(HotIdea idea : hotIdeas){
			JsonObject object = new JsonObject();
			object.addProperty("page",idea.getPage());
			object.addProperty("totlePgae",idea.getTotlePgae());
			object.addProperty("id", idea.getId());
			object.addProperty("title", idea.getTitle());
			object.addProperty("bodys", idea.getBodys());
			object.addProperty("logImage", idea.getLogImage());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param famousTeachers
	 * @return  获取推荐名师
	 */
	public static String getFamousTeacherList(List<FamousTeacher> famousTeachers) {
		JsonArray array=new JsonArray();
		for(FamousTeacher famousTeacher : famousTeachers){
			JsonObject object = new JsonObject();
			object.addProperty("page",famousTeacher.getPage());
			object.addProperty("totlePage",famousTeacher.getTotlePage());
			object.addProperty("id", famousTeacher.getId());
			object.addProperty("nickName", famousTeacher.getNickName());
			object.addProperty("headFace", famousTeacher.getHeadFace());
			object.addProperty("level", famousTeacher.getLevel());
			object.addProperty("isV", famousTeacher.getIsV());
			object.addProperty("introduce", famousTeacher.getIntroduce());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param hotIdea
	 * @param teacher
	 * @return  获取热门观点详细内容
	 */
	public static String getIdeaDetaile(HotIdea hotIdea, FamousTeacher teacher) {
		JsonObject object = new JsonObject();
		object.addProperty("id", hotIdea.getId());
		object.addProperty("title", hotIdea.getTitle());
		object.addProperty("bodys", hotIdea.getBodys());
		object.addProperty("insertDate", hotIdea.getInsertDate());
		object.addProperty("goods", hotIdea.getGoods());
		object.addProperty("nickName", teacher.getNickName());
		object.addProperty("level", teacher.getLevel());
		object.addProperty("isV", teacher.getIsV());
		object.addProperty("headFace", teacher.getHeadFace());
		return object.toString();
	}

	/**
	 * @param teacher
	 * @param txtLives 
	 * @return  获取名师详细信息
	 */
	public static String getFamousTeacherDetaile(FamousTeacher teacher, List<TextLive> txtLives) {
		JsonObject object = new JsonObject();
		object.addProperty("id", teacher.getId());
		object.addProperty("nickName", teacher.getNickName());
		object.addProperty("level", teacher.getLevel());
		object.addProperty("isV", teacher.getIsV());
		object.addProperty("headFace", teacher.getHeadFace());
		object.addProperty("popularity", teacher.getLiveFans());
		object.addProperty("fans", teacher.getFans());
		object.addProperty("goods", teacher.getArticleGood());
		object.addProperty("joinDate", teacher.getJoinDate());
		object.addProperty("hoby", teacher.getHoby());
		object.addProperty("introduce",teacher.getIntroduce());
		object.addProperty("ideaCount", teacher.getArticleCount());
		object.addProperty("answerCount",teacher.getAnswerCount());
		if(txtLives.size()>0){
			object.addProperty("isEnd",txtLives.get(0).getIsEnd());
			object.addProperty("txtLiveId", txtLives.get(0).getId());
		}
		return object.toString();
	}

	/**
	 * @param txtLives
	 * @param famousTeachers 
	 * @return   返回名师看盘列表数据
	 */
	public static String getTxtLiveList(List<TextLive> txtLives, List<FamousTeacher> famousTeachers) {
		JsonArray array=new JsonArray();
		for(int i=0;i<txtLives.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("id",txtLives.get(i).getId());
			object.addProperty("startDate", txtLives.get(i).getStartDate());
			object.addProperty("title",txtLives.get(i).getTitle());
			object.addProperty("renQi",txtLives.get(i).getMoods());
			object.addProperty("teacherId", famousTeachers.get(i).getId());
			object.addProperty("level", famousTeachers.get(i).getLevel());
			object.addProperty("nickName",famousTeachers.get(i).getNickName());
			object.addProperty("headFace",famousTeachers.get(i).getHeadFace());
			object.addProperty("isV",famousTeachers.get(i).getIsV());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param hotIdeas
	 * @param teachers 
	 * @return   获取所有的投资观点列表
	 */
	public static String getInvestmentIdeaList(List<HotIdea> hotIdeas, List<FamousTeacher> teachers) {
		JsonArray array=new JsonArray();
		for(int i=0;i<hotIdeas.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("id",hotIdeas.get(i).getId());
			object.addProperty("insertDate",hotIdeas.get(i).getInsertDate());
			object.addProperty("title",hotIdeas.get(i).getTitle());
			object.addProperty("bodys",hotIdeas.get(i).getBodys());
			object.addProperty("hits",hotIdeas.get(i).getHits());
			object.addProperty("teacherId",teachers.get(i).getId());
			object.addProperty("nickName",teachers.get(i).getNickName());
			object.addProperty("level",teachers.get(i).getLevel());
			object.addProperty("headFace",teachers.get(i).getHeadFace());
			object.addProperty("isV",teachers.get(i).getIsV());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param users
	 * @return  获取所有的粉丝数据列表
	 */
	public static String getAttentionList(List<User> users) {
		JsonArray array=new JsonArray();
		for(User user :users){
			JsonObject object=new JsonObject();
			object.addProperty("userName",user.getUserName());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param askClasses
	 * @return   获取咨询分类信息
	 */
	public static String getAskClassList(List<AskClass> askClasses) {
		JsonArray array=new JsonArray();
		for(AskClass askType :askClasses){
			JsonObject object=new JsonObject();
			object.addProperty("classId",askType.getId());
			object.addProperty("askName",askType.getClassName());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param todayIdeas
	 * @return    获取今日观点列表
	 */
	public static String getTodayIdeasList(
			List<TxtLiveDetails> todayIdeas) {
		JsonArray array=new JsonArray();
		for(int i=0;i<todayIdeas.size();i++){
			TxtLiveDetails details=todayIdeas.get(i);
			JsonObject object=new JsonObject();
			object.addProperty("id",details.getId());
			object.addProperty("relete_liveId",details.getRelate_liveId());
			object.addProperty("bodys",details.getBodys());
			object.addProperty("insertDate", details.getInsertDate());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param renQi
	 * @param answerCount
	 * @param ideas
	 * @param fans
	 * @return   返回首页统计数据
	 */
	public static String getIndexStatisticsData(int renQi, int answerCount,
			int ideas, int fans) {
		JsonObject object=new JsonObject();
		object.addProperty("renQi",renQi);
		object.addProperty("answerCount",answerCount);
		object.addProperty("ideas",ideas);
		object.addProperty("fans",fans);
		return object.toString();
	}

	/**
	 * @param ideas
	 * @param teachers
	 * @return   通过讲师id获取投资观点信息
	 */
	public static String getInvestmentIdeaListByTeacherId(List<HotIdea> ideas,
			FamousTeacher teachers) {
		JsonArray array=new JsonArray();
		for(int i=0;i<ideas.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("page",ideas.get(i).getPage());
			object.addProperty("totlePage",ideas.get(i).getTotlePgae());
			object.addProperty("id",ideas.get(i).getId());
			object.addProperty("insertDate",ideas.get(i).getInsertDate());
			object.addProperty("title",ideas.get(i).getTitle());
			object.addProperty("bodys",ideas.get(i).getBodys());
			object.addProperty("hits",ideas.get(i).getHits());
			object.addProperty("teacherId",teachers.getId());
			object.addProperty("nickName",teachers.getNickName());
			object.addProperty("level",teachers.getLevel());
			object.addProperty("headFace",teachers.getHeadFace());
			object.addProperty("isV",teachers.getIsV());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param hotIdeas
	 * @param teachers
	 * @return   获取所有的热门观点信息
	 */
	public static String getAllHotIdeaList(List<HotIdea> hotIdeas,
			List<FamousTeacher> teachers) {
		JsonArray array=new JsonArray();
		for(int i=0;i<hotIdeas.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("page",hotIdeas.get(i).getPage());
			object.addProperty("totlePage",hotIdeas.get(i).getTotlePgae());
			object.addProperty("id",hotIdeas.get(i).getId());
			object.addProperty("insertDate",hotIdeas.get(i).getInsertDate());
			object.addProperty("title",hotIdeas.get(i).getTitle());
			object.addProperty("bodys",hotIdeas.get(i).getBodys());
			object.addProperty("hits",hotIdeas.get(i).getHits());
			object.addProperty("teacherId",teachers.get(i).getId());
			object.addProperty("nickName",teachers.get(i).getNickName());
			object.addProperty("level",teachers.get(i).getLevel());
			object.addProperty("headFace",teachers.get(i).getHeadFace());
			object.addProperty("isV",teachers.get(i).getIsV());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param interactives
	 * @param users 
	 * @return   获取直播互动信息
	 */
	public static String getLiveInterationList(
			List<LiveInteractive> interactives, List<User> users) {
		JsonArray array=new JsonArray();
		for(int i=0;i<interactives.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("userName",users.get(i).getUserName());
			object.addProperty("userLogo",users.get(i).getFaceImage());
			object.addProperty("insertDate",interactives.get(i).getInsertDate());
			object.addProperty("bodys",interactives.get(i).getBodys());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param teacher
	 * @param asks
	 * @param answerList
	 * @param users 
	 * @return   获取名师咨询回答列表
	 */
	public static String getQuestionForTeacher(FamousTeacher teacher,
			List<Ask> asks, List<Answer> answerList, List<User> users) {
		JsonArray array=new JsonArray();
		for(int i=0;i<answerList.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("teacherId",teacher.getId());
			object.addProperty("headFace",teacher.getHeadFace());
			object.addProperty("nickName",teacher.getNickName());
			object.addProperty("level",teacher.getLevel());
			object.addProperty("isV",teacher.getIsV());
			object.addProperty("userName",users.get(i).getUserName());
			object.addProperty("askBody",asks.get(i).getAskBody());
			object.addProperty("answerBodys",answerList.get(i).getAnswerBody());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param askList
	 * @param users
	 * @return   获取提问列表
	 */
	public static String getAskList(List<Ask> askList, List<User> users) {
		JsonArray array=new JsonArray();
		for(int i=0;i<askList.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("askId",askList.get(i).getId());
			object.addProperty("userName",users.get(i).getUserName());
			object.addProperty("insertDate",askList.get(i).getAskDate());
			object.addProperty("askBodys",askList.get(i).getAskBody());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param comms
	 * @param users
	 * @return   返回热门观点评论列表
	 */
	public static String getIdeaCommList(List<LogCommen> comms, List<User> users) {
		JsonArray array=new JsonArray();
		for(int i=0;i<comms.size();i++){
			JsonObject object=new JsonObject();
			object.addProperty("commId", comms.get(i).getId());
			object.addProperty("insertDate",comms.get(i).getInsertDate());
			object.addProperty("commBody",comms.get(i).getBodys());
			object.addProperty("goods",comms.get(i).getGoods());
			object.addProperty("repCount",comms.get(i).getRepCount());
			object.addProperty("userName", users.get(i).getUserName());
			object.addProperty("faceImage",users.get(i).getFaceImage());
			array.add(object);
		}
		return array.toString();
	}

	/**
	 * @param teachers
	 * @return   返回找名家列表数据
	 */
	public static String getFindTeacherList(List<FamousTeacher> teachers) {
		JsonArray array=new JsonArray();
		for(FamousTeacher teacher :teachers){
			JsonObject object=new JsonObject();
			object.addProperty("id",teacher.getId());
			object.addProperty("level",teacher.getLevel());
			object.addProperty("headFace",teacher.getHeadFace());
			object.addProperty("nickName", teacher.getNickName());
			object.addProperty("isV",teacher.getIsV());
			object.addProperty("introduce",teacher.getIntroduce());
			object.addProperty("answerCount",teacher.getAnswerCount());
			object.addProperty("fans", teacher.getFans());
			array.add(object);
		}
		return array.toString();
	}

}

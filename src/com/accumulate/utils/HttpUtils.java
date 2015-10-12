package com.accumulate.utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtils {
	private static String sendChatPath = "http://chat-data.jucaipen.com/ashx/chat_msg.ashx?action=add";
	/**
	 * @param path
	 * @param id
	 *            topId roomId userId
	 * 
	 *            获取聊天记录
	 */
	public static String sendHttpPost(String path, int... id) {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
			conn.setRequestProperty("accept", "*/");
			conn.setReadTimeout(1000*5);
			conn.setConnectTimeout(1000*5);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			out.print("topId=" + id[0] + "&roomid=" + id[1] + "&userId="
					+ id[2]);
			out.flush();
			InputStream is = conn.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte bs[] = new byte[dis.available()];
			dis.read(bs);
			String data = new String(bs, "UTF-8");
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	/**
	 * @param msgcontent
	 *            发送消息
	 * @param sendusername
	 *            发送用户昵称
	 * @param SendUserId
	 *            发送用户id
	 * @param roomid
	 *            直播间id
	 * @return 发送聊天消息
	 */
	public static String sendChatMessage(String msgcontent,
			String sendusername, int SendUserId, int roomid) {
		try {
			URL url = new URL(sendChatPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			String content=URLEncoder.encode(msgcontent, "UTF-8");
			String userName=URLEncoder.encode(sendusername, "UTF-8");
			String param="msgcontent=" + content + "&sendusername="
					+ userName + "&SendUserId=" + SendUserId + "&roomid="
					+ roomid;
			out.print(param);
			out.flush();
			InputStream is = conn.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte bs[] = new byte[dis.available()];
			dis.read(bs);
			String data = new String(bs, "UTF-8");
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param url
	 * @return  发送 get 请求
	 */
	public static String sendHttpGet(String url) {
		try {
			URL path = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) path.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			InputStream is = conn.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte bs[] = new byte[dis.available()];
			dis.read(bs);
			String data = new String(bs, "UTF-8");
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

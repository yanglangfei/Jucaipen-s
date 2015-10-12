package com.accumulate.utils;

/**
 * @author YLF
 * 
 *         创建网页标签，解析网页标签
 * 
 */
public class HtmlUtils {

	/*
	 * private String url1 =
	 * "<iframe width='480' height='380' frameborder='0' src='http://www.quklive.com/q3/embed/a/4045?autoPlay=true'></iframe>"
	 * ; private String url2 =
	 * " <iframe width='480' height='380' frameborder='0' src='http://www.quklive.com/q3/embed/a/4043?autoPlay=true'></iframe>"
	 * ; private String imagePath1 =
	 * "<img src='http://img.jucaipen.com/jucaipenUpload/2015/7/15/2015715174415.gif'>"
	 * ; private String imagePath =
	 * "http://img.jucaipen.com/jucaipenUpload/2015/7/15/2015715174415.gif";
	 */

	/**
	 * @return 解析直播视频URL
	 */
	public static String parseWeb(String videoUrl) {
		String array[] = videoUrl.split(" src=");
		if (array.length > 1) {
			String path = videoUrl.split("src=")[1].replace("></iframe>", "").replace("\"", "");
			return path;
		} else {
			return null;
		}
	}

	/**
	 * @return 创建网页src标签图片
	 */
	public static String createImageWeb(String imagePath) {
		String webImage = "<img src='" + imagePath + "'>";
		return webImage;
	}

	/**
	 * @return 解析网页src 标签
	 */
	public static String parseWebImage(String imagePath) {
		String image = imagePath.replace("<img src=", "").replace(">", "");
		return image;
	}
}

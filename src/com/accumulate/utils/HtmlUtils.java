package com.accumulate.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author YLF
 * 
 *         创建网页标签，解析网页标签
 * 
 */
public class HtmlUtils {

	/**
	 * @return 解析直播视频URL
	 */
	public static String parseWeb(String videoUrl) {
		if (videoUrl != null) {
			if (videoUrl.contains("iframe")&&videoUrl.contains("src")) {
				Document document = Jsoup.parse(videoUrl);
				Element ec = document.select("iframe").first();
				return ec.attr("src");
			} else if (videoUrl.contains("object")&&videoUrl.contains("data")) {
				Document document = Jsoup.parse(videoUrl);
				Element ec = document.select("object").first();
				return ec.attr("data");
			}

		}
		return null;

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

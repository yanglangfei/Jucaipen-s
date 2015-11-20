package com.accumulate.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * 
 *  下载APK文件
 *
 */
@SuppressWarnings("serial")
public class DownLoadApk extends HttpServlet {
	private String rootPath;
	private String loadPath;
	private String fileName;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rootPath="D:/apkInfo/apk/";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		fileName = request.getParameter("fileName");
		loadPath=rootPath+fileName;
		File apkFile=new File(loadPath);
		if(apkFile.exists()){
			downLoadApk(response);
		}
	}

	
	private void downLoadApk(HttpServletResponse response) {
		try {
			// 设置响应头，控制浏览器下载该文件
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(loadPath);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request, response);
	}

}

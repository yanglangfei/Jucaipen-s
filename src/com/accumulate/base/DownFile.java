package com.accumulate.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ����APK�ļ�
 * 
 */
@SuppressWarnings("serial")
public class DownFile extends HttpServlet {
	private String rootPath;
	private String loadPath;
	private String fileName;
	private String result;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rootPath = "D:/apkInfo/apk/";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		fileName = request.getParameter("fileName");
		if (StringUtil.isNotNull(fileName)) {
			loadPath = rootPath + fileName;
			File apkFile = new File(loadPath);
			if (apkFile.exists()) {
				downLoadApk(response);
			} else {

			}
		} else {
			PrintWriter out = response.getWriter();
			result = JsonUtil.getRetMsg(1, "�����ļ�������Ϊ��");
			out.write(result);
			out.flush();
			out.close();
		}
	}

	private void downLoadApk(HttpServletResponse response) {
		try {
			// ������Ӧͷ��������������ظ��ļ�
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8"));
			// ��ȡҪ���ص��ļ������浽�ļ�������
			FileInputStream in = new FileInputStream(loadPath);
			// ���������
			OutputStream out = response.getOutputStream();
			// ����������
			byte buffer[] = new byte[1024];
			int len = 0;
			// ѭ�����������е����ݶ�ȡ������������
			while ((len = in.read(buffer)) > 0) {
				// ��������������ݵ��������ʵ���ļ�����
				out.write(buffer, 0, len);
			}
			// �ر��ļ�������
			in.close();
			// �ر������
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("err1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("err2");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("err3");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
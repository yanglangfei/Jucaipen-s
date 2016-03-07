package com.accumulate.manager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.accumulate.entity.ApkInfo;
import com.accumulate.service.ApkInfoServer;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         �ļ��ϴ�
 * 
 *         versionName versionCode file
 * 
 */
@SuppressWarnings("serial")
public class UploadApk extends HttpServlet {
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * APK�ļ�����·��
	 */
	private String rootPath;
	/**
	 * �ϴ�APK����
	 */
	private Map<String, String> param = new HashMap<String, String>();
	private ApkInfo info;
	//private int isSuccess;
	private int maxId;
	private String uuId;
	private String savePath;
	private String versionName;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rootPath="D:/apkInfo/apk/";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		uuId=UUID.randomUUID().toString();
		savePath=rootPath+uuId;
		File dirFile=new File(savePath);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		DiskFileItemFactory dif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dif);
		try {
			List<FileItem> list = sfu.parseRequest(request);
			Iterator<FileItem> iter = list.iterator();
			while (iter.hasNext()) {
				FileItem fi = iter.next();
				if (fi.isFormField()) {
					String key = fi.getFieldName();
					String values = fi.getString("UTF-8");
					param.put(key, values);
				} else {
					if (fi.getFieldName() != null && !fi.getName().equals("")) {
						File tempFile = new File(fi.getName());
						File saveFile = new File(savePath, tempFile.getName());
						fi.write(saveFile);
							querryMaxId();
							if(maxId>0){
								// ����apk���ݿ�����
								createApkDate(param, uuId+"/"+ tempFile.getName());
								if(info!=null){
									updateApkInfo(info);
								    pushUpdateInfo();
				     				out.print("�ļ��ϴ�����ɹ�");
								}else {
									out.print("�ļ�����ʧ��");
								}
							}else {
								out.print("�ļ�����ʧ��");
							}
					} else {
						out.print("û��ѡ���ļ�");
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("�ļ��ϴ�ʧ��");
		}
		out.flush();
		out.close();
	}

	private void pushUpdateInfo() {
		//XinGeUtil.getInstance(false).pushAllUpdateDevice(0, "apk�汾��������", "�ɸ��µ����°汾"+versionName);
	}

	/**
	 * ��ȡAPK��Ϣ����id 
	 */
	private void querryMaxId() {
	  maxId=ApkInfoServer.querryMaxId();
		
	}

	/**
	 * @param info
	 * 
	 *            �ϴ�APK�ļ�
	 */
	private void updateApkInfo(ApkInfo info) {
		ApkInfoServer.insertApkInfo(info);

	}

	/**
	 * @param param2
	 * @param string
	 *            ����APK����
	 */
	private void createApkDate(Map<String, String> param, String path) {
		if (param.size() > 0) {
			versionName = param.get("versionName");
			String versionCode = param.get("versionCode");
			info = new ApkInfo();
			info.setId(++maxId);
			info.setVsionName(versionName);
			info.setApkPath(path);
			info.setPkgName("com.example.androidnetwork");
			String date=sdf.format(new Date());
			info.setUpdateDate(date);
			if (StringUtil.isInteger(versionCode)) {
				int vCode = Integer.parseInt(versionCode);
				info.setVersionCode(vCode);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		doPost(request, response);
	}
}

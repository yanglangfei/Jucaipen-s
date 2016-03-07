package com.accumulate.userop;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.utils.UpLoadFileUtils;

/**
 * @author ylf
 *    �ļ�����
 *
 */
@SuppressWarnings("serial")
public class DownUserLogo extends HttpServlet {
	//private String resultMsg;
	private int result;
	private String fileSaveRootPath;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		fileSaveRootPath="D:/apkInfo/userLogo/";
	}

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
        //�õ�Ҫ���ص��ļ���
        String fileName = request.getParameter("filename");
        if(fileName!=null&&!fileName.equals("")){
        	String fileNames = new String(fileName.getBytes("iso8859-1"),"UTF-8");
            //�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
        	UpLoadFileUtils upLoadFileUtils=new UpLoadFileUtils();
        	result=upLoadFileUtils.downFile(fileNames, fileSaveRootPath, response);
	      //  result=new UpLoadFileUtils().downFile(fileNames, fileSaveRootPath, response);
			if(result==0){
				//resultMsg=JsonUtil.getRetMsg(result, "�ļ��������");
			}else if(result==1){
				//resultMsg=JsonUtil.getRetMsg(result, "�����ļ�������");
			}else {
				//resultMsg=JsonUtil.getRetMsg(2, "�ļ�����ʧ��");
			}
        }
    }
    
    /**
    * @Method: findFileSavePathByFileName
    * @Description: ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
    * @Anthor:ylf
    * @param filename Ҫ���ص��ļ���
    * @param saveRootPath �ϴ��ļ�����ĸ�Ŀ¼��Ҳ����/WEB-INF/uploadĿ¼
    * @return Ҫ���ص��ļ��Ĵ洢Ŀ¼
    */ 
    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        System.out.println("  "+filename+"  "+dir);
        File file = new File(dir);
        if(!file.exists()){
            //����Ŀ¼
            file.mkdirs();
        }
        return dir;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doGet(request, response);
    }
}
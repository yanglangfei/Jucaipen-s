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
 *    文件下载
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
        //得到要下载的文件名
        String fileName = request.getParameter("filename");
        if(fileName!=null&&!fileName.equals("")){
        	String fileNames = new String(fileName.getBytes("iso8859-1"),"UTF-8");
            //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        	UpLoadFileUtils upLoadFileUtils=new UpLoadFileUtils();
        	result=upLoadFileUtils.downFile(fileNames, fileSaveRootPath, response);
	      //  result=new UpLoadFileUtils().downFile(fileNames, fileSaveRootPath, response);
			if(result==0){
				//resultMsg=JsonUtil.getRetMsg(result, "文件下载完成");
			}else if(result==1){
				//resultMsg=JsonUtil.getRetMsg(result, "访问文件不存在");
			}else {
				//resultMsg=JsonUtil.getRetMsg(2, "文件下载失败");
			}
        }
    }
    
    /**
    * @Method: findFileSavePathByFileName
    * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
    * @Anthor:ylf
    * @param filename 要下载的文件名
    * @param saveRootPath 上传文件保存的根目录，也就是/WEB-INF/upload目录
    * @return 要下载的文件的存储目录
    */ 
    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        System.out.println("  "+filename+"  "+dir);
        File file = new File(dir);
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doGet(request, response);
    }
}
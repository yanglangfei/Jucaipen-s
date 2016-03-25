package com.accumulate.teacgeridea;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.HotIdea;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.HotIdeaServ;
import com.accumulate.utils.Compress;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ���Ź۵��б� whichPage 0 ��ҳ ֻ��ȡ����������� 1 ��ȡȫ������  ��Ͷ�ʹ۵㣩
 * 
 */
@SuppressWarnings("serial")
public class HotIdeasList extends HttpServlet{
	private List<HotIdea> hotIdeas;
	private String result;
	private List<FamousTeacher> teachers=new ArrayList<FamousTeacher>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String which = request.getParameter("whichPage");
		if (StringUtil.isInteger(which)) {
			int whichPage = Integer.parseInt(which);
			if (whichPage == 0) {
				//��ҳ����
				initIndexHotIdeaData();
				result = JsonUtil.getIndexHotIdeaList(hotIdeas);
			} else if (whichPage == 1) {
				//ȫ������
				String page = request.getParameter("page");
				if (StringUtil.isInteger(page)) {
					//ҳ����������
					int p = Integer.parseInt(page);
					initAllHotIdeasData(p);
					result = JsonUtil.getAllHotIdeaList(hotIdeas,teachers);
					//sendData(response,result);
				} else {
					//ҳ�������쳣
					result = JsonUtil.getRetMsg(2, "��ҳ�������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(3, "whichPage����������Ҫ��");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "whichPage�������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	
	
	
	
	/*
	public void sendData(HttpServletResponse response,String res){
		byte data[]=res.getBytes();
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		OutputStream os=null;
		try { 
			os=response.getOutputStream();
			//���Ҫ���صĽ���ֽ�����С��50λ������ѹ��
			if(data.length<Compress.BYTE_MIN_LENGTH){
				byte flagByte=Compress.FLAG_GBK_STRING_UNCOMPRESSED_BYTEARRAY;
				bos.write(flagByte);
				bos.write(data);
			}else{
				byte flagByte=Compress.FLAG_GBK_STRING_COMPRESSED_BYTEARRAY;
				bos.write(flagByte);
				bos.write(Compress.byteCompress(data));
			}
			bos.flush();
			bos.close();
			//�������֯����ֽ����鷢�͸��ͻ���
			os.write(bos.toByteArray());
			Date d=new Date();
			long after=d.getTime();
			System.out.println("after:"+after);
		} catch (Exception e) {
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

	private void initAllHotIdeasData(int p) {
		// ��ҳ��ѯ��������
		teachers.clear();
		hotIdeas = HotIdeaServ.findAllHotIdea(p);
		if(hotIdeas.size()>0){
			for(HotIdea idea :hotIdeas){
				int teacherId=idea.getTeacherId();
				FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
				teachers.add(teacher);
			}
		}

	}

	private void initIndexHotIdeaData() {
		// ��ȡ��ҳ����
		hotIdeas = HotIdeaServ.findIdeaByCount(3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}




package com.accumulate.teacgeridea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Answer;
import com.accumulate.entity.Ask;
import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.Question;
import com.accumulate.entity.User;
import com.accumulate.service.AnswerSer;
import com.accumulate.service.AskSer;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ʦ�ʴ�   whichPage   0   ��ҳ����
 *                           1    ��������
 * 
 */
@SuppressWarnings("serial")
public class TeacherQuestion extends HttpServlet {
	private List<Answer> answers;
	private Question question;
	private String result;
	private List<Question> questions=new ArrayList<Question>();
	private String askName;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String which=request.getParameter("whichPage");
		if(StringUtil.isInteger(which)){
			int whichPage=Integer.parseInt(which);
			if(whichPage==0){
				//��ȡ��ҳ
				initIndexQuestion();
				result = JsonUtil.getObject(questions);
			}else if(whichPage==1){
				//��ȡ��������
				String pager=request.getParameter("page");
				if(StringUtil.isInteger(pager)){
					int page=Integer.parseInt(pager);
					initAllQuestion(page);
					result = JsonUtil.getObject(questions);
				}else {
					result=JsonUtil.getRetMsg(4,"ҳ���������ָ�ʽ���쳣");
				}
				
			}else {
				result=JsonUtil.getRetMsg(2,"whichPage����������Ҫ��");
			}
			
		}else {
			result=JsonUtil.getRetMsg(1, "whichPage�������ָ�ʽ���쳣");
		}
	
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAllQuestion(int page) {
		questions.clear();
		answers=AnswerSer.findAllAnswer(page);
		int totlePage=answers.get(0).getTotlePage();
		if(answers.size()>0){
			for(Answer answer :answers){
				String answerBodys=answer.getAnswerBody();
				int id=answer.getTeacherId();
				int askId=answer.getAskId();
				FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(id);
				Ask ask=AskSer.findAskById(askId);
				String askDate=ask.getAskDate();
				int userId=ask.getUserId();
				User user=UserServer.findUserNikNameById(userId);
				String image=teacher.getHeadFace();
				String nickName=teacher.getNickName();
				String level = teacher.getLevel();
				int isV = teacher.getIsV();
				if(user!=null){
					askName = user.getUserName();
				}else{
					 askName ="null";
				}
			
				String askBodys = ask.getAskBody();
				int isReply = ask.getIsReply();
				question = new Question(id, image, nickName, level, isV,
						askName, askBodys, isReply, answerBodys);
				question.setAskId(askId);
				question.setTotlePage(totlePage);
				question.setPage(page);
				question.setAskDate(askDate);
				questions.add(question);
				
			}
		}
		
	}

	//��ʼ��������Ϣ
	private void initIndexQuestion() {
		questions.clear();
		answers=AnswerSer.findAnswerByLast(3);
		if(answers.size()>0){
			for(Answer answer :answers){
				String answerBodys=answer.getAnswerBody();
				int id=answer.getTeacherId();
				int askId=answer.getAskId();
				FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(id);
				Ask ask=AskSer.findAskById(askId);
				String askDate=ask.getAskDate();
				int userId=ask.getUserId();
				User user=UserServer.findUserNikNameById(userId);
				String image=teacher.getHeadFace();
				String nickName=teacher.getNickName();
				String level = teacher.getLevel();
				int isV = teacher.getIsV();
				String askName = user.getUserName();
				String askBodys = ask.getAskBody();
				int isReply = ask.getIsReply();
				question = new Question(id, image, nickName, level, isV,
						askName, askBodys, isReply, answerBodys);
				question.setAskId(askId);
				question.setAskDate(askDate);
				questions.add(question);
				
			}
		}
		
	}
			
			

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

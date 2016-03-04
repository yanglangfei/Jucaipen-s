package com.accumulate.timertask;

import java.util.List;
import java.util.TimerTask;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.TextLive;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.TxtLiveSer;
import com.accumulate.utils.TimeUtils;
import com.accumulate.utils.XinGeUtil;

public class NewTextLiveTasker extends TimerTask {

	private List<TextLive> textLives;

	@Override
	public void run() {        
		//ͨ��liveId ��ȡ���µ�ֱ����Ϣ
		textLives=TxtLiveSer.findLastPushLive(1);
		//��������ֱ����Ϣ���ͻ���
		if(textLives.size()>0){
			for(TextLive textLive :textLives){
				String title=textLive.getTitle();
				String startDate=textLive.getStartDate();
				int id=textLive.getId();
				boolean isPush=TimeUtils.compareDate(startDate);
				if(isPush){
					int teacherId=textLive.getTeacherId();   
					FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
					String nickName=teacher.getNickName();
				   // XinGeUtil.getInstance(false).pushAllDevice(id,nickName+"����ֱ��", title);
				}
			}
		}
	
		
	}

}
package com.accumulate.timertask;

import java.util.List;
import java.util.TimerTask;

import org.json.JSONObject;

import com.accumulate.entity.FamousTeacher;
import com.accumulate.entity.TextLive;
import com.accumulate.service.FamousTeacherSer;
import com.accumulate.service.TxtLiveSer;
import com.accumulate.utils.GePushUtils;
import com.accumulate.utils.TimeUtils;
import com.accumulate.utils.XinGeUtil;

public class NewTextLiveTasker extends TimerTask {

	private List<TextLive> textLives;
 
	@Override
	public void run() {        
		//通过liveId 获取最新的直播信息
		textLives=TxtLiveSer.findLastPushLive(1);
		//推送最新直播信息到客户端
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
				   // JSONObject res=XinGeUtil.getInstance(false).pushAllDevice(id,nickName+"今日直播", title);
				    //GePushUtils.getInstance().pushAllDev(nick Name+"今日直播", title);
				   // System.out.println(res.toString());
				}
			}
		}
	
		
	}

}

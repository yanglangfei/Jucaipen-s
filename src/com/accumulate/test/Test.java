package com.accumulate.test;

import java.util.List;

import org.apache.commons.lang.math.IEEE754rUtils;

import com.accumulate.entity.News;
import com.accumulate.entity.NewsSmallClass;
import com.accumulate.service.NewServer;
import com.accumulate.service.NewSmallSer;
import com.accumulate.utils.JdbcUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Test {


	public static void main(String[] args) {
		
		//   [{name:"123",item:[{title:"123"},{title:"65"}]},{name:"123",item:[{title:"123"},{title:"65"}]}]
	JsonArray array=new JsonArray();
	 List<NewsSmallClass> type = NewSmallSer.findNewSmallByByBigId(6);
	 for(int i=0;i<type.size();i++){
		 JsonObject obj1=new JsonObject();
		NewsSmallClass tp=type.get(i);
		String name = tp.getSamllName();
		int sId=tp.getId();
		obj1.addProperty("name",name);
		JsonArray arr1=new JsonArray();
		List<News> items=NewServer.findIndexNewsById(6, sId, 2);
        for(int j=0;j<items.size();j++){
        	JsonObject obj2=new JsonObject();
        	News n = items.get(j);
        	String title = n.getTitle();
        	int id=n.getId();
        	String desc=n.getDescript();
        	obj2.addProperty("title", title);
        	obj2.addProperty("id", id);
        	obj2.addProperty("desc", desc);
        	arr1.add(obj2);
        }
        obj1.add("item", arr1);
        array.add(obj1);		 
	 }
	
		
      
	  
	 System.out.println(array.toString());
	  
	  
		
	}

}

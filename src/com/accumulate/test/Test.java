package com.accumulate.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;




public class Test{
	private static Random random;
	
	public static void main(String[] args) {
		try {
			String t="2000-11-11 14:23:20";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d=sdf.parse(t);
			System.out.println("t:"+d.getHours()+":"+d.getMinutes());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

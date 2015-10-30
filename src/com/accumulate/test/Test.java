package com.accumulate.test;

import java.util.Random;




public class Test{
	private static Random random;
	
	public static void main(String[] args) {
		StringBuffer buffer=new StringBuffer();
		if(random==null){
			random=new Random();
		}
		for(int i=0;i<5;i++){
			int r=random.nextInt(10);
			buffer.append(r);
		}
	}
	
}

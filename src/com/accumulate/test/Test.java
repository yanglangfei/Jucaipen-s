package com.accumulate.test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test{
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
		String uu=UUID.randomUUID().toString();
		System.out.println("uu:"+uu);
		}
}
}

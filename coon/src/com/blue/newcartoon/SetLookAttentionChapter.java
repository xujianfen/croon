package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.user.UserDaoImpl;

public class SetLookAttentionChapter extends HttpServlet {
	
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	 ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	    
		String mboolean = "";
		String attention_id = "";
		String this_chapter = "";
		
		if(request.getParameter("attention_id")!=null){
			attention_id = request.getParameter("attention_id");
			System.out.println(attention_id+"");
		}
		if(request.getParameter("this_chapter")!=null){
			this_chapter = request.getParameter("this_chapter");
		    System.out.println(this_chapter+"");
		}
		System.out.println(attention_id+" "+this_chapter);
		try {
			
			mboolean = new UserDaoImpl(){}.setLookAttentionChapter(attention_id,this_chapter);
			System.out.println("com.blue.lanfeng.UQuestionSerblet:22:"+mboolean);
		
		} catch (Exception e) {
			mboolean = "-2";
			System.out.println("false");
			e.printStackTrace();
		}
		    response.getOutputStream().write(mboolean.toString().getBytes("utf-8"));
		
	}
	 
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {
		
			doGet(request,response);
		
	}

}

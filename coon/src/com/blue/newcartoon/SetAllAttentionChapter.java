package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.user.UserDaoImpl;

public class SetAllAttentionChapter extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		 
			request.setCharacterEncoding("UTF-8");

			String mboolean = "";
			
			String attention_id = ""+0;
//			String num = 0+"";
			
			if(request.getParameter("attention_id")!=null)
			attention_id = request.getParameter("attention_id");
			
//			if(request.getParameter("num")!=null)
//				num = request.getParameter("num");
			if(attention_id==null)
				System.out.println("null");
			else
				
		System.out.println(attention_id+" ssss");		
			try {    
		
				mboolean = new UserDaoImpl(){}.setAllAttentionChapter(attention_id);
				
			} catch (Exception e) {
				
				mboolean = null;
				e.printStackTrace();
				
			}finally {
				
				response.getOutputStream().write(mboolean.toString().getBytes("utf-8"))	;
				
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		doGet(request,response);
		
	}

}

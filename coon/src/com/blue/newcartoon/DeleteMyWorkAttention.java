package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.user.UserDaoImpl;

public class DeleteMyWorkAttention extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String mboolean = "";
		String id = -1+"";
//		String attention_id = -1+"";
//		String attention = "";
////		int aid = Integer.getInteger(id);
		
		if(request.getParameter("id")!=null)
			id = request.getParameter("id");
System.out.println("detel="+id);
//		if(request.getParameter("attention_id")!=null)
//			attention_id = request.getParameter("attention_id");
//		
//		if(request.getParameter("attention")!=null)
//			attention = request.getParameter("attention");

		try{
			   
			mboolean = new UserDaoImpl(){}.remove_my_work_attention(id);
			
		}catch (Exception e) {
			
			 e.printStackTrace();
		     System.out.println(e);
		     
		}finally{
	
			response.getOutputStream().write(mboolean.toString().getBytes())	;
			System.out.println("com.blue.lanfeng:addidea:39<a>"+mboolean+"</a>");
		
		}
	}
		
			

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		doGet(request,response);
	}

}


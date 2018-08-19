package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.blue.user.UserDaoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SetMyLikeComics extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {
			
				request.setCharacterEncoding("UTF-8");
	
			    String mboolean = "";
			    String attention = null;
			   
			    if(request.getParameter("attention")!=null){
			    	attention = request.getParameter("attention");
			    }
			    
			    Gson gson = new Gson();
			    List<String> attentionArray = gson.fromJson(attention, new
			    		TypeToken<List<String>>() {
			    		 }.getType());
			    try{ 
			    	
					mboolean = new UserDaoImpl().setMyLikeComics(attentionArray);
					
				}catch (Exception e){
					
					e.printStackTrace();
					mboolean = null;
				}
				
			    System.out.println("setMyLikeComics="+mboolean);
				response.getOutputStream().write(mboolean.toString().getBytes("utf-8"));
			
				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			doGet(request,response);
		
	}

}

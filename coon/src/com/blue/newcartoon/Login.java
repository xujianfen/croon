package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.json.Json;
import com.blue.user.User;
import com.blue.user.UserDaoImpl;

public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	   
		int boolean_num = 0;
		   
		 
		String name = null;
	    String password = null;
	    String json_user = null;
	    boolean b = true;
	  
	    boolean boolean_n = true;
	   
	    if(request.getParameter("name")!=null){
	    	name = (String)request.getParameter("name");
	    	System.out.println("com.ideacontent23:"+name);
	    	;
	    }
	    
	 
	    if(request.getParameter("password")!=null){
	    	password = (String)request.getParameter("password");
	    	System.out.println("com.ideacontent23:"+password);

	   }
	    if(request.getParameter("boolean")!=null){
	    	b = Boolean.parseBoolean(request.getParameter("boolean"));
	    	System.out.println("com.ideacontent23:"+b);

	   }
	   try {    
		   
			 json_user = new UserDaoImpl(){}.set(name,password,b);
	   } catch (Exception e) {
			e.printStackTrace();
		    boolean_num = -1;
		    System.out.println("Exception-->Login_40");
		    response.getOutputStream().write(boolean_num);
	   }
	      
	   		System.out.println("µÇÂ½³É¹¦");
	        response.getOutputStream().write(json_user.toString().getBytes("utf-8"));
	        
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		
		doGet(request,response);
		
	}

	

}

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

public class Parsonal extends HttpServlet {

	
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	    ServletException, IOException {
	    	 
	    	 request.setCharacterEncoding("UTF-8");
	    
	    	 Integer i = -1;
	    	 
	    	 String id = null;//id 1
	    	 String username = null;//用户名 2
	    	 String password = null;//密码 3
	    	 String phone = null;//手机号 4
	         String gender = null;//性别 14
	    	 String introduce = null;//介绍 15
	    	 String industry = null;//工作室 16
	    	
	    	
	    	if(request.getParameter("id")!=null&&!request.getParameter("id")
	    			.trim().isEmpty()&&!request.getParameter("id").equals("")){
		    	id = request.getParameter("id");
		    }
	    	
	    	if(request.getParameter("username")!=null&&!request.getParameter("username")
	    			.trim().isEmpty()&&!request.getParameter("username").equals("")){
	    		username = request.getParameter("username");
	    	}
	    	
	    	if(request.getParameter("password")!=null&&!request.getParameter("password")
	    			.trim().isEmpty()&&!request.getParameter("password").equals("")){
	    		password = request.getParameter("password");
	    	}
	    	
	    	if(request.getParameter("phone")!=null&&!request.getParameter("phone")
	    			.trim().isEmpty()&&!request.getParameter("phone").equals("")){
	    		phone = request.getParameter("phone");
	    	}
	    	
	    	if(request.getParameter("introduce")!=null&&!request.getParameter("introduce")
	    			.trim().isEmpty()&&!request.getParameter("introduce").equals("")){
	    		introduce = request.getParameter("introduce");
	    	}
	    	
	    	if(request.getParameter("industry")!=null&&!request.getParameter("industry")
	    			.trim().isEmpty()&&!request.getParameter("industry").equals("")){
	    		industry = request.getParameter("industry");
	    	}
	    	
	    	if(request.getParameter("gender")!=null&&!request.getParameter("gender").equals("")){
	    		gender = request.getParameter("gender");
	    	}
	    	System.out.println(id+" "+username+" "+password+" "+phone+" "+gender+" "+introduce+" "+industry);
	        try {
		    		i = new UserDaoImpl().uUser(id,username,password,phone,introduce,industry,gender);
				}  catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
			}
	      
		    response.getOutputStream().write(i.toString().getBytes());
		    
		}
	    
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {

			doGet(request,response);
		
		}

}

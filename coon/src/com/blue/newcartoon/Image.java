package com.blue.newcartoon;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.user.UserDaoImpl;

/**
 * Servlet implementation class Image
 */

public class Image extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
   ServletException, IOException {
	  
	    request.setCharacterEncoding("UTF-8");
	    
	    String error = ""+-1;
	    
	    String image = null;
	    String id = null;
	    
	    if(request.getParameter("image")!=null){
	    	image = (String)request.getParameter("image");
	    	System.out.println("com.ideacontent23:iamge = "+image);
	    
	    if(request.getParameter("id")!=null){
	    	id = request.getParameter("id");
	    	System.out.println("id = "+id);
	    }
		
	    try{
			   error =new UserDaoImpl(){}.vImage(id,image);
		   }catch (Exception e) {
			  System.out.println(e);
		}
	    }
	    	
	    	response.getOutputStream().write(error.getBytes("utf-8"))	;
		
  		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
	
		doGet(request, response);
	
	}

}

package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.user.UserDaoImpl;

public class SetAllComics extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String num = ""+0;
		String setComics = "";
		
		if(request.getParameter("num")!=null)
	    	num = request.getParameter("num");
	       
		try{
	    	setComics = new UserDaoImpl(){}.setAllcomics(num);
	    	System.out.println(setComics);
	    }catch (Exception e) {
			System.out.println(e);
			setComics = null;
			
		}finally {
			 response.getOutputStream().write(setComics.toString().getBytes("utf-8")); 
		}
	   
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		doGet(request,response);
		
	}

}


package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.json.Json;
import com.blue.json.JsonAgent;
import com.blue.user.UserDaoImpl;

public class AddComics extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
 
		    request.setCharacterEncoding("UTF-8");
		  
		    String mboolean = -1+"";
		 
	        String name ="";//漫画名 2
	        String work ="";//作者名 3
	        String work_id ="";//作者ID 4
//	        String attention_num ="";//章节Id 5
	        String introduce ="";//介绍 6
	        String cover ="";//封面 7
	       
	        if(request.getParameter("name")!=null)
	        	name = request.getParameter("name");
	        if(request.getParameter("work")!=null)
	        	work = request.getParameter("work");
	        if(request.getParameter("work_id")!=null)
	        	work_id = request.getParameter("work_id");
//	        if(request.getParameter("attention_num")!=null)
//	        	attention_num = request.getParameter("attention_num");
	        if(request.getParameter("introduce")!=null)
	        	introduce = request.getParameter("introduce");
	        if(request.getParameter("cover")!=null)
	        	cover = request.getParameter("cover");
	      System.out.println(name+" "+work+" "+work_id+" "
	    		 + introduce+" "+cover);
	        try{    String i = "";
			
				mboolean = new UserDaoImpl(){}.addComics(name,work,work_id,introduce,cover);
	
			} catch (Exception e) {
				System.out.println("com.blue.lanfeng:addidea:29:false");
				e.printStackTrace();
			}
					
			response.getOutputStream().write(mboolean.toString().getBytes());
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}

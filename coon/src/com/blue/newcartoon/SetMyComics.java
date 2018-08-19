package com.blue.newcartoon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.user.UserDaoImpl;

/**
 * Servlet implementation class SetMyComics
 */

public class SetMyComics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {

		    request.setCharacterEncoding("UTF-8");
		    
			String mboolean = "";
		   
		    String  work_id = -1+""; //ÎÒµÄid
	
			
			if(request.getParameter("work_id")!=null){
				work_id = request.getParameter("work_id");
				System.out.println("===="+work_id);
			}
	        
			try {
				mboolean = new UserDaoImpl(){}.setMyComics(work_id);
			} catch (Exception e) {
				mboolean = null;
				e.printStackTrace();
			}		
			System.out.println(mboolean);
			response.getOutputStream().write(mboolean.getBytes("utf-8"))	;
			
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
	
		doGet(request,response);
		
	}

}

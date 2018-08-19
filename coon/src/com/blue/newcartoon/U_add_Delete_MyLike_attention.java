package com.blue.newcartoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.json.Json;
import com.blue.user.UserDaoImpl;

public class U_add_Delete_MyLike_attention extends HttpServlet {

	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
	    
    	String mboolean = ""+-1;
    	
    	String id = -1+"";
    	String attention = "";
    	String attention_id = -1+"";
    	boolean boolean_num = false;
    	
    	if(request.getParameter("id")!=null)
    		id = request.getParameter("id");
    	if(request.getParameter("attention")!=null)
    		attention = request.getParameter("attention");
    	if(request.getParameter("attention_id")!=null)
    		attention_id = request.getParameter("attention_id");
    	if(request.getParameter("boolean_num")!=null){
    		boolean_num = Boolean.parseBoolean(request.getParameter("boolean_num"));
    	System.out.println("bushinuoazdflwadmdl=="+boolean_num);
    	
    	;
    	}System.out.println("com.blue.lanfeng.UQuestionSerblet:22:"+mboolean);
    	System.out.println("com.blue.lanfeng.UQuestionSerblet:22:"+id);
    	System.out.println("com.blue.lanfeng.UQuestionSerblet:22:"+attention);
    	System.out.println("com.blue.lanfeng.UQuestionSerblet:22:"+attention_id);
    	
    	try {
    		
			mboolean = new UserDaoImpl(){}.u_add_delete_mylike_attention(id,attention,attention_id,boolean_num);
			System.out.println("com.blue.lanfeng.UQuestionSerblet:22:"+mboolean);
			
		} catch (Exception e) {
			
			System.out.println(e);
			e.printStackTrace();
			
		}finally{
			
			response.getOutputStream().write(mboolean.toString().getBytes());
			
		}
		    
		
    }
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {

			doGet(request,response);
	
	}

}

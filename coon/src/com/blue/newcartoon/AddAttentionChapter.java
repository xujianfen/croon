package com.blue.newcartoon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.json.Json;
import com.blue.json.JsonAgent;
import com.blue.user.UserDaoImpl;

public class AddAttentionChapter extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {

		    request.setCharacterEncoding("UTF-8");
		    
			String mboolean = -1+"";
		   
			String this_chapter = ""+-1; //��ǰ���� 2
		    String view_list = "";//ͼƬ���� 3
//		    String danmak = "";//��Ļ���� 4
//		    String danmak_X = "";//��ĻX�� 5
//		    String danmak_Y = "";//��ĻY�� 6
//		    String danmak_position = "";//��Ļλ�� 7
		    String attention_id = ""+-1;//����id 8
		  	if(request.getParameter("this_chapter")!=null){
				this_chapter = request.getParameter("this_chapter");
			}
			if(request.getParameter("view_list")!=null){
				view_list = request.getParameter("view_list");
				}
		
//			if(request.getParameter("danmak")!=null){
//				danmak = request.getParameter("danmak");
//				}
//			if(request.getParameter("danmak_X")!=null){
//				danmak_X = request.getParameter("danmak_X");
//				}
//			if(request.getParameter("danmak_Y")!=null){
//				danmak_Y = request.getParameter("danmak_Y");
//				}
//			if(request.getParameter("danmak_position")!=null){
//				danmak_position = request.getParameter("danmak_position");
//				}
			if(request.getParameter("attention_id")!=null){
	
				attention_id = request.getParameter("attention_id");

				}
//			if(request.getParameter("attention")!=null){
//				attention = request.getParameter("attention");
//			}
			System.out.println(mboolean+" "+this_chapter+" "+view_list+" "+attention_id);
			try {
				mboolean = new UserDaoImpl(){}.addcomicsChapter(this_chapter,view_list,attention_id);//,attention
			} catch (Exception e) {
				e.printStackTrace();
			}		
			
			response.getOutputStream().write(mboolean.getBytes())	;
			
	}
	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {
	
			doGet(request,response);
		
		}
		
}

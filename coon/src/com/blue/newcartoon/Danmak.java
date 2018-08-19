package com.blue.newcartoon;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.atguigu.android.json.bean.AttentionChapter;
import com.blue.json.Json;
	import com.blue.user.User;
	import com.blue.user.UserDaoImpl;

	 public class Danmak  extends HttpServlet {
	    private AttentionChapter attentionChapter = new AttentionChapter();
	     private String mboolean =-2+"";
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	attentionChapter.setId(Integer.parseInt(request.getParameter("attention_id")));
	    	if(request.getParameter("danmak")!=null)
	    		attentionChapter.setDanmak(new String(request.getParameter("danmak")));
	    	if(request.getParameter("danmak_postion")!=null)
	    		attentionChapter.setDanmak_position(request.getParameter("danmak_postion"));
			
	    	System.out.println("sss="+attentionChapter.getDanmak_position());
	    	String danmak = "";
			String danmak_position = "";
			if(request.getParameter("danmak_id")!=null)
				danmak = request.getParameter("danmak_id");
			if(request.getParameter("danmak_position_id")!=null)
				danmak_position = request.getParameter("danmak_position_id");
			try {
				mboolean = new UserDaoImpl().setUser(attentionChapter,danmak,danmak_position);
			} catch (Exception e) {
		
				e.printStackTrace();
			
			}
		
			  	response.getOutputStream().write(mboolean.toString().getBytes("utf-8"))	;
			  	System.out.println("<a>"+mboolean+"</a>");
			}
			
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doGet(request,response);
		
		}

	}

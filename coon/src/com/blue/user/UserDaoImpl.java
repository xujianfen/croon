package com.blue.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.atguigu.android.json.bean.Account;
import com.atguigu.android.json.bean.Attention;
import com.atguigu.android.json.bean.AttentionChapter;
import com.atguigu.android.json.bean.AttentionChapterInclude;
import com.atguigu.android.json.bean.MyComics;
//import com.atguigu.android.json.bean.String;
import com.blue.json.Json;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class UserDaoImpl {
	
	public String boolean_num= ""+-1;
	public ArrayList  stringToList(String string){
		
		if(string==null)
			return null;
		
		ArrayList list = new ArrayList();
		Pattern p = Pattern.compile(",");
		String s[]=p.split(string);
		
		for(String ss:s){
		   list.add(ss);	
		}
		return list;
		
	}
	
	
	  
	   /**
	    * 
	    * ËùÓÐÕÂ½ÚÔ¤ÀÀ
	    * @param id
	    * @param num
	    * @return
	    */
	   public String setAllAttentionChapter(String id){
		   	
		   	Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String  mboolean = "";
			List<String> v = new ArrayList<String>();
			try {
				System.out.println("1");
			    
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement("select * from attention_chapter where attention_id=?");//
				System.out.println("2");
				ps.setInt(1, Integer.parseInt(id));
				System.out.println("3");
				rs = ps.executeQuery();
				System.out.println("41");
				Gson gson = new Gson();
				while(rs.next()){
					System.out.println(rs.getString(3));
					List<String> rs_3 = gson.fromJson(rs.getString(3),new
								TypeToken<List<String>>(){}.getType());
					if(rs_3.size()!=0)
						v.add(rs_3.get(0));
					
				;
				}
				mboolean = gson.toJson(v);
				
			} catch (Exception e) {
				
				mboolean = null;
				e.printStackTrace();
				
			}finally{
				
				DBUtils.closeAll(rs, ps, conn);
				System.out.println("mboolean = "+mboolean+" ");
				return mboolean;
				
			}
			
	   }
	   
	   
	/**
	 * 
	 * ËÑË÷
	 * @param num
	 * @return
	 */
	public String setAllcomics(String num1){
		
		 Connection conn = null;
	     PreparedStatement ps = null;
		 ResultSet rs = null;
		 
		 int num = Integer.parseInt(num1);
		 int i =0;
		 int m =2;
		 String  mboolean = "";
		 int a =2;
		 int s = 2;
		 if(num == 0){
		    m=0;
		 }
		 
		 try {
			 
			 Gson gson = new Gson();
			conn = DBUtils.getConnection();
			System.out.println("    aa  "+num1);
			ps = conn.prepareStatement("select * from attention");
			System.out.println("  bb  "+i);
			rs = ps.executeQuery();
			List<Attention> attentionArray = new ArrayList<Attention>();
			
			while(rs.next()){
				if(i>=num*a+m&&i<(num+1)*a+s){
					 
					attentionArray.add(new Attention(rs.getInt(1),rs.getString(2),rs.getString(3)
					,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
					
				 } 
				 i++;
					 
			}
			
			mboolean = gson.toJson(attentionArray);
			
			 }catch (Exception e) {
				
				 System.out.println(e);
				 mboolean = null;
				 
			}	
		 
		return mboolean;
	}
		 
  
	
    
    /**
     * 
     * Êé¼Üä¯ÀÀ
     * 
     */
    public String setMyLikeComics(List<String> attention){
		  
	    Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String  mboolean = "";
		int i;
		List<Attention> attentionArray = new ArrayList<Attention>();
		
		try {
			
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from attention");//
			rs = ps.executeQuery();
			while(rs.next()){
			
				for(i=0;i<attention.size();i++)
					if(rs.getInt(1)==Integer.parseInt(attention.get(i).toString()))
						break;
				if(i!=attention.size()){
					
					Attention a = new Attention(rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
					attentionArray.add(a);
					
				}
				
				
			}
			
			Gson gson = new Gson();
			mboolean = gson.toJson(attentionArray);
			
		} catch (Exception e) {
			
			mboolean = null;
			e.printStackTrace();
			
		}finally{
			
			DBUtils.closeAll(rs, ps, conn);
			return mboolean;
			
		}
			
   }
    
    
    /**
     * 
     * ¿´Âþ»­
     * @param id
     * @return
     */
    public String setLookAttentionChapter(String id,String this_chapter){
	   	
	   	Connection conn = null;
	   	PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		String mboolean = "";
		List<AttentionChapter> attentionchapterarray = new ArrayList<AttentionChapter>();
		try {
			int a =0;
			conn = DBUtils.getConnection();
			System.out.println(true);
			ps = conn.prepareStatement("select * from attention_chapter where this_chapter=?&&attention_id=?");
			System.out.println(false);
			ps.setInt(2, Integer.parseInt(id));
			ps.setInt(1, Integer.parseInt(this_chapter));
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(a++);
				AttentionChapter attentionChapter = new AttentionChapter(rs.getInt(1),rs.getInt(2),
						rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getInt(8));
				attentionchapterarray.add(attentionChapter);
				
			}
			
			Gson gson = new Gson();
			mboolean = gson.toJson(attentionchapterarray);
		    System.out.println(mboolean);
		} catch (Exception e) {
			
			mboolean = null;
			e.printStackTrace();
		}finally{
		
			DBUtils.closeAll(rs, ps, conn);
			System.out.println("mboolean = "+mboolean+" ");
			return mboolean;
		
		}
	   
   }
    
	/**
	 * 
	 * µÇÂ½
	 * @param name
	 * @param password
	 * @return
	 */
	public String set(String name,String password,boolean b){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account;
			try {
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement("select * from account where password=?||idAccount=?");//
				ps.setString(2, name);
				ps.setString(1, password);
				rs = ps.executeQuery();
				while(rs.next()){
					
					if(name.equals(rs.getString(7))){
						if(b)
							if(password.equals(rs.getString(3))){
								
						 	    account = new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						 	    		rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),
						 	    		rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
										rs.getString(14),rs.getString(15));
						 
							    Gson gson = new Gson();
						 	    boolean_num = gson.toJson(account);
						 	    
						
							}
							else{
								boolean_num = "3";
								System.out.println(boolean_num+" sss");
							}
						else{
							boolean_num ="2";
						}
					}
				   
			
				}
				if(!b&&!boolean_num.equals("2"))
					boolean_num = In(name,password);
				if(b&&boolean_num.equals("-1")){
					boolean_num = "2";
				}
				
			} catch (Exception e) {
				boolean_num = ""+-1;
				e.printStackTrace();
				System.out.println(e);
			}finally{
		
				DBUtils.closeAll(rs, ps, conn);
				System.out.println("error:"+boolean_num+" "+name+" "+password);
			}
			
		return boolean_num;
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	  public String In(String accound,String password){
		  
		     String mboolean = "-1";
		    Connection conn = null;
		    PreparedStatement ps = null;
		   
		    try{
			     System.out.println("Ìí¼Ó");
		    	conn = DBUtils.getConnection();
				ps = conn.prepareStatement("INSERT INTO account(id,idAccount,password) VALUES(?,?,?)");
				ps.setInt(1,0);
				ps.setString(2,accound);
			    ps.setString(3,password);
	            int i = ps.executeUpdate();
			   System.out.println("×¢²á³É¹¦");
			   mboolean = 1+""x;
		    }catch(Exception e){
		    	e.printStackTrace();
		    	throw new RuntimeException("Ìí¼ÓÊ§°Ü"+e);
		    }finally{
		    	DBUtils.closeAll(null, ps, conn);
		    	return mboolean;
		    }
		    
		  
	  }
	  
	/**
	 * 
	 * Ìí¼ÓÂþ»­ÕÂ½Ú
	 * @param this_chapter
	 * @param view_list
	 * @param danmak
	 * @param danmak_X
	 * @param danmak_Y
	 * @param danmak_position
	 * @return
	 */
	public String addcomicsChapter(String this_chapter,String view_list,String attention_id){//,String attention
		   
		    String mboolean = "-1";
		    Connection conn = null;
		    PreparedStatement ps = null;
		   
		    try{
			
		    	conn = DBUtils.getConnection();
				ps = conn.prepareStatement("INSERT INTO attention_chapter(id,this_chapter,view_list,danmak,danmak_X,danmak_Y,danmak_position,attention_id) VALUES(?,?,?,?,?,?,?,?)");
				ps.setInt(1,0);
			    ps.setInt(2,Integer.parseInt(this_chapter));
			    ps.setString(3,view_list);
			    ps.setString(4,"");
			    ps.setString(5,null);
			    ps.setString(6,null);
			    ps.setString(7,"");
			    ps.setInt(8,Integer.parseInt(attention_id));
			   
			    System.out.println(view_list);
			    int i = ps.executeUpdate();
			   
			    System.out.println(view_list);
		    }catch(Exception e){
		    	e.printStackTrace();
		    	throw new RuntimeException("Ìí¼ÓÊ§°Ü"+e);
		    }finally{
		    	DBUtils.closeAll(null, ps, conn);
//		    	mboolean = s_attention(attention_id,attention);
		    	return mboolean;
		    }
		    
	}    
	   public String s_attention(String attention_id,String attention){
		
		    String mboolean = "-1";
		    Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Account account;
				try {
					
					conn = DBUtils.getConnection();
					ps = conn.prepareStatement("select * from attention_chapter where attention_id=?");//
					ps.setInt(1,Integer.parseInt(attention_id));
					rs = ps.executeQuery();
					Gson gson = new Gson();
					List<String> attention_array = gson.fromJson(attention,new TypeToken<List<String>>(){}.getType());
					int x;
					
					while(rs.next()){
						
						for(x=0;x<attention_array.size();x++){
							
							if(attention_array.get(x).toString().equals(rs.getInt(1)+""))
								break;
						
						}
						
						if(x>attention_array.size()){
							mboolean = u_attention(rs.getInt(1)+"",attention,attention_id);
							
							break;
						}
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}finally{
					
					DBUtils.closeAll(rs, ps, conn);
					return mboolean;
				}
				
	  }
		
	   public String  u_attention(String id,String attention,String attention_id){
	   
	   String mboolean = -1+"";
	   Connection conn = null;
	   PreparedStatement ps = null;
	   
	   try{ 
		
		    conn = DBUtils.getConnection();	
			ps = conn.prepareStatement("UPDATE account SET attention=?,attentionnum=? WHERE id=?");
			
			Gson gson = new Gson();
			List<String> attention_all_id = gson.fromJson(attention,new TypeToken<List<String>>(){
			}.getType());
			
			attention_all_id.add(new String(id));
				
		    ps.setString(1,gson.toJson(attention_all_id));
	        ps.setInt(2,attention_all_id.size());
			ps.setInt(3,Integer.parseInt(attention_id));
			mboolean = "1";
			int a = ps.executeUpdate();
		
	   }catch(Exception e){
			
			e.printStackTrace();
			throw new RuntimeException("ÐÞ¸ÄÊ§°Ü£¡£¡£¡");
	
		}finally{
		
			DBUtils.closeAll(null, ps, conn);
			return mboolean;
		   
		}   
	   
	}

	
	   
	public String setMyComics(String work_id1){
		
		 Connection conn = null;
	     PreparedStatement ps = null;
		 ResultSet rs = null;
		 
		 int work_id = Integer.parseInt(work_id1);
		 String  mboolean = "";
		 
		 try {
			
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from attention where work_id=?");
			ps.setInt(1,work_id);
			rs = ps.executeQuery();
			List<MyComics> mycomics_array = new ArrayList<MyComics>();
			while(rs.next()){
					
				MyComics mycomics = new MyComics(rs.getInt(1),rs.getString(2),rs.getString(7));
				mycomics_array.add(mycomics);
				
			} 
			Gson gson = new Gson();
			mboolean = gson.toJson(mycomics_array);
			
		 }catch (Exception e) {
			
			 System.out.println(e);
			 mboolean = null;
			 
		}	
		 
		return mboolean;
		
	}
	/**
	 * 
	 * Ìí¼ÓÂþ»­
	 * 
	 */
	  public String addComics(String name,String work,String work_id,String introduce,String cover){
		   
		   int a = -1;
		    Connection conn = null;
		    PreparedStatement ps = null;
		    
		    try{
		    conn = DBUtils.getConnection();
			ps = conn.prepareStatement("INSERT INTO attention(id,name,work,work_id,attention_num,introduce,cover) VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1,0);
		    ps.setString(2,name);
		    ps.setString(3,work);
		    ps.setInt(4,Integer.parseInt(work_id));
		    ps.setInt(5,0);
		    ps.setString(6,introduce);
		    ps.setString(7,cover);
		
		    int i = ps.executeUpdate();
		    a = 1;
		    
		    }catch(Exception e){
		    	e.printStackTrace();
		    	throw new RuntimeException("Ìí¼ÓÊ§°Ü"+e);
		    }finally{
		    	DBUtils.closeAll(null, ps, conn);
		    	return a+"";
		    }
		    
	   }
	  
	
	/**
	 * 
	 * ¸ü¸ÄÍ·Ïñ
	 */
	public String vImage(String id,String image){
		    int i = -1;
			Connection conn = null;
			PreparedStatement ps = null;
			try{ 
				conn = DBUtils.getConnection();	
				ps = conn.prepareStatement("UPDATE account SET head=? WHERE id=?");
				ps.setInt(2,Integer.parseInt(id));  
				ps.setString(1,image);
			    int a = ps.executeUpdate();
			    i=1;
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("ÐÞ¸ÄÊ§°Ü£¡£¡£¡");
			
	}finally{
			DBUtils.closeAll(null, ps, conn);
			return i+"";
		}
	}
	
	
	/**
	 * 
	 * 
	 * ÐÞ¸Ä¸öÈËÐÅÏ¢
	 * @param id
	 * @param username
	 * @param password
	 * @param phone
	 * @param introduce
	 * @param industry
	 * @param gender
	 * @return
	 */
	public int uUser(String id,String username,String password,String phone,String introduce,String industry,String gender){
		
		int i = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		try{ 
			
			conn = DBUtils.getConnection();	
		    ps = conn.prepareStatement("UPDATE account SET username=?,password=?,phone=?,introduce=?,industry=?,gender=? WHERE id=?");
		    ps.setString(1,username);
	        ps.setString(2,password);
	        ps.setString(3,phone);
	        ps.setString(4,introduce);
	        ps.setString(5,industry);
	        ps.setString(6,gender);
	        ps.setString(7,id);
		    int a = ps.executeUpdate();
		    i = 1;
		    System.out.println("ÐÞ¸Ä³É¹¦");
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println("ÐÞ¸ÄÊ§°Ü");
			throw new RuntimeException("ÐÞ¸ÄÊ§°Ü£¡£¡£¡");
			
		}finally{
			
			System.out.println(i);
			DBUtils.closeAll(null, ps, conn);
			return i;
		
		}
	}
	
	
		/**
		 * 
		 * Ìí¼Ó»òÉ¾³ýÊé¼ÜµÄÄÚÈÝ
		 * @param id
		 * @param attention
		 * @param attention_id
		 * @param boolean_num
		 * @return
		 */
		  public String u_add_delete_mylike_attention(String id,String attention,String attention_id,boolean boolean_num){
		   
		   String mboolean = -1+"";
		   Connection conn = null;
		   PreparedStatement ps = null;
		   
		   try{ 
			
			    conn = DBUtils.getConnection();	
				ps = conn.prepareStatement("UPDATE account SET attention=?,attentionnum=? WHERE id=?");
				boolean n = false;
			    int num =0;
				Gson gson = new Gson();
				List<String> attention_all_id = gson.fromJson(attention,new TypeToken<List<String>>(){
				}.getType());
				if(attention_all_id==null){
					System.out.println("null");
				
					attention_all_id = new ArrayList<String>();
				}
				System.out.println("attention_all_id=="+attention_all_id);
				System.out.println("atention_id=="+attention);
				System.out.println("mboolean ==="+boolean_num);
				for(int i=0;i<attention_all_id.size();i++)
					
					if(attention_all_id.get(i).equals(attention_id+"")){
					  n = true;
					  num = i;
					}
					if(!boolean_num){
						if(n)
						attention_all_id.remove(num);
					}
					else
						if(!n)
						attention_all_id.add(new String(""+attention_id));
				
//				
//				if(n||attention_all_id.size()==0){
//					if(boolean_num)
//						attention_all_id.add(new String(""+attention_id));
//				}
				System.out.println("1=="+attention_all_id);
				System.out.println("2=="+attention);
				System.out.println("3 ==="+boolean_num);
				ps.setString(1,gson.toJson(attention_all_id));
   	       		ps.setInt(2,attention_all_id.size());
				ps.setInt(3,Integer.parseInt(id));
				mboolean = gson.toJson(attention_all_id);
				int a = ps.executeUpdate();
			
		   }catch(Exception e){
				
				e.printStackTrace();
				throw new RuntimeException("ÐÞ¸ÄÊ§°Ü£¡£¡£¡");
    	
			}finally{
			
				DBUtils.closeAll(null, ps, conn);
				return mboolean;
			   
			}   
		   
		}
		  
	
	 
	   
	   
	
	 
	   
	   
       /**
        * 
        * É¾³ý×÷Æ·
        * @param id
        * @param attention_id
        * @return
        */

	   public String remove_my_work_attention(String attention_id){
		   
		   	Connection conn = null;
			PreparedStatement ps = null;
	    	
			String mboolean = "";
	    	
			try{
		    	
	    		conn = DBUtils.getConnection();	
		    	ps = conn.prepareStatement("DELETE FROM attention WHERE id=?");
				ps.setInt(1,Integer.parseInt(attention_id));
				int i = ps.executeUpdate();
				ps = conn.prepareStatement("DELETE FROM attention_chapter WHERE attention_id=?");
				ps.setInt(1,Integer.parseInt(attention_id));
			    System.out.println("id= "+Integer.parseInt(attention_id));
				int j = ps.executeUpdate();
//			    mboolean = u_attention(id, attention_id, attention);
			    mboolean = ""+1; 
	    	}catch(Exception e){
	    		
	    		mboolean = null;
	    		e.printStackTrace();
	    		throw new RuntimeException(e);
	    		
	    	}finally{

	    		DBUtils.closeAll(null, null, conn);
	    		return mboolean;
	    	
	    	}
	    
	   }
	   /**
		 *À¬»ø 
		 * @param user
		 * @return
		 * @throws Exception
		 */
		
		
		
		
		public String setUser(AttentionChapter attentionChapter,String danmak,String danmak_ip) throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
		
			int  mboolean=1;
			Gson gson = new Gson();
			List<String> attention_all_id ;
			List<String> attention_all_id2;
				attention_all_id = gson.fromJson(attentionChapter.getDanmak(),new TypeToken<List<String>>(){
			}.getType());
		
			attention_all_id2 = gson.fromJson(attentionChapter.getDanmak_position(),new TypeToken<List<String>>(){
			}.getType());
			
			try {
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement("UPDATE attention_chapter SET danmak=?,danmak_position=? WHERE id=?");
				if(attention_all_id2==null)
					attention_all_id2 = new ArrayList<String>();
				if(attention_all_id==null)
					attention_all_id = new ArrayList<String>();
			    System.out.println("1 = "+attention_all_id);
			    System.out.println("2 = "+attention_all_id2);
			
				attention_all_id.add(danmak);
				attention_all_id2.add(danmak_ip);
			    System.out.println(gson.toJson(attention_all_id)+"1 = "+attention_all_id);
			    System.out.println(gson.toJson(attention_all_id2)+"2 = "+attention_all_id2);
			    System.out.println("2 = "+attentionChapter.getId());
				ps.setString(1,gson.toJson(attention_all_id));
				ps.setString(2,gson.toJson(attention_all_id2));
				ps.setInt(3,attentionChapter.getId());
				int a = ps.executeUpdate();
		
			} catch (Exception e) {
				mboolean = -2;
				e.printStackTrace();
			}finally{
				DBUtils.closeAll(null, ps, conn);
			  System.out.println("mboolean = "+mboolean+" ");
			 }
			return mboolean+"";
		}
		
		
	   	public String u_attention(int id,int attention_id,String attention){
			   
			   String mboolean = "";
			   Connection conn = null;
			   PreparedStatement ps = null;
			   try{ 
					conn = DBUtils.getConnection();	
					ps = conn.prepareStatement("UPDATE account SET comics=?,comicsnum=? WHERE id=?");
					Gson gson = new Gson();
					List<String> attention_all_id = gson.fromJson(attention,new TypeToken<List<String>>(){
					}.getType());
					
					for(int i=0;i<attention_all_id.size();i++){
						
						if(attention_all_id.get(i).equals(attention_id+""))
						
							attention_all_id.remove(i);
					
					}
						
					mboolean = gson.toJson(attention_all_id);
					ps.setString(1,mboolean);
	   	       		ps.setInt(2,attention_all_id.size());
					ps.setInt(3,id);
					
					int a = ps.executeUpdate();
					
				}catch(Exception e){
					
					mboolean = null;
					e.printStackTrace();
					throw new RuntimeException("É¾³ýÖ®ÐÞ¸ÄÊ§°Ü£¡£¡£¡");
					
	    	}finally{
				DBUtils.closeAll(null, ps, conn);
			
			   return mboolean;
	    	}
		}
		   
	   
}	 
		
			
    


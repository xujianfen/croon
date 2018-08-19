package com.blue.json;

import java.util.regex.Pattern;

import com.blue.user.User;

public class Json {
	public String setJson(User user){
	      	return user.toString();
	}
	public  String[]  setJson(String string){
		Pattern p = Pattern.compile("[/}/,/{]");      	
		String s[]=p.split(string);
		return s;
	}
	public  String getJson(Object ...object){
		String state = "Json:{";
		for(int i=0;i<object.length;i++){
			state += object[i];
			if(i!=object.length-1)
			state+="},{";
			else
			state += "}";
		}
		
		return state;
	}
	public boolean jsonEquals(String give,String newgive){
		boolean b = false;
		try{
			Pattern p = Pattern.compile("[+]");      	
			String s[]=p.split(give);
				for(int i=0;i<s.length;i++){
					b =newgive.equals(s[i]);
					if(b)
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
		    }
		System.out.println("json:41:"+b);
		return b;
	}

	public User setPersonalJson(String state){
		User user = new User();
		try{
		Pattern p = Pattern.compile("[/}/,/{]");      	
		String s[]=p.split(state);
		if(s[0].contentEquals("Json:")){
				for(int i=0;i<s.length;i++)
				System.out.println(s[i]+" "+i);
			  	user.setId(Integer.parseInt(s[1]));
				user.setUsername(s[1+1*3]);;
		    	user.setIndustry(s[1+15*3]);
		    	user.setIntroduce(s[1+14*3]);
		    	user.setGender(s[1+13*3]);
		    	System.out.println("gender"+user.getGender());
		    	System.out.println("com.json:25:"+user);
		    } 		
		} catch (Exception e) {
			e.printStackTrace();
	    }
    	
    	return user;
	}
	
}

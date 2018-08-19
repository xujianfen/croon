package com.blue.json;

public class JsonAgent {
	private Json json = null;
	public String[] setJson(String state){
		String [] w;
		w = json.setJson(state);
		return w;
	}
  public String getJson(Object ...object){
	  String state = null;
	  state = json.getJson(object);
	  return state;
  }
}

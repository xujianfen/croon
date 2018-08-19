package com.atguigu.android.json.bean;



import java.util.List;

import com.google.gson.Gson;

/**
 * Created by �� on 2018/8/8.
 */

public class AttentionChapter {
    public AttentionChapter(int id, int this_chapter, String view_list, String danmak,
			String danmak_X, String danmak_Y, String danmak_position) {
		super();
		this.id = id;
		this.this_chapter = this_chapter;
		this.view_list = view_list;
		this.danmak = danmak;
		this.danmak_X = danmak_X;
		this.danmak_Y = danmak_Y;
		this.danmak_position = danmak_position;
	}
    
    public AttentionChapter(){
    	super();
    }
    
	private int id; //id 1
    private int this_chapter; //��ǰ���� 2
    private String view_list;//ͼƬ���� 3
    private String danmak;//��Ļ���� 4
    private String danmak_X;//������ 5
    private String danmak_Y;//��ĻY�� 6
    private String danmak_position;//��Ļλ�� 7
    private int attention_id;//����Id 8
	public AttentionChapter(int id, int this_chapter, String view_list, String danmak, String danmak_X, String danmak_Y,
			String danmak_position, int attention_id) {
		super();
		this.id = id;
		this.this_chapter = this_chapter;
		this.view_list = view_list;
		this.danmak = danmak;
		this.danmak_X = danmak_X;
		this.danmak_Y = danmak_Y;
		this.danmak_position = danmak_position;
		this.attention_id = attention_id;
	}
	public int getAttention_id() {
		return attention_id;
	}
	public void setAttention_id(int attention_id) {
		this.attention_id = attention_id;
	}
	@Override
	public String toString() {
		return "AttentionChapter [id=" + id + ", this_chapter=" + this_chapter + ", view_list=" + view_list
				+ ", danmak=" + danmak + ", danmak_X=" + danmak_X + ", danmak_Y=" + danmak_Y + ", danmak_position="
				+ danmak_position + ", attention_id=" + attention_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getThis_chapter() {
		return this_chapter;
	}
	public void setThis_chapter(int this_chapter) {
		this.this_chapter = this_chapter;
	}
	public String getView_list() {
		return view_list;
	}
	public void setView_list(String view_list) {
		this.view_list = view_list;
	}
	public String getDanmak() {
		return danmak;
	}
	public void setDanmak(String danmak) {
		this.danmak = danmak;
	}
	public String getDanmak_X() {
		return danmak_X;
	}
	public void setDanmak_X(String danmak_X) {
		this.danmak_X = danmak_X;
	}
	public String getDanmak_Y() {
		return danmak_Y;
	}
	public void setDanmak_Y(String danmak_Y) {
		this.danmak_Y = danmak_Y;
	}
	public String getDanmak_position() {
		return danmak_position;
	}
	public void setDanmak_position(String danmak_position) {
		this.danmak_position = danmak_position;
	}
    

}

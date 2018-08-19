package com.atguigu.android.json.bean;

public class AttentionChapterInclude {
	
	private int id;
	private int this_chapter;
	private String view_list;
	public AttentionChapterInclude(int id, int this_chapter, String view_list) {
		super();
		this.id = id;
		this.this_chapter = this_chapter;
		this.view_list = view_list;
	}
	@Override
	public String toString() {
		return "AttentioonChapterInclude [id=" + id + ", this_chapter=" + this_chapter + ", view_list=" + view_list
				+ "]";
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
	
	
	
}

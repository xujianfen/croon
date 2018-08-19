package com.atguigu.android.json.bean;

public class MyComics {


    private int id;//id 1
    private String name;//Âþ»­Ãû 2
    private String cover;//·âÃæ 7
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public MyComics(int id, String name, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "MyComics [id=" + id + ", name=" + name + ", cover=" + cover + "]";
	}
    
}

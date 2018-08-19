package com.blue.user;

import java.util.Date;

public class User {
	public User(){
		super();
	}
	public void setUser(Integer id, String username, String password,
			String phone,String idea, String attention,String collect,
			String head, String cover,String gender, String introduce, String industry, 
			String fans,int fansnum, int attentionnum, int ideanum
			) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.attention = attention;
		this.attentionnum = attentionnum;
		this.fans = fans;
		this.fansnum = fansnum;
		this.ideanum = ideanum;
		this.idea = idea;
		this.collect = collect;
		this.head = head;
		this.cover = cover;
		this.gender = gender;
		this.introduce = introduce;
		this.industry = industry;
	}
	private Integer id;//账号
	private String username;//用户名
	private String password;//密码
	private String phone;//手机号
	private String attention;//关注
	private int attentionnum;//关注人数
	private String fans;//粉丝
	private  int fansnum;//粉丝人数
	private int ideanum;//我的想法数量
	private String idea;//我的想法
	private String collect;//收藏
	private String head;//头像
	private String cover;//封面
	private String gender;//性别
	private String introduce;//介绍
	private String industry;//行业
	public int getAttentionnum() {
		return attentionnum;
	}

	public void setAttentionnum(int attentionnum) {
		this.attentionnum = attentionnum;
	}

	public String getFans() {
		return fans;
	}

	public void setFans(String fans) {
		this.fans = fans;
	}

	public int getFansnum() {
		return fansnum;
	}

	public void setFansnum(int fansnum) {
		this.fansnum = fansnum;
	}

	public int getIdeanum() {
		return ideanum;
	}

	public void setIdeanum(int ideanum) {
		this.ideanum = ideanum;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getCollect() {
		return collect;
	}

	public void setCollect(String collect) {
		this.collect = collect;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	@Override
	public String toString() {
		return "Json:{"+id+"},{" + username + "},{"
				+ password + "},{" + phone + "},{" + idea + "},{" + attention+ "},{"
						+ collect + "},{" + head + "},{"
						+ cover + "},{" + gender + "},{" + introduce
						+ "},{" + industry 
				+ "},{" + fans
				+ "},{" + fansnum + "},{"+ attentionnum + "},{"  + ideanum + "}";
	}
	//"Json:{"+name+"},{"+id+"},{"+phone+"}"
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}

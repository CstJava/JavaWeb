package com.service.user;

import java.io.Serializable;


public class User implements Serializable{

	private String name;
	private String phoneNum;
	private String sex;
	private int age;
	private String email;
	private String address;
	private String introduction;
	private String password;
	private String headSculptureAdd;
	private int fans;
	private int guanzhu;
	private String userCreateTime;
	private int userCommentNum;
	private int userTopicNum;
	public User(){
		
	};
	public User(String name, String phoneNum, String sex, int age, String email,
			String address, String introduction,String password) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.address = address;
		this.introduction = introduction;
		this.setPassword(password);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String string) {
		this.phoneNum = string;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String string) {
		this.password = string;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getGuanzhu() {
		return guanzhu;
	}
	public void setGuanzhu(int guanzhu) {
		this.guanzhu = guanzhu;
	}
	public String getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	public int getUserCommentNum() {
		return userCommentNum;
	}
	public void setUserCommentNum(int userCommentNum) {
		this.userCommentNum = userCommentNum;
	}
	public int getUserTopicNum() {
		return userTopicNum;
	}
	public void setUserTopicNum(int userTopicNum) {
		this.userTopicNum = userTopicNum;
	}
	public String getHeadSculptureAdd() {
		return headSculptureAdd;
	}
	public void setHeadSculptureAdd(String headSculptureAdd) {
		this.headSculptureAdd = headSculptureAdd;
	}
	
}

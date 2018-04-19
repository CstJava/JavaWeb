package com.service.topic;

import java.io.Serializable;

public class Topic implements Serializable{

	private String phoneNum;
	private int topicNum;
	private String topicName;
	private String topicType;
	private String topicContent;
	private int topicCommentNum;
	private String topicCreateTime;
	private int topicClickNum;
	private String topicLastClickTime;
	private String name;
	private int zan;
	private int collectionNum;
	public Topic(){
		
	}
	
	public Topic(String phoneNum, int topicNum, String topicName,
			String topicType, String topicContent, int topicCommentNum,
			String topicCreateTime, int topicClickNum,
			String topicLastClickTime, String name, int zan) {
		super();
		this.phoneNum = phoneNum;
		this.topicNum = topicNum;
		this.topicName = topicName;
		this.topicType = topicType;
		this.topicContent = topicContent;
		this.topicCommentNum = topicCommentNum;
		this.topicCreateTime = topicCreateTime;
		this.topicClickNum = topicClickNum;
		this.topicLastClickTime = topicLastClickTime;
		this.name = name;
		this.zan = zan;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getTopicNum() {
		return topicNum;
	}
	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicType() {
		return topicType;
	}
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public int getTopicCommentNum() {
		return topicCommentNum;
	}
	public void setTopicCommentNum(int topicCommentNum) {
		this.topicCommentNum = topicCommentNum;
	}
	public String getTopicCreateTime() {
		return topicCreateTime;
	}
	public void setTopicCreateTime(String topicCreateTime) {
		this.topicCreateTime = topicCreateTime;
	}
	public int getTopicClickNum() {
		return topicClickNum;
	}
	public void setTopicClickNum(int topicClickNum) {
		this.topicClickNum = topicClickNum;
	}
	public String getTopicLastClickTime() {
		return topicLastClickTime;
	}
	public void setTopicLastClickTime(String topicLastClickTime) {
		this.topicLastClickTime = topicLastClickTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}

	public int getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}
	
}

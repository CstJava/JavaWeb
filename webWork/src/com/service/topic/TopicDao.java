package com.service.topic;

import java.util.ArrayList;
import java.util.HashMap;

import com.service.comment.Comment;
import com.service.user.User;

public interface TopicDao {

	/**
	 * 获取话题信息
	 * @param topicNum
	 * @param phoneNum 
	 * @return
	 */	
	Topic topicInfo(int topicNum);
	
	/**
	 * 获取话题主人信息
	 * @param topicNum
	 * @param phoneNum 
	 * @return
	 */
	User topicUserInfo(int topicNum, String phoneNum);
	
	/**
	 * 获取话题评论信息列表
	 * @param topicNum
	 * @return
	 */
	HashMap<String,ArrayList<Object>> topicCommentList(int topicNum);
	
	/**
	 * 创建话题评论
	 * @param topicComment
	 * @param topicNum 
	 * @return
	 */
	boolean createComment(String topicComment,String phoneNum, int topicNum);
	/**
	 * 获得当前用户话题信息
	 * @param phoneNum
	 * @return
	 */
	ArrayList<Topic> personTopic(String phoneNum);
	
	/**
	 * 创建话题
	 * @param phoneNum
	 * @param topicName
	 * @param topicType
	 * @param topicContent
	 * @return
	 */
	boolean createTopic(String phoneNum,String topicName,String topicType,String topicContent);
	
	/**
	 * 删除话题
	 * @param topicNum
	 * @return
	 */
	boolean topicDelete(int topicNum);
	
	/**
	 * 操作收藏
	 * @param phoneNum
	 * @param topicNum
	 * @return
	 */
	String collectActivity(String phoneNum,int topicNum);

	/**
	 * 话题点赞
	 * @param topicNum
	 * @return 
	 */
	int zan(int topicNum);
	
	/**
	 * 评论点赞
	 * @param commentNum
	 * @return
	 */
	int commentZan(int commentNum);
	
	/**
	 * 删除评论
	 * @param commentNum
	 * @return
	 */
	boolean deleteComment(int commentNum);
	
	/**
	 * 最近一周话题
	 * @return
	 */
	ArrayList<Object> indexTopic();

	/**
	 * 判断是否收藏
	 * @param phoneNum
	 * @param parseInt
	 * @return
	 */
	boolean isCollect(String phoneNum, int topicNum);
	
	/**
	 * 最近三天好友话题
	 * @return
	 */
	ArrayList<Object> indexFriendsTopic(String phoneNum);
	
	/**
	 * 搜索话题
	 * @param topicName
	 * @return
	 */
	HashMap<String, ArrayList<Object>> selectTopic(String topicName);

}

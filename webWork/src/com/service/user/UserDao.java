package com.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.service.topic.Topic;

public interface UserDao {

	/**
	 * 修改密码
	 * @param phone
	 * @param password
	 * @return
	 */
	boolean changePassword(String phone,String password);
	
	/**
	 * 判断用户是否存在
	 * @param phone
	 * @return
	 */
	boolean userExist(String phone);
	
	/**
	 * 判断密码是否正确
	 * @param phone
	 * @return
	 */
	User userExist(String phone,String password);
	
	/**
	 * 添加新用户
	 * @param phone
	 * @param password
	 * @param email
	 * @param name
	 * @return
	 */
	boolean insertUser(String phone,String password,String email,String name);
	
	/**
	 * 修改头像
	 * @param phoneNum
	 * @param string
	 * @return
	 */
	boolean updataTouxiang(String phoneNum, String touxiangSrc);
	/**
	 * 修改用户个人信息
	 * @param phone
	 * @param email
	 * @param name
	 * @param sex
	 * @param age
	 * @param address
	 * @param introduction
	 * @return
	 */
	boolean changeUser(String phone,String email,String name,String sex,int age,String address,String introduction);
	
	/**
	 * 判断用户与邮箱是否存在
	 * @param phone
	 * @param email
	 * @return
	 */
	boolean userExistEmail(String phone,String email);
	

	/**
	 * 回复他人的信息
	 * @param phoneNum
	 * @return
	 */
	ArrayList<HashMap<String, String>> toOthersTopicComment(String phoneNum);
	
	/**
	 * 获取用户收到回复的话题
	 * @param phoneNum
	 * @return
	 */
	ArrayList<HashMap<String, String>> userCommentTopic(String phoneNum);
	
	/**
	 * 用户最近访问的话题
	 * @param phoneNum
	 * @return
	 */
	Object[][] userRecentlyVisitTopic(String phoneNum);
	
	/**
	 * 用户收藏的话题
	 * @param phoneNum
	 * @return
	 */
	ArrayList<Topic> userCollectionTopic(String phoneNum);
	
	/**
	 * 获取关注人的信息
	 * @param phoneNum
	 * @return
	 */
	ArrayList<User> userConcernUser(String phoneNum);
	
	/**
	 * 获取粉丝信息
	 * @param phoneNum
	 * @return
	 */
	ArrayList<User> userFans(String phoneNum);
	
	/**
	 * 取消关注
	 * @param phoneNum
	 * @return
	 */
	boolean deleteUserConcernUser(String phoneNum,String beConcerner);

	/**
	 * 取消粉丝
	 * @param phoneNum
	 * @param beConcerner
	 * @return
	 */
	boolean deleteUserFans(String phoneNum, String concerner);
	
	/**
	 * 好友信息
	 * @param phoneNum
	 * @return
	 */
	User userFriends(String phoneNum);
	
	/**
	 * 判断关系
	 * true表示已关注
	 * false表示还未关注
	 * @param phoneNum
	 * @param otherPhoneNum
	 * @return
	 */
	boolean getRelation(String phoneNum,String othersPhoneNum);
	
	/**
	 * 设置好友关系
	 * @param phoneNum
	 * @param othersPhoneNum
	 * @param b
	 * b为true代表原本已关注，将执行取消操作
	 * b为false代表原本还未关注，将执行关注操作
	 * @return
	 */
	boolean setRelation(String phoneNum,String othersPhoneNum,boolean b);

	/**
	 * 搜索用户
	 * @param phoneNum
	 * @return
	 */
	ArrayList<User> selectUser(String name);

	
}

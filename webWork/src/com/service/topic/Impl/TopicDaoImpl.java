package com.service.topic.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.jdbc.DBUtil;
import com.service.comment.Comment;
import com.service.topic.Topic;
import com.service.topic.TopicDao;
import com.service.user.User;

public class TopicDaoImpl implements TopicDao{
	
	@Override
	public Topic topicInfo(int topicNum) {
		Topic topic=null;
		try {
			String sql = "select * from topic where topicNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,topicNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				topic = new Topic();
				topic.setPhoneNum(rs.getString("phoneNum"));
				topic.setTopicNum(rs.getInt("topicNum"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setName(topic.getName());
				topic.setTopicContent(rs.getString("topicContent"));
				topic.setTopicCreateTime(rs.getString("topicCreateTime"));
				topic.setTopicType(rs.getString("topicType"));
				topic.setTopicCommentNum(rs.getInt("topicCommentNum"));
				topic.setTopicClickNum(rs.getInt("topicClickNum"));
				topic.setTopicLastClickTime(rs.getString("topicLastClickTime"));
				topic.setZan(rs.getInt("topicZan"));
				topic.setCollectionNum(rs.getInt("collectionNum"));
			}
			sql = "update topic set topicClickNum=topicClickNum+1 where topicNum=?";
			ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1, topicNum);
			ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
		return topic;
	}
	@Override
	public User topicUserInfo(int topicNum,String phoneNum) {
		User user=null;
		try {
			String sql = "SELECT * FROM USER u,topic t WHERE u.phoneNum=t.phoneNum  "+
					"AND t.topicNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,topicNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getString("sex"));
				user.setIntroduction(rs.getString("introduction"));
				user.setAge(rs.getInt("age"));
				user.setFans(rs.getInt("fans"));
				user.setGuanzhu(rs.getInt("concerns"));
				user.setUserCreateTime(rs.getString("userCreateTime"));
			}
			sql = "insert into uservisitrecord  values(?,?,now())";
			ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ps.setInt(2, topicNum);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return user;
	}
	
	@Override
	public HashMap<String,ArrayList<Object>> topicCommentList(int topicNum) {
		HashMap<String,ArrayList<Object>> map = new HashMap<String,ArrayList<Object>>();
		ArrayList<Object> userList = new ArrayList<Object>();
		ArrayList<Object> commentList =new ArrayList<Object>();
		try {
			String sql = "SELECT c.commentContent,c.commentNum,c.commentTime,c.topicNum,c.zan,u.* FROM COMMENT c,USER u,topic t  "+
							"WHERE t.topicNum = c.topicNum   "+
							"AND c.phoneNum=u.phoneNum   "+
							"AND t.topicNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,topicNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				Comment comment = new Comment();
				user.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getString("sex"));
				user.setIntroduction(rs.getString("introduction"));
				user.setAge(rs.getInt("age"));
				user.setFans(rs.getInt("fans"));
				user.setGuanzhu(rs.getInt("concerns"));
				user.setUserTopicNum(rs.getInt("userTopicNum"));
				user.setUserCommentNum(rs.getInt("userCommentNum"));
				user.setUserCreateTime(rs.getString("userCreateTime"));
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentNum(rs.getInt("commentNum"));
				comment.setPhoneNum(rs.getString("phoneNum"));
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setTopicNum(rs.getInt("topicNum"));
				comment.setZan(rs.getInt("zan"));
				userList.add(user);
				commentList.add(comment);
			}
			map.put("user", userList);
			map.put("comment", commentList);
		} catch (Exception e) {
			
		}
		
		return map;
	}
	
	@Override
	public boolean createComment(String topicComment,String phoneNum,int topicNum) {
		try {
			String sql = "insert into comment values(?,?,now(),?,0,null)";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1,phoneNum);
			ps.setString(2,topicComment);
			ps.setInt(3, topicNum);
			//查询返回结果集
			Integer rs = ps.executeUpdate();
			if(rs!=1)return false;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public ArrayList<Topic> personTopic(String phoneNum) {
		ArrayList<Topic> list= new ArrayList<Topic>();
		
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT * FROM topic WHERE phoneNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Topic topic=new Topic();
				topic.setPhoneNum(rs.getString("phoneNum"));
				topic.setTopicNum(rs.getInt("topicNum"));
				topic.setTopicName(rs.getString("topicName"));
				topic.setTopicContent(rs.getString("topicContent"));
				topic.setTopicCreateTime(rs.getString("topicCreateTime"));
				topic.setTopicType(rs.getString("topicType"));
				topic.setTopicCommentNum(rs.getInt("topicCommentNum"));
				topic.setTopicClickNum(rs.getInt("topicClickNum"));
				topic.setTopicLastClickTime(rs.getString("topicLastClickTime"));
				topic.setZan(rs.getInt("topicZan"));
				list.add(topic);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public boolean createTopic(String phoneNum, String topicName,
			String topicType, String topicContent) {
		try {
			String sql = "INSERT INTO topic(phoneNum,topicName,topicType,topicContent,topicCreateTime) VALUES(?,?,?,?,NOW())";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1,phoneNum);
			ps.setString(2,topicName);
			ps.setString(3,topicType);
			ps.setString(4,topicContent);
			//查询返回结果集
			Integer rs = ps.executeUpdate();
			if(rs!=1)return false;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean topicDelete(int topicNum) {
		try {
			String sql = "DELETE FROM topic WHERE topicNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,topicNum);
			//查询返回结果集
			Integer rs = ps.executeUpdate();
			if(rs!=1)return false;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String collectActivity(String phoneNum, int topicNum) {
		Connection sqlConnection = null;
		try {
			sqlConnection = DBUtil.getSQLConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		PreparedStatement ps;
		try {
			boolean b=isCollect(phoneNum,topicNum);
			if(!b){
				String sql = "insert into cellect values(?,?,now())";
				ps = sqlConnection.prepareStatement(sql);
				ps.setString(1,phoneNum);
				ps.setInt(2, topicNum);				
				Integer rs = ps.executeUpdate();
				if(rs!=0){
					return "取消收藏";			
				}
			}else{
				String sql = "delete from cellect where phoneNum=? and topicNum=?";
				ps = sqlConnection.prepareStatement(sql);
				ps.setString(1,phoneNum);
				ps.setInt(2, topicNum);				
				Integer rs = ps.executeUpdate();
				if(rs!=0){
					return "收藏";			
				}
			}
						
		} catch (Exception e) {
		}
		return "已收藏";
	}
	
	@Override
	public int zan(int topicNum) {
		try {
			String sql = "update topic set topicZan=topicZan+1 where topicNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,topicNum);
			int result = ps.executeUpdate();
			if(result!=0){
				topicInfo(topicNum);
				return topicInfo(topicNum).getZan();
			}
		} catch (Exception e) {
			
		}
		return 0;
	}
	
	@Override
	public int commentZan(int commentNum) {
		try {
			String sql = "update comment set zan=zan+1 where commentNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,commentNum);
			int result = ps.executeUpdate();
			if(result!=0){
				sql = "select zan from comment where commentNum=?";
				ps = sqlConnection.prepareStatement(sql);
				ps.setInt(1,commentNum);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					return rs.getInt("zan");
					
				}
				
			}
		} catch (Exception e) {
			
		}
		return 0;
	}
	
	@Override
	public boolean deleteComment(int commentNum) {
		try {
			String sql = "DELETE FROM comment WHERE commentNum=?";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setInt(1,commentNum);
			//查询返回结果集
			Integer rs = ps.executeUpdate();
			if(rs!=1)return false;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public ArrayList<Object> indexTopic() {
		ArrayList<Object> list= new ArrayList<Object>();
		//获取当前时间前七天的时间
		SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Calendar c= Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE,-7);
		Date date =c.getTime();
		String dateTime = sf.format(date);
		try {
			String sql = "SELECT t.topicType,t.topicCreateTime,u.headSculptureAdd,t.topicNum,t.topicZan,t.topicName,t.topicContent,t.topicCommentNum,u.name,u.introduction,u.phoneNum " +
					"FROM topic t,USER u "+
					"WHERE t.topicCreateTime> ?  "+
					"AND t.phoneNum=u.phoneNum   ORDER BY t.topicCreateTime DESC  ";
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1,dateTime);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
				User topicUser = new User();
				topic.setTopicType(rs.getString("topicType"));
				topic.setTopicCreateTime(rs.getString("topicCreateTime"));
				topic.setTopicNum(rs.getInt("topicNum"));
				topic.setZan(rs.getInt("topicZan"));
				topic.setName(rs.getString("topicName"));
				topic.setTopicCommentNum(rs.getInt("topicCommentNum"));
				topic.setTopicContent(rs.getString("topicContent"));
				topicUser.setPhoneNum(rs.getString("phoneNum"));
				topicUser.setName(rs.getString("name"));
				topicUser.setIntroduction(rs.getString("introduction"));
				topicUser.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				list.add(topic);
				list.add(topicUser);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean isCollect(String phoneNum, int topicNum) {
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql="Select * from cellect where phoneNum=? AND topicNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1,phoneNum);
			ps.setInt(2, topicNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Object> indexFriendsTopic(String phoneNum) {		
		ArrayList<Object> list= new ArrayList<Object>();
		SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Calendar c= Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE,-3);
		Date date =c.getTime();
		String dateTime = sf.format(date);
		try {
			String sql =" SELECT t.topicCreateTime,u.headSculptureAdd,t.topicNum,t.topicZan,t.topicName,t.topicContent,t.topicCommentNum,u.name,u.introduction,u.phoneNum "+
					"FROM topic t,USER u,relation r  "+
					"WHERE t.topicCreateTime> ? "+
					"AND t.phoneNum=u.phoneNum  "+
					"AND r.beConcerner=u.phoneNum  "+
					"AND r.concerner= ? "+
					"ORDER BY t.topicCreateTime DESC " ;
			Connection sqlConnection = DBUtil.getSQLConnection();
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1,dateTime);
			ps.setString(2,phoneNum);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
				User topicUser = new User();
				topic.setTopicCreateTime(rs.getString("topicCreateTime"));
				topic.setTopicNum(rs.getInt("topicNum"));
				topic.setZan(rs.getInt("topicZan"));
				topic.setName(rs.getString("topicName"));
				topic.setTopicCommentNum(rs.getInt("topicCommentNum"));
				topic.setTopicContent(rs.getString("topicContent"));
				topicUser.setPhoneNum(rs.getString("phoneNum"));
				topicUser.setName(rs.getString("name"));
				topicUser.setIntroduction(rs.getString("introduction"));
				topicUser.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				list.add(topic);
				list.add(topicUser);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public HashMap<String, ArrayList<Object>> selectTopic(String topicName) {
		HashMap<String, ArrayList<Object>> map= new HashMap<String, ArrayList<Object>>();
		ArrayList<Object> topicList =new ArrayList<Object>();
		ArrayList<Object> userList =new ArrayList<Object>();
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql="SELECT t.*,u.* FROM topic t,USER u WHERE topicName LIKE '%"+topicName+"%'  "+
					"AND t.phoneNum=u.phoneNum ORDER BY t.topicCreateTime DESC ";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Topic topic =new Topic();
				User topicUser = new User();
				topic.setTopicType(rs.getString("topicType"));
				topic.setTopicCreateTime(rs.getString("topicCreateTime"));
				topic.setTopicNum(rs.getInt("topicNum"));
				topic.setZan(rs.getInt("topicZan"));
				topic.setName(rs.getString("topicName"));
				topic.setTopicCommentNum(rs.getInt("topicCommentNum"));
				topic.setTopicContent(rs.getString("topicContent"));
				topicUser.setPhoneNum(rs.getString("phoneNum"));
				topicUser.setName(rs.getString("name"));
				topicUser.setIntroduction(rs.getString("introduction"));
				topicUser.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				topicList.add(topic);
				userList.add(topicUser);
			}
			map.put("topicList", topicList);
			map.put("userList", userList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}

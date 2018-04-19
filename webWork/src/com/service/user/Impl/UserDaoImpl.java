package com.service.user.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;



import com.jdbc.DBUtil;
import com.service.topic.Topic;
import com.service.user.User;
import com.service.user.UserDao;


public class UserDaoImpl implements UserDao{
	
	@Override
	public boolean userExist(String phone) {
		boolean flag = false;	
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT * FROM user WHERE phoneNum=? ";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phone);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			User user = null;
			
			while(rs.next()){				
				user = new User();
			}
			flag = user == null ? false : true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean changePassword(String phone, String password) {
		boolean flag = false;	
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "Update user set password=?  WHERE phoneNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, phone);
			//查询返回结果集
			int result = ps.executeUpdate();
		
			flag = result == 0 ? false : true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean insertUser(String phone, String password, String email,
			String name) {
		
		boolean flag = false;	
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "INSERT into user(phoneNum,password,name,email,userCreateTime) values(?,?,?,?,now())";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			//查询返回结果集
			int result = ps.executeUpdate();
		
			flag = result == 0 ? false : true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updataTouxiang(String phoneNum, String touxiangSrc) {
		boolean flag = false;	
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "Update user set headSculptureAdd=? where phoneNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, touxiangSrc);
			ps.setString(2, phoneNum);
			
			//查询返回结果集
			int result = ps.executeUpdate();
		
			flag = result == 0 ? false : true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public boolean changeUser(String phone, String email, String name,
			String sex, int age, String address, String introduction) {
		boolean flag = false;	
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "Update user set email=?,name=?,sex=?,age=?,address=?,introduction=? where phoneNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, sex);
			ps.setInt(4, age);
			ps.setString(5, address);
			ps.setString(6, introduction);
			ps.setString(7, phone);
			//查询返回结果集
			int result = ps.executeUpdate();
		
			flag = result == 0 ? false : true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public User userExist(String phone, String password) {
		User user = null;
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT * FROM user WHERE phoneNum=? and password=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, password);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				user = new User();
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
			}			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean userExistEmail(String phone, String email) {
		boolean flag = false;	
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT * FROM user WHERE phoneNum=? and email=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, email);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			User user = null;
			
			while(rs.next()){				
				user = new User();
			}
			
			flag = user == null ? false : true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public ArrayList<HashMap<String,String>> userCommentTopic(String phoneNum) {
		ArrayList<HashMap<String,String>> list= new ArrayList<HashMap<String,String>>();
		ArrayList<Integer> topicNumList = new ArrayList<Integer>();
		Connection sqlConnection =null;
		try {
			sqlConnection = DBUtil.getSQLConnection();
		} catch (Exception e) {
		}
		try {
			String sql = "SELECT topicNum FROM topic WHERE phoneNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				topicNumList.add(rs.getInt("topicNum"));
			}	
		} catch (Exception e) {
		}
		try {
			for(int i=0;i<topicNumList.size();i++){
				String sql = "SELECT t.topicNum,c.commentContent,c.commentTime,t.topicName,u.name FROM topic t,comment c,user u WHERE t.topicNum=? and t.topicNum=c.topicNum and u.phoneNum=c.phoneNum";
				PreparedStatement ps = sqlConnection.prepareStatement(sql);
				ps.setInt(1, topicNumList.get(i));
				//查询返回结果集
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					HashMap<String,String> map=new HashMap<String,String>();
					map.put("commentContent", rs.getString("c.commentContent"));
					map.put("commentTime", rs.getString("c.commentTime"));
					map.put("topicName", rs.getString("t.topicName"));
					map.put("topicNum", rs.getString("t.topicNum"));
					map.put("commentName", rs.getString("u.name"));
					list.add(map);
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Object[][] userRecentlyVisitTopic(String phoneNum) {
		Connection sqlConnection =null;
		Object[][] userRecentlyVisitTopic;
		ArrayList<Integer> userVisitTopicList = new ArrayList<Integer>();
		ArrayList<String> userVisitTopicLastTimeList = new ArrayList<String>();
		ArrayList<String> userVisitTopicUserNameList = new ArrayList<String>();
		try {
			sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT u1.topicNum,MAX(u1.visitTime),u2.name FROM uservisitrecord u1,USER u2,topic t  "+
					"WHERE u1.phoneNum='"+phoneNum+"' AND u1.topicNum=t.topicNum AND u2.phoneNum=t.phoneNum  "+
					"GROUP BY u1.topicNum ORDER BY MAX(u1.visitTime) DESC ";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
				userVisitTopicList.add(rs.getInt("topicNum"));
				userVisitTopicLastTimeList.add(rs.getString("max(u1.visitTime)"));
				userVisitTopicUserNameList.add(rs.getString("name"));
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		userRecentlyVisitTopic = new Object[userVisitTopicList.size()][3];
		try {
			sqlConnection = DBUtil.getSQLConnection();
			for(int i=0;i<userVisitTopicList.size();i++){
				String sql = "SELECT * FROM topic WHERE topicNum=?";
				PreparedStatement ps = sqlConnection.prepareStatement(sql);
				ps.setInt(1, userVisitTopicList.get(i));
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
					userRecentlyVisitTopic[i][0]=topic;
					userRecentlyVisitTopic[i][1]=userVisitTopicLastTimeList.get(i);
					userRecentlyVisitTopic[i][2]=userVisitTopicUserNameList.get(i);
				}						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userRecentlyVisitTopic;
	}

	@Override
	public ArrayList<Topic> userCollectionTopic(String phoneNum) {
		ArrayList<Topic> list= new ArrayList<Topic>();
		
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT t.*,u.name FROM topic t,cellect c,USER u WHERE c.phoneNum =? AND t.topicNum=c.topicNum AND u.phoneNum=t.phoneNum";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1,phoneNum);
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
				topic.setName(rs.getString("name"));
				list.add(topic);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<HashMap<String, String>> toOthersTopicComment(
			String phoneNum) {
		ArrayList<HashMap<String,String>> list= new ArrayList<HashMap<String,String>>();
		
		try {
			Connection sqlConnection =DBUtil.getSQLConnection();
			String sql = "SELECT c.commentContent,c.commentTime,t.topicName,u.name,c.commentNum,t.topicNum FROM COMMENT c,topic t,USER u "
						+"WHERE c.phoneNum=? "
						+"AND c.topicNum=t.topicNum "
						+"AND t.phoneNum=u.phoneNum ";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				HashMap<String,String> map=new HashMap<String,String>();
				map.put("commentContent", rs.getString("c.commentContent"));
				map.put("commentTime", rs.getString("c.commentTime"));
				map.put("topicName", rs.getString("t.topicName"));
				map.put("topicNum", rs.getString("t.topicNum"));
				map.put("commentNum", rs.getString("c.commentNum"));
				map.put("commentName", rs.getString("u.name"));
				list.add(map);
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<User> userConcernUser(String phoneNum) {
		ArrayList<User> list= new ArrayList<User>();
		try {
			Connection sqlConnection= DBUtil.getSQLConnection();
			String sql = "SELECT u.phoneNum,u.introduction,u.name,u.headSculptureAdd FROM relation t,USER u "+
					"WHERE t.concerner=?  "+
					"AND t.beConcerner=u.phoneNum";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString("name"));
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setIntroduction(rs.getString("introduction"));
				user.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				list.add(user);
			}	
		} catch (Exception e) {
		}
		return list;
	}
	
	@Override
	public ArrayList<User> userFans(String phoneNum) {
		ArrayList<User> list= new ArrayList<User>();
		try {
			Connection sqlConnection= DBUtil.getSQLConnection();
			String sql = "SELECT u.phoneNum,u.introduction,u.name,u.headSculptureAdd FROM relation t,USER u "
					+"WHERE t.beConcerner=?  "
					+"AND t.concerner=u.phoneNum";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setName(rs.getString("name"));
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setIntroduction(rs.getString("introduction"));
				user.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				list.add(user);
			}	
		} catch (Exception e) {
		}
		return list;
	}
	
	@Override
	public boolean deleteUserConcernUser(String phoneNum, String beConcerner) {
		try {
			Connection sqlConnection= DBUtil.getSQLConnection();
			String sql = "DELETE FROM relation WHERE concerner=? AND beConcerner =?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ps.setString(2, beConcerner);
			int rs = ps.executeUpdate();
			if(rs==0){
				return false;
			}
		} catch (Exception e) {
		}
		return true;
	}
	
	@Override
	public boolean deleteUserFans(String phoneNum, String concerner) {
		try {
			Connection sqlConnection= DBUtil.getSQLConnection();
			String sql = "DELETE FROM relation WHERE beConcerner=? AND concerner =?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ps.setString(2, concerner);
			int rs = ps.executeUpdate();
			if(rs==0){
				return false;
			}
		} catch (Exception e) {
		}
		return true;
	}

	@Override
	public User userFriends(String phoneNum) {
		User user = null;
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT * FROM user WHERE phoneNum=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			//查询返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()){			
				user = new User();
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
			}			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public boolean getRelation(String phoneNum, String othersPhoneNum) {
		try {
			Connection sqlConnection= DBUtil.getSQLConnection();
			String sql = "SELECT * FROM relation WHERE concerner=? AND beConcerner=?";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ps.setString(2, othersPhoneNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){			
				return true;
			}
		} catch (Exception e){
		}
		return false;
	}
	
	@Override
	public boolean setRelation(String phoneNum, String othersPhoneNum,boolean b) {
		try {
			Connection sqlConnection= DBUtil.getSQLConnection();
			String sql;
			if(b){
				sql = "DELETE	FROM relation WHERE concerner=? AND beConcerner=?";				
			}else{
				sql = "INSERT INTO relation VALUE(?,?,NOW())";
			}
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ps.setString(1, phoneNum);
			ps.setString(2, othersPhoneNum);
			int rs = ps.executeUpdate();
			if(rs!=0)return true;
		} catch (Exception e){
		}
		return false;
	}

	@Override
	public ArrayList<User> selectUser(String name) {
		ArrayList<User> list = new ArrayList<User>();
		try {
			Connection sqlConnection = DBUtil.getSQLConnection();
			String sql = "SELECT * FROM USER WHERE NAME LIKE '%"+name+"%' ORDER BY userCreateTime DESC ";
			PreparedStatement ps = sqlConnection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user= new User();
				user.setPhoneNum(rs.getString("phoneNum"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setHeadSculptureAdd(rs.getString("headSculptureAdd"));
				user.setIntroduction(rs.getString("introduction"));
				list.add(user);
			}
		} catch (Exception e) {
		}
		return list;
	}
}


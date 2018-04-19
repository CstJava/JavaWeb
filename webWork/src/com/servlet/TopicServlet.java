package com.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.service.topic.Topic;
import com.service.topic.TopicDao;
import com.service.topic.Impl.TopicDaoImpl;
import com.service.user.User;


public class TopicServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private TopicDao topicDao = new TopicDaoImpl();
	
	/**
	 *话题信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void topic(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		HttpSession session = request.getSession();
		String phoneNum = ((User)session.getAttribute("id")).getPhoneNum();
		String topicNum = request.getParameter("topicNum");			
		Topic topic=topicDao.topicInfo(Integer.parseInt(topicNum));	
		User user =topicDao.topicUserInfo(Integer.parseInt(topicNum),phoneNum);
		session.setAttribute(topicNum+"Topic", topic);	
		session.setAttribute(topicNum+"TopicUser", user);		
	}
	
	/**
	 * 话题评论信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void topicComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String topicNum = request.getParameter("topicNum");	
		HashMap<String,ArrayList<Object>> map = topicDao.topicCommentList(Integer.parseInt(topicNum));
		ArrayList<Object> userList =map.get("user");
		ArrayList<Object> commentList = map.get("comment");
		HttpSession session = request.getSession();
		session.setAttribute(topicNum+"UserList", userList);	
		session.setAttribute(topicNum+"CommentList", commentList);
	}
	
	/**
	 * 创建话题评论
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void createTopicComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String createTopicComment = request.getParameter("createTopicComment");	
		String topicNum = request.getParameter("topicNum");	
		HttpSession session = request.getSession();
		String phoneNum = ((User)session.getAttribute("id")).getPhoneNum();
		boolean b = topicDao.createComment(createTopicComment,phoneNum,Integer.parseInt(topicNum));
		String tips = b?"评论成功":"评论失败";
		out_write(response,tips);
	}
	
	/**
	 * 所有人话题信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void personTopic(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");			
		ArrayList<Topic> list=topicDao.personTopic(phoneNum);		
		HttpSession session = request.getSession();
		session.setAttribute(phoneNum+"TopicList", list);		
	}
	
	/**
	 * 创建话题
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void createTopic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String topicName = request.getParameter("createTopicName");	
		String topicType = request.getParameter("createTopicType");	
		String topicContent = request.getParameter("createTopicContent");	
		boolean b=topicDao.createTopic(((User)session.getAttribute("id")).getPhoneNum(), topicName, topicType, topicContent);
		String tips = b? "提交成功":"提交失败";
		out_write(response,tips);						
	}
	
	/**
	 * 删除话题
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void topicDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String topicNum = request.getParameter("topicNum");	
		boolean b=topicDao.topicDelete(Integer.parseInt(topicNum));
		String tips = b? "删除成功":"删除失败";
		out_write(response,tips);						
	}
	
	/**
	 * 判断是否收藏
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void isCollect(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String topicNum = request.getParameter("topicNum");	
		HttpSession session = request.getSession();
		String phoneNum=((User)session.getAttribute("id")).getPhoneNum();
		boolean b=topicDao.isCollect(phoneNum,Integer.parseInt(topicNum));
		String tips = b? "取消收藏":"添加收藏";
		out_write(response,tips);						
	}
	
	/**
	 * 操作收藏
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void CollectActivity(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String topicNum = request.getParameter("topicNum");	
		HttpSession session = request.getSession();
		String phoneNum=((User)session.getAttribute("id")).getPhoneNum();
		String tips=topicDao.collectActivity(phoneNum,Integer.parseInt(topicNum));
		out_write(response,tips);						
	}

	/**
	 * 话题点赞
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void zan(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String topicNum = request.getParameter("topicNum");	
		int i=topicDao.zan(Integer.parseInt(topicNum));
		out_write(response,""+i);						
	}
	
	/**
	 * 评论点赞
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void commentZan(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String commentNum = request.getParameter("commentNum");	
		int i=topicDao.commentZan(Integer.parseInt(commentNum));
		out_write(response,""+i);						
	}
	
	/**
	 * 删除评论
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void deleteComment(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String commentNum = request.getParameter("commentNum");	
		boolean b=topicDao.deleteComment(Integer.parseInt(commentNum));
		String tips = b? "删除成功":"删除失败";
		out_write(response,tips);						
	}
	
	/**
	 * 最近一周话题
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void indexTopic(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		ArrayList<Object> list=topicDao.indexTopic();
		HttpSession session = request.getSession();
		//下标奇数表示用户信息，偶数表示话题信息
		session.setAttribute("indexTopicList", list);	
	}
	
	/**
	 * 最近三天好友话题
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void indexFriendsTopic(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		HttpSession session = request.getSession();
		//下标奇数表示用户信息，偶数表示话题信息
		ArrayList<Object> list=topicDao.indexFriendsTopic(((User)session.getAttribute("id")).getPhoneNum());
		session.setAttribute("indexFriendsTopicList", list);	
	}
	
	/**
	 * 搜索话题
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void selectTopic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String topicName = request.getParameter("topicName");
		HttpSession session = request.getSession();
		//下标奇数表示用户信息，偶数表示话题信息
		HashMap<String,ArrayList<Object>> map=topicDao.selectTopic(topicName);
		ArrayList<Object> userList =map.get("userList");
		ArrayList<Object> commentList = map.get("topicList");
		session.setAttribute("selectTopicUserList", userList);	
		session.setAttribute("selectTopicTopicList", commentList);	
	}
	
}








<%@page import="java.util.HashMap"%>
<%@page import="com.service.topic.Topic"%>
<%@page import="com.service.user.User"%>
<%@ page import="java.util.ArrayList" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	ArrayList<User> selectTopicUserlist = (ArrayList<User>)session.getAttribute("selectTopicUserList");	
	ArrayList<Topic> selectTopicTopicList = (ArrayList<Topic>)session.getAttribute("selectTopicTopicList");	
	int lie=Integer.parseInt(request.getParameter("selectTopicpage")); 
	String zan ="#zan";
	for(int i=lie*10;i<selectTopicUserlist.size();i++){
		if(i>=(lie+1)*10){
			break;
		}
		out.print("<div class="+'"'+"index_topic"+'"'+">");
		out.print("<input id="+'"'+"topicNum"+i+'"'+"type="+'"'+"hidden"+'"'+" value="+'"'+selectTopicTopicList.get(i).getTopicNum()+'"'+">");
		out.print("<div onclick="+'"'+"openOthersIndex("+selectTopicUserlist.get(i).getPhoneNum()+")"+'"'+"  class="+'"'+"index_topic_head"+'"'+">");
		out.print("<img src="+'"'+selectTopicUserlist.get(i).getHeadSculptureAdd()+'"'+">");
		out.print("<span id="+'"'+"userName"+i+'"'+"class="+'"'+"index_topic_head_name"+'"'+">"+selectTopicUserlist.get(i).getName()+"</span>");
		out.print("<span class="+'"'+"index_topic_head_jiesao"+'"'+">"+selectTopicUserlist.get(i).getIntroduction()+"</span>");
		out.print("<span class="+'"'+"index_topic_type"+'"'+">"+selectTopicTopicList.get(i).getTopicType()+"</span>");
		out.print("</div>");
		out.print("<div onclick="+'"'+"topic("+selectTopicTopicList.get(i).getTopicNum()+")"+'"'+"  class="+'"'+"index_topic_body"+'"'+">");
		out.print("<div class="+'"'+"index_topic_name"+'"'+">"+selectTopicTopicList.get(i).getName()+"</div>");
		out.print("<div class="+'"'+"index_topic_content"+'"'+">"+selectTopicTopicList.get(i).getTopicContent()+"<span>...点击进入  ></span></div>");
		out.print("</div>");
		out.print("<div class="+'"'+"index_topic_foot"+'"'+">");
		out.print("<img onclick="+'"'+"zanView('"+(zan+i)+"',"+selectTopicTopicList.get(i).getTopicNum()+")"+'"'+"id="+'"'+"zan"+i+'"'+"src="+'"'+"images/zan.png"+'"'+">"); 
		out.print("<span>"+selectTopicTopicList.get(i).getZan()+"</span>");
		out.print("<span>"+selectTopicTopicList.get(i).getTopicCommentNum()+"条评论</span>");
		out.print("<span onclick="+'"'+"updateCollect("+selectTopicTopicList.get(i).getTopicNum()+",collect"+i+")"+'"'+"  id="+'"'+"collect"+i+'"'+">收藏</span>");
		out.print("<span style="+'"'+"color:#f9a114;"+'"'+">"+selectTopicTopicList.get(i).getTopicCreateTime()+"</span>");
		out.print("</div>");
		out.print("</div>");
	} 				
%>
<script type="text/javascript">

$(function(){
	var num = document.getElementsByTagName("input").length-3;
	for(var i=0;i<num;i++){
		var id = "#collect"+(i);
		var idNum=id.substring(8);
		var topicNumId = "#topicNum"+idNum; 
		var topicNum = $(topicNumId).val();
		isCollect(topicNum,id);
	} 
});
</script>
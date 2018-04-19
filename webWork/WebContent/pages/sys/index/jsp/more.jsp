<%@page import="com.service.topic.Topic"%>
<%@page import="com.service.user.User"%>
<%@ page import="java.util.ArrayList" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	ArrayList<Object> indexTopiclist = (ArrayList<Object>)session.getAttribute("indexTopicList");	
	int lie=Integer.parseInt(request.getParameter("currentpage")); 
	String zan ="#zan";
	for(int i=lie*10;i<indexTopiclist.size();i+=2){
		if(i>=(lie+1)*10){
			break;
		}
		out.print("<div class="+'"'+"index_topic"+'"'+">");
		out.print("<input id="+'"'+"topicNum"+i+'"'+"type="+'"'+"hidden"+'"'+" value="+'"'+((Topic)indexTopiclist.get(i)).getTopicNum()+'"'+">");
	  	out.print("<div onclick="+'"'+"openOthersIndex("+((User)indexTopiclist.get(i+1)).getPhoneNum()+")"+'"'+"  class="+'"'+"index_topic_head"+'"'+">");
		out.print("<img src="+'"'+((User)indexTopiclist.get(i+1)).getHeadSculptureAdd()+'"'+">");
		out.print("<span id="+'"'+"userName"+i+'"'+"class="+'"'+"index_topic_head_name"+'"'+">"+((User)indexTopiclist.get(i+1)).getName()+"</span>");
		out.print("<span class="+'"'+"index_topic_head_jiesao"+'"'+">"+((User)indexTopiclist.get(i+1)).getIntroduction()+"</span>");
		out.print("<span class="+'"'+"index_topic_type"+'"'+">"+((Topic)indexTopiclist.get(i)).getTopicType()+"</span>");
		out.print("</div>");
		out.print("<div onclick="+'"'+"topic("+((Topic)indexTopiclist.get(i)).getTopicNum()+")"+'"'+"  class="+'"'+"index_topic_body"+'"'+">");
		out.print("<div class="+'"'+"index_topic_name"+'"'+">"+((Topic)indexTopiclist.get(i)).getName()+"</div>");
		out.print("<div class="+'"'+"index_topic_content"+'"'+">"+((Topic)indexTopiclist.get(i)).getTopicContent()+"<span>...点击进入  ></span></div>");
		out.print("</div>");
		out.print("<div class="+'"'+"index_topic_foot"+'"'+">");
		out.print("<img onclick="+'"'+"zanView('"+(zan+i)+"',"+((Topic)indexTopiclist.get(i)).getTopicNum()+")"+'"'+"id="+'"'+"zan"+i+'"'+"src="+'"'+"images/zan.png"+'"'+">"); 
		out.print("<span>"+((Topic)indexTopiclist.get(i)).getZan()+"</span>");
		out.print("<span>"+((Topic)indexTopiclist.get(i)).getTopicCommentNum()+"条评论</span>");
		out.print("<span onclick="+'"'+"updateCollect("+((Topic)indexTopiclist.get(i)).getTopicNum()+",collect"+i+")"+'"'+"  id="+'"'+"collect"+i+'"'+">收藏</span>");
		out.print("<span style="+'"'+"color:#f9a114;"+'"'+">"+((Topic)indexTopiclist.get(i)).getTopicCreateTime()+"</span>");
		out.print("</div>");
		out.print("</div>");
	} 				
%>
<script type="text/javascript" src="pages/sys/index/js/more.js"></script>
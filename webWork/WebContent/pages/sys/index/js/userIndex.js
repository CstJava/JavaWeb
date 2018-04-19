$(function(){
	var phoneNum= $("#phoneNum").val();
	requset("UserServlet?method=toOthersTopicComment","phoneNum="+phoneNum,function(msg){	
		if(msg.tips=="0"){
			alert("你还未发表过评论哦!");
		}
		$("#userActivityIframe").attr("src","pages/sys/index/jsp/userActivity/dynamics.jsp");	
	});
	$("#li1").css("border-bottom","3px solid rgb(15,136,235)");
	$("li").click(function(){
		
		for(var i=1;i<6;i++){
			var li="#li"+i;
			$(li).css("border-bottom","none");
			$(li).css("font-weight","normal");
		}
		var id = "#"+$(this).attr("id");
		$(id).css("border-bottom","3px solid rgb(15,136,235)");
		$(id).css("font-weight","bold");
	});
});

function relation(){
	location.href="pages/sys/index/jsp/userFriends.jsp";
	
}


function dongtai(){	
	var phoneNum= $("#phoneNum").val();
	requset("UserServlet?method=toOthersTopicComment","phoneNum="+phoneNum,function(msg){	
		if(msg.tips=="0"){
			alert("你还未发表过评论哦!");
		}
		$("#userActivityIframe").attr("src","pages/sys/index/jsp/userActivity/dynamics.jsp");	
	});
}

function huida(){
	var phoneNum= $("#phoneNum").val();
	requset("UserServlet?method=myTopicComment","phoneNum="+phoneNum,function(msg){	
		if(msg.tips=="0"){
			alert("暂无回复信息哦!");
		}
		$("#userActivityIframe").attr("src","pages/sys/index/jsp/userActivity/reply.jsp");	
	});
}

function tiezi(){
	var phoneNum= $("#phoneNum").val();
	personTopicList(phoneNum);
	$("#userActivityIframe").attr("src","pages/sys/index/jsp/userActivity/myTopic.jsp");			
}

function zuijinfangwen(){
	var phoneNum= $("#phoneNum").val();
	requset("UserServlet?method=userRecentlyVisit","phoneNum="+phoneNum,function(msg){
		if(msg.tips=="0"){
			alert("你还没访问过任何主题呢!");
		}
		
		$("#userActivityIframe").attr("src","pages/sys/index/jsp/userActivity/recentlyVisit.jsp");
	});
}

function shoucang(){
	var phoneNum= $("#phoneNum").val();
	requset("UserServlet?method=userCollectionTopic","phoneNum="+phoneNum,function(msg){
		if(msg.tips=="0"){
			alert("你还没收藏过任何主题哦!");
		}
		$("#userActivityIframe").attr("src","pages/sys/index/jsp/userActivity/colloction.jsp");
		
	});
}
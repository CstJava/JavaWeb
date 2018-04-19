$(function(){
	$("#li1").css("color","rgb(15,136,235)");
	$("#li1").css("font-weight","bold");
	concern();
	$("li").click(function(){		
		for(var i=1;i<3;i++){
			var li="#li"+i;
			$(li).css("font-weight","normal");
			$(li).css("color","gray");
		}
		var id = "#"+$(this).attr("id");
		$(id).css("color","rgb(15,136,235)");
		$(id).css("font-weight","bold");
	});	
});

function concern(){
	var phoneNum = $("#phoneNum").val();
	requset("UserServlet?method=userConcernUser","phoneNum="+phoneNum,function(msg){
		if(msg.tips==0){
			console.log("无关注");
		}
	});
	$("#friends_iframe").attr("src","pages/sys/index/jsp/userFriends/userFriendsFriends/userFriendsConcern.jsp?phoneNum="+$("#phoneNum").val());
}

function fans(){
	var phoneNum = $("#phoneNum").val();
	requset("UserServlet?method=userFans","phoneNum="+phoneNum,function(msg){
		if(msg.tips==0){
			console.log("无粉丝");
		}
	});
	$("#friends_iframe").attr("src","pages/sys/index/jsp/userFriends/userFriendsFriends/userFriendsFans.jsp?phoneNum="+$("#phoneNum").val());
}
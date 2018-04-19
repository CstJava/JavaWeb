
requset = function(req_url,datas,callback)
{
	   $.ajax({
		   type: "POST",
		   url: req_url,
		   data: datas,
		   dataType:"json",
		   async :false,
		   success: function(msg){
			   callback(msg);
		   }	   		
		});
};

requsetGetList = function(req_url,datas)
{
	   $.ajax({
		   type: "POST",
		   url: req_url,
		   data: datas,
		});
};

requsetGetForm = function(req_url)
{
   $.ajax({
	   type: "POST",
	   url: req_url
	});
};

/**
 * 上传图片
 */
requsetImage = function(req_url,formData)
{
	$.ajax({
		type: "POST",
		url: req_url,
		data: formData,
		dataType:"json",
		success: function(){
		}
	});
};

/**
 * 跳转话题页面
 */
function topic(topicNum){
	requsetGetList("TopicServlet?method=topic","topicNum="+topicNum);
	requsetGetList("TopicServlet?method=topicComment","topicNum="+topicNum);
	setTimeout(function(){
		window.open("pages/sys/topic/Topic.jsp?topicNum="+topicNum);		
	}, 300);
}

/**
 * 用户话题信息
 * @param phoneNum
 */
function personTopicList(phoneNum){
	requsetGetList("TopicServlet?method=personTopic","phoneNum="+phoneNum);
}

/**
 * 是否关注
 * @param otherPhoneNum
 */
function isConcern(otherPhoneNum,Class){
	requset("UserServlet?method=getRelation","phoneNum="+otherPhoneNum,function(msg){
		$(Class).html(msg.tips);		
	});	
}


/**
 * 是否收藏
 * @param topicNum
 * @param collectId
 * @returns
 */
function isCollect(topicNum,collectId){
	requset("TopicServlet?method=isCollect","topicNum="+topicNum,function(msg){
		$(collectId).text(msg.tips);
		$(collectId).css("color","rgb(15,136,235)");
	});
}

/**
 * 收藏操作
 * @param topicNum
 */
function updateCollect(topicNum,id){
	requset("TopicServlet?method=CollectActivity","topicNum="+topicNum,function(msg){
		$(id).text(msg.tips);			
	});
}

/**
 * 话题点赞
 * @param topicNum
 */
function zanView(id,topicNum){
	
	$(id).css("width","6%");
	$(id).css("height","100" +
			"%");
	setTimeout(function(){
		$(id).css("width","5%");
		$(id).css("height","90%");
	},300); 	
	requset("TopicServlet?method=zan","topicNum="+topicNum,function(msg){
		$(id).next().text(msg.tips);
	});
}

/**
 * 评论点赞
 */
function commentZan(id,commentNum){
	$(id).css("width","6%");
	$(id).css("height","100" +
			"%");
	setTimeout(function(){
		$(id).css("width","5%");
		$(id).css("height","90%");
	},300); 
	requset("TopicServlet?method=commentZan","commentNum="+commentNum,function(msg){
		$(id).next().text(msg.tips);
	});
}
/**
 * 打开他人主页
 * @param phoneNum
 */
function openOthersIndex(phoneNum){
	requset("UserServlet?method=userFriends","phoneNum="+phoneNum,function(msg){
		console.log(msg.tips);
	});
	setTimeout(function(){
		window.open("pages/sys/index/jsp/othersIndex.jsp?phoneNum="+phoneNum);		
	}, 300);
}
/**
 * 打开他人关注好友页面
 * @param phoneNumId
 */
function relation(phoneNum){
	location.href="pages/sys/index/jsp/userFriends/userFriendsFriends/userFriendsFriends.jsp?phoneNum="+phoneNum;
}
/**
 * 首页信息
 */
function indexTopic(){
	requsetGetForm("TopicServlet?method=indexFriendsTopic");
	requsetGetForm("TopicServlet?method=indexTopic");
    location.href="pages/sys/index/jsp/index.jsp";
};


/**
 * 设置关系
 * @param topicUserPhoneNum
 * @param Class
 */
function setRelation(topicUserPhoneNum,Class){
	requset("UserServlet?method=setRelation","phoneNum="+topicUserPhoneNum+"&relation="+$(Class).text(),function(msg){
		if(msg.tips=="取消成功"){
			$(Class).text("关注好友");			
		}else if(msg.tips=="关注成功"){
			$(Class).text("取消关注");			
		}
		alert(msg.tips);		
	});	
}

/**
 * 搜索
 * @param topicName
 */
function select(topicName){
	setTimeout(function(){
		window.open("pages/sys/select/select.jsp?topicName="+topicName);
	}, 500);
}
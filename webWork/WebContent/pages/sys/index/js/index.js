var currentpage = -1; //默认首页话题第一页
$(function(){
	requsetGetForm("TopicServlet?method=indexFriendsTopic");
	requsetGetForm("TopicServlet?method=indexTopic");
	more();
    $('.more').click(function() {
    	requsetGetForm("TopicServlet?method=indexTopic");
    	more();
    });
});

function more(){
	 $.ajax({ url: 'pages/sys/index/jsp/more.jsp', type: 'POST', data: { currentpage: currentpage+1}, complete: function (xhr) {               
         if (200==xhr.status) {//成功返回
             if(currentpage!=1)
             $(xhr.responseText).insertBefore('.more');//将返回内容插入容器中
         }
         else alert('动态页出错，返回内容：'+xhr.responseText);
     }
     });
	 currentpage++;
     return false;
}

function publishQuestion(){
	if($(".create_topic").css("display")=="block"){
		$(".create_topic").css("display","none");	
	}else{
		$(".create_topic").css("display","block");		
	}
	
};

function publishPost(){
	
};

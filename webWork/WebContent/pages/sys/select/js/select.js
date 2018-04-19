var selectTopicpage = -1; //默认搜索话题第一页
var selectUserpage = -1; //默认搜索用户第一页
$(function(){
	requsetGetList("TopicServlet?method=selectTopic","topicName="+$("#topicName").val());
	requsetGetList("UserServlet?method=selectUser","name="+$("#topicName").val());
	setTimeout(function(){
		moreTopic();
		moreUser();
	}, 300);
    $('.moreTopic').click(function() {
    	requsetGetList("TopicServlet?method=selectTopic","topicName="+$("#topicName").val());
    	moreTopic();
    });
    $('.moreUser').click(function() {
    	requsetGetList("UserServlet?method=selectUser","name="+$("#topicName").val());
    	moreUser();
    });
});

function moreTopic(){
	 $.ajax({ url: 'pages/sys/select/selectTopic.jsp', type: 'POST', data: { selectTopicpage: selectTopicpage+1}, complete: function (xhr) {               
         if (200==xhr.status) {//成功返回
             if(selectTopicpage!=1)
             $(xhr.responseText).insertBefore('.moreTopic');//将返回内容插入容器中
         }
         else alert('动态页出错，返回内容：'+xhr.responseText);
     }
     });
	 selectTopicpage++;
     return false;
}

function moreUser(){
	 $.ajax({ url: 'pages/sys/select/selectUser.jsp', type: 'POST', data: { selectUserpage: selectUserpage+1}, complete: function (xhr) {               
        if (200==xhr.status) {//成功返回
            if(selectUserpage!=1)
            $(xhr.responseText).insertBefore('.moreUser');//将返回内容插入容器中
        }
        else alert('动态页出错，返回内容：'+xhr.responseText);
    }
    });
	 selectUserpage++;
    return false;
}
function selectTopicUser(){
	var topicName = $("#selectTopic").val();
	select(topicName);
}
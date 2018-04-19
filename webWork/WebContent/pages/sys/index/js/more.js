

$(function(){
	var num = document.getElementsByTagName("input").length-1;
	for(var i=0;i<num*2;i+=2){
		var id = "#collect"+(i);
		var idNum=id.substring(8);
		var topicNumId = "#topicNum"+idNum; 
		var topicNum = $(topicNumId).val();
		isCollect(topicNum,id);
	}
});


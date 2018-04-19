<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script type="text/javascript" src="pages/sys/index/js/createTopic.js"></script>
    <div class="create_topic">
	    <form id="createTopicForm" method="post">
	    	<div class="create_topic_head">
	    		<textarea onclick="" id="createTopicName" name="createTopicName"></textarea>
	    		类型：<select id="createTopicType" name="createTopicType">
	    			<option>娱乐</option>
	    			<option>体育</option>
	    			<option>美食</option>
	    			<option>科普</option>
	    			<option>学术</option>
	    			<option>就业</option>
	    		</select>
	    	</div>
	    	<div class="create_topic_body">
	    		<textarea id="createTopicContent" name="createTopicContent"></textarea>
	    	</div>
	    </form>
	    <button onclick="createTopic()">提交</button>	    
    </div>

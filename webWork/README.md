# webWork
模仿知乎网的一个网站  
1. 搭建开发环境   
	1.1 导入开发包  
		mysql驱动：  
		DBUtils开发包：  
		log4j开发包：commons-fileupload-1.3.1.jar  
	1.2 创建程序包  
	 	filter   
		jdbc    
		service  
		service.comment  
		service.topic  
		service.user  
		service.topic.Impl  
		service.user.Impl  
		servlet  
		util  
  
		webContent\images 保存头像信息  
		webContent\pages  
		webContent\pages\common  基础jsp  
		webContent\pages\css  基础css  
		webContent\pages\js 基础js  
		webContent\pages\img  网站基本的图象  
		webContent\pages\sys  网站各类jsp  
  
		webContent\pages\sys\forget 忘记密码找回密码jsp  
		webContent\pages\sys\index 首页及个人主页...等主要界面  
		webContent\pages\sys\login 登陆jsp  
		webContent\pages\sys\register 注册jsp  
		webContent\pages\sys\select 搜索jsp  
		webContent\pages\sys\topic 话题页面jsp  
		
	1.3 创建工具类  
		EmailUtil.java  
		VerifyCodeUtils.java  
		DBUtil.java  
		 
	1.4 建库  
		  
		1.4.1建用户表  
		CREATE TABLE `user` (  
		  `phoneNum` varchar(11) NOT NULL COMMENT '手机号',  
		  `password` varchar(16) NOT NULL COMMENT '密码',  
		  `name` varchar(10) NOT NULL COMMENT '姓名',  
		  `sex` varchar(3) DEFAULT NULL COMMENT '性别',  
		  `age` int(3) DEFAULT NULL COMMENT '年龄',  
		  `email` varchar(30) NOT NULL COMMENT '邮箱',  
		  `address` varchar(50) DEFAULT NULL COMMENT '地址',  
		  `introduction` varchar(100) DEFAULT NULL COMMENT '个人介绍',  
		  `fans` int(4) DEFAULT '0' COMMENT '粉丝数',   
		  `concerns` int(4) DEFAULT '0' COMMENT '关注数',  
		  `headSculptureAdd` varchar(200) DEFAULT 'images/default.png' COMMENT '头像地址',  
		  `collections` int(4) DEFAULT '0' COMMENT '收藏数',  
		  `userCreateTime` datetime DEFAULT NULL COMMENT '用户创建时间',  
		  `userCommentNum` int(8) DEFAULT '0' COMMENT '用户评论数',  
		  `userTopicNum` int(8) DEFAULT '0' COMMENT '用户的话题数',  
		  PRIMARY KEY (`phoneNum`)  
		) ENGINE=InnoDB DEFAULT CHARSET=utf8  
		
		
		1.4.2建话题表  

		CREATE TABLE `topic` (  
		  `phoneNum` varchar(11) NOT NULL COMMENT '话题创建者',  
		  `topicNum` int(9) NOT NULL AUTO_INCREMENT COMMENT '话题编号',  
		  `topicName` varchar(20) NOT NULL COMMENT '话题标题',  
		  `topicType` varchar(5) NOT NULL COMMENT '话题类型',  
		  `topicContent` varchar(1000) NOT NULL COMMENT '话题内容',  
		  `topicCommentNum` int(9) DEFAULT '0' COMMENT '话题评论数',  
		  `topicCreateTime` datetime DEFAULT NULL COMMENT '话题创建时间',  
		  `topicClickNum` int(9) DEFAULT '0' COMMENT '话题点击数',  
		  `topicLastClickTime` datetime DEFAULT NULL COMMENT '话题最后点击时间',  
		  `collectionNum` int(8) DEFAULT '0' COMMENT '被收藏数',  
		  `topicZan` int(8) DEFAULT '0',  
		  PRIMARY KEY (`topicNum`),  
		  KEY `phoneNum` (`phoneNum`),  
		  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`phoneNum`) REFERENCES `user` (`phoneNum`) ON DELETE CASCADE ON UPDATE CASCADE 
		) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8    

 
		1.4.3建用户关系表  

		CREATE TABLE `relation` (  
		  `concerner` varchar(11) NOT NULL DEFAULT '' COMMENT '关注者',  
		  `beConcerner` varchar(11) NOT NULL DEFAULT '' COMMENT '被关注者',  
		  `concernTime` datetime DEFAULT NULL COMMENT '关注时间',  
		  PRIMARY KEY (`concerner`,`beConcerner`),  
		  KEY `beConcerner` (`beConcerner`),  
		  CONSTRAINT `relation_ibfk_1` FOREIGN KEY (`concerner`) REFERENCES `user` (`phoneNum`) ON DELETE CASCADE ON UPDATE   			CASCADE,  
		  CONSTRAINT `relation_ibfk_2` FOREIGN KEY (`beConcerner`) REFERENCES `user` (`phoneNum`) ON DELETE CASCADE ON UPDATE  			CASCADE  
		) ENGINE=InnoDB DEFAULT CHARSET=utf8  
		
		1.4.4建用户收藏表  
		CREATE TABLE `cellect` (  
		  `phoneNum` varchar(11) NOT NULL COMMENT '用户账号',  
		  `topicNum` int(9) NOT NULL COMMENT '收藏话题编号',  
		  `collectTime` datetime DEFAULT NULL COMMENT '收藏时间',  
		  PRIMARY KEY (`phoneNum`,`topicNum`),  
		  KEY `FK_cellect` (`topicNum`),  
		  CONSTRAINT `FK_cellect` FOREIGN KEY (`topicNum`) REFERENCES `topic` (`topicNum`) ON DELETE CASCADE ON UPDATE CASCADE,  
		  CONSTRAINT `FK_cellect1` FOREIGN KEY (`phoneNum`) REFERENCES `user` (`phoneNum`) ON DELETE CASCADE ON UPDATE CASCADE  
		) ENGINE=InnoDB DEFAULT CHARSET=utf8  
		
		
		1.4.5建用户评论表  

		CREATE TABLE `comment` (  
		  `phoneNum` varchar(11) DEFAULT NULL COMMENT '用户账号',  
		  `commentContent` varchar(1000) DEFAULT NULL COMMENT '评论内容',  
		  `commentTime` datetime DEFAULT NULL COMMENT '评论时间',  
		  `topicNum` int(9) DEFAULT NULL COMMENT '评论话题编号',  
		  `zan` int(8) DEFAULT '0' COMMENT '赞数',  
		  `commentNum` int(9) NOT NULL AUTO_INCREMENT COMMENT '评论编号',  
		  PRIMARY KEY (`commentNum`),  
		  KEY `topicNum` (`topicNum`),  
		  KEY `phoneNum` (`phoneNum`),  
		  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`topicNum`) REFERENCES `topic` (`topicNum`) ON DELETE CASCADE ON UPDATE   			ASCADE,  
		  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`phoneNum`) REFERENCES `user` (`phoneNum`) ON DELETE CASCADE ON UPDATE   			SCADE  
		) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8  
		
		
		1.4.6还有一些其他补充的表就不多写了





 


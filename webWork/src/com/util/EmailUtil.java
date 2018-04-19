package com.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * 类名称：EmailUtil 
 * 类描述：发送邮件工具
 * @version 1.0
 */
public class EmailUtil {
	
	public static void sendMail(String user_email,String attribute) {
		
		    JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
	        // 设定mail server  
	        senderImpl.setHost("smtp.qq.com");  
	        senderImpl.setPort(587);   
	        senderImpl.setUsername("q836304196@qq.com"); // 根据自己的情况设置username  
	        senderImpl.setPassword("zbdkoohhwaxpbbbi"); // 密码为在163邮箱上的授权
	  
	        Properties prop = new Properties();  
	        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行确认认证用户名和密码是否正确  
	        prop.put("mail.smtp.timeout", "2500");  
	        senderImpl.setJavaMailProperties(prop);  
	        

	        // 建立邮件消息  
	  
			try {
		        MimeMessage message = senderImpl.createMimeMessage();
		        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		        messageHelper.setTo(user_email);  
		        messageHelper.setFrom("q836304196@qq.com");  
		        messageHelper.setSubject(" 邮箱取回验证?");  
		        messageHelper.setText(" 验证码："+attribute );  
			       
			    senderImpl.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	        	  
	  
	}

}

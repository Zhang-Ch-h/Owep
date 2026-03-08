package com.kclm.owep.utils.email;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SendEmail {
	
	private static final Logger LOG = LoggerFactory.getLogger(SendEmail.class);
	
	/**
	 * @Title: send_email
	 * @Description: TODO
	 * @author huangfei
	 * @param toEmail 接收者邮箱
	 * @param senEmail 发送都邮箱
	 * @param emailSubject //邮件主题
	 * @param emailLink //邮件内链接
	 * @return boolean
	 * @date: 2017年5月9日 下午2:22:30
	 */
	public static boolean send_email(String toEmail,String senEmail,String emailSubject,String emailLink){
		LOG.info("SendEmail: Execute Method send_email ");
		boolean flag =false;
		try {
			 String to = toEmail;//接收者邮箱
			 String senEmaillocal=senEmail;//发送者邮箱
	         String subject = emailSubject;//邮件主题
	         String content = emailLink;//邮件内容
	         Properties properties = new Properties();  
	         properties.setProperty("mail.host","smtp.mxhichina.com" );  
	         properties.setProperty("mail.transport.protocol", "smtp");  
	         properties.setProperty("mail.smtp.auth", "true");  
	         properties.setProperty("mail.debug", "false");

	         Authenticator authenticator = new Email_Authenticator(senEmaillocal, "Hd@123456");
	         javax.mail.Session sendMailSession = javax.mail.Session.getDefaultInstance(properties, authenticator);
	         MimeMessage mailMessage = new MimeMessage(sendMailSession);
	         mailMessage.setFrom(new InternetAddress(senEmaillocal));
	         // Message.RecipientType.TO属性表示接收者的类型为TO
	         mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         mailMessage.setSubject(subject, "UTF-8");
	         mailMessage.setSentDate(new Date());
	         // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
	         Multipart mainPart = new MimeMultipart();
	         // 创建一个包含HTML内容的MimeBodyPart
	         BodyPart html = new MimeBodyPart();
	         html.setContent(content.trim(), "text/html; charset=utf-8");
	         mainPart.addBodyPart(html);
	         mailMessage.setContent(mainPart);
	         Transport.send(mailMessage);
			flag = true;
		} catch (Exception e) {
			LOG.error("SendEmail: Execute Method send_email "+e);
			flag = false;
		}
		return flag;
	}
	
	
}

package com.lyz.utils.test;

import com.lyz.utils.email.MailSender;
import com.lyz.utils.email.MailSenderInfo;
import junit.framework.Assert;

import java.io.InputStream;
import java.util.Properties;

/**
 * 测试发送邮件
 * @author liuyazhuang
 *
 */
public class SendTest {

	/**
	 * 
	 *  QQ邮箱 POP3 和 SMTP 服务器地址设置如下：邮箱POP3服务器（端口110）SMTP服务器（端口25）qq.com pop.qq.com smtp.qq.comSMTP服务器需要身份验证。
		如果是设置POP3和SMTP的SSL加密方式，则端口如下：
		POP3服务器（端口995）
		SMTP服务器（端口465或587）。
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Properties prop = new Properties();
		InputStream in = SendTest.class.getResourceAsStream("/email.properties");
		prop.load(in);
		
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(prop.getProperty("mail_server_host"));
		mailInfo.setMailServerPort(prop.getProperty("mail_server_port"));
		mailInfo.setUserName(prop.getProperty("mail_user_name"));
		mailInfo.setPassword(prop.getProperty("mail_password"));
		mailInfo.setFromAddress(prop.getProperty("mail_from_address"));
		
		mailInfo.setValidate(true);
		mailInfo.setToAddress("vivian8174@qq.com");
		mailInfo.setSubject("你好");
		mailInfo.setContent("测试邮件发送");
		
		// 这个类主要来发送邮件
		MailSender.sendTextMailWithAttachment(mailInfo);// 发送文体格式
		Assert.assertEquals("邮件主题验证", "你好", "你好");
		Assert.assertEquals("邮件内容验证","测试邮件发送","测试邮件发送");
		System.out.println("邮件主题：你好");
		System.out.println("邮件内容：测试邮件发送");
	}

}

package com.itwillbs.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger mylog = LoggerFactory.getLogger(MailService.class);
	
	// @Async : 비동기방식으로 처리하는 메서드
	@Async
	public void sendMail(String to, String subject, String body) throws Exception {
		mylog.debug(" to : " + to);
		mylog.debug(" subject : " + subject);
		mylog.debug(" body : " + body);
		
		MimeMessage message = mailSender.createMimeMessage();
		// -> 메일을 전송하기 위한 MimeMessage 객체 생성
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
		
		messageHelper.setFrom("ahr9291028@gmail.com","hyerim"); // 이메일 주소(보내는 사람), 사람이름
		messageHelper.setTo(to);     // 이메일 주소(받는사람)
		messageHelper.setSubject(subject); // 이메일 제목
		messageHelper.setText(body,true); // 이메일 본문
		
		// 메일 전송
		mailSender.send(message);
		
		mylog.debug("메일전송 완료");
		
		
		
	}
}

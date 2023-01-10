package com.itwillbs.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.MailService;

// @EnableAsync : 비동기방식의 호출을 사용가능
@Controller
@EnableAsync
public class MainController {
	
	private static final Logger mylog = LoggerFactory.getLogger(MainController.class);

	// Mail서비스 객체 생성(객체 의존주입)
	@Inject
	private MailService mailService;
	
	//  /sendMail.will 가상주소 호출 시 가상주소를 제외한 뷰페이지 연결
	@RequestMapping(value = "/sendMail.will",method = RequestMethod.GET)
	public void sendMail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		mylog.debug(" sendMail() 호출 ");
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		sb.append(" <html><body>");
		sb.append(" <h1>안녕하세요</h1>");
		sb.append(" <a href='https://news.artnet.com/app/news-upload/2014/08/gif-history-dvdp.gif'>");
		sb.append(" <img src='https://news.artnet.com/app/news-upload/2014/08/gif-history-dvdp.gif'> ");
		sb.append(" </a>");
		sb.append(" <img src='https://news.artnet.com/app/news-upload/2014/08/gif-history-dvdp-2.gif'> ");
		sb.append("</body></html> ");
		
		String str = "";
		str += " <html><body> ";
		str += " <h1>안녕하세요</h1> ";
		str += " <a href='https://news.artnet.com/app/news-upload/2014/08/gif-history-dvdp.gif'>";
		str += " <img src='https://news.artnet.com/app/news-upload/2014/08/gif-history-dvdp.gif'>";
		str += " </a>";
		str += " </body></html>";
		
		// 메일 보내기
		//					 받는 주소				// 제목				// 내용
		mailService.sendMail("gpfla2349@naver.com","테스트 메일 제목", sb.toString());
		
		out.print("메일 전송 성공!");
		mylog.debug(" 메일 전송 성공@@@@@ ");
//		return "sendMail.will";  >> 그대로 호출
	}
	
}

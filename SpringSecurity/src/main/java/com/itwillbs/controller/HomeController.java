package com.itwillbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// /accessErr - 시큐리티 사용(접근권한 없이 페이지 접근 시 처리 페이지)
	@RequestMapping(value = "/accessErr", method = RequestMethod.GET)
	public void accessDenied(Authentication auth, Model model) throws Exception{
		logger.debug(" accessDenied() 호출 ");
		logger.debug(" 접근 권한 없는 페이지 호출! ");
		
		logger.debug(auth+ " ");
		logger.debug(auth.getName()+ " ");// 접근 아이디
		logger.debug(auth.getAuthorities()+ " ");
		
		model.addAttribute("msg", "접근 권한 없는 페이지 호출입니다!");
		
		//  /accessErr.jsp 페이지 이동
	}
	
	// http://localhost:8080/customLogin
	
	// 로그인 페이지
	@RequestMapping(value ="/customLogin",method = RequestMethod.GET)
	public void customLogin() throws Exception {
		logger.debug(" /customLogin 호출! -> views/customLogin.jsp 이동");
		
		
	}
	
	
}

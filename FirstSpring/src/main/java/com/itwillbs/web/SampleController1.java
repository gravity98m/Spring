package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller : 해당 클래스가 컨트롤러 역할 수행

@Controller
@RequestMapping("/test/*")
public class SampleController1 {
	// 로그 출력 객체
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// * 메서드의 리턴타입이 void인 경우 호출주소.jsp 뷰 연결
	
	// http://localhost:8080/web/doA
	// http://localhost:8080/web/test/doA
	@RequestMapping(value = "/doA")
	public void doA() {
		logger.info("/doA 호출 -> doA() 실행");
	}
	
	// /doB 주소로 호출되는 doB()메서드
	// http://localhost:8080/web/doB
	//@RequestMapping("/doB")
	//@RequestMapping(value = "/doB", method = RequestMethod.GET)
	//@PostMapping
	@GetMapping(value="/doB")
	public void doB() {
		logger.info("/doB 호출 -> doB() 실행");
	}
}

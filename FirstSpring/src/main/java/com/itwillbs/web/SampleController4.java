package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger mylog = LoggerFactory.getLogger(SampleController4.class);
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	// 동작 처리 이후에 페이지 이동(주소이동)
	
	// http://localhost:8080/web/doE
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr /* Model model */) {
		logger.info("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		
		// rttr.addAttribute("msg", "ITWILL"); 
		// 기존의 Model 객체와 동일
		// - URI에 표시됨, F5(새로고침)시 데이터 유지
		//	 기존의 이동방식 사용가능 
		rttr.addFlashAttribute("msg", "ITWILL");
		// 전달 정보를 1회성으로 사용가능
		// - URI에 표시안됨, F5(새로고침)시 데이터 사라짐
		// 	 redirect 이동 시에만 사용 가능
		
		//model.addAttribute("msg", "ITWILL");
		// => 주소줄에 파라미터 형태로 전달 /doF?msg=ITWILL
		//return "/doF"; // 리다이렉트 X , 뷰페이지 호출 O
		//return "forward:/doF"; // 포워딩 O
		//return "redirect:/doF?msg=hello"; // 리다이렉트 O
		return "redirect:/doF"; // 리다이렉트 O
	}

	// http://localhost:8080/web/doF
	@RequestMapping("/doF")
	public String doF(@ModelAttribute("msg") String msg) {
		logger.info("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
		logger.info("msg : "+msg);
		
		return "doF 실행";
	}
}

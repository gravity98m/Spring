	package com.itwillbs.spring2;
	
	public class HelloApp { // Controller
	
		public static void main(String[] args) {
	//		// MessageBean - sayHello() 실행
	//		
	//		// MessageBean 객체 생성 => Why? 메서드 사용하려고 필요하니까
	//		// MessageBean 객체 의존하고 있다.(없으면 안됨)
	//		// HelloApp - MessageBean
	//		// 		의존 관계
	//		
	//		// MessageBean 객체 생성 => action으로 보면 됨
	//		MessageBean mb = new MessageBean(); // 강한결합
	//		mb.sayHello("홍길동");
	//		
			
		// MessageBeanKr - sayHello() 호출 => 강한 결합
//		MessageBeanKr beanKR = new MessageBeanKr();
//		beanKR.sayHello("홍길동2");
//		
//		// 약한 결합으로 호출하기!
//		MessageBean mb = new MessageBeanKr();
//		// => 업캐스팅
//		mb.sayHello("홍길동(업캐스팅)");
//		
//		MessageBean mb2 = new MessageBeanEn();
//		mb2.sayHello("Hong");
//		}
			
		// 약한결합 - spring (DI)
			
	}
}
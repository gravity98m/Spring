	package com.itwillbs.spring3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

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
			
		// 약한 결합 - Spring(DI)
		//MessageBean mb2 = new MessageBeanEn();
		//MessageBean mb2 = 스프링 만들어진 객체 호출;
		//					springBeans.xml 파일에 있는 bean << 을 가져올 것
		
		// springBeans.xml 파일에 생성한 객체(bean) 불러오기
		BeanFactory factory 
			= new XmlBeanFactory(new FileSystemResource("springBeans.xml"));
		
			
		System.out.println("factory : "+ factory);
		
		// 의존성 객체 주입(DI)
//		MessageBean mb = (MessageBean) factory.getBean("messageBean"); // 객체를 가져온다.("id")
		MessageBean mb = factory.getBean("messageBean",MessageBean.class); // 다운캐스팅없이 클래스를 가져옴
		
		mb.sayHello("스프링");
			
		}
	}

package com.itwillbs.spring4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		// 스프링(beans.xml)에서 제공되는 객체를 주입받아서 사용
		// 객체 p 사용해서 사용자 정보 출력
		// (홍길동, 20)
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("springBeans.xml"));
		
		Person p1 = factory.getBean("p", Person.class);
		p1.showMyInfo("홍길동", 20);
		p1.showMyInfo(); // strinBeans에서 초기값을 줄 수 있음 (setter를 이용한 주입)
		
		Person p2 = factory.getBean("p2", Person.class);
		p2.showMyInfo();
		

	}

}

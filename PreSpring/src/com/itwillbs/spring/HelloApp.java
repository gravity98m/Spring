package com.itwillbs.spring;

public class HelloApp {

	public static void main(String[] args) {
		// MessageBean - sayHello() 실행
		
		// MessageBean 객체 생성 => Why? 메서드 사용하려고 필요하니까
		// MessageBean 객체 의존하고 있다.(없으면 안됨)
		// HelloApp - MessageBean
		// 		의존 관계
		
		// MessageBean 객체 생성
		MessageBean mb = new MessageBean(); // 강한결합
		mb.sayHello("홍길동");
		
	}
}

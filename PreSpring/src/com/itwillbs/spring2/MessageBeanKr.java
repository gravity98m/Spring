package com.itwillbs.spring2;

public class MessageBeanKr implements MessageBean{
	// 형태는 유지하지만 특화시킨 것
	
	@Override
	public void sayHello(String name) {
		System.out.println(name+"님~ 안녕하세요!(KR)");
		
	}
	
}

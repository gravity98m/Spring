package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//  advice : 보조기능 - 로깅(출력)
public class LoggingAdvice implements MethodInterceptor {

	// 보조기능 호출 메서드
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println(" 주기능(메서드) 호출전  LoggingAdvice");
		System.out.println(invocation.getMethod() + "호출전");
		
		Object obj = invocation.proceed(); // 주기능의 메서드를 호출
		
		System.out.println(" 주기능(메서드) 호출후  LoggingAdvice");
		System.out.println(invocation.getMethod() + "호출후");
		
		return obj;
	}
	
	// throwable - err / exp ->  exception: 실행중 발생, error : 실행전 발생
	
	
	
}

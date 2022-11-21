package com.itwillbs.spring4;

public class PersonImpl implements Person{
	
	private String name;
	private int age;
	
	public PersonImpl() {	}
	public PersonImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void showMyInfo() { // 이 방식은 외부의 접근이 불가능하여 getter/setter 생성
		System.out.println(" 이름 : "+name);
		System.out.println(" 나이 : "+age);
	}

	@Override
	public void showMyInfo(String name, int age) { // 인터페이스에서 파라메터 생성자 생성
		System.out.println(" 이름 : "+name);
		System.out.println(" 나이 : "+age);
	}
	

}

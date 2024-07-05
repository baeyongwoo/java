// 0628
// 자바 총복습
// 패키지 & 클래스 만들기
// 접근제어자

package com.naver.service;

public class Person {
	// field(변수)
	public String name; 
	
	// method(함수)
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	
	// 클래스를 만들었으면 JavaEssential에서 instance를 만들어야 함.
	
	
	
	
	// 디폴트 생성자
	public Person() {}
	
	// 생성자 오버로딩
	public Person(String name) {
		this.name=name;
	}
	
	
}

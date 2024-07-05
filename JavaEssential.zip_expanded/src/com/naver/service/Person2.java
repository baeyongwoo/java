// 0628
// 자바 총복습
// 클래스 만들기
// 접근제어자

package com.naver.service;

public class Person2 {
	private String name;
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	
	// 자동으로 getter, setter 호출하기
	// Source - Generate getters and setters 클릭 - name 클릭
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// setter
	// private라서 다른 패키지에서 접근 못하는 name 필드의 값을 변경해 줄 수 있는 setter 만들기
	// public 붙여줘서 다른 패키지(JavaEssential)에서 접근할 수 있게.
//	public void setName(String name) {
//		this.name=name;
//	}
//	
//	// getter
//	// 호출한 쪽으로 리턴해줘야 하니까 void 대신 자료형 타입 입력
//	public String getName() {
//		return this.name;
//		
//		
//	}
	
	
}

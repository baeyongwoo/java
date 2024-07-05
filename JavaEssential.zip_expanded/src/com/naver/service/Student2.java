// 0628
// 인터페이스 상속


package com.naver.service;

public class Student2 implements Person3{
	// 부모인 인터페이스(Person3)는 변수(필드)를 가질 수 없음. 
	// 자식(Student2)이 필요한 변수를 선언해서 사용해야 함.
	public String name;
	public String department;

	// 인터페이스를 상속받으면 해당 인터페이스의 추상메서드를 자식이 반드시 구현해야 함
	@Override
	public void sleep() {
		System.out.println("하루에 2시간 잡니다.");
		
	}

	
}

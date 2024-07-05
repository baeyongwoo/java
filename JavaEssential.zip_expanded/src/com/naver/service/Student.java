// 0628
// 상속
// 오버라이딩
// 생성자 오버로딩
// 부모 클래스 Person에 name 필드랑 sleep()메서드 있음

package com.naver.service;

public class Student extends Person{ // 학생도 사람이니까 Person 상속
	public String department; // 학과 필드 추가
	
	void study() { // default 접근제어자. 같은 패키지에서만 접근 가능 // 메서드 추가
		System.out.println("공부를 합니다.");
	}
	
	// Person의 sleep() 오버라이딩. source - override/implement methods 클릭해서 생성
	@Override
	public void sleep() {
		System.out.println("하루에 4시간 잡니다."); // 부모 클래스 Person의 sleep()보다 우선순위 높음
	}
	
	
	// 디폴트 생성자
	// 생성자를 만들 때 얘를 먼저 만들어 줘야 Student instance 만든 곳에서 오류 안 남
	// 빈 공간에 ctrl+space 하면 constructor 뜸
	public Student(){}

	
	// 생성자 오버로딩(Constructor Overloading)
	// 필드를 초기화할 때 사용
	// 이렇게 하면 instance를 생성할 때 바로 변수를 저장(초기화)할 수 있음.
	public Student(String name, String department){
//		this.name=name; // 필드 초기화 // Person의 name을 상속 받아서 쓰고 있음
//		this.department=department; // 필드 초기화
		
		// 부모 클래스에 같은 필드가 있으면 this 대신 부모의 생성자를 호출하는 super를 사용
		// 원래 상속을 했을 때 자식클래스의 생성자를 호출하면 자동으로 부모클래스의 생성자가 호출됨
		super(name); // 부모 클래스 Person의 name을 매개변수로 받는 생성자를 호출해서 name 초기화(부모한테 똑같은 코드 있으니까 그거 쓰는 거임)
		this.department=department;
	}
	
	
	
	
	
	
	
}

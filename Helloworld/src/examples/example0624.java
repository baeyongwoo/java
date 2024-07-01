package examples;

import java.util.ArrayList;
import java.util.Arrays;

//1. (공통부분) 소스코드 작성 -> 컴파일 ->(C언어) : .exe -> 실행
//							 ->(Java언어) : .class ->jvm이 해석 -> 실행
//							 
//2. 자바 바이트 코드 : 컴파일 한 번만 하면되는 장점으로, 개발자에게 좋다,
//
//3. 자바 가상머신(jvm) : 소스코드를 컴파일 후 바이트 코드가 만들어지며, jvm에 의해 해석이 되고 실제 기계에서 실행됨
//
//4. 클래스는 설계도와 비슷한 개념으로, 객체를 정의한 틀, 객체의 속성과, 메서드를 포함
// 인스턴스는 클래스를 기반을 만들어진 객체이다. 
//
// 5.추상화 : 객체를 모델링 
//   정보은닉 : 객체 내부 데이터를 외부에 감추는 것
//   상속 : 부모 클래스 -> 자식 클래스 생성
//   다형성 : 이름 동일하지만, 다른 기능을 가진 함수 여러개 만드는 것
//   객체 지향 
   
   

public class example0624 {
	
	public static void main(String[] args) {
	
		
//		6번문제
		int [] exam6 = {1,2,3,4,5,6,7};
		System.out.println("6번문제 답 ");
		for(int i : exam6) { System.out.print(i + " ");}
		System.out.println();
		
		//7번문제
		String [] exam7 = {"a", "b", "c", "d", "e" , "f", "g"};
		System.out.println("7번문제 답 ");
		Arrays.stream(exam7).forEach(i -> System.out.println(i + ""));
		
		System.out.println();
		
		//8번문제
//		ArrayList<Integer> exam8 = new ArrayList<>();
//		System.out.println("8번문제 답 ");
//		for(int i =0; i < 3; i++) {
//			exam8.add(i);
//		}
//		exam8.forEach(i -> System.out.print(i + ""));
//		
		
		
		//피라미드 이중 for 말고 하나만
		int maxRow = 5;
		char star = '*';
		for(int i =0; i<maxRow; i++) { //층
			for(int j =  maxRow -1;  i<j; j--) { //각 층 공백
				System.out.print(" ");
			}
			
			if((i*2)%2==1) {
				System.out.println(star);
				
			}
			
			
				
			
			System.out.println();

		
	} //피라미드 함수 
		
			
	}
}
package examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//6
class Circle{
	
	void calculator(double r, double pi) {
		System.out.println("입력하신 원의 넓이는(Circle 메소드 실행)) : " + Math.pow(r, 2) * pi);
	}
}

//7
//마우스의 공통적인 기능 : 좌클릭, 우클릭, 색깔, 가격
//	1.마우스 1-1 게이밍 1-1-1 무선 1-1-1-1 색깔은 4종류 
//				    1-1-2 유선 1-1-2 색깔은 2종류
//				
//	   	   1-2 사무용 1-2-1 유선 1-2-1 색깔 2종류
//	   			    1-2-2 무선 1-2-2 색깔 2종류
	   
	 
class Mouse{
	String buttonLeft ="왼쪽";
	String buttonRight = "오른쪽";
	String color;
	int defalutPrice = 10000;
	int price =defalutPrice;
	
	
	void priceSet(int price) {
		this.price = price;
	}
	
	void clickLeft() {
		System.out.println(buttonLeft);
	}
	void clickRight() {
		System.out.println(buttonRight);
	}
	
}

class Option_line extends Mouse{
	String line;
	
	
	void setline(String line) {
		if(line.equals("무선")) {
			this.line = line;
			System.out.println("선택하신 라인 옵션은 무선입니다 가격은 10000원추가입니다");
			
			this.price+= 10000; // 무선일 경우 만원 추가
		}else if(line.equals("유선")){
			this.line = line;
			System.out.println("선택하신 라인 옵션은 유선입니다 가격은 5천원추가입니다.");
			this.price += 5000; //유선일경우 5천원 추가
		}else {
			System.out.println("선택안함(랜덤)");
			this.line = "선택안함";
		}
	}
}

class Option_color extends Option_line{
	//String []  = {"red", "blue", "white", "black"};
	Map<String, Integer> colors= new HashMap<>(){{
		put("red", 2000);
		put("blue", 3000);
		put("white", 4000);
		put("black", 5000);
		
	}}; 
	
	
	void plusColor(String color_choice) {
		if(!colors.containsKey(color_choice)) { 
			System.out.println("선택안함(랜덤)");
			this.color="선택안함(랜덤)";
			
		}else {
		System.out.println("선택하신"+color_choice +" 컬러의 가격은 : " + colors.get(color_choice));
		this.color = color_choice;
		this.price+=colors.get(color_choice);
		}
	}
	
}
class MouseBuy extends Option_color{
	void print() {
		System.out.println("구매하신 옵션은 게이밍 마우스이며,기본값은 : "+this.defalutPrice+"원이며, 컬러 : " + this.color + ", 선의 타입 : " + this.line + ", 총 가격은 : " +this.price + "원 입니다.");
	}
}

public class example0626 {
	final static double pi  = 3.14;
	public static void main(String[] args) {
		
		for(int i =0; i<5; i++) {
			for(int j = 0;  j<5+i; j++) { 
				if(i+j> 3) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			
			}
			System.out.println();

		}
		
		
		
		
		Scanner scan = new Scanner(System.in);
				
		// 4
		System.out.print("원의 넓이를 구하겠습니다 >> 반지름을 입력하세요 : ");
		double r = scan.nextDouble();
		System.out.println("입력하신 원의 넓이는 : " + Math.pow(r, 2) * pi);
		Circle circle = new Circle();
		circle.calculator(r, pi);
		
		System.out.println("=============================================");
		//7
		
		
		
		
		MouseBuy mouse1 = new MouseBuy();
		System.out.println("유선 무선 택 해주세요 : >>");
		mouse1.setline(scan.next());
		System.out.print("[");
		mouse1.colors.keySet().forEach(i ->System.out.print( i + ","));
		System.out.println("]");
		System.out.print("색깔을 골라주세요 : >>");
		mouse1.plusColor(scan.next());
		
		mouse1.print();
		
		
		
	}
}

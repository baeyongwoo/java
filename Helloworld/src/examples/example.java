package examples;

import java.util.Scanner;

public class example {
	public static char star = '*';

	//	몇단 피라미드를 입력받아서 출력하기
	public static void pyramid(int maxRow) {
		for(int i =0; i<maxRow; i++) { //층
			for(int j = maxRow -1;  i<j; j--) { //각 층 공백
				System.out.print(" ");
			}
			for(int k =0; k < i*2+1 ; k++) { //별찍기
				System.out.print(star);
			}
			System.out.println();

		}
	} //피라미드 함수 

	public static void step(int maxStep) {
		for (int i = 0; i < maxStep; i++) {
			System.out.println("*".repeat(i + 1));
		}		    
		//		    IntStream.range(0, maxStep)
		//            .forEach(i -> System.out.println("*".repeat(i + 1)));

	}//계단모형



	//구구단 가로모드
	public static void gugudan_row(int maxValue) {
		for(int i =2; i <= maxValue; i++) {
			System.out.println("===========" + i + "단=========");
			for(int j =1; j <= maxValue; j++) {
				System.out.print(" " + i + "X" + j + "=" +i*j );
			}
			System.out.println();
		}
	}



	public static void gugudan_column(int maxValue) {
		for(int i =1; i <= maxValue; i++) {
			
			for(int j =2; j <= maxValue; j++) {
				
				System.out.printf("%3d X %3d = %3d |", j, i, i*j );
			}
			System.out.println();
		} 

	}//구구단 세로 


	public static void main(String[] args) {
		boolean flag = true;
		while(flag) {
			System.out.println("============for문 연습 프로그램============");
			Scanner scan = new Scanner(System.in);
			System.out.println("1.피라미드모형, 2.계단모형, 3.구구단 0.종료");
			System.out.print("어떤 것을 보시겠습니까? (숫자나 문자 입력가능합니다)");
			String select = scan.next();
			select = select.toUpperCase();
			switch (select) {
			
			case "피라미드모형": case "1": {
				System.out.print("몇층까지 출력하시겠습니까? ");
				int maxRow = scan.nextInt();
				pyramid(maxRow);
				break;
			}

			case "계단모형": case "2": {
				System.out.print("몇층까지 출력하시겠습니까? ");
				int maxStep = scan.nextInt();
				step(maxStep);
				break;
			}
			case "구구단": case "3":{
				System.out.print("1.가로모드, 2.세로모드 (숫자나 문자 입력가능합니다)");
				select = scan.next();
				if(select.equals("가로모드") || select.equals("1")) {
					System.out.print("몇단까지 출력하시겠습니까? ");
					int maxValue =  + scan.nextInt();
					gugudan_row(maxValue);
				}
				if(select.equals("세로모드") || select.equals("2")) {
					System.out.print("몇단까지 출력하시겠습니까? "); 
					int maxValue =  + scan.nextInt();
					gugudan_column(maxValue);
				}
				break;
			}

			case "0": case "종료" : case "O":{
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			}

			default:
				System.out.println();
				System.out.println("선택하신 사항은 없으며, 다시확인해주시고 입력해주세요");
				System.out.println();

			} //switch 함수
		}//while문
	}//main 함수
}

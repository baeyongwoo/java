import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		try {
			System.out.print("분자 : ");
			int num1 = scan.nextInt();
			System.out.print("분모 : ");
			int num2 = scan.nextInt();
			int result = num1 / num2;	
			System.out.println("결과는 : " + result);
		} catch (java.util.InputMismatchException e) {
			
				//e.printStackTrace();
				System.out.println("숫자타입아니여서 Error");
			}
		catch (java.lang.ArithmeticException e) {
			System.out.println("0으로 나눌수없습니다.");
		}
			
		
		finally {
			//db연동시 close()작업을 주로 처리
			System.out.println("나눗셈 프로그램 종료");
		}
		
		
	}
}
class Count1{
	static int count = 0;
	
}


public class StaticTest {
	public static void main(String[] args) {
		Count1 c1 = new Count1();
		Count1 c2 = new Count1();
		
		c1.count++; 
		c2.count++;
		Count1.count++;//클래스명으로 접근가능
		System.out.println(Count1.count);
		
	}
}
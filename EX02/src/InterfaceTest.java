interface Predator{
	//추상메서드 {}이 없음 선언만 함
	String getFood();
//	String getFood(int n);
}

class Tiger implements Predator{

	//메서드 오버라이딩. 부모의 추상메서드를 반드시 오버라이딩 해야함
	@Override
	public String getFood() {
		return "apple";
	}
	
	//메서드 오버로딩
	public String getFood(int ea) {
		return "apple" + ea + "개";
	}}


public class InterfaceTest {
	
	public static void main(String[] args) {
		//interface는 instatnce 생성 불가
		
		//자식 클래스를 이용해서 instance 생성
		Tiger t = new Tiger();
		System.out.println(t.getFood());
		
		Predator p = new Tiger(); // upcasting Predator - 부모, tiger - 자식
		System.out.println(p.getFood());
//		System.out.println(p.getFood(2));  // 부모쪽에 머서드가 없어서, 즉, 자식이 오버로딩한 메서드 사용 불가
		
		System.out.println(t.getFood(2));
		
	}
}


public class LinkedListTest {
	public static void main(String[] args) {
		//시작하는 객체를 가리키는 래퍼런스
		Shape head = null; 
		//끝 마지막 객체를 가리키는 래퍼런스
		Shape tail = null;
		//생성된 객체를 가리키는 임시 래퍼런스
		Shape temp = null;
		
//		temp = new Shape();
//		head = temp;
//		tail = temp;
//		temp.name="원";
//		
//		temp = new Shape();
//		tail.next = temp;
//		tail=temp;
//		temp.name="삼각형";
//		
//		temp = new Shape();
//		tail.next = temp;
//		tail = temp;
//		temp.name="사각형";
		
		for(int i=1; i<=10; i++) {
			temp = new Shape();
			temp.name = i+"번째 Shape";
			//처음 객체를 만들었을 때, head가 아직 null, 즉, 최초 값을 넣을경우
			if(head==null) {
				head = temp;
				tail=temp;
			}
			tail.next = temp;
			tail = temp;
			
		}
		
		
		
		//출력
		//head가 가리키는 객체부터 시작
		Shape s = head;
		while(s!=null) {
			s.draw();
			s=s.next;
		}
		
	}
}

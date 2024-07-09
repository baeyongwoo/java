
public class LinkedListTest2 {
	public static Shape head=null; // 시작
	public static Shape tail=null; // 끝
	public static Shape tmp=null;
	
	public static int i=0;
		
	public static void recursiveLinkedList(int
			count) {		
		i++;
		if(i>count) {
			return;
		}
		tmp=new Shape();	
		tmp.name=i+"번째 도형";
		if(head==null) {
			head=tmp;
			tail=head;				
		}else {	
			tail.next=tmp; 
			tail=tmp;
		}
		
		
		recursiveLinkedList(count);
	}
	
	
	public static void main(String[] args) {	

		recursiveLinkedList(5);		
		
		//출력
		Shape p=head; // head값을 p에 저장
		while(p!=null) {
			p.draw();
			p=p.next;
		}
		

	}

}

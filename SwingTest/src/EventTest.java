import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//event처리 방법 중 1 (외부클래스 만들어서)
class MyEvent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// e.getActionCommand(); 어떤 버튼을 눌렀는지 확인가능
		System.out.println("클릭");
	}
	
}

////event처리 방법 중 3 (JFrame이 리스너 상속받아서)
public class EventTest extends JFrame implements ActionListener{
	
	JButton btn1 = null;
	JButton btn2 = null;
	JButton btn3 = null;
	JButton btn4 = null;
	
	////event처리 방법 중 2 (이너클래스 만들어서)
	//inner class
	class MyEvent2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("클릭2");
			
		}
		
	}
	
	
	public EventTest() {
		this.setTitle("이벤트처리 연습");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//직접 프레임에 버튼추가하면 꽉차게 되어 다른 버튼들을 사용못한다 그래서 레이아웃을 flow로 만들어준다.
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼1");
		btn1.addActionListener(new MyEvent()); //Action Event 처리 적용
		this.add(btn1); //직접 프레임에 버튼 추가하기
		
		
		btn2 = new JButton("버튼2");
		btn2.addActionListener(new MyEvent2());
		this.add(btn2);
		
		btn3 = new JButton("버튼3");
		btn3.addActionListener(this); //현재 만들어져있는 래퍼런스를 전달하기 위해
		//만약에 파라미터를 new MyEvent2()하면 윈도우를 한 개 더 만든다
		this.add(btn3);
		
	//event처리 방법 중 4 (익명클래스)
		btn4 = new JButton("버튼4");
		btn4.addActionListener(new ActionListener() { 
			//ActionListener는 인터페이스이다. 근데 인터페이스는 스스로 객체를 만들지 못한다. 하지만 중괄호 해서 익명클래스를 만들어서 사용가능하다 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("클릭 4");
				
			}
		});
		this.add(btn4);
		
		
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new EventTest();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("클리3");
		
	}



}

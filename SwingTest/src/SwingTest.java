import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SwingTest extends JFrame{ //1. JFrame 상속받기
	//2. default 생성자 초기화
	public SwingTest() { 
		this.setTitle("학사관리"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X버튼 눌렀을때 프로그램 종료
		

		//아래 구문은 반드시 setSize와 위 구문 사이에 
		Container c = this.getContentPane();//container 생성
		c.setLayout(new FlowLayout()); //FlowLayout 설정. 왼쪽부터 순서대로 배치  =>defalut가 align이 center라서 아래 버튼 하나만 생성하면 가운데로 보인다.
		
		JButton btn1 = new JButton("버튼1");
		c.add(btn1);
		
		JButton btn2 = new JButton("button2");
		btn2.setBackground(Color.gray); //배경색
		btn2.setForeground(Color.green); //글자색설정
		btn2.setFont(new Font("Arial", Font.ITALIC,20)); //폰트설정
		c.add(btn2);
		
		
		ImageIcon icon1 = new ImageIcon("images/icon01.png"); //image 아이콘
		JLabel imageLabel = new JLabel("자바", icon1, SwingConstants.CENTER); //Label
		c.add(imageLabel);
		
		
		ImageIcon icon2 = new ImageIcon("images/icon02.png"); //image 아이콘
		JButton btn = new JButton("자바", icon1);
		btn.setRolloverIcon(icon2); //마우스가 hover 될 때 아이콘 지정
		c.add(btn);
		
		
		this.setSize(300,200);
		this.setVisible(true); //윈도우 보이게 설정
	}
	
	public static void main(String[] args) {
		//3. 생성자 호출
		new SwingTest(); 
	}
}



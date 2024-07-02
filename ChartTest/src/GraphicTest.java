import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicTest extends JFrame{
	//inner class. Jpanel을 상속받음
	class Mypanel extends JPanel{

		@Override
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);//부모 클래스인 JPanel의 paintComponents 호출
			
			g.setColor(Color.red);
			
			g.drawLine(10, 10, 110, 110); //직선
//			g.drawOval(10, 120, 200, 100); //원
//			g.drawRect(10, 230, 100, 100);//사각형
//			g.drawRoundRect(10, 350, 100, 100, 50, 50);//사각형
//			g.drawArc(10, 470, 100, 100, 0, 180); //원호
			
			
			g.fillOval(10, 120, 200, 100); //원
			g.fillRect(10, 230, 100, 100);//사각형
			g.fillRoundRect(10, 350, 100, 100, 50, 50);//사각형
			g.fillArc(10, 470, 100, 100, 0, 180); //원호
			
			
			g.drawString("그래픽스", 10, 600); //왼쪽 하단이 꼭짓점 좌표 텍스트 출력
		}
		
	}
	
	public GraphicTest() {
		this.setTitle("그래픽 연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setContentPane(new Mypanel()); //panel을 화면에 꽉차게 배치
		
		
		
		this.setSize(800, 800);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GraphicTest();
	}
}

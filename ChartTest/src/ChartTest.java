import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartTest extends JFrame{	
	class MyPanel extends JPanel{
		// panel을 그려주는 메서드
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			//막대그래프
			int height=20;
			int vGap=5; // 막대 사이의 여백
			//좌표
			int x=150; 
			int y=20;
			g.fillRect(x, y, 100, height);//1/4분기
			g.fillRect(x, y+height+vGap, 150, height);//2/4분기
			g.fillRect(x, y+(height+vGap)*2, 200, height);//3/4분기
			g.fillRect(x, y+(height+vGap)*3, 300, height);//4/4분기
			
			g.drawString("1/4분기", x-50, y+15);
			g.drawString("2/4분기", x-50, y+15+height+vGap);
			g.drawString("3/4분기", x-50, y+15+(height+vGap)*2);
			g.drawString("4/4분기", x-50, y+15+(height+vGap)*3);
			
			//꺾은선그래프
			int hGap=50;
			g.drawLine(x, 400, x+hGap, 400-100);
			g.drawString(TOOL_TIP_TEXT_KEY, x, y);
			g.drawLine(x+hGap, 400-100, x+hGap+hGap, 400-150);
			g.drawLine(x+hGap+hGap, 400-150, x+hGap+hGap+hGap, 400-220);
			g.drawLine(x+hGap+hGap+hGap, 400-220, x+hGap+hGap+hGap+hGap, 400-50);
			
			//파이차트
			g.setColor(Color.RED);
			g.fillArc(x, 400, 300, 300, 0, 45);
			g.setColor(Color.GREEN);
			g.fillArc(x, 400, 300, 300, 45, 70);
			g.setColor(Color.BLUE);
			g.fillArc(x, 400, 300, 300, 115, 90);
			g.setColor(Color.ORANGE);
			g.fillArc(x, 400, 300, 300, 205, 155);
			
		}		
	}	
	public ChartTest() {
		this.setTitle("챠트연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel p=new MyPanel();
		p.setBackground(Color.WHITE);
		this.setContentPane(p);
		
		this.setSize(800, 800);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new ChartTest();
	}
}

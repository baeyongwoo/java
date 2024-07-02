package examples;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class example0702 extends JFrame{	
	class MyPanel extends JPanel{
		// panel을 그려주는 메서드
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			//좌표
			int x=150; 

			
			//꺾은선그래프
			int hGap=50;
			g.drawLine(x, 400, x+hGap, 400-100);
	
			g.drawLine(x+hGap, 400-100, x+hGap+hGap, 400-150);
			g.drawLine(x+hGap+hGap, 400-150, x+hGap+hGap+hGap, 400-220);
			g.drawLine(x+hGap+hGap+hGap, 400-220, x+hGap+hGap+hGap+hGap, 400-50);
			
			// 꺾은선 그래프에서 x축과 y축 표시
			g.setColor(Color.BLACK);
			g.drawLine(x, 400, x + 300, 400); // x축
			g.drawLine(x, 400, x, 100); // y축

			// x축 레이블
			g.drawString("1/4분기성과", x, 420);
			g.drawString("2/4분기성과", x + hGap, 420);
			g.drawString("3/4분기성과", x + hGap * 2, 420);
			g.drawString("4/4분기성과", x + hGap * 3, 420);

			
			// y축 레이블
			g.drawString("0", x - 20, 400);
			g.drawString("100", x - 20, 300);
			g.drawString("200", x - 20, 200);
			g.drawString("300", x - 20, 100);
			
			
	
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
	public example0702() {
		
		this.setTitle("챠트연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel p=new MyPanel();
		p.setBackground(Color.WHITE);
		this.setContentPane(p);
		
		this.setSize(800, 800);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new example0702();
	}
}

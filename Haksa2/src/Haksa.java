import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//JAVA, JDBC, Swing, Oracle
//custome dialog
class MyDialog extends JDialog{
	JLabel lblID = null;
	JTextField tfID = null;
	JLabel lblPW = null;
	JPasswordField tfPW = null;
	JButton btnLogin = null;
	
	
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLayout(new FlowLayout());
		lblID = new JLabel("ID");
		this.add(lblID);
		tfID=new JTextField(10);
		this.add(tfID);
		
		lblPW = new JLabel("PW");
		this.add(lblPW);
		tfPW=new JPasswordField(10);
		this.add(tfPW);
		
		btnLogin = new JButton("로그인");
		this.add(btnLogin);
		
		this.setSize(170, 140);
		
		
	}
}


public class Haksa extends JFrame{
	
	JPanel panel = null;//메뉴별 화면이 출력되는 패널
	MyDialog dialog =null;
	
	public Haksa() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MenuBar
		JMenuBar bar = new JMenuBar();
		
		//Menu
		JMenu mStudent = new JMenu("학생관리"); //학생관리 메뉴
		bar.add(mStudent); //뭔가 뭐든지 만들고 추가하는 식?
		
		JMenu mBook = new JMenu("도서관리");
		bar.add(mBook);
		
		//Menu Item 
		//Menu 디렉터리 안에 새 폴더 만든다고 생각하면 쉬움 
		JMenuItem miList = new JMenuItem("학생정보");
		
		miList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				
				panel.add(new Student());
				panel.setLayout(null);
								
			}
		});
		mStudent.add(miList);
		
		
		
		JMenuItem miBookRent = new JMenuItem("대출목록");
		miBookRent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				
				panel.add(new BookRent());
				panel.setLayout(null);
				
			}
		});
		
		
		
		mBook.add(miBookRent);
		
		
		//메뉴바도 만들었으니 프레임에 추가
		//add와 차이점이 있다. JMenuBar는 메뉴바 처럼 생성
		//프레임은 윈도우, 윈도우는 1개, 패널을 만들어서 화면 교체하는 느낌
		this.setJMenuBar(bar);
		
		//panel생성, 추가
		this.panel = new JPanel();
		this.panel.setBackground(Color.LIGHT_GRAY);
		this.add(panel);
		
		this.setSize(400, 500);
		this.setVisible(true);
		
//		//로그인 dialog 띄우기
//		dialog = new MyDialog(this, "로그인");
//		dialog.setModal(true); // modal dialog로 설정
//		dialog.setVisible(true); 
//		
	
	}
	
	public static void main(String[] args) {
		new Haksa();
	}
}

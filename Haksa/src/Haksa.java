import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Haksa extends JFrame {
	JLabel lblID = null;
	JTextField tfId = null;
	JLabel lblName = null;
	JTextField tfName = null;
	JLabel lblDepart = null;
	JTextField tfDepart = null;
	JTextArea taList =null;
	
	public Haksa() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		lblID = new JLabel("학번");
		c.add(lblID);
		tfId = new JTextField(20); //input type text와 같은것
		c.add(tfId);
		lblName = new JLabel("이름");
		c.add(lblName);
		tfName = new JTextField(20); //input type text와 같은것
		c.add(tfName);
		lblDepart = new JLabel("학과");
		c.add(lblDepart);
		tfDepart = new JTextField(20); //input type text와 같은것
		c.add(tfDepart);
		taList = new JTextArea(15,23);
		c.add(new JScrollPane(taList)); //scroll 추가
		
		
		
		
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Haksa();
	}
}

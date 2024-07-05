import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
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
	
	
	JButton btnInsert = null; 
	JButton btnSelect = null; 
	JButton btnUpdate = null; 
	JButton btnDelete = null; 

	JButton btnSearch = null;
	public Haksa() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		lblID = new JLabel("학번");
		c.add(lblID);
		tfId = new JTextField(13); //input type text와 같은것
		c.add(tfId);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//oracle jdbc driver load
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ora_user","hong");
					
					
					//Sql문을 생성하는 객체
					Statement stmt = conn.createStatement();
					
					//목록 초기화
					taList.setText("");
					
					//select
					ResultSet rs = stmt.executeQuery("select * from student where id ='"+tfId.getText()+"'");
					System.out.println("search완료");
					taList.append("학번\t이름\t학과\n");
					taList.append("==============================\n");
					while(rs.next()) {
					
						taList.append(rs.getString("id") + '\t');
						taList.append(rs.getString("name") + '\t');
						taList.append(rs.getString("depart") + '\n');
						
						tfId.setText(rs.getString("id"));
						tfName.setText(rs.getString("name"));
						tfDepart.setText(rs.getString("depart"));
						
						
						
					}
					
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		
		c.add(btnSearch);
		
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
		
		
		
		//버튼 CRUD
		btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//oracle jdbc driver load
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ora_user","hong");
					
					
					//Sql문을 생성하는 객체
					Statement stmt = conn.createStatement();
					
					//insert, update, delete 포함
					stmt.executeUpdate("insert into student values('"+tfId.getText()+"', '"+tfName.getText()+"', '"+tfDepart.getText()+"')");
					System.out.println("insert완료");
					//stmt.execute("update student set name='홍길돈' where id= 'K202002'");
					//stmt.execute("delete from student where id='K202001'");
					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					//목록 초기화
					taList.setText("");
					
					taList.append("학번\t이름\t학과\n");
					taList.append("==============================\n");
					while(rs.next()) {
						

						taList.append(rs.getString("id") + '\t');
						taList.append(rs.getString("name") + '\t');
						taList.append(rs.getString("depart") + '\n');
					}
					
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		c.add(btnInsert);
		btnSelect = new JButton("목록");
		btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//oracle jdbc driver load
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ora_user","hong");
					
					System.out.println("select완료");
					
					//Sql문을 생성하는 객체
					Statement stmt = conn.createStatement();
					
					//목록 초기화
					taList.setText("");
					
					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					taList.append("학번\t이름\t학과\n");
					taList.append("==============================\n");
					while(rs.next()) {						
						taList.append(rs.getString("id") + '\t');
						taList.append(rs.getString("name") + '\t');
						taList.append(rs.getString("depart") + '\n');
					}
					
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		c.add(btnSelect);
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//oracle jdbc driver load
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ora_user","hong");
					
					
					//Sql문을 생성하는 객체
					Statement stmt = conn.createStatement();
					
					stmt.execute("update student set name='"+tfName.getText()+"', depart='"+tfDepart.getText()+"' where id= '"+tfId.getText()+"'");
					System.out.println("update완료");
					
					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					//목록 초기화
					taList.setText("");
					
					taList.append("학번\t이름\t학과\n");
					taList.append("==============================\n");
					while(rs.next()) {
						
						taList.append(rs.getString("id") + '\t');
						taList.append(rs.getString("name") + '\t');
						taList.append(rs.getString("depart") + '\n');
					}
					
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		
		c.add(btnUpdate);
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//oracle jdbc driver load
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ora_user","hong");
					
					
					//Sql문을 생성하는 객체
					Statement stmt = conn.createStatement();
					
					
					stmt.execute("delete from student where id='"+tfId.getText()+"'");
					System.out.println("delete완료");
					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					//목록 초기화
					taList.setText("");
					tfId.setText("");
					tfName.setText("");
					tfDepart.setText("");
					
					taList.append("학번\t이름\t학과\n");
					taList.append("==============================\n");
					while(rs.next()) {
						

						taList.append(rs.getString("id") + '\t');
						taList.append(rs.getString("name") + '\t');
						taList.append(rs.getString("depart") + '\n');
					}
					
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		c.add(btnDelete);
		
		
		
		
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Haksa();
	}
}

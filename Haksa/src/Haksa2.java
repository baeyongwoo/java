import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Haksa2 extends JFrame {
	JLabel lblID = null;
	JTextField tfId = null;
	JLabel lblName = null;
	JTextField tfName = null;
	JLabel lblDepart = null;
	JTextField tfDepart = null;
	JLabel lblAddress = null;
	JTextField tfAddress = null;
	
	JButton btnInsert = null; 
	JButton btnSelect = null; 
	JButton btnUpdate = null; 
	JButton btnDelete = null; 

	JButton btnSearch = null;
	
	DefaultTableModel model = null;
	JTable table = null;
	public Haksa2() {
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
					model.setRowCount(0); //model의 행의 수 0으로 설정

					//select
					ResultSet rs = stmt.executeQuery("select * from student where id ='"+tfId.getText()+"'");
					
					System.out.println("search완료");
					
					while(rs.next()) {
						String[] row = new String[4];
						row[0] = rs.getString("id");
						row[1] = rs.getString("name");
						row[2] = rs.getString("depart");
						row[3] = rs.getString("address");
						model.addRow(row);
						
				
						tfId.setText(rs.getString("id"));
						tfName.setText(rs.getString("name"));
						tfDepart.setText(rs.getString("depart"));
						tfAddress.setText(rs.getString("address"));



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
		
		lblAddress = new JLabel("주소");
		c.add(lblAddress);
		tfAddress = new JTextField(20);
		c.add(tfAddress);	
		
		String[] colName = {"학번", "이름", "학과", "주소"}; //컬럼명
		model = new DefaultTableModel(colName, 0); //model.데이터
		table = new JTable(model); // table과 model 바인딩(binding)
		table.setPreferredScrollableViewportSize(new Dimension(250, 200)); //table 사이즈 가로,세로크기
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable)e.getComponent(); 
				model = (DefaultTableModel)table.getModel();
				String id = (String)model.getValueAt(table.getSelectedRow(), 0); // 첫번째(행)에서 0번째 (열)인덱스 즉, 학번 가져온다
				tfId.setText(id);
				String name = (String)model.getValueAt(table.getSelectedRow(), 1); 
				tfName.setText(name);
				String depart = (String)model.getValueAt(table.getSelectedRow(), 2); 
				tfDepart.setText(depart);
				String address = (String)model.getValueAt(table.getSelectedRow(), 3); 
				tfAddress.setText(address);
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}	
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
		});
		
		
		c.add(new JScrollPane(table)); //스크롤바 구현


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
					stmt.executeUpdate("insert into student values('"+tfId.getText()+"',"
							+ "										 '"+tfName.getText()+"',"
									+ "								 '"+tfDepart.getText()+"',"
											+ "						 '"+tfAddress.getText()+"')");
					System.out.println("insert완료");
					//stmt.execute("update student set name='홍길돈' where id= 'K202002'");
					//stmt.execute("delete from student where id='K202001'");
					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					//목록 초기화
					model.setRowCount(0); //model의 행의 수 0으로 설정

				
						
					while(rs.next()) {
						String[] row = new String[4];
						row[0] = rs.getString("id");
						row[1] = rs.getString("name");
						row[2] = rs.getString("depart");
						row[3] = rs.getString("address");
						model.addRow(row);

					
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
				
					

					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					
					model.setRowCount(0); //model의 행의 수 0으로 설정

					
					
					while(rs.next()) {
						String[] row = new String[4];
						row[0] = rs.getString("id");
						row[1] = rs.getString("name");
						row[2] = rs.getString("depart");
						row[3] = rs.getString("address");
						model.addRow(row);
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

					stmt.execute("update student set name='"+tfName.getText()+"', depart='"+tfDepart.getText()+"', address='"+tfAddress.getText()+ "'where id= '"+tfId.getText()+"'");
					System.out.println("update완료");

					//select
					ResultSet rs = stmt.executeQuery("select * from student");
					//목록 초기화
					

				
					model.setRowCount(0); //model의 행의 수 0으로 설정

					
					
					while(rs.next()) {
						String[] row = new String[4];
						row[0] = rs.getString("id");
						row[1] = rs.getString("name");
						row[2] = rs.getString("depart");
						row[3] = rs.getString("address");
						model.addRow(row);
					
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
				
				//자바스크립트 alert 기능
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				
				if(result==JOptionPane.YES_OPTION) {
					
					
					
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
						
						model.setRowCount(0); //model의 행의 수 0으로 설정
						
						
						
						while(rs.next()) {
							String[] row = new String[3];
							row[0] = rs.getString("id");
							row[1] = rs.getString("name");
							row[2] = rs.getString("depart");
							row[3] = rs.getString("address");
							model.addRow(row);
							
						}
						
						rs.close();
						stmt.close();
						conn.close();
					} catch (Exception E) {
						E.printStackTrace();
					}
				}

			}
		});
		c.add(btnDelete);





		this.setSize(300, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Haksa2();
	}
}

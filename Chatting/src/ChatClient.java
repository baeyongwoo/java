import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	JLabel lblID = null;
	JTextField tfID = null;
	JLabel lblWamming = null;
	String id = null;
	JButton btnLogin = null;
	
	
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLayout(new FlowLayout());
		lblID = new JLabel("ID");
		this.add(lblID);
		tfID=new JTextField(10);
		this.add(tfID);
		lblWamming = new JLabel("닉네임을 입력해주세요");
		
		btnLogin = new JButton("접속");
		this.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfID.getText().equals("")) {
					System.out.println("id가 널일경우");
					JOptionPane.showMessageDialog(null, "Id를 입력해주세요");
					
				}else {
					id = tfID.getText();
					setVisible(false);
				}
 
				
			}
		});
		this.setSize(170, 140);
		
		
	}
}


public class ChatClient extends JFrame implements ActionListener{
	private BufferedReader in=null;
	private BufferedWriter out=null;	
	private Socket socket=null;
	private Receiver receiver=null;
	private JTextField sender=null;
	
	public String inputId = null;
	
	JPanel panel = null;
	MyDialog dialog = null;
	
	
	
	
	
	public ChatClient() {
//		this.panel = new JPanel();
//		//this.panel.setBackground(Color.LIGHT_GRAY);
//		this.add(panel);
		
		this.setSize(300, 500);
		this.setVisible(true);
		
//		//로그인 dialog 띄우기
		dialog = new MyDialog(this, "로그인");
		dialog.setModal(true); // modal dialog로 설정
		dialog.setVisible(true); 
		
		
		
	
		
		
		
//		panel.setLayout(null);
		setTitle("클라이언트 채팅 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setLayout(new BorderLayout());
		this.receiver=new Receiver();
		this.receiver.setEditable(false);
		this.sender=new JTextField();
		this.sender.addActionListener(this);
		c.add(new JScrollPane(receiver),BorderLayout.CENTER);
		c.add(sender,BorderLayout.SOUTH);
		
		setSize(400,200);
		setVisible(true);
		
		try {
			setupConnection(); //Connection
		}catch(IOException e) {
			handleError(e.getMessage());
		}
		//Thread Start
		Thread th=new Thread(receiver);
		th.start();
	}
	//Connection
	private void setupConnection() throws IOException{
		
//		socket=new Socket("192.168.0.33",9999);
		socket=new Socket("localhost",9999);
		receiver.append("서버에 연결 완료");
		int pos=receiver.getText().length();
		receiver.setCaretPosition(pos);
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	
	}
	
	// error message. app exit
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	//inner class
	private class Receiver extends JTextArea implements Runnable{

		@Override
		public void run() {
			String msg=null;
			while(true) {
				try {
					msg=in.readLine();
				}catch(IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n 서버 : "+msg);
				int pos=this.getText().length();
				this.setCaretPosition(pos);
			}			
		}		
	}

	public static void main(String[] args) {
		new ChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if(e.getSource()==sender) {
			String msg=sender.getText();
			try {
				out.write(msg+"\n");
				out.flush();
				
				receiver.append("\n'"+dialog.id+"' : "+msg);
				int pos=receiver.getText().length();
				receiver.setCaretPosition(pos);
				sender.setText(null);
			}catch(IOException e1) {
				handleError(e1.getMessage());
			}
		}		
	}
}

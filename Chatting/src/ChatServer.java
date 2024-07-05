import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener{
	private BufferedReader in=null;
	private BufferedWriter out=null;
	private ServerSocket listener=null;
	private Socket socket=null;
	private Receiver receiver=null;
	private JTextField sender=null;
	
	public ChatServer() {
		this.setTitle("서버 채팅 창");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setLayout(new BorderLayout()); //center와 south만 설정된것??
		receiver=new Receiver();
		receiver.setEditable(false);
		
		sender=new JTextField();
		sender.addActionListener(this);
		
		add(new JScrollPane(receiver),BorderLayout.CENTER);
		add(sender,BorderLayout.SOUTH);
		
		this.setSize(400,200);
		this.setVisible(true);
		
		try {
			setupConnection();
		}catch(IOException e) {
			handleError(e.getMessage());
		}
		
		//Thread 생성
		Thread th=new Thread(receiver);
		th.start();
		
		
	}
	// Connection
	private void setupConnection() throws IOException{
		listener=new ServerSocket(9999);
		socket=listener.accept();
		receiver.append("클라이언트로 부터 연결 완료");
		int pos=receiver.getText().length();
		receiver.setCaretPosition(pos);//마지막 위치로 자동 스크롤
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	
	// Error Message출력. 앱종료
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
				}catch(Exception e) {
					handleError(e.getMessage());
				}
				this.append("\n클라이언트 : "+msg);
				int pos=this.getText().length();
				this.setCaretPosition(pos);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new ChatServer();

	}

	@Override
	public void actionPerformed(ActionEvent e) { //enter키 입력하면 전송
		if(e.getSource()==sender) {
			String msg=sender.getText();
			try {
				out.write(msg+"\n");
				out.flush();
				
				receiver.append("\n서버 : "+msg);
				int pos=receiver.getText().length();
				receiver.setCaretPosition(pos);
				sender.setText(null); // 입력창 초기화
			}catch(IOException e1) {
				handleError(e1.getMessage());
			}
		}
		
	}

}



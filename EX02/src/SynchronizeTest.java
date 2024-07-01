class SharedBoard{
	private int sum=0;
	//동기화. 어떤 쓰레드가 add()를 실행하고 있을 때 다른 쓰레드는 
	synchronized public void add(){
		int n=sum;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Thread.yield();//쓰레드 양보
		n+=10;
		sum=n;
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
}
class StudentThread extends Thread{
	private SharedBoard board;
	public StudentThread(String name, SharedBoard board) {
		super(name); // 쓰레드이름설정
		this.board=board;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			board.add();
		}
	}	
}


public class SynchronizeTest {
	public static void main(String[] args) {
		SharedBoard board=new SharedBoard();
		StudentThread th1=new StudentThread("기태",board);
		StudentThread th2=new StudentThread("효수",board);
		th1.start();
		th2.start();
	}
}


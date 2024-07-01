
public class ThreadTest extends Thread{
	int seq;
	public ThreadTest(int seq) {
		this.seq = seq;
	}
	
	@Override 
	public void run() {
		System.out.println(this.seq + " thread start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(this.seq + "thread end");
	}
	
	public static void main(String[] args) {
		//쓰레드 10개 생성 + main thread ==> 11개
		for(int i =0; i<10; i++) {
			Thread t = new ThreadTest(i);
			t.start(); //jvm의 thread   scheduler에 등록
			
		}
		System.out.println("main endw");
	}
}
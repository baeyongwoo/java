import java.util.Arrays;

class CircularQueue {
    
    int rear = 0;            
    int front = 0;            
    int maxSize = 0;        
    int[] circularQueue;         
    
    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueue = new int[this.maxSize];
    }
    
    public boolean isEmpty() {
        if(rear == front) {
            return true;
        }
        return false;
    }
    public boolean isFull() {
        if((rear+1)%maxSize == front) {
            return true;
        }
        return false;
    }
    
    public void enQueue(int num) {
        if(isFull()) {
            System.out.println("큐가 가득 찼습니다");
        }
        else {
            rear = (rear+1) % maxSize;
            circularQueue[rear]=num;
        }
    }
    
    public int deQueue() {
          if(isEmpty()) {
              return -1;
          }
          else {
              front = (front+1)%maxSize;
              return circularQueue[front];
          }
      }
}



public class CircualrQueTest {
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(5);
		cq.enQueue(1);
		cq.enQueue(2);
		cq.enQueue(3);
		cq.enQueue(4);
		cq.enQueue(5);
		System.out.println(Arrays.toString(cq.circularQueue));
		
		 
		
	}

}

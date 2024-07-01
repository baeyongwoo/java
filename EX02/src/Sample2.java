class Updator{
	void updator(Count count) {
		count.count++;
	}
}

class Count{
	int count = 0;
}


public class Sample2 {

	
	
	public static void main(String[] args) {
	
		
		Updator upda = new Updator();
		Count count = new Count();
		System.out.println("before : " + count.count);
		upda.updator(count);
		upda.updator(count);
		upda.updator(count);
		
		System.out.println("after : " + count.count);
		
		
	}
}

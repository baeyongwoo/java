class Anima2{
	String name;
	void setName(String name) {
		this.name = name;
	}
}

class Dog extends Anima2{
	void sleep() {
		System.out.println(this.name + "(이)가 zzz");
	}
	
}

class HouseDog extends Dog{
	
	 HouseDog() {
	
	}
	
	HouseDog(String name){
		this.setName(name);
	}
	
	HouseDog(int type){
		if(type==1) {
			this.setName("yorkshire");
		}else if(type==2) {
			this.setName("bulldog");
		}
	}
	
	
	@Override
	void sleep() {
		
		System.out.println(this.name + "(이)가 zzz In House");
	}
	void sleep(int hour) {
		System.out.println(this.name + " (이)가" + hour + "시간 동안 zzzz");
	}
	
}





public class Sample4 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("찰롱");
		dog.sleep();
		
		Anima2 cat = new Dog();
		
		HouseDog hd = new HouseDog(1);
		HouseDog hd2 = new HouseDog();
		HouseDog hd3 = new HouseDog("happy");
		hd2.setName("hd");
		hd2.sleep();
		hd2.sleep(3);
		
		System.out.println(hd.name);
		System.out.println(hd2.name);
		System.out.println(hd3.name);
	}
}

class Animal{
	String name;
	public void setName(String name) {
		this.name = name;
	}
}

class Sample{
	void sayNick(String nick) {
		if("바보".equals(nick)) {
			return;
		}
		System.out.println(nick + "출력");
	}
}



public class Ex02 {

	public static void main(String[] args) {
		Calculator cal =  new Calculator(); //Calcuator클래스로 instatnce 생성
		
		System.out.println(cal.add(120));
		System.out.println(cal.add(120));
		
		
		//Animal 클래스로 instance 생성
		Animal cat = new Animal();

		Animal dori = new Animal();
		
		cat.setName("고양이");
		dori.setName("dori");
		
		System.out.println(cat.name + ", " + dori.name);
		
		//sample 클래스로 instance 생성 (sample)
		Sample sample = new Sample();
		
		sample.sayNick("바보");

		

		
	
	}
}

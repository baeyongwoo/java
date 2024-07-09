
public class Shape {
	public String name;
	public Shape next=null; //다음 객체를 가리키는 reference
	public void draw() {
		System.out.println(this.name);
	}
	
}

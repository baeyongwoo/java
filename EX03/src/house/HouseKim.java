package house;

public class HouseKim {
	public String name;
	private String address;
	protected String subject; 
	String id;
	public HouseKim(){}
	
	public HouseKim(String address) {
		this.address = address; // private address는 class 내부에서만 접근 가능
	}
	
	String getAdddress() {
		return this.address;
	}
}


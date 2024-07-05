// 0628
// 자바 총 복습


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.naver.service.Person;
import com.naver.service.Person2;
import com.naver.service.Student;
import com.naver.service.Student2;
public class JavaEssential {

	public static void main(String[] args) {
		// instance 생성 (Person 클래스는 설계도일 뿐이라서 사용하려면 new 해서 객체를 만들어 줘야 함.)
		Person p = new Person(); // import 해주기
		p.name="홍길동";
		p.sleep(); // Person 클래스에서 sleep() 메서드 호출되면서 "잠을 잡니다." 출력
		System.out.println(p.name); // "홍길동" 출력(JavaEssential 클래스의 main 메서드에서 초기화함.)
		
		
		// instance 생성
		Person2 p2 = new Person2();
		p2.setName("이순신");
		p2.sleep();
		System.out.println(p2.getName()); // Person2의 이름을 리턴해주는 getName()이 "이순신" 리턴
		
		
		Person p3 = new Person("을지문덕"); // 오버로딩한 생성자 사용해서 name 필드 초기화
		System.out.println(p3.name);
		
		// instance 생성
		Student s = new Student();
		s.name="왕건";
		s.department="학과";
		s.sleep(); // Student 클래스에서 Person을 상속 받아 오버라이드를 했기 때문에 "하루에 4시간 잡니다." 출력
		
		
		// 학생 추가
		Student s2 = new Student("강감찬", "컴퓨터공학"); // 오버로딩한 생성자 사용해서 name 필드 초기화
		System.out.println(s2.name);
		System.out.println(s2.department); // null 출력?
		
		
		Student2 s3 = new Student2();
		s3.name="신사임당";
		s3.department="심리학과";
		System.out.println(s3.name);
		System.out.println(s3.department);
		
		
		// ArrayList
		// ArrayList에 클래스 사용하기(가독성이 좋아지고 메서드도 사용할 수 있음)
		// add, get
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student()); // 새로운 Student를 만들어서 그 레퍼런스를 list에 넣음. // new Student() 대신 s2 넣어도 레퍼런스 변수(클래스의 이름은 레퍼런스 변수이다)라서 똑같음
		list.add(new Student());
//		list.get(0).name="이율곡"; // ArrayList list의 0번째 Student
//		list.get(0).department="국문학과";
		
		// 가독성 좋게
		Student s4 = list.get(0);
		s4.name="이율곡";
		s4.department="국문학과";
		
		
		// HashMap
		// HashMap에 클래스 사용하기
		// Map<key 타입, vlaue 타입>
		// put, get
		Map<String,Student2> map = new HashMap<>(); // 업캐스팅(HashMap이 Map의 자식) // 뒷부분 <> 타입추론
		map.put("천재", new Student2());
		map.put("영재", new Student2());
		map.get("천재").name="김천재";
		map.get("천재").department="수학과";
		
		// Map에 ArrayList<Student2>를 넣을 수 있음
		Map<String, ArrayList<Student2>> map2 = new HashMap<>(); // 업캐스팅
		// key : 학년
		// value : 학생 목록(배열)
		
		// ArrayList에 Map을 넣을 수 있음
		ArrayList<Map<String,Student2>> list2 = new ArrayList<>(); // 뒷부분 <> 타입추론
		// key : 학년
		// value : 학생
		
		
	}

}

import java.util.Arrays;
import java.util.stream.IntStream;

class Student{

	String name;
	String [] subject;

	void setSubjects(String[] subject) {
		this.subject = subject;
	}


}



public class ReferenceTest {
	public static void main(String[] args) {
		Student std1 = new Student();
		Student std2 = new Student();

		std1.name = "홍길동";
		System.out.println(std1.name);
		std2.name = "도리도리";
		System.out.println(std2.name);

		Student gamja;
		gamja = std1;

		System.out.println(gamja.name);

		int [] arr = {1,2,3};
		int [] arr2;
		arr2 = arr;



		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		Arrays.stream(arr).forEach(i -> System.out.print(i));

		String[] subjects = {"컴퓨터공학", "철학"};

		std1.setSubjects(subjects);

		System.out.println( std1.name+ " 님의 수강신청 과목은 : " + Arrays.toString(std1.subject));



	}
}
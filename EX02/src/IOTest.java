import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in; //표준 입력. 키보드로 입력받음
		InputStreamReader reader = new InputStreamReader(in); //encoding위해 필요
		BufferedReader br = new BufferedReader(reader); // buffer 사용
		
		System.out.print("입력하세요 >");
		String a = br.readLine(); //한줄을 입력해서 문자열 변수에 저장
		System.out.println(a);
		
		
		
	}
}

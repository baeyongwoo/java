package examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStudy2 {
		public static void main(String[] args) {
			ArrayList<Map<String, Object>> student = new ArrayList<>();
			Map<String, Object> studentInfo = new HashMap<String, Object>();
			studentInfo.put("이름", "홍길동");
			studentInfo.put("나이", 20);
			studentInfo.put("이", "홍길동");
			studentInfo.put("이", 20);
			studentInfo.put("름", "홍길동");
			studentInfo.put("나", 20);
			studentInfo.put("이름", "홍길동");
			studentInfo.put("나이", 20);
			
			student.add(studentInfo);
		
		}
}

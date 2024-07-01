import java.util.ArrayList;
import java.util.Arrays;import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

public class EX01 {

	public static void main(String[] args) {
		Integer a = Integer.valueOf(10);
		int b = 5;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		
		String s1 = "Hello Java";
		s1.replaceAll("Hello Java", "World"); //원본이 안바뀐다.
		System.out.println(s1);
		
		StringBuffer sb = new StringBuffer("Hello Java");
		
		sb.replace(0,5 ,"World");
		System.out.println(sb);
		
		
		int [] odds = {1,3,5,7,9};
		
		Arrays.stream(odds).boxed().forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		
		//타입 추론. compiler가 String일 것이라고 추측해서 처리해줨
		ArrayList<String> pictches = new ArrayList<>(Arrays.asList("138", "129", "142"));
		String result2 = String.join(",", pictches);  // csv생성
		System.out.println(result2);
		
		pictches.sort(Comparator.naturalOrder()); // 오름차순
		System.out.println(pictches);
		pictches.sort(Comparator.reverseOrder()); // 내림차순
		System.out.println(pictches);
		
		
		pictches.stream().sorted(Comparator.naturalOrder());
		
		pictches.forEach(System.out::print);
		
		
		
		System.out.println("========================================");
		
		Map<String, String> map = new HashMap<>();
		
		map.putAll(Map.of(
		    "people", "사람",
		    "baseball", "야구",
		    "game", "게임",
		    "school", "학교",
		    "study", "공부"
		));
		
		System.out.println(map.get("people"));
		
		System.out.println(map.containsKey("people"));
		System.out.println(map.containsKey("peoples"));
		
		System.out.println(map.remove("game")); //삭제 후 삭제값 리턴
		System.out.println(map.size());
		
		System.out.println(map.keySet());
		
		for(String key : map.keySet()) {System.out.println(key);}
		map.keySet().forEach(key -> System.out.println(key));
		
		
		HashSet<String> set = new HashSet<String>(Arrays.asList("H", "e", "l", "l", "o"));	
		System.out.println(set);
		
		
		HashSet<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7));	
		HashSet<Integer> set2 = new HashSet<Integer>(Arrays.asList(4,5,6,7,8,9));	
		
//		set1.retainAll(set2);
//		
//		System.out.println(set1);
		
		HashSet<Integer> union = new HashSet<Integer>(set1);
		union.addAll(set2);
		System.out.println(union);
		
		enum CoffeType{
			AMERICANO,
			ICE_AMERICANO,
			CAFE_LATTE
		}
		
		
		for (CoffeType type : CoffeType.values()) {
			System.out.println(type);
			
		}
		
		Arrays.stream(CoffeType.values()).forEach(System.out::println);
		
		
		String num = "123";
		
		int n = Integer.parseInt(num);
		
		
		
		for(int i = 1; i <= 10; i++) {
			System.out.print(i);
			
		}
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		
		String[] members = {"one", "two", "three"};
		for(String m : members) {
			System.out.println(m);
		}
		
		Arrays.stream(members).forEach(System.out::println);
		
		ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList(members));
		for(String s2 : numbers2) {
			System.out.println(s2);
		}
		
		numbers2.forEach(System.out::println);
		
	}//main
	
}//class


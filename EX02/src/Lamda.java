import java.util.Arrays;

public class Lamda {
	public static void main(String[] args) {
		
		int [] data = {1,2,3,4,5,6,7,8,9,10};
		String [] data2 = {"test", "sss"};
//		int [] result = new int[10];
//		for(int i = 0; i<data.length;i++) {
//			result[i] = data[i]*2;
//		}
//		int [] result =Arrays.stream(data).map((a->a*2)).toArray();
//		
	
		
		
		
		int[] result = Arrays.stream(data).filter((a)->a%2==0).toArray();
		
		for(int a : result) {
			System.out.println(a);
		}
//		
//		Arrays.stream(data).map((a)->{
//			System.out.println(a*2);
//			return a*2;
//		}).toArray();
//		
		
		
	}
}

import java.util.Arrays;

public class BubbleSortTest {
	
	public static void bubbleSort(int[] a) {
		bubble_sort(a, a.length);
		
	}
	
	private static void bubble_sort(int[] a, int size) {
		
		for(int i = 1; i < size; i++) {
			for(int j = 0; j < size - 1; j ++) {
				if(a[j] > a[j+1]) {
					swap(a, j, j+1);
				}
			}
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	
	public static void main(String[] args) {
		int [] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			int ran = (int) (Math.random()*100);
			arr[i] = ran;
		}
		
		System.out.println("sort 전 data" + Arrays.toString(arr));
		
		bubbleSort(arr);
		
		System.out.println("sort 후 data " + Arrays.toString(arr));
	}
}

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSortTest {

	public static void selectionSort(int[] a) {
		selectionSort(a, a.length);
		}
	
	private static void selectionSort(int[] a, int size) {
		for(int i=0; i < size -1; i++) {
			int minIndex = i;
			
			for(int j = i+1; j<size ; j++) {
				if(a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			
			
			swap(a, minIndex, i);
			System.out.println(i + "번째 sort : " + Arrays.toString(a));
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
		
		selectionSort(arr);
		
		System.out.println("sort 후 data " + Arrays.toString(arr));
		
		
	}
	
	}

package examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Multiple{

	List<Integer> MutilpleFunction(int startNum, int endNum, int step) {
		List<Integer> numList = new ArrayList<Integer>();
		// startNum부터 endNum까지 step 배수
		if(endNum > startNum) {
			for(int i = startNum; i <endNum - startNum; i++) {
				if(i%step==0) {
					numList.add(i);
				}
				continue;
			}

		}
		else {
			System.err.println("처음 숫자값이 더 클 수 없습니다");
			throw new RuntimeException();
			
		}

		return numList;
	}
}

class MakeErrorLog{

	File newDir = new File("C:\\log");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	String path = newDir.getPath()+"\\";
	Date now = new Date();
	String data = sdf.format(now).concat(".log");
	String error = null;

	void fileMake(String OuterError) {
		try {
			if(newDir.mkdir()) {
				System.out.println(newDir.getPath()+ "폴더 생성");
				
			}
			
			
			FileOutputStream output = new FileOutputStream(path.concat(data), true);
			
			output.write(OuterError.getBytes());

			output.close();
			
		} catch (Exception e) {	
			System.out.println("내부에러");
			e.getStackTrace();
		}
	}



}

public class Example0708 {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("처음값을 입력하세요 : " );
			int startNum = scan.nextInt();
			System.out.print("끝값을 입력하세요 : ");
			int endNum = scan.nextInt();
			System.out.print("몇의 배수를 구하시겠습니까? : ");
			int step = scan.nextInt();
			Multiple mul = new Multiple();

			List<Integer> mulValue =  mul.MutilpleFunction(startNum, endNum, step);
			System.out.println("배수의 값 : " + mulValue);

		} catch (Exception e) {
			MakeErrorLog mel = new MakeErrorLog();
			
			System.out.println("main함수에서 error " + e.toString());
			mel.fileMake(e.toString());
		
		}
		

	}
}

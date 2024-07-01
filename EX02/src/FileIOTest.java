import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream output = new FileOutputStream("c:/temp/out.txt", true);
		for(int i=0; i<11; i++) {
			String data = i+"번째 줄입니다/r\n";
			output.write(data.getBytes());
		}
		output.close();
		
//		FileWriter fw = new FileWriter("c:/temp/out.txt");
//		for(int i = 1; i < 11; i++) {
//			String data = i + "번";
//			fw.write(data);
//		}
//		fw.close();
		
		BufferedReader br = new BufferedReader(new FileReader("c:/temp/out.txt"));
		
		while(true) {
			String line = br.readLine();
			
			if(line == null) 
				break;
			
			System.out.println(line);
		}
		
	}
}

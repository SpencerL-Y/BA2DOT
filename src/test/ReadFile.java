package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] leargs) throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader reader = new FileReader("/home/clexma/Desktop/GUI/BA2DOT/readfiles/test.ba");
		BufferedReader br = new BufferedReader(reader);
		
		String str = null;
		while((str = br.readLine()) != null) {
			sb.append(str+"/n");
			
			System.out.println(str);
		}
		br.close();
		reader.close();
		
	}
}
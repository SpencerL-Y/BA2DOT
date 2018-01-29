package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) throws IOException {
		File f = new File("./writefiles/testResult.txt");
		FileWriter fw;
		fw = new FileWriter(f);
		String teststr = "input the file";
		fw.write(teststr);
		fw.close();
		
		
	}

}

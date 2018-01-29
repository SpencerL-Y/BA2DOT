package test;

import java.io.IOException;

import main.Converter;

public class FinalTest {

	public static void main(String[] args) throws IOException {
		Converter.BA2DOT("./readfiles/test.ba", "./writefiles/testResult");
	}

}

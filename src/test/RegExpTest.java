package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {
	public static void main(String[] args) {
		Boolean accFlag = false;
		String input = "[43]  ";
		if(input.indexOf(",")!= -1) {
			System.out.println("This is a transition");
			String trans[] = input.split(",");
			trans[0] = trans[0].trim();
			String line = trans[1];
			
			String[] temp = line.split("->");
			temp[0] = temp[0].trim();
			String[] tempFrom =  temp[0].split("\\[");
			tempFrom[0] = tempFrom[1].split("\\]")[0];
			temp[1] = temp[1].trim();
			String[] tempTo = temp[1].split("\\[");
			tempTo[0] = tempTo[1].split("\\]")[0];
			
			Integer from = Integer.parseInt(tempFrom[0]);
			Integer to = Integer.parseInt(tempTo[0]);
			System.out.println(from);
			System.out.println(to);
			
		} else if(input.indexOf("[") != -1){
			if(accFlag) {
				System.out.println("This is acc state");
				input = input.trim();
				String acc = input.split("\\[")[1].split("\\]")[0];
				Integer accNum = Integer.parseInt(acc);
				System.out.println(accNum);
			} else {
				System.out.println("This is init state");
				input = input.trim();
				String init = input.split("\\[")[1].split("\\]")[0];
				Integer initNum = Integer.parseInt(init);
				System.out.println(initNum);
			}
		} else {
			System.out.println("Input error");
		}
		
		
		Integer a = 0;
		
		String[] letter = new String[1];
		System.out.println(test(a, letter)[0] + test(a, letter)[1]);
		System.out.println(letter[0]);
	}
	
	
	public static Integer[] test(Integer a, String[] letter) {
		Integer result[] = new Integer[2];
		result[0] = a;
		result[1] = 12;
		letter[0] = "a";
		return result;
	}
}

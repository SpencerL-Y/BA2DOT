package test;

import java.util.ArrayList;

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
		
		
		
	
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.remove(0);
		System.out.println(a.get(0));
	}
	
	
	public static Integer[] test(Integer a, String[] letter) {
		Integer result[] = new Integer[2];
		result[0] = a;
		result[1] = 12;
		letter[0] = "a";
		return result;
	}
}

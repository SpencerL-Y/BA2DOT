package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParserBA {
	private String currentLine;
	private FileReader reader;
	private BufferedReader br;
	
	public ParserBA(String filename) throws IOException {
		this.currentLine = null;
		this.reader = new FileReader(filename);
		this.br = new BufferedReader(reader);
		
	}
	
	
	public MidComponent convertToMid(String filename) throws IOException {
		MidComponent mid = new MidComponent();
		this.reader = new FileReader(filename);
		this.br = new BufferedReader(this.reader);
		Boolean accFlag = false;
		while((this.currentLine = br.readLine()) != null) {
			if(this.currentLine.indexOf(",") != -1) {
				String[] letter = new String[1];
				Integer[] pair = new Integer[2];
				pair = this.transParser(this.currentLine, letter);
				mid.addTransition(pair[0], pair[1], letter[0]);
			} else if(this.currentLine.indexOf("[") != -1 && 
					  this.currentLine.indexOf("]") != -1) {
				if(accFlag) {
					Integer accNum = this.accParser(this.currentLine);
					mid.addAcc(accNum);
				} else {
					Integer initNum = this.initParser(this.currentLine);
					mid.addInit(initNum);
				}
			} else {
				System.out.println("Input Error! Please check your grammar");
			}
			accFlag = true;
		}
		
		return mid;
	}
	
	private Integer initParser(String input) {
		//System.out.println("This is initial state");
		input = input.trim();
		String init = input.split("\\[")[1].split("\\]")[0];
		Integer initNum = Integer.parseInt(init);
		return initNum;
		
	}
	
	private Integer[] transParser(String input, String[] letter) {
		//System.out.println("This is a transition");
		String trans[] = input.split(",");
		trans[0] = trans[0].trim();
		letter[0] = trans[0];
		//System.out.println(trans[0]);
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
		Integer result[] = new Integer[2];
		result[0] = from;
		result[1] = to;
		
		
		//System.out.println(from);
		//System.out.println(to);
		return result;
	}
	
	private Integer accParser(String input) {
		//System.out.println("This is acc state");
		input = input.trim();
		String acc = input.split("\\[")[1].split("\\]")[0];
		//System.out.println(Integer.parseInt(acc));
		return Integer.parseInt(acc);
	}
	
	
}

package main;

public class Transition {
	private int from;
	private int to;
	private String letter;
	
	public Transition(int f, int t, String l) {
		this.from = f;
		this.to = t;
		this.letter = l;
	}
	
	public int getFrom() {
		return this.from;
	}
	
	public int getTo() {
		return this.to;
	}
	
	public String getLetter() {
		return this.letter;
	}
	
}

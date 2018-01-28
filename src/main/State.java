package main;

public class State {
	private int stateNum;
	private Boolean isInit;
	private Boolean isAcc;
	public State(int num, Boolean init, Boolean acc) {
		this.stateNum = num;
		this.isInit = init;
		this.isAcc = acc;
	}
	
	public Boolean getInit() {
		return this.isInit;
	}
	
	public int getId() {
		return this.stateNum;
	}
	
	public Boolean getAcc() {
		return this.isAcc;
	}
}

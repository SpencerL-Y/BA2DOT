package main;

import java.util.ArrayList;

public class MidComponent {
	public ArrayList<Transition> transitions;
	public State initState;
	public ArrayList<State> hiddenStates;
	public ArrayList<State> accStates;
	
	public MidComponent() {
		this.transitions = new ArrayList<Transition>();
		this.accStates = new ArrayList<State>();
		this.hiddenStates = new ArrayList<State>();
		this.initState = null;
	}
	
	public void setInit(int num) {
		this.initState = new State(num, true, false);
	}
	
	public State getInit() {
		return this.initState;
	}
	
	public void addAcc(int num) {
		if(!this.checkStateExist(num, this.accStates)) {
			this.checkAndDelState(num, this.hiddenStates);
			State s = new State(num, false, true);
			this.accStates.add(s);
		}
	}
	
	public void addHidden(int num) {
		if(!this.checkStateExist(num, this.hiddenStates)) {
			State s = new State(num, false, false);
			this.hiddenStates.add(s);
		} else {
			System.out.println("Warning: State " + num + " already exists");
		}
	}
	
	public void addInit(int num) {
		if(this.initState == null) {
			this.initState = new State(num, true, false);
		} else {
			System.out.println("Error: Initial state already exists");
		}
	}
	
	public void addTransition(int from, int to, String letter) {
		if(!checkTransExist(from, to, letter, this.transitions)) {
			Transition trans = new Transition(from, to, letter);
			this.transitions.add(trans);
		} else {
			System.out.println("Warning: Transition " +from +" "+ letter + " " + to + " already exists");
		}
	}
	
	
	
	private Boolean checkStateExist(int num, ArrayList<State> list) {
		for(State s : list) {
			if(s.getId() == num) {
				return true;
			} 
		}
		return false;
	}
	
	private Boolean checkTransExist(int from, int to, String letter, 
								    ArrayList<Transition> list) {
		for(Transition t : list) {
			if(t.getFrom() == from && t.getTo() == to && t.getLetter().equals(letter)) {
				return true;
			}
		}
		return false;
		
	}
	
	private void checkAndDelState(int num, ArrayList<State> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == num) {
				list.remove(i);
				return;
			}
		}
	}
	
	
}

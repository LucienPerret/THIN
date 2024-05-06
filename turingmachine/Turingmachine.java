package turingmachine;

import java.util.HashMap;

public class Turingmachine {
	private Head head;
	private Tape tape;	
	private HashMap stateTransitions;
	
	public Turingmachine(){
		head = new Head();
		tape = new Tape();
	}
	

}

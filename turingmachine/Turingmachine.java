package turingmachine;

import java.util.HashMap;

public class Turingmachine {
	private Head head;
	private Tape tape;
	private HashMap<State, State> stateTransitions;

	public Turingmachine() {
		head = new Head();
		tape = new Tape();
	}

	public void parseGoedelNumber(String input) {
		String binaryInput;
		String tapeInput;
		if (input.matches("01+")) {
			binaryInput = input;
		} else {
			binaryInput = Integer.toBinaryString(Integer.valueOf(input));
		}
		while (binaryInput.charAt(0) != 0) {
			binaryInput = binaryInput.substring(1, binaryInput.length() - 1);
			break;
		}
		parseMachineCode(binaryInput.split("111", 2)[0]);
		tapeInput = binaryInput.split("111", 2)[1];

		for (int i = 0; i < tapeInput.length(); i++) {
			tape.writeTape(i, tapeInput.charAt(i));
		}

	}
	private void parseMachineCode(String input){
		String[] stateTransitions = input.split("11");
		for(String strings: stateTransitions){

		}
	}

}

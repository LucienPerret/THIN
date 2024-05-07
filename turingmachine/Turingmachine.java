package turingmachine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Turingmachine {
	private Head head;
	private Tape tape;
	private HashMap<State, State> stateTransitions;
	private char[] characterTable = { '0', '1', '_', 'a', 'b', 'c', 'd' };
	private char[] directionTable = { 'l', 'r' };
	private State currentState;
	private boolean finished = false;
	private boolean isAccepted = false;
	private int mode;
	private int delay = 2;
	private int step = 0;

	public Turingmachine(String input, int mode) throws InterruptedException {
		head = new Head();
		tape = new Tape();
		stateTransitions = new HashMap<>();
		currentState = new State("q1");
		parseGoedelNumber(input);
		this.mode = mode;
		runMachine();
	}

	public void parseGoedelNumber(String input) {
		String binaryInput;
		String tapeInput;
		if (input.matches("^[01]+$")) {
			binaryInput = input;
		} else {

			BigInteger bigNumber = new BigInteger(input);
			binaryInput = bigNumber.toString(2);

		}
		while (binaryInput.charAt(0) != '0') {
			binaryInput = binaryInput.substring(1);
		}
		parseMachineCode(binaryInput.split("111", 2)[0]);
		tapeInput = binaryInput.split("111", 2)[1];

		for (int i = 0; i < tapeInput.length(); i++) {
			tape.writeTape(i, tapeInput.charAt(i));
		}

	}

	private void parseMachineCode(String input) {
		String[] transitionString = input.split("11");
		for (String string : transitionString) {
			String[] transition = string.split("1");
			stateTransitions.put(new State("q" + transition[0].chars().filter(ch -> ch == '0').count(),
					characterTable[Long.valueOf(transition[1].chars().filter(ch -> ch == '0').count() - 1).intValue()]),
					new State("q" + transition[2].chars().filter(ch -> ch == '0').count(),
							characterTable[Long.valueOf(transition[3].chars().filter(ch -> ch == '0').count() - 1)
									.intValue()],
							directionTable[Long.valueOf(transition[4].chars().filter(ch -> ch == '0').count() - 1)
									.intValue()]));
		}
	}

	private void runMachine() throws InterruptedException {
		while (!finished) {
			step++;
			if (mode == 1) {
				printTape();
				Thread.sleep(delay);
			}
			State nextState = null;
			char readCharacter = tape.readTape(head.getCurrentPosition());
			currentState.setCharacter(readCharacter);
			if (stateTransitions.get(currentState) == null) {
				if (currentState.isAccepted()) {
					finished = true;
					isAccepted = true;
				} else {
					finished = true;
					break;
				}
			} else {
				nextState = stateTransitions.get(currentState);
			}
			try {
				tape.writeTape(head.getCurrentPosition(), nextState.getCharacter());
			} catch (IndexOutOfBoundsException e) {
				head.moveHead('r');
				tape.writeTapeNegative(nextState.getCharacter());
			}
			head.moveHead(nextState.getDirection());
			currentState.setState(nextState.getState());
			System.out.print("\n");
		}
		String currentString = currentState.getState();
		if (currentString.equals("q2")) {
			System.out.println(
					"\nThe turingmachine has reached an accepting state after: " + Integer.toString(step) + " Steps");
		} else {
			System.out.println(
					"\nThe turingmachine has stopped in a non-valid state after: " + Integer.toString(step) + " Steps");
		}

	}

	private void printTape() {
		ArrayList<Character> tape = this.tape.getTape();
		int headPos = head.getCurrentPosition();
		boolean headPrinted = false;
		System.out.println("Step: " + Integer.toString(step));
		System.out.print("_______________");
		for (int i = 0; i < tape.size(); i++) {
			if (headPos < 0 && !headPrinted) {
				System.out.print(currentState.getState());
				System.out.print(Character.toString('_').repeat(0 - headPos));
				headPrinted = true;
			}

			if (i == headPos) {
				System.out.print(currentState.getState());
				System.out.print(Character.toString(tape.get(i)));
			} else {
				System.out.print(Character.toString(tape.get(i)));
			}
		}
		System.out.print("_______________");
	}
}

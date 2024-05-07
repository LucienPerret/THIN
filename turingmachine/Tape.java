package turingmachine;

import java.util.ArrayList;

public class Tape {
	private ArrayList<Character> tape;	

	public Tape(){
		tape = new ArrayList<>();
	}
	public char readTape(int position){
		char result;
		try {
			result = tape.get(position);
		} catch (IndexOutOfBoundsException e){
			result = '_';
		}
		return result;

	}
	public void writeTape(int position, char input){
		if(position >= 0){
			tape.add(position,input);
			if(tape.size() > position + 1){
				tape.remove(position + 1);
			}
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public void writeTapeNegative(char input){
		tape.addFirst(input);
	}
	public ArrayList<Character> getTape(){
		return tape;
	}
}

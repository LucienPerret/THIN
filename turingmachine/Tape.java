package turingmachine;

public class Tape {
	private char[] tape;	

	public Tape(){
	}
	public char readTape(int position){
		return tape[position];
	}
	public void writeTape(int position, char input){
		if(position > 0){
			tape[position] = input;
		} else {
			//TODO throw exception here
		}
		
	}
}

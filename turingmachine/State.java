package turingmachine;

public class State {

	private String state;
	private char character;
	private char direction;
	private boolean isAccepted;

	public State(String state){
		this.state = state;
	}

	public State(String state, char character) {
		this.state = state;
		this.character = character;
		isAccepted = false;
	}

	public State(String state, char character, char direction) {
		this.state = state;
		this.character = character;
		this.direction = direction;
		isAccepted = false;
	}
	public void setIsAccepted(){
		isAccepted = true;
	}
	public boolean isAccepted(){
		return isAccepted;
	}

	@Override
	public boolean equals(Object obj) {
		State compareState = (State) obj;
		boolean result = false;
		if (this.state == compareState.state && this.character == compareState.character
				&& this.direction == compareState.direction) {
			result = true;
		}
		return result;
	}

}

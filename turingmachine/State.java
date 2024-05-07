package turingmachine;

import java.util.Objects;

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
		if(state == "q2"){
			isAccepted = true;
		}
	}
	public boolean isAccepted(){
		return isAccepted;
	}
	public void setCharacter(char character){
		this.character = character;
	}
	public char getCharacter(){
		return character;
	}
	public char getDirection(){
		return direction;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return state;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		State state = (State) obj;
		return Objects.equals(this.state, state.state) &&
			   Objects.equals(this.character, state.character) &&
			   Objects.equals(this.direction, state.direction) &&
			   Objects.equals(this.isAccepted, state.isAccepted);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(state, character, direction, isAccepted);
	}

}

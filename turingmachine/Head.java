package turingmachine;

public class Head {
	private int currentPosition;
	public Head(){
		currentPosition = 0;
	}	
	public void moveHead(char direction){
		if(direction == 'R'){
			currentPosition++;
		} else {
			currentPosition --;
		}
	}
	public int getCurrentPosition(){
		return currentPosition;
	}
}

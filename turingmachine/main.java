package turingmachine;

import java.util.Scanner;

public class Main {
	Scanner scanner;
    String input;
    int mode;
    boolean printResult;
	Turingmachine turingmachine;

	public Main(){
		scanner = new Scanner(System.in);
		printResult = false;
	}
	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
		main.runIt();
	}	
	public void runIt() throws InterruptedException{
		determineMode();
		readInput();
		turingmachine = new Turingmachine(input, mode);
	}
	
	private void determineMode() {
        boolean inputCorrect = false;
        System.out.println("""
                            Choose mode.
                            1. Step-Mode
                            2. Run-Mode
                            """);
        while (!inputCorrect) {
            String input = scanner.nextLine();
            if (input.matches("\\d")) {
                mode = Integer.valueOf(input);
                inputCorrect = true;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private void readInput() {
        boolean inputCorrect = false;
        System.out.println("Please input a Goedel number or binary input");
        while (!inputCorrect) {
            String input = scanner.nextLine();
			if (input.matches("\\d+")) {
				this.input =  input;
				inputCorrect = true;
			} else {
				System.out.println("Invalid input");
			}
        }

    }

}

package turingmachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
	public static void main(String[] args) throws InterruptedException, IOException {
		Main main = new Main();
		main.runIt();
	}	
	public void runIt() throws InterruptedException, IOException{
		determineMode();
		determineInputMethod();
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
	private void determineInputMethod() throws IOException {
        boolean inputCorrect = false;
        System.out.println("""
                            Choose an input method.
                            1. String
                            2. File
                            """);
        while (!inputCorrect) {
            String input = scanner.nextLine();
            if (input.matches("1|2")) {
				if (input.equals("1")) {
					readInputString();	
				} else {
					readInputFile();
				}
                inputCorrect = true;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private void readInputString() {
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

	private void readInputFile() throws IOException{
		boolean inputCorrect = false;
		String filePath = "goedelnumber.txt";
		System.out.println("Please input the name of the file to read");
		while (!inputCorrect) {
			String input = scanner.nextLine();
			if (input.matches("\\w*\\.txt")) {
				filePath =  "turingmachine/" + input;
				inputCorrect = true;
			} else {
				System.out.println("Invalid input");
			}
		}
		input = Files.readString(Path.of(filePath));
	}

}

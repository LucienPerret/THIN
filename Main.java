import java.util.Scanner;

public class Main {
    Scanner scanner;
    Stack stack;
    char[] input;
    int mode;


    public Main() {
        scanner = new Scanner(System.in);
        stack = new Stack();
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.doThing();
    }

    private void doThing() throws InterruptedException  {
        determineMode();
        readInput();
        inputToStack(input);
        printResult();
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
        System.out.println("Please input a calculation in UPN");
        while (!inputCorrect) {
            String input = scanner.nextLine();
            if (input.matches("(\\d\\d(\\+|\\*))(\\d\\d(\\+|\\*)(\\+|\\*))*")) {
                this.input = input.toCharArray();
                inputCorrect = true;
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    private void inputToStack(char[] input) throws InterruptedException {
        for (char c : input) {
            if (c != '+' && c != '*') {
                stack.putOnStack(Character.getNumericValue(c));
                if (mode == 1) {
                    System.out.println("Current stack:\n" + stack.toString()); 
                    Thread.sleep(1000);
                }
            } else {
                stack.calculateStack(c);
                if (mode == 1) {
                    System.out.println("Current stack:\n" + stack.toString());
                    Thread.sleep(1000);
                }
            } 
        }
    }
    private void printResult(){
        System.out.println("The result is:\n" + stack.getResult());
    }

}

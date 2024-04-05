import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> stack;
    int result;
    Stack() {
        stack = new ArrayList<>();
    }

    public void putOnStack(int input) {
        stack.addFirst(input);
    }

    public void calculateStack(char operand) throws IllegalArgumentException {
        int result = 0;
        if(stack.size() < 2){
            throw new IllegalArgumentException("""
            The Pushdown-Automaton has reached an none accepting state because there are not enough
            values on the stack for the calculation
            """);
        } else {
        int a = stack.get(0);
        int b = stack.get(1);
        switch (operand) {
            case '+' -> result = a + b;
            case '*' -> result = a * b;
        }
        stack.remove(0);
        stack.remove(0);
        stack.addFirst(result);
        this.result = result;
        }

    }
    public String getResult(){
        String result;
        if(stack.size() > 1){
            result = """
            The Pushdown-Automaton has ended in a none accepting state because there are multiple values on
            the stack
            """;
        }else{
            result = "The result is:\n" + Integer.toString(this.result);
        }
        return result;
    }


    @Override
    public String toString(){
        String stringStack = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : stack) {
            stringBuilder.append("\n");
            stringBuilder.append(integer);
        }
        stringStack = stringBuilder.toString();
        return stringStack;
    }
}

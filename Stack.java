import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> stack;
    int result;
    Stack() {
        stack = new ArrayList<>();
    }

    public void putOnStack(int input) {
        stack.add(input);
    }

    public void calculateStack(char operand) {
        int result = 0;
        int a = stack.get(0);
        int b = stack.get(1);
        switch (operand) {
            case '+' -> result = a + b;
            case '*' -> result = a * b;
        }
        stack.remove(0);
        stack.remove(0);
        stack.add(result);
        this.result = result;
    }
    public String getResult(){
        String result;
        if(stack.size() > 1){
            result = "The stack has more than 1 value on it.";
        }else{
            result = Integer.toString(this.result);
        }
        return result;
    }

    public ArrayList<Integer> getStack(){
        return stack;
    }
    @Override
    public String toString(){
        String stringStack = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : stack) {
            stringBuilder.insert(0,"\n");
            stringBuilder.insert(0,integer);
        }
        stringStack = stringBuilder.toString();
        return stringStack;
    }
}

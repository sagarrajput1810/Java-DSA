package Stack;

import java.util.Stack;

public class StackCollection {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        System.out.println(stack.size());
        System.out.println(stack.peek());//top element of stack
        System.out.println(stack.pop());
    }
}

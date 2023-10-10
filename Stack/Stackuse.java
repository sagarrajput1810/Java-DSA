package Stack;

public class Stackuse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
      
      // StackUsingArray stack = new StackUsingArray();
        LLStack<Integer> stack = new LLStack<>();
      stack.push(10);
        System.out.println(stack.top());
        stack.pop();
        stack.size();
        System.out.println(stack.isEmpty());
        stack.pop();
    }
}

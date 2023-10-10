package Stack;

import LL.Node;

public class LLStack<t> {
    private Node<t> head;
    private int size;
    
    public LLStack(){
        head = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void push(t elem){
        Node<t> newNode = new Node<t>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public t top() throws StackEmptyException{
        if(head == null){
            throw new StackEmptyException();
        }
        return head.data;
    }
    public t pop() throws StackEmptyException{
        if(head == null){
            throw new StackEmptyException();
        }
        t temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}
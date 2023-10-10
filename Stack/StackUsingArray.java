package Stack;
//Stack is a linear data structure that follows a particular order 
//in which the operations are performed. The order may be 
//LIFO(Last In First Out) 
public class StackUsingArray {
    private int data[];
    private int topIndex; // index of the top most element of the stack.

    public StackUsingArray(){
        data = new int [10];
        topIndex = -1;
    }
    public StackUsingArray(int size){
        data = new int [size];
        topIndex = -1;
    }
    public int size(){
        return topIndex + 1;
    }
    public boolean isEmpty(){
        return topIndex == -1;
    }
    public void push(int elem) throws StackFullException{
        // If Stack is full 
        if(topIndex == data.length - 1){
            doubleCapacity();
        // throw new StackFullException(); // trhrow Exception
        }
        data[++topIndex] = elem;
    }
    public int top() throws StackEmptyException{
        if(topIndex == -1)
        throw new StackEmptyException();
        else
        return data[topIndex];
    }
    public int pop() throws StackEmptyException{
        if(topIndex == -1)
        throw new StackEmptyException();
        return data[topIndex--];
    }
    public void doubleCapacity(){
        int temp[] = data;
        data = new int [2 * temp.length];
        for(int i=0 ; i<temp.length; i++){
            data[i]=temp[i];
        }


    }
} 

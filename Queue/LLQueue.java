package Queue;

import LL.Node;

public class LLQueue<t> {
    private Node<t> front = null;
    private Node<t> rear = null;
    private int size;
    
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public void enqueue(t elem){
        Node<t> newNode = new Node<>(elem);
        size++;
        if(front == null){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next=newNode;
            rear = newNode; // rear = rear.next
        }
    }

    public t front() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    public t dequeue() throws QueueEmptyException{
        if(front == null){
            throw new QueueEmptyException();
        }
        t temp = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
        return temp;

    }
}
package Queue;

public class QueueUsingArray {
    private int data[];
    private int front; // index of element at the front of the queue
    private int rear;// index of element at the rear of the queue
    private int size;

    public QueueUsingArray(){
        data = new int[5];
        front=-1;
        rear = -1;
    }
    
    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size(){
        return size ;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int elem){
        if(size == data.length){
            doubleCapacity();
        }
        if(size == 0){
            front =0;
        }
        rear++;
        data[rear] = elem;
        size++;
    }
    public int front() throws QueueEmptyException{
        if(size==0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int dequeue() throws QueueEmptyException{
        if(size == 0){
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front++;
        size--;
        return temp;
    }

    private void doubleCapacity(){
        int temp[]=data;
        data = new int [2 * temp.length];
        for(int i=0 ; i<temp.length; i++){
            data[i]=temp[i];
    }
}
}
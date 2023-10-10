package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>(); // QUEUE is an interface so it not have constructor. 
        // Interface is an collection of methods, Interface collection can only use by the other class.
        //For use Queue interface create own class or use with Linkedlist class;
        queue.add(10);
        queue.add(20);
        System.out.println(queue.size());
        System.out.println(queue.peek());// for print font element;
        System.out.println(queue.poll()); // for remove the element;
        System.out.println(queue.size());
    }
}
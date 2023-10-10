package LL;
import java.util.Scanner;

public class LLbyUser {
// Create linked list by taking input by user:
    public static Node<Integer> input(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null ; // for first node we create null node.
        while (data != -1) {
            Node<Integer> currentNode = new Node<Integer>(data);
            if (head == null) {
                //Make this node as head node
                head = currentNode;
            } else {
                Node<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                // Now tail will refer to last node
                //connect current node after last node
                tail.next = currentNode;
            }
            data = s.nextInt();
        }
        return head;
    }
// we also have shoter way to tak input:
public static Node<Integer> takeInput(){
    Scanner s = new Scanner(System.in);
    int data = s.nextInt();
    Node<Integer> head = null , tail =null; // for first and last node we create null node.
    while (data != -1) {
        Node<Integer> currentNode = new Node<Integer>(data);
        if (head == null) {
            //Make this node as head node
            head = currentNode;
            tail = currentNode;
        } else {
            tail.next = currentNode;
            tail = tail.next;
        }
        data = s.nextInt();
    }
    return head;
}
// Create the function for mid point without calculating length:
    // this task can done with the help of 2 pointer
    public static int  midPoint(Node<Integer> head) {
        Node<Integer> fast = head;
        while(fast.next != null && fast.next.next != null ){
            head = head.next;
            fast= fast.next.next;
        }
        return head.data;
    }

    
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        LLuse.print(head);
        System.out.println("");
        System.out.println(midPoint(head));
    }
    
}
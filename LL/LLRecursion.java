package LL;

import java.util.Scanner;

public class LLRecursion {
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
// Create print funtion by the use of recusion:
    public static void printR(Node<Integer> head){
        if(head == null){
            return; // Base condition for stop recursion
        }
        System.out.print(head.data + " ");
        printR(head.next);
    }
// Create the function for insert element by the use of recursion:
    public static Node<Integer> insertR(int index, int element, Node<Integer> head){
        if(index == 0){
            Node<Integer> currentNode = new Node<Integer>(element);
            currentNode.next = head;
            return currentNode; 
        }
        else{
            head.next = insertR(index-1, element, head.next);
            return head;
        }

    }
// Create the function for delete element by the use of recursion:
    public static Node<Integer> deleteR(Node<Integer> head, int index){
        if(index==0){
            return head.next;
        }
        else{
            head.next = deleteR(head.next, index-1);
            return head;
        }
    }
// Create the function for reverse the linkedlist :
    public static Node<Integer> reverseR(Node<Integer> head){
        if(head == null || head.next==null){
            return head;
        }
        else{
            Node<Integer> main = reverseR(head.next); // reverse the whole linked list
            Node<Integer> tail = head.next;
            tail.next = head; // connect first node to the reverse list
            head.next = null; 
            return main;
        }
    }

    // main function for use function created above
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printR(head);
        System.out.println("");
        // insertR(3, 45, head);
        deleteR(head, 2);
        printR(head);

    }
}

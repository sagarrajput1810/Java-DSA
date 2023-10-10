package LL;
// Create a linked list by the coder:
public class LLuse {
    public static Node<Integer> createLL(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        Node<Integer> n5 = new Node<>(50);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;

    }
// Create the linked list print function for display linked list:
    public static void print(Node<Integer> head){
        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next; // Its refers to next node.
        }
    }
// Create the size function for determine the length of the linked list:
    public static int size(Node<Integer> head){
        int count=0;
        while(head != null){
            head=head.next;
            count++;
        }
        return count;
    }
// Create a funcion for insert element at given index:
    public static void insert(int index,int  element, Node<Integer> head){
        Node<Integer> n = new Node<Integer>(element);
        // for traverse the list to given index
        for(int i=0 ; i < index-1 ; i++){
            head = head.next;
        }
        Node<Integer> temp; // swap the address for fix the element
        temp=head.next;
        head.next = n;
        n.next = temp;

    }
// Create a funcion for insert element at given index:
    public static void delete(int index, Node<Integer> head){
        for(int i=0 ; i<index-1; i++ ){
            head = head.next;
        }
        head.next = head.next.next; // give next address

    }


// main function for practicing all function we created:
public static void main(String[] args) {
        
        
    //System.out.println(size(createLL()));
    print(createLL());
    
    // leave one element write (createLL().next)
}   
}
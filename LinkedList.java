/*  Copyright (c) 2015 Andrew Cleland 
    Integer Linked List Implementation in Java 
    - Partly based on "Cracking the Coding Interview" by Gayle Laakmann McDowell
*/

public class LinkedList {
    private int data;
    private LinkedList next;

    public LinkedList(int firstData) {
        this.data = firstData;
        this.next = null;
    }
    
    public boolean hasNext() {
        return (this.next != null);
    }
    
    public void append(int nextData) {

        LinkedList newNode = new LinkedList(nextData);
        LinkedList node = this;

        // Go to end of list
        while (node.hasNext()) {
            node = node.next;
        }

        // Append the new node
        node.next = newNode;
    }

    public LinkedList deleteNode(int nodeDataToDelete) {
        // If list is an instance of LinkedList, then this method should be called
        // list = deleteNode(int something). i.e. The return value should replace
        // the head of the list. 

        LinkedList head = this;
        
        // If the head is the thing to delete, move head to next node.
        if (head.data == nodeDataToDelete) {
            return head.next;
        }
        

        // Iterate through nodes until value matches. 
        LinkedList node = head;
        while (node.hasNext()) {
            if (node.next.data == nodeDataToDelete) {
                node.next = node.next.next;
                return head; // Head doesn't change.
            }
            node = node.next;
        }
        return head;
    }



    public String toString() {
        String s = "";
        LinkedList n = this;
        s += n.data + " ";
        while (n.hasNext()) {
            n = n.next;
            s += n.data + " ";
        }
        return s;
    }

}

/*  Copyright (c) 2015 Andrew Cleland 
    Linked List Implementation in Java
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

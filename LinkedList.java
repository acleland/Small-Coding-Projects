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
    
    public int getData() {
        return this.data;
    }

    public LinkedList getNext() {
        return this.next;
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

    public int getSize() {
        int size = 1; // This method will only be successully if there is at least one element
        LinkedList node = this;
        while (node.hasNext()) {
            size++;
            node = node.next;
        }
        return size;
    }

    public int getNode(int index) {
        if (index < 0) 
            throw new IllegalArgumentException(Integer.toString(index));
        else if (index == 0)
            return this.data;
        LinkedList node = this;
        int i = 0;
        while (node.hasNext()) {
            i++;
            if (i == index) 
                return node.next.data;
            node = node.next;
        }
        throw new IllegalArgumentException(Integer.toString(index));
    }


    public LinkedList deleteNodeWithValue(int nodeDataToDelete) {
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

    
    // Delete Next
    public void deleteNext() {
        if (this.hasNext()) {
            this.next = this.next.next;
        }
    }

    // Remove duplicates - Interview question 2.1 from "Cracking the Coding Interview"
    public void removeDuplicates() {
        // For each element in the list, check against all remaining elements in the list
        LinkedList node = this;
        LinkedList runner = null;
        while(node != null) {
            runner = node;
            while (runner.hasNext()) {
                if (runner.next.data == node.data)
                    runner.deleteNext();
                else
                    runner = runner.next;
            }
            node = node.next;
        }
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

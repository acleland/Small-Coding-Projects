/*  Copyright (c) 2015 Andrew Cleland
    Test of Linked List Implementation in Java
*/

import java.util.Random;

public class LinkedListTest {
    
    // Make a random list of integers
    public static LinkedList makeRandom(int length, int max) {
        Random random = new Random();
        LinkedList list = new LinkedList(random.nextInt(max));
        
        for (int i = 0 ; i < length-1; i++) {
            list.append(random.nextInt(max));
        }
        return list;
    }

    // Test the list.getNode(i) method
    public static void testGetNode(LinkedList list) {
        System.out.println("\nTesting list.getNode()...");
        System.out.printf("list: " + list.toString() + "\n");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.printf("%d %d\n", i, list.getNode(i));    
        }
    }

    // Test the list.deleteNodeWithValue() method
    public static void testDelete(LinkedList list) {
        int toDelete = getRandomElement(list);
        System.out.println("\nTesing list.deleteNodeWithValue()...");
        System.out.println("List prior: " + list.toString());
        System.out.println("Value to delete: " + toDelete);
        list.deleteNodeWithValue(toDelete);
        System.out.println("List after: " + list.toString());
    }

    // Get random element from a list
    public static int getRandomElement(LinkedList list) {
        Random random = new Random();
        return list.getNode(random.nextInt(list.getSize()));
    }

    // Shorcut for printing a list 
    public static void printList(LinkedList l) {
        System.out.println(l.toString());
    }
    
    public static void main(String[] args) {
        LinkedList list1 = makeRandom(10, 100);
        printList(list1);
        testGetNode(list1);
        testDelete(list1);          

    }

}

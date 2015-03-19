/*  Copyright (c) 2015 Andrew Cleland
    Test of Linked List Implementation in Java
*/

import java.util.Random;

public class LinkedListTest {
    
    public static LinkedList makeRandom(int length, int max) {
        Random random = new Random();
        LinkedList list = new LinkedList(random.nextInt(max));
        
        for (int i = 0 ; i < length-1; i++) {
            list.append(random.nextInt(max));
            System.out.println(i);
        }
        return list;
    }

    public static void printList(String name, LinkedList l) {
        System.out.println(name + ": " + l.toString());
    }
    
    public static void main(String[] args) {
        LinkedList list1 = makeRandom(10, 100);

        printList("list1", list1);
        

    }

}

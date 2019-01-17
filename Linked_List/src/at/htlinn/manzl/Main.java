package at.htlinn.manzl;

import at.htlinn.manzl.Double_Linked_List.DoubleLinkedList;
import at.htlinn.manzl.SingleLinkedList.LinkedList;

public class Main {

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        DoubleLinkedList dll = new DoubleLinkedList();
	    for(int i = 0; i<= 10; i++)
	    {
	        ll.add(i);
	        dll.addfront(i);
	        System.out.println(i);
	        System.out.println(dll.getFrom(i));
        }


        System.out.println("Jetz gethts los mit LinkedList!");

        System.out.println(ll.getFrom(1));
        System.out.println(ll.getFrom(2));
        System.out.println(ll.getFrom(3));
        System.out.println("Jetzt wird dieses Element gelöscht:"+ll.getFrom(2));
        System.out.println("##########");
        ll.delete(2);
        System.out.println("##########");
        System.out.println(ll.getFrom(1));
        System.out.println(ll.getFrom(2));
        System.out.println(ll.getFrom(3));

        System.out.println("Jetzt mit Double Linked List!");
        System.out.println("##########");

        System.out.println( dll.getFrom(1));
        System.out.println( dll.getFrom(2));
        System.out.println( dll.getFrom(3));
        System.out.println("##########");
        dll.delete(1);
        dll.delete(2);
        dll.delete(3);
        System.out.println( dll.getFrom(1));
        System.out.println( dll.getFrom(2));
        System.out.println( dll.getFrom(3));
        System.out.println("##########");

        System.out.println( dll.getFrom(10));
        System.out.println( dll.getFrom(9));
        System.out.println( dll.getFrom(8));
        System.out.println("##########");
        dll.delete(1);
        dll.delete(2);
        dll.delete(3);
        System.out.println("##########");
        System.out.println( dll.getFrom(10));
        System.out.println( dll.getFrom(9));
        System.out.println( dll.getFrom(8));


        /*for(int i = 3; i<= 5; i++)
        {
            System.out.println(ll.getValue(i));
        }*/
    }
}

package at.htlinn.manzl.test;

import at.htlinn.manzl.Double_Linked_List.DoubleLinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void addfront() {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addfront(12);
        dll.addfront(20);
        dll.addfront(40);

        assertEquals(12, dll.getFrom(2));
        assertEquals(20, dll.getFrom(1));
        assertEquals(40,dll.getFrom(0));

    }

    @org.junit.jupiter.api.Test
    void addbackwards() {
    }

    @org.junit.jupiter.api.Test
    void getFrom() {
        DoubleLinkedList dll = new DoubleLinkedList();

        dll.addfront(12);
        dll.addfront(20);
        dll.addfront(40);

    }

    @org.junit.jupiter.api.Test
    void hopfor() {
    }

    @org.junit.jupiter.api.Test
    void hopback() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void getSize() {
    }
}
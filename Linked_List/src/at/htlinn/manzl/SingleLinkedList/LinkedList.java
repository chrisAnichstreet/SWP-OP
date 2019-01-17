package at.htlinn.manzl.SingleLinkedList;

public class LinkedList<T> {
    private Node head = null;
    private int counter = 0;
    private int index = 0;
    public LinkedList()
    {

    }
    public void add(T value)
    {
        //list is empty
        Node node = new Node(value);
        if(head == null)
        {
            head = node;
            return;
        }
        //list has got one element
        if(head.getNext() == null)
        {
            head.setNext(node);
            return;
        }





        Node tmp = head;
        while ((tmp.getNext() != null)){
            tmp = tmp.getNext();
        }
        tmp.setNext(node);


    }
    public T getFrom(int index)
    {
        counter =0;
        this.index = index;
        return (T) hop(head).getValue();


    }
    public Node hop(Node pointer)
    {
        if(counter == index)
        {
            return pointer;
        }
        else{counter++;}

        return (hop(pointer.getNext()));
    }
    public void delete(int index)
    {
        counter =0;
        this.index = index;
        Node tempNode = null;
        tempNode =hop(head);

        counter=0;
        this.index = index-1;
        hop(head).setNext(tempNode.getNext());
    }

}

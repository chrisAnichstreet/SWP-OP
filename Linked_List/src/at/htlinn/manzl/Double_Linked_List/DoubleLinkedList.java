package at.htlinn.manzl.Double_Linked_List;

public class DoubleLinkedList<T> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    private int counter = 0;
    private int index = 0;
    public DoubleLinkedList()
    {

    }
    public void addfront(T value)
    {
        //list is empty, fill head and tail  with the same pointer
        Node<T> node = new Node<T>(value);
        this.size++;

        if((head == null) && (tail==null))
        {
            head = node;
            tail = node;
            return;
        }

        //list has got one element
        if((head.getNext() == null) && (tail.getPrevious()== null))
    {
        tail.setPrevious(node);
        head.setNext(node); //Diese Getauscht weil sonst zeigung auf einen selbst DIESE 1
        head=node; //DIESE2
        return;
    }


        if ((head.getNext() !=null)&&(tail.getPrevious() != null))
        {
            Node tmp;
            tmp = node;
            head.setPrevious(node);
            node.setNext(head);
            head = node;
            return;

        }

        /*Has more elements:
        while ((tmp.getNext() != null)){
            tmp = tmp.getNext();
        }

        tmp.setNext(node);
        tail = node;*/
    }
    public void addbackwards(T value)
    {
        //list is empty, fill head and tail  with the same pointer
        Node<T> node = new Node<T>(value);
        this.size++;
        if((head == null) && (tail==null))
        {
            head = node;
            tail = node;
            return;
        }

        //list has got one element
        if ((head.getNext() == null)&& (tail.getPrevious()== null))
        {
            head.setNext(node);
            tail = node;
            tail.setPrevious(node);
            return;
        }

        if ((head.getNext() !=null)&&(tail.getPrevious() != null)){
            Node tmp = tail;
            tail.setNext(node);
            tail = node;
            node.setPrevious(tmp);
        }

        /*Has more elements:
        while ((tmp.getPrevious() != null)){
            tmp = tmp.getPrevious();
        }

        tmp.setPrevious(node);*/
    }




    public T getFrom(int index)
    {
        this.index = index;
        //Hop through the list from Head
        if((getSize()/2)>index){
            getSize();
            counter = getSize();
            counter =0;
            return (T) hopfor(head).getValue();
        }
        // Hop through the list from tail
        if((getSize()/2)<index){
            counter = getSize()-1;
            return (T) hopback(tail).getValue();
        }
        return null;
    }
    public Node hopfor(Node pointer)
    {
        if(counter == index)
        {
            return pointer;
        }
        else{counter++;}

        return (hopfor(pointer.getNext()));
    }
    public Node hopback(Node pointer)
    {
        if(counter == index)
        {
            return pointer;
        }
        else{counter--;}

        return (hopback(pointer.getPrevious()));
    }
    public void delete(int index)
    {
        this.index = index;
        if((getSize()/2)>index)
        {
            counter =0;
            Node tempNode = null;
            tempNode =hopfor(head);

            counter=0;
            if(this.index>0)
            {this.index --;} //index -1
            else{this.index = 0;}
            hopfor(head).setNext(tempNode.getNext());

            counter=0;
            this.index = +2;
            hopfor(head).setPrevious(tempNode.getPrevious());
        }
        if((getSize()/2)<index)
        {
            counter = getSize();
            Node tempNode = null;
            tempNode =hopback(tail);

            counter= getSize();
            if(this.index>0)
            {this.index --;} //index -1
            else{this.index = 0;}
            hopback(tail).setNext(tempNode.getNext());

            counter=getSize();
            this.index = +2;
            hopback(tail).setPrevious(tempNode.getPrevious());
        }
    }


    public int getSize()
    {
        return  this.size;
    }

}

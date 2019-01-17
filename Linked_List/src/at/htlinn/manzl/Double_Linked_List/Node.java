package at.htlinn.manzl.Double_Linked_List;

public class Node<T> {
    private T value;
    private Node next;
    private Node pre;

    public Node(T value)
    {
        this.value = value;
    }

    public Node getNext()
    {
            return next;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
    public T getValue()
    {
        return value;
    }
    public void setValue(T value)
    {
        this.value = value;
    }

    public Node getPrevious()
    {
        return pre;
    }
    public void setPrevious(Node pre)
    {
        this.pre = pre;
    }
}

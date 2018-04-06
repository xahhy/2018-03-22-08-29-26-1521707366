package com.thoughtworks.collection;

public class Node<T> {
    private T data; //存放结点值

    private Node next; //后继结点的引用

    //无参数时的构造方法
    public Node()
    {
        this(null, null);
    }

    //带一个参数的构造方法
    public Node(T data)
    {
        this(data, null);
    }

    //带两个参数的构造方法
    public Node(T data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}

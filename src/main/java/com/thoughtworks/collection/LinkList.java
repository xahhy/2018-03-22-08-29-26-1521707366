package com.thoughtworks.collection;

public class LinkList<T> implements SingleLink<T> {
    Node<T> head;

    @Override
    public T getHeaderData() {
        return (T) head.getData();
    }

    @Override
    public T getTailData() {
        if (head != null) {
            Node next = head.getNext();
            while (next.getNext() != null) {
                next = next.getNext();
            }
            return (T) next.getData();
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        if (head != null) {
            size += 1;
            Node next = head.getNext();
            if (next == null) {
                return size;
            }
            size += 1;
            while (next.getNext() != null) {
                next = next.getNext();
                size += 1;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean deleteFirst() {
        if (head.getNext() != null) {
            head = head.getNext();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLast() {
        if (head != null) {
            Node before = head;
            Node next = head.getNext();
            if (head.getNext() == null) {
                head = null;
                return true;
            }
            while (next.getNext() != null) {
                before = next;
                next = next.getNext();
            }
            before.setNext(null);
            return true;
        }
        return false;
    }

    @Override
    public void addHeadPointer(T item) {
        head = new Node<>(item, head);
    }

    @Override
    public void addTailPointer(T item) {
        if (head != null) {
            Node next = head.getNext();
            if (next == null) {
                head.setNext(new Node<>(item));
                return;
            }
            while (next.getNext() != null) {
                next = next.getNext();
            }
            next.setNext(new Node<>(item));
            return;
        }
        head = new Node<>(item);
    }

    @Override
    public T getNode(int index) {
        int size = 0;
        if (head != null) {
            size += 1;
            Node next = head.getNext();
            if (next == null) {
                if (index == 0) return (T) head.getData();
                return null;
            }
            size += 1;
            while (next.getNext() != null) {
                if (index == size-1){
                    return (T) next.getData();
                }
                next = next.getNext();
                size += 1;
            }
        }
        return null;
    }
}

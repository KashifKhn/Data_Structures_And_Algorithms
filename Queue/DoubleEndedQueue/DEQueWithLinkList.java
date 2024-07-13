package DoubleEndedQueue;

public class DEQueWithLinkList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DEQueWithLinkList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueueAtTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public T dequeueAtHead() {
        if (isEmpty()) {
            return null;
        }
        T value = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            // If head becomes null, tail should also be null
            tail = null;
        }
        return value;
    }

    public void enqueueAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public T dequeueAtTail() {
        if (isEmpty()) {
            return null;
        }
        T value = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            // If tail becomes null, head should also be null
            head = null;
        }
        return value;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}

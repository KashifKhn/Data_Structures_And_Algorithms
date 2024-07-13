package StackWithLinkLists;

public class StackLink<T> {
    Node top;
    int size;

    public StackLink() {
        this.top = null;
        this.size = 0;
    }

    private boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node newNode = new Node(data);
        size++;
        if (isEmpty()) {
            top = newNode;
            return;
        }
        newNode.nextNode = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = top.data;
        top = top.nextNode;
        this.size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public int size() {
        return this.size;
    }

    public class Node {
        Node nextNode;
        T data;

        public Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}
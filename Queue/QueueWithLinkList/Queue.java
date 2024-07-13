package QueueWithLinkList;

public class Queue<T> {
    
    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
         tail.next = newNode;
        tail = newNode;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T value = head.data;
        head = head.next;
        return value;
    }

    public class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

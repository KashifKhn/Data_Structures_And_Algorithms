package CircularLinkedList;

public class CircularLinkedList<T> {
    public Node head;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void insertAtStart(T data) {
        Node newNode = new Node(data);
        size++;
        if (isEmpty()) {
            head = newNode;
            head.nextNode = head;
            head.prevNode = head;
            return;
        }
        newNode.nextNode = head;
        newNode.prevNode = head.prevNode;
        head.prevNode.nextNode = newNode;
        head.prevNode = newNode;
        head = newNode;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        size++;
        if (isEmpty()) {
            head = newNode;
            head.nextNode = head;
            head.prevNode = head;
            return;
        }
        newNode.nextNode = head;
        newNode.prevNode = head.prevNode;
        head.prevNode.nextNode = newNode;
        head.prevNode = newNode;
    }

    public T deleteAtStart() {
        if (isEmpty()) {
            return null;
        }
        T value = head.data;
        if (head.nextNode == head) {
            head = null;
            return value;
        }
        head.nextNode.prevNode = head.prevNode;
        head.prevNode.nextNode = head.nextNode;
        head = head.nextNode;
        return value;
    }

    public T deleteAtEnd() {
        if (isEmpty()) {
            return null;
        }
        T value = head.prevNode.data;
        if (head.nextNode == head) {
            head = null;
            return value;
        }
        head.prevNode.prevNode.nextNode = head;
        head.prevNode = head.prevNode.prevNode;
        return value;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node tempNode = head;
        do {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.nextNode;
        } while (tempNode != head);
        System.out.println();
    }

    public int size() {
        return size;
    }

    public class Node {
        T data;
        Node nextNode;
        Node prevNode;

        public Node(T data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }
}

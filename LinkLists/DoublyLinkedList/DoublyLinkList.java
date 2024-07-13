package DoublyLinkedList;

public class DoublyLinkList<T> {
    private Node tail;
    private Node head;
    private int size;

    public DoublyLinkList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void insertAtStart(T data) {
        Node newNode = new Node(data);
        size++;
        if (isEmpty()) {
            tail = head = newNode;
            return;
        }
        newNode.nextNode = head;
        head.prevNode = newNode;
        head = newNode;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        size++;
        if (isEmpty()) {
            tail = head = newNode;
            return;
        }
        tail.nextNode = newNode;
        newNode.prevNode = tail;
        tail = newNode;
    }

    public T deleteAtStart() {
        if (isEmpty()) {
            return null;
        }
        T value = head.data;
        size--;
        if (head == tail) {
            tail = head = null;
            return value;
        }
        head = head.nextNode;
        head.prevNode = null;
        return value;
    }

    public T deleteAtEnd() {
        if (isEmpty()) {
            return null;
        }

        T value = tail.data;
        size--;
        if (head == tail) {
            tail = head = null;
            return value;
        }

        tail = tail.prevNode;
        tail.nextNode = null;
        return null;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.nextNode;
        }
        System.out.print("null");
        System.out.println();
    }

    public T search(T key) {
        if (isEmpty()) {
            return null;
        }
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.data.equals(key)) {
                return tempNode.data;
            }
            tempNode = tempNode.nextNode;
        }
        return null;
    }

    public int size() {
        return this.size ;
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

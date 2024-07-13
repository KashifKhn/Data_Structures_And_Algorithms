public class SingleLinkList<T> {
    private Node head;
    private Node tail;
    private int size;

    private boolean isEmpty() {
        return this.head == null;
    }

    public void insertAtStart(T data) {
        Node newNode = new Node(data);
        this.size++;
        if (isEmpty()) {
            this.head = this.tail = newNode;
            return;
        }
        newNode.nextNode = head;
        head = newNode;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        this.size++;
        if (isEmpty()) {
            this.head = this.tail = newNode;
        }
        tail.nextNode = newNode;
        tail = newNode;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is Empty");
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

    public T deleteAtStart() {
        if (isEmpty()) {
            return null;
        }
        T value = head.data;
        if (head == tail) {
            head = tail = null;
            return value;
        }
        head = head.nextNode;
        return value;
    }

    public T deleteAtEnd() {
        if (isEmpty()) {
            return null;
        }
        T value = tail.data;
        if (head == tail) {
            tail = head = null;
            return value;
        }
        Node tempNode = head;
        while (tempNode.nextNode != tail) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = null;
        return value;
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("List Empty");
            return;
        }
        if (head == tail) {
            return;
        }
        Node prev = null;
        Node current = head;
        Node next;
        head = tail;
        tail = current;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
    }

    public Node findMid() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (isEmpty() || head == tail) {
            return true;
        }
        Node midNode = findMid();
        Node prev = null;
        Node current = midNode;
        Node next;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }

        Node right = prev;
        Node left = head;

        while (right != null) {
            if (!right.data.equals(left.data)) {
                return false;
            }
            right = right.nextNode;
            left = left.nextNode;
        }

        return true;
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
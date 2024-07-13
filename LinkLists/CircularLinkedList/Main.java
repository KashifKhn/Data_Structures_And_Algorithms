package CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

        System.out.println(list.head);
        list.insertAtEnd(1);
        // list.insertAtEnd(2);
        // list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtStart(0);
        // System.out.println(list.head);
        list.insertAtStart(-1);
        list.insertAtStart(-2);
        // System.out.println(list.head);
        list.insertAtStart(-3);

        // System.out.println(list.head);

        // System.out.println(list.deleteAtStart());
        // System.out.println(list.deleteAtStart());
        list.traverse();
        System.out.println(list.deleteAtEnd());
        System.out.println(list.deleteAtEnd());
        // Output: 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
        list.traverse();
    }
}

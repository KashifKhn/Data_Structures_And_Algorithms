package DoublyLinkedList;

public class Main {

    public static void main(String[] args) {
        DoublyLinkList<Integer> dLinkList = new DoublyLinkList<>();
        dLinkList.insertAtStart(1);
        dLinkList.insertAtEnd(10);
        dLinkList.insertAtEnd(100);
        dLinkList.insertAtEnd(1000);
        dLinkList.insertAtStart(0);
       System.out.println( dLinkList.size());
        dLinkList.traverse();
    }
    
    
}

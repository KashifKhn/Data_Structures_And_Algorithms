public class Main {

    public static void main(String[] args) {
        SingleLinkList<Integer> sLinkList = new SingleLinkList<>();
        // sLinkList.insertAtStart(1);
        // sLinkList.insertAtEnd(10);
        // sLinkList.insertAtEnd(100);
        // sLinkList.insertAtEnd(1000);
        // sLinkList.insertAtStart(0);

        // sLinkList.insertAtStart(1);
        // sLinkList.insertAtStart(2);
        // sLinkList.insertAtStart(2);
        // sLinkList.insertAtStart(1);
        // sLinkList.traverse();
        // sLinkList.reverse();
        sLinkList.traverse();
        System.out.println(sLinkList.isPalindrome());
    }
}
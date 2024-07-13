package DoubleEndedQueue;

public class Main {
    public static void main(String[] args) {
        // DEQueWithLinkList<Integer> arr = new DEQueWithLinkList<>();
        DEQueWithArray<Integer> arr = new DEQueWithArray<>(5);
        arr.enqueueAtTail(1);
        arr.enqueueAtTail(2);
        arr.enqueueAtTail(3);
        arr.enqueueAtTail(4);
        arr.enqueueAtTail(5);

        System.out.println(arr.dequeueAtHead());
        System.out.println(arr.dequeueAtHead());
        System.out.println(arr.dequeueAtHead());
        System.out.println(arr.dequeueAtHead());
        System.out.println(arr.dequeueAtHead());
    }
}

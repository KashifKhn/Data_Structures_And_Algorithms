package QueueWithLinkList;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> arr = new Queue<>();
        System.out.println(arr.dequeue());
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(3);
        arr.enqueue(4);
        arr.enqueue(5);
        arr.enqueue(6);
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
        arr.enqueue(7);
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
    }
}

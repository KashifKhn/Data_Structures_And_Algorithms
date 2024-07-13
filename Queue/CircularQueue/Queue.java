package CircularQueue;

public class Queue<T> {

    private T[] arr;
    private int head;
    private int tail;
    private int length;

    @SuppressWarnings("unchecked")
    public Queue(int length) {
        this.arr = (T[]) new Object[length];
        this.head = 0;
        this.tail = 0;
        this.length = length;
    }

    public boolean isEmpty() {
        return (this.head == this.tail);
    }

    private boolean isFull() {
        return ((this.tail - this.head) == length);
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        arr[tail % length] = data;
        tail++;
    }

    public T dequeue() {
        if (isEmpty()) {
            head = tail = 0;
            return null;
        }
        T value = arr[head % length];
        head++;
        return value;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }

        return arr[head % length];
    }

    public int size() {
        return (tail - head);
    }
}

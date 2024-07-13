public class Queue<T> {
    private T[] arr;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public Queue(int length) {
        this.arr = (T[]) new Object[length];
        this.tail = -1;
        this.head = 0;
    }

    private boolean isEmpty() {
        return tail == -1;
    }

    private boolean isFull() {
        return tail + 1 == arr.length;
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        arr[++tail] = data;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T value = arr[head];
        moveForward();
        tail--;
        return value;
    }

    private void moveForward() {
        for (int i = 1; i <= tail; i++) {
            arr[i-1] = arr[i];
        }
    }

    public T front() {
        return arr[head];
    }

    public int size() {
        return tail + 1;
    }

}

package DoubleEndedQueue;

public class DEQueWithArray<T> {
    private T[] arr;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public DEQueWithArray(int length) {
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

    public void enqueueAtTail(T data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        arr[++tail] = data;
    }

    public void enqueueAtHead(T data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        moveBackward();
        arr[head] = data;
    }

    public T dequeueAtHead() {
        if (isEmpty()) {
            return null;
        }
        T value = arr[head];
        moveForward();
        return value;
    }

    public T dequeueAtTail() {
        if (isEmpty()) {
            return null;
        }
        return arr[tail--];
    }

    private void moveForward() {
        for (int i = 1; i <= tail; i++) {
            arr[i - 1] = arr[i];
        }
        tail--;
    }

    private void moveBackward() {
        for (int i = tail; i >= 0; i--) {
            arr[i+1] = arr[i];
        }
        tail++;
    }

    public T front() {
        return arr[head];
    }

    public int size() {
        return tail + 1;
    }
}

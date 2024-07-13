package PriorityQueue;

public class Queue<T> {
    CircularQueue.Queue<T> high = new CircularQueue.Queue<>(5);
    CircularQueue.Queue<T> mid = new CircularQueue.Queue<>(5);
    CircularQueue.Queue<T> low = new CircularQueue.Queue<>(5);

    public void enqueue(T data, int priority) {
        
        if (priority == 0) {
            high.enqueue(data);
        } else if (priority == 1) {
            mid.enqueue(data);
        } else if (priority == 2) {
            low.enqueue(data);
        }
    }

    public T dequeue() {
        if (!high.isEmpty()) {
            return high.dequeue();
        } else if (!mid.isEmpty()) {
            return mid.dequeue();
        } else if (!low.isEmpty()) {
            return low.dequeue();
        } else {
            return null;
        }
    }

}

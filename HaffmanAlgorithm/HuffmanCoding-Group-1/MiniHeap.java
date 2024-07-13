public class MiniHeap {
    Node[] heap;
    int size;

    public MiniHeap() {
        heap = new Node[HuffmanCoding.FREQUENCY_SIZE];
        size = 0;
    }

    public void addNode(Node node) {
        size++;
        heap[size] = node;
        addHeapAdjustment(size);
    }

    private void addHeapAdjustment(int i) {
        while (i > 1 && heap[parent(i)].frequency > heap[i].frequency) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public Node removeMinNode() {
        Node min = heap[1];
        heap[1] = heap[size];
        size--;
        removeHeapAdjustment(1);
        return min;
    }

    private void removeHeapAdjustment(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l <= size && heap[l].frequency < heap[i].frequency) {
            smallest = l;
        }
        if (r <= size && heap[r].frequency < heap[smallest].frequency) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            addHeapAdjustment(smallest);
        }
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    public int size() {
        return size;
    }
}

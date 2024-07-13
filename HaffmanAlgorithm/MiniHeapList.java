import java.util.ArrayList;
import java.util.List;

/*
 * Group 1
 * KASHIF KHAN  FA22-BSE-068
 * AMIR SHEHZAD  SP22-BSE-014
 */

  /*
 * classes which are used
 * 1. Main.java
 * 2. HuffmanCoding.java
 * 3. Node.java
 * 4. MiniHeapList.java
 */

public class MiniHeapList {

    List<Node> heap;
    int size;

    public MiniHeapList() {
        heap = new ArrayList<>();
        heap.add(null); 
        size = 0;
    }

    public void addNode(Node node) {
        heap.add(node);
        size++;
        addHeapAdjustment(size);
    }

    private void addHeapAdjustment(int i) {
        while (i > 1 && heap.get(parent(i)).frequency > heap.get(i).frequency) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public Node removeMinNode() {
        Node min = heap.get(1);
        heap.set(1, heap.get(size));
        heap.remove(size);
        size--;
        removeHeapAdjustment(1);
        return min;
    }

    private void removeHeapAdjustment(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l <= size && heap.get(l).frequency < heap.get(i).frequency) {
            smallest = l;
        }
        if (r <= size && heap.get(r).frequency < heap.get(smallest).frequency) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            removeHeapAdjustment(smallest);
        }
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
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

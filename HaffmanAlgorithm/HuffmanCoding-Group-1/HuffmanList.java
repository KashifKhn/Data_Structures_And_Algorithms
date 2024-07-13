public class HuffmanList {

  Node tail;
  Node head;

  public HuffmanList() {
    tail = null;
    head = null;
  }

  public void addNode(Node node) {
    if (head == null) {
      head = node;
      tail = node;
    } else {
      Node current = head;
      Node previous = null;
      while (current != null && current.frequency <= node.frequency) {
        previous = current;
        current = current.next;
      }
      if (previous == null) {
        node.next = head;
        head = node;
      } else {
        previous.next = node;
        node.next = current;
      }
      if (current == null) {
        tail = node;
      }
    }
  }

  public Node removeMinNode() {
    Node node = head;
    head = head.next;
    return node;
  }

  public int size() {
    int size = 0;
    Node current = head;
    while (current != null) {
      size++;
      current = current.next;
    }
    return size;
  }

}

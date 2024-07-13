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

public class Node {
  int frequency;
  char ch;
  Node left, right;
public Node next;

  public Node(char ch, int frequency, Node left, Node right) {
    this.frequency = frequency;
    this.ch = ch;
    this.left = left;
    this.right = right;
  }

  public Node(char ch, int frequency) {
    this.frequency = frequency;
    this.ch = ch;
    this.left = null;
    this.right = null;
  }

  public Node(int frequency, Node left, Node right) {
    this.ch = '\0';
    this.frequency = frequency;
    this.left = left;
    this.right = right;
  }
}

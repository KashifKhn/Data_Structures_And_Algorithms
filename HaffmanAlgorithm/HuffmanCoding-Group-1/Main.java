import java.io.IOException;

/*
 * Group 1
 * KASHIF KHAN  FA22-BSE-068
 * AMIR SHEHZAD  SP22-BSE-014
 * 
 */

/*
 * classes which are used
 * 1. Main.java
 * 2. HuffmanCoding.java
 * 3. Node.java
 * 4. MiniHeapList.java
 */

public class Main {
  public static void main(String[] args) throws IOException {
    HuffmanCoding hc = new HuffmanCoding();
    hc.compressFile("io/all.txt");
  }
}
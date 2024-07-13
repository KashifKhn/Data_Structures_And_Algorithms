import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


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

public class HuffmanCoding {

  public static final int FREQUENCY_SIZE = 255;

  private Node createFrequencyTree(int[] frequency) {
    MiniHeapList nodeList = new MiniHeapList();

    for (char i = 0; i < FREQUENCY_SIZE; i++) {
      if (frequency[i] > 0) {
        nodeList.addNode(new Node(i, frequency[i]));
      }
    }
    makeTree(nodeList);
    return nodeList.removeMinNode();
  }

  private void makeTree(MiniHeapList nodeList) {
    while (nodeList.size() > 1) {
      Node left = nodeList.removeMinNode();
      Node right = nodeList.removeMinNode();
      Node newParentNode = new Node(left.frequency + right.frequency, left, right);
      nodeList.addNode(newParentNode);
    }
  }

  private void makeNewBitCode(String[] codeTable, Node node, String newBitCode) {
    if (isLeafNode(node)) {
      codeTable[node.ch] = newBitCode;
    } else {
      makeNewBitCode(codeTable, node.left, newBitCode + '0');
      makeNewBitCode(codeTable, node.right, newBitCode + '1');
    }
  }

  private boolean isLeafNode(Node node) {
    return node.left == null && node.right == null;
  }

  private String[] makeHuffmanNewBits(int[] frequency) {
    Node root = createFrequencyTree(frequency);
    String[] codeTable = new String[FREQUENCY_SIZE];
    if (isLeafNode(root)) {
      codeTable[root.ch] = "0";
      return codeTable;
    }
    makeNewBitCode(codeTable, root, "");
    return codeTable;
  }

  private void countFrequency(BufferedReader reader, int[] frequency) throws IOException {
    int ch;
    while ((ch = reader.read()) != -1) {
      frequency[ch]++;
    }
  }

  private void printNewBits(String[] codeTable, int[] frequency) {
    for (int i = 0; i < codeTable.length; i++) {
      if (codeTable[i] != null) {
        System.out.println((char) i + ": " + codeTable[i] + "  " + frequency[i]);
      }
    }
  }

  public void compressFile(String inputFilePath) throws IOException {
    int[] frequency = new int[FREQUENCY_SIZE];

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
      countFrequency(reader, frequency);
    }

    String[] codeTable = makeHuffmanNewBits(frequency);
    printNewBits(codeTable, frequency);

    int compLen = writeCompressedFile(inputFilePath, codeTable);
    int orgLen = writeOriginalBytes(inputFilePath);
    printStatistics(orgLen, compLen);
  }

  private void printStatistics(int orgLen, int compLen) {
    System.out.println();
    System.out.println("Original total Number of Bits: " + orgLen + " bits");
    System.out.println("Compressed total Number of Bits: " + compLen + " bits");
    System.out.println();

    System.out.println("Original file size: " + String.format("%.2f", (double) orgLen / 8) + " bytes");
    System.out.println("Compressed file size: " + String.format("%.2f", (double) compLen / 8) + " bytes");
    System.out.println();

    System.out.println("Original file size: " + String.format("%.2f", (double) orgLen / 8 / 1000) + " KB");
    System.out.println("Compressed file size: " + String.format("%.2f", (double) compLen / 8 / 1000) + " KB");
    System.out.println();

    System.out.println("Original file size: " + String.format("%.2f", (double) orgLen / 8 / 1000 / 1000) + " MB");
    System.out.println("Compressed file size: " + String.format("%.2f", (double) compLen / 8 / 1000 / 1000) + " MB");
    System.out.println();

    System.out.println(
        "Ratio of original to compressed file: " + String.format("%.2f", ((double) compLen / orgLen * 100)) + " %");
    System.out.println("Compression ratio: " + String.format("%.2f", (100 - ((double) compLen / orgLen * 100))) + " %");
    System.out.println();
  }

  private int writeOriginalBytes(String inputFilePath)
      throws IOException {
    String originalBinaryFile = inputFilePath.replace(".txt", "Org.bin");
    int bitLength = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        FileOutputStream fos = new FileOutputStream(originalBinaryFile);
        DataOutputStream dos = new DataOutputStream(fos)) {
      while ((reader.read()) != -1) {
        bitLength += 8;
      }
      byte[] originalBytes = new byte[(bitLength + 7) / 8];
      int ch;
      while ((ch = reader.read()) != -1) {
        // String binaryString = String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0');
        String binaryString = Integer.toBinaryString(ch);
        for(int i=0; i<binaryString.length(); i++ ) {
          if (binaryString.charAt(i) == '1') {
            originalBytes[i / 8] |= 1 << (7 - (i % 8));
          }
        }
      }
      dos.writeInt(bitLength);
      dos.write(originalBytes);
    }
    return bitLength;
  }

  private int writeCompressedFile(String inputFilePath, String[] codeTable)
      throws IOException {

    String encodedFilePath = inputFilePath.replace(".txt", "Comp.bin");
    int compressedBitsLen = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        FileOutputStream fos = new FileOutputStream(encodedFilePath);
        DataOutputStream dos = new DataOutputStream(fos)) {

      int ch = 0;
      StringBuilder compressedBits = new StringBuilder();
      while ((ch = reader.read()) != -1) {
        compressedBits.append(codeTable[ch]);
      }
      compressedBitsLen = compressedBits.length();
      byte[] compressedBytes = new byte[(compressedBits.length() + 7) / 8];
      for (int i = 0; i < compressedBits.length(); i++) {
        if (compressedBits.charAt(i) == '1') {
          compressedBytes[i / 8] |= 1 << (7 - (i % 8));
        }
      }
      dos.writeInt(compressedBits.length());
      dos.write(compressedBytes);
    }

    return compressedBitsLen;
  }
}

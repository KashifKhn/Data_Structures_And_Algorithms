package BinarySearch;

public class Main {
  public static void main(String[] args) {
    // for BinarySearch array must be sort
    int[] arr = { 5, 10, 12, 15, 18, 50, 70 };
    int idx = search(arr, 5);
    int rIdx = searchRecursive(arr, 5, 0, arr.length - 1);
    System.out.println(idx);
    System.out.println(rIdx);
  }

  private static int search(int[] arr, int key) {
    int startIdx = 0;
    int endIdx = arr.length - 1;

    while (startIdx <= endIdx) {
      int midIdx = startIdx + (endIdx - startIdx) / 2;
      if (arr[midIdx] == key) {
        return midIdx;
      }
      if (key < arr[midIdx]) {
        endIdx = midIdx - 1;
      } else {
        startIdx = midIdx + 1;
      }
    }

    // not founded
    return -1;
  }

  private static int searchRecursive(int[] arr, int key, int sIdx, int eIdx) {
    if (sIdx > eIdx) {
      return -1;
    }
    int midIdx = sIdx + (eIdx - sIdx) / 2;
    if (arr[midIdx] == key) {
      return midIdx;
    }
    if (key < arr[midIdx]) {
      return searchRecursive(arr, key, sIdx, midIdx - 1);
    } else {
      return searchRecursive(arr, key, midIdx + 1, eIdx);
    }
  }
}

package LinearSearch;

public class Main {
  public static void main(String[] args) {
    int[] arr = { 4, 435, 23, 22, 5, 2, 8, 67 };
    int idx = search(arr, 67);
    System.out.println(idx);
  }

  public static int search(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
      if (key == arr[i]) {
        return i;
      }
    }
    return -1;
  }
}

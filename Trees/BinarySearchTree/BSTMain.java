public class BSTMain {
    public static void main(String[] args) {
        BstClass tree = new BstClass();

        int[] arr = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        tree.traversal();
        System.out.println();
        tree.delete(1);
        tree.traversal();
        // System.out.println(tree.search(8));

    }
}

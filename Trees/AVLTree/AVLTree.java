package AVLTree;

public class AVLTree {
    Node rootNode;

    public void insert(int data) {
        rootNode = insert(data, rootNode);
    }

    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(data, node.left);
        } else {
            node.right = insert(data, node.right);
        }

        return balance(node);
    }

    private Node balance(Node node) {
        if (isBalance(node))
            return node;
        if (balanceFactor(node) > 1) {
            if (balanceFactor(node.left) >= 0) {
                return rotateRight(node);
            }
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else {
            if (balanceFactor(node.right) <= 0) {
                return rotateLeft(node);
            }
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
    }

    private boolean isBalance(Node node) {
        return Math.abs(balanceFactor(node)) < 2;
    }

    private Node rotateLeft(Node node) {
        Node rChild = node.right;
        node.right = rChild.left;
        rChild.left = node;
        return rChild;
    }

    private Node rotateRight(Node node) {
        Node lChild = node.left;
        node.left = lChild.right;
        lChild.right = node;
        return lChild;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.right), height(node.left)) + 1;
    }

    public void traversal() {
        preOrder(rootNode);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);

    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }
}

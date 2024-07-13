package AVLTree;

public class AVLClass {
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
        if (isBalance(node)) {
            return node;
        }
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

    private Node rotateRight(Node node) {
        Node lChild = node.left;
        node.left = lChild.right;
        lChild.right = node;
        return lChild;
    }

    private Node rotateLeft(Node node) {
        Node rChild = node.right;
        node.right = rChild.left;
        rChild.left = node;
        return rChild;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isBalance(Node node) {
        return Math.abs(balanceFactor(node)) < 2;
    }

    public int delete(int key) {
        return (delete(key, rootNode).data);
    }

    private Node delete(int key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.data > key) {
            node.left = delete(key, node.left);
        } else if (node.data < key) {
            node.right = delete(key, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node in = inSu(node.right);
            node.data = in.data;
            node.right = delete(in.data, node.right);
        }
        return balance(node);
    }

    private Node inSu(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

public class BSTree {

    Node rootNode = null;

    public void insert(int data) {
        if (rootNode == null) {
            rootNode = new Node(data);
            return;
        }
        insert(data, rootNode);
    }

    private void insert(int data, Node parent) {
        if (data >= parent.data) {
            if (parent.right == null) {
                parent.right = new Node(data);
                return;
            }
            insert(data, parent.right);
        } else {
            if (parent.left == null) {
                parent.left = new Node(data);
                return;
            }
            insert(data, parent.left);
        }
    }

    public void traversal() {
        inOrder(rootNode);
    }

    public Node delete(int key) {
        return delete(key, rootNode);
    }

    private Node delete(int key, Node root) {
        if (root == null) {
            return null;
        }
        if (root.data > key) {
            root.left = delete(key, root.left);
        } else if (root.data < key) {
            root.right = delete(key, root.right);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node inSuccessor = inOrderSuccessor(root.right);
            root.data = inSuccessor.data;
            root.right = delete(inSuccessor.data, root.right);
        }
        return root;
    }

    private Node inOrderSuccessor(Node n) {
        while (n.left != null) {
            n = n.left;

        }
        return n;
    }

    public Node search(int value) {
        return search(value, rootNode);
    }

    private Node search(int value, Node n) {

        if (n == null) {
            return null;
        }
        if (n.data == value) {
            return n;
        }

        if (value >= n.data) {
            return search(value, n.right);
        } else {
            return search(value, n.left);
        }

    }

    public void inOrder(Node n) {
        if (n == null) {
            return;
        }
        inOrder(n.left);
        System.out.print(n.data + "  ");
        inOrder(n.right);
    }

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

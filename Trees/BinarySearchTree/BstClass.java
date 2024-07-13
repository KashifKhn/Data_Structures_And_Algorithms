public class BstClass {

    Node rootNode;

    public void insert(int data) {
        rootNode = insert(data, rootNode);
    }

    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data >= node.data) {
            node.right = insert(data, node.right);
        } else {
            node.left = insert(data, node.left);
        }
        return node;
    }

    public Node search(int key) {
        return search(key, rootNode);
    }

    private Node search(int key, Node node) {
        if (node == null) {
            return null;
        }

        if (key == node.data) {
            return node;
        }

        if (key < node.data) {
            return search(key, node.left);
        } else {
            return search(key, node.right);
        }
    }

    public int delete(int key) {
        return delete(key, rootNode).data;
    }

    private Node delete(int key, Node node) {
        if (node == null) {
            return null;
        }
        if (key < node.data) {
            node.left = delete(key, node.left);
        } else if (key > node.data) {
            node.right = delete(key, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.right;
            }
            Node inSuc = inSuccessor(node.right);
            node.data = inSuc.data;
            node.right = delete(inSuc.data, node.right);
        }
        return node;
    }

    private Node inSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void traversal() {
        inOrder(rootNode);
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

public class Tree<T> {

    Node rootNode;

    public void insertRoot(T data) {
        if (rootNode == null) {
            Node newNode = new Node(data);
            rootNode = newNode;
            return;
        }
        System.out.println("Root already have filled");
    }

    public void insertLeft(T data, T parent) {
        if (rootNode == null) {
            System.out.println("Root is Not filled Yet");
            return;
        }
        Node parentNode = search(rootNode, parent);

        if (parentNode == null) {
            System.out.println("Parent Node not founded");
            return;
        }

        if (parentNode.left != null) {
            System.out.println("left already Filled");
            return;
        }
        Node newNode = new Node(data);
        parentNode.left = newNode;
    }

    public void insertRight(T data, T parent) {
        if (rootNode == null) {
            System.out.println("Root is Not filled Yet");
            return;
        }

        Node parentNode = search(rootNode, parent);

        if (parentNode == null) {
            System.out.println("Parent Node not founded");
            return;
        }

        if (parentNode.right != null) {
            System.out.println("Right already filled");
            return;
        }

        Node newNode = new Node(data);
        parentNode.right = newNode;
    }

    public Node search(Node root, T key) {
        if (root == null) {
            return null;
        }

        if (root.data.equals(key)) {
            return root;
        }
        Node leftResult = search(root.left, key);
        if (leftResult != null) {
            return leftResult;
        }

        return search(root.right, key);
    }

    public void traversal(int option) {
        if (option == 0) {
            preOrder(rootNode);
        } else if (option == 1) {
            inOrder(rootNode);
        } else if (option == 2) {
            postOrder(rootNode);
        } else {
            System.out.println("Wrong Option");
        }

    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

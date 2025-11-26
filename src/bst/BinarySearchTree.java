public class BinarySearchTree {
    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private void insertIterative(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key < current.value) {
                current = current.left;
            } else if (key > current.value) {
                current = current.right;
            } else {
                return;
            }
        }
        if (key < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    private Node insertRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }

        if (key < current.value) {
            current.left = insertRecursive(current.left, key);
        } else if (key > current.value) {
            current.right = insertRecursive(current.right, key);
        }

        return current;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Let's build the tree: 50, 30, 20, 40, 70, 60, 80
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println("Tree created successfully.");
    }
}

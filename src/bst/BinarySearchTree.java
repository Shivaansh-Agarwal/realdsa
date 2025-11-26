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

    public void printBST(BSTTraversalType type) {
        if (type == BSTTraversalType.IN_ORDER) {
            System.out.println("\nIN_ORDER Traversal");
            printInOrder(root);
            System.out.println(); 
        } else if (type == BSTTraversalType.PRE_ORDER) {
            System.out.println("\nPRE_ORDER Traversal");
            printPreOrder(root);
            System.out.println();
        } else if (type == BSTTraversalType.POST_ORDER) {
            System.out.println("\nPOST_ORDER Traversal");
            printPostOrder(root);
            System.out.println();
        }
    }

    private void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    private void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
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

        bst.printBST(BSTTraversalType.PRE_ORDER);
        bst.printBST(BSTTraversalType.IN_ORDER);
        bst.printBST(BSTTraversalType.POST_ORDER);
    }
}
enum BSTTraversalType {
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER;
}
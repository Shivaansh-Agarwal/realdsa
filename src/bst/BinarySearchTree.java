class BinarySearchTree {
    private class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int x) {
        // root = insertRecursive(root, x);
        root = insertIterative(root, x);
    }

    private Node insertRecursive(Node root, int x) {
        Node newNode = new Node(x);
        if (root == null) {
            return newNode;
        }
        if (root.key < x) {
            root.right = insertRecursive(root.right, x);
        } else if (root.key > x) {
            root.left = insertRecursive(root.left, x);
        }
        return root;
    }

    private Node insertIterative(Node root, int x) {
        Node newNode = new Node(x);
        if (root == null) {
            return newNode;
        }
        Node curr = root;
        Node parent = root;
        while (curr != null) {
            parent = curr;
            if (curr.key < x) {
                curr = curr.right;
            } else if (curr.key > x) {
                curr = curr.left;
            }
        }
        if (parent.key < x) {
            parent.right = newNode;
        } else if (parent.key > x) {
            parent.left = newNode;
        }
        return root;
    }

    public void print(TraversalTypeEnum traversalType) {
        switch (traversalType) {
            case IN_ORDER:
                System.out.print("IN_ORDER: ");
                inorderTraversal(root);
                System.out.println();
                break;
            case PRE_ORDER:
                System.out.print("PRE_ORDER: ");
                preorderTraversal(root);
                System.out.println();
                break;
            case POST_ORDER:
                System.out.print("POST_ORDER: ");
                postorderTraversal(root);
                System.out.println();
                break;
        }
    }

    private void inorderTraversal(Node root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.key + ", ");
        inorderTraversal(root.right);
    }

    private void preorderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.key + ", ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private void postorderTraversal(Node root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.key + ", ");
    }

    public void search(int x) {
        // boolean isKeyPresent = searchRecursive(root, x);
        boolean isKeyPresent = searchIterative(root, x);
        System.out.println("is " + x +" present? " + isKeyPresent);
    }

    private boolean searchRecursive(Node root, int x) {
        if (root == null) {
            return false;
        } else if (root.key == x) {
            return true;
        } else if (root.key < x) {
            return searchRecursive(root.right, x);
        } else if (root.key > x) {
            return searchRecursive(root.left, x);
        }
        return false;
    }

    private boolean searchIterative(Node root, int x) {
        Node curr = root;
        while (curr != null) {
            if (curr.key == x) {
                return true;
            } else if (curr.key < x) {
                curr = curr.right;
            } else if (curr.key > x) {
                curr = curr.left;
            }
        }
        return false;
    }

    public void delete(int x) {
        deleteNodeRecursive(root, x);
    }

    private Node deleteNodeRecursive(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.key > x) {
            root.left = deleteNodeRecursive(root.left, x);
        } else if (root.key < x) {
            root.right = deleteNodeRecursive(root.right, x);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                Node successor = getSuccessor(root);
                root.key = successor.key;
                root.right = deleteNodeRecursive(root.right, successor.key);
            }
            return root;
        }
        return root;
    }

    private Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

}

enum TraversalTypeEnum {
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER
}

class Solution {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(10);
        bst.insert(40);
        bst.insert(30);

        bst.print(TraversalTypeEnum.IN_ORDER);
        bst.print(TraversalTypeEnum.PRE_ORDER);
        bst.print(TraversalTypeEnum.POST_ORDER);

        bst.search(10);
        bst.search(22);
    }
}

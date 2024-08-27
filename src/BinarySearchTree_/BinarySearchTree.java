package BinarySearchTree_;

import utils.printer.BinaryTreeInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BinarySearchTree implements BinaryTreeInfo {
    private int size;

    private Node root;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Integer value) {
        Node current = root;
        while (current != null) {
            if (value > current.value) {
                current = current.right;
            } else if (value < current.value) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public void add(Integer newValue) {

        if (newValue == null) {
            throw new IllegalArgumentException("Value must not be null.");
        }

        final Node newNode = new Node(newValue);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;
        int compareResult = 0;
        while (current != null) {
            parent = current;
            compareResult = newValue - current.value;
            if (compareResult < 0) {
                current = current.left;
            } else if (compareResult > 0) {
                current = current.right;
            } else {
                return;
            }
        }

        if (compareResult < 0) {
            parent.left = newNode;
        } else if (compareResult > 0) {
            parent.right = newNode;
        }
        newNode.parent = parent;

        size++;
    }


    public void remove(Integer value) {
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        Node n = (Node) node;
        return n.left;
    }

    @Override
    public Object right(Object node) {
        Node n = (Node) node;
        return n.right;
    }

    @Override
    public Object string(Object node) {
        Node n = (Node) node;
        return n.value + "_p(" + (n.parent != null ? n.parent.value : "null") + ")";
    }

    /**
     * 前序遍历
     */
    public void preorderTraversal() {
        final ArrayList<Integer> arrayList = new ArrayList<>(size);
        preorderTraversal(root, arrayList);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    private void preorderTraversal(Node root, final ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        arrayList.add(root.value);
        preorderTraversal(root.left, arrayList);
        preorderTraversal(root.right, arrayList);
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal() {
        final ArrayList<Integer> arrayList = new ArrayList<>(size);
        inorderTraversal(root, arrayList);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    private void inorderTraversal(Node root, final ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arrayList);
        arrayList.add(root.value);
        inorderTraversal(root.right, arrayList);
    }

    /**
     * 后序遍历
     */
    public void postorderTraversal() {
        final ArrayList<Integer> arrayList = new ArrayList<>(size);
        postorderTraversal(root, arrayList);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    private void postorderTraversal(Node root, final ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, arrayList);
        postorderTraversal(root.right, arrayList);
        arrayList.add(root.value);
    }

    public void levelOrderTraversal() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Node> linkedList = new LinkedList<>();

        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            final Node node = linkedList.pop();
            arrayList.add(node.value);
            if (node.left != null) {
                linkedList.addLast(node.left);
            }

            if (node.right != null) {
                linkedList.addLast(node.right);
            }
        }

        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    /**
     * @return 树的高度
     */
    public int heightByRecursively() {
        return heightByRecursively(root);
    }

    /**
     * @param root The root of a tree or a subtree
     * @return The height
     */
    private int heightByRecursively(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightByRecursively(root.left), heightByRecursively(root.right));
    }

    public int heightByIterate() {
        if (root == null) {
            return 0;
        }

        int height = 0;
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        int rowSize = 1;

        while (!linkedList.isEmpty()) {
            final Node node = linkedList.pop();
            rowSize--;

            if (node.left != null) {
                linkedList.add(node.left);
            }

            if (node.right != null) {
                linkedList.add(node.right);
            }

            if (rowSize == 0) {
                ++height;
                rowSize = linkedList.size();
            }
        }

        return height;
    }

    private static class Node {
        Integer value;
        Node left;
        Node right;
        Node parent;

        public Node(Integer value) {
            this.value = value;
        }


        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

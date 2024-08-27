package BinarySearchTree_;

import utils.printer.BinaryTrees;

import java.util.Random;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < 1000; i++) {
            final Random random = new Random();
            final int num = random.nextInt(100, 999);
            bst.add(num);
        }

        BinaryTrees.println(bst);

        System.out.println("Preorder Traversal:");
        bst.preorderTraversal();

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();

        System.out.println("Postorder Traversal:");
        bst.postorderTraversal();

        System.out.println("Level Order Traversal:");
        bst.levelOrderTraversal();

        System.out.println("Height: " + bst.heightByRecursively());
        System.out.println("Height: " + bst.heightByIterate());

        System.out.println("Size: " + bst.getSize());

        System.out.println("done");
    }
}

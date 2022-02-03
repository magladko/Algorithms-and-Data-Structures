package dataStructures;

import javax.swing.tree.TreeCellRenderer;
import java.net.BindException;

class BinaryTree {
    // Root of Binary Tree
    TreeNode root;

    // Driver method
    public static void main(String[] args) {

    }


    BinaryTree() { root = null; }

    BinaryTree(TreeNode root) { this.root = root; }

    public static BinaryTree fromHeapArr(int[] arr) {
        BinaryTree tree = new BinaryTree();

        tree.root = tree.heapInsert(arr, tree.root, 0, arr.length-1);


//        TreeNode tmp = tree.root;
//        for (int i = 1; 2*i+1 < arr.length; i++) {
//            tmp.left = new TreeNode(arr[2*i+1]);
//            if (2*i+2 < arr.length) tmp.right = new TreeNode(arr[2*i+2]);


//            tmp = new TreeNode(arr[i]);
//            tmp.left = new TreeNode(arr[2*i+1]);
//            if (2*i+2 < arr.length) tmp.right = new TreeNode(arr[2*i+2]);

//            for (int j = i; j < ; j++) {
//
//            }

        return tree;
//        for (int i = 1; 2*i < arr.length; i++) {
//            tree.root.right = new TreeNode(arr[2*i-1]);
//            tree.root.left = new TreeNode(arr[2*i]);
//        }
    }

    TreeNode heapInsert(int[] arr, TreeNode node, int start, int end) {
        if (node == null) node = new TreeNode(arr[start]);
        if (2*(start+1)-1 <= end)
            node.left = heapInsert(arr, new TreeNode(arr[2*(start+1)-1]), 2*(start+1)-1, end);

        if (2*(start+1)+1-1 <= end)
            node.right = heapInsert(arr, new TreeNode(arr[2*(start+1)+1-1]), 2*(start+1)+1-1, end);

        return node;
    }

    int findHeight(TreeNode aNode) {
        if (aNode == null) {
            return -1;
        }

        int lefth = findHeight(aNode.left);
        int righth = findHeight(aNode.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    /* PRINTING */

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    public static void printPostorder(TreeNode node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    public static void printInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    public static void printPreorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        System.out.print("POST:\t");
        printPostorder(root);
        System.out.println();
    }
    void printInorder() {
        System.out.print("IN: \t");
        printInorder(root);
        System.out.println();
    }
    void printPreorder() {
        System.out.print("PRE:\t");
        printPreorder(root);
        System.out.println();
    }

}
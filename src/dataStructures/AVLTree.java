package dataStructures;

import com.BTreePrinter;

public class AVLTree extends BSTTree {

    int rotationCounterL;
    int rotationCounterR;
    int rotationCounterRL;
    int rotationCounterLR;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree(
//                new int[]{1,2,3,4,5,6,7,8,9}
//                new int[]{4,2,7,1,3,6,8,5,9}
//                new int[]{19,7,13,12,9,3,18,5,8,6}
//                new int[]{9,2,6,18,8,19,12,13,3,11}
//                new int[]{2,7,15,18,8,14,0,3,4,1}
//                new int[]{12,18,5,16,7,4,17,3,11,9}
//                new int[]{1,11,13,7,15,5,17,0,2,4}
//                new int[]{14,12,9,10,4,11,8,7,19,1}
//                new int[]{14,10,2,12,15,1,5,9,13,0}
//                new int[]{17,11,19,8,18,10,1,14,9,4}
//                new int[]{13,9,7,12,10,4,3,6,11,17}
//                new int[]{6,3,8,2,4,7,9,1,5}
//                new int[]{4,2,7,1,3,6,8,5,9}
//                new int[]{1,2,3,4,5,6,7,8,9}
//                new int[]{14,10,2,12,15,1,5,9,13,0}
//                new int[]{16,11,5,6,15,19,8,13,4,0}
                new int[]{14,18,7,6,5,3,8,15,1,9}
        );
        BTreePrinter.printNode(tree.root);

//        AVLTree tree1 = new AVLTree(new BSTTree(new int[]{5,3,1,2,4,7,6}).root); // from PREORDER
//        BTreePrinter.printNode(tree1.root);

        DelType delType = DelType.SUCC;
        int[] toDel = {10,12,9};
//
//        tree.delete(toDel[0], delType);
//        BTreePrinter.printNode(tree.root);
//        tree.delete(toDel[1], delType);
//        BTreePrinter.printNode(tree.root);
//        tree.delete(toDel[2], delType);
//        BTreePrinter.printNode(tree.root);


        tree.printTreeDetails();
//        tree1.printTreeDetails();
    }

    public AVLTree(TreeNode root) {
        rotationCounterL = 0;
        rotationCounterR = 0;
        rotationCounterRL = 0;
        rotationCounterLR = 0;
        this.root = root;
        recUpdateHeight(this.root);
    }

    public AVLTree(int[] arr) {
        rotationCounterL = 0;
        rotationCounterR = 0;
        rotationCounterRL = 0;
        rotationCounterLR = 0;
        root = insertArr(root, arr);
    }

    @Override
    public TreeNode insertArr(TreeNode root, int[] arr) {
        for (int e : arr) {
            this.root = insert(this.root, e);
        }
        return this.root;
    }

    @Override
    public TreeNode insert(TreeNode node, Integer key) {

        if (node == null) {
            return new TreeNode(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    @Override
    public void delete(int key, DelType b) {
        this.root = recDelete(this.root, key, b);
    }

    public TreeNode recDelete(TreeNode node, int key, DelType b) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = recDelete(node.left, key, b);
        } else if (node.key < key) {
            node.right = recDelete(node.right, key, b);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                if (b == DelType.SUCC) {
                    TreeNode mostLeftChild = mostLeftChild(node.right);
                    node.key = mostLeftChild.key;
                    node.right = recDelete(node.right, node.key, b);
                } else {
                    TreeNode mostRightChild = mostRightChild(node.left);
                    node.key = mostRightChild.key;
                    node.left = recDelete(node.left, node.key, b);
                }
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    void updateHeight(TreeNode n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    void recUpdateHeight(TreeNode n) {
        if (n == null)
            return;

        // first recur on left subtree
//        rebalance(n);
        recUpdateHeight(n.left);
        updateHeight(n);

        // then recur on right subtree
//        rebalance(n);
        recUpdateHeight(n.right);
        updateHeight(n);
    }

    int height(TreeNode n) {
        return n == null ? -1 : n.height;
    }

    int getBalance(TreeNode n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    TreeNode rebalance(TreeNode z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                // LEFT
                rotationCounterL++;

                z = rotateLeft(z);
            } else {
                // RIGHT-LEFT
                rotationCounterRL++;

                z.right = rotateRight(z.right);

                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                // RIGHT
                rotationCounterR++;

                z = rotateRight(z);
            }
            else {
                // LEFT-RIGHT
                rotationCounterLR++;

                z.left = rotateLeft(z.left);

                z = rotateRight(z);
            }
        }
        return z;
    }

    TreeNode rotateLeft(TreeNode y) {

        TreeNode x = y.right;
        TreeNode z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    TreeNode rotateRight(TreeNode y) {
//        rotationCounterR++;

        TreeNode x = y.left;
        TreeNode z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public TreeNode mostLeftChild(TreeNode node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public TreeNode mostRightChild(TreeNode node) {
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public void printRotationCount() {
        System.out.println("ROTATIONS:");
        System.out.println("TOTAL:\t" + (rotationCounterL+rotationCounterR+rotationCounterRL+rotationCounterLR));
        System.out.println(
                "LEFT:\t" + rotationCounterL +
                        "\nRIGHT:\t" + rotationCounterR +
                        "\nRIGHT-LEFT:\t" + rotationCounterRL +
                        "\nLEFT-RIGHT:\t" + rotationCounterLR);
    }
    public void printTreeDetails() {
        this.printRotationCount();
        System.out.println();
        this.printInorder();
        this.printPostorder();
        this.printPreorder();
        System.out.println("\nHeight: " + this.height(this.root));
    }
}

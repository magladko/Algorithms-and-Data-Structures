package dataStructures;

import com.BTreePrinter;

import java.util.Objects;

public class BSTTree extends BinaryTree {

    public enum DelType {
        SUCC, PRED
    }

//    TreeNode root;

    public static void main(String[] args) {

        BSTTree tree = new BSTTree(
//                new int[]{9,19,14,7,12,18,13,16,17,1}
//                new int[]{9,14,16,6,4,7,13,2,0,5}
//                new int[]{8,2,4,7,6,1,3,0,5}
//                new int[]{1,4,3,2,5,0,6}
//                new int[]{9,15,4,3,19,5,14,11,19,13}
//                new int[]{7,3,18,1,0,12,13,4,11,19}
//                new int[]{16,17,18,9,6,11,5,8,0,13}
//                new int[]{17,7,12,8,16,3,19,18,5,9}
                new int[]{2,0,16,10,4,13,14,3,5,11}
        );


        DelType delType = DelType.PRED;
        int[] toDel = {4,16,11};
//
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[0], delType);
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[1], delType);
        BTreePrinter.printNode(tree.root);
        tree.delete(toDel[2], delType);
        BTreePrinter.printNode(tree.root);

        tree.printPreorder();
        tree.printPostorder();
        tree.printInorder();

//        tree.printPreorder();
//        System.out.println();



        System.out.println(tree.findHeight(tree.root));

    }

    public BSTTree(int[] arr) {
        root = insertArr(root, arr);
    }

    public BSTTree() {}

    public boolean member(TreeNode root, Integer e) {
        while (root != null) {
            if (Objects.equals(root.key, e)) return true;
            else if (root.key > e) root = root.getLeft();
            else root = root.right;
        }
        return false;
    }

    public TreeNode insertArr(TreeNode root, int[] arr) {
        for (int e : arr) {
            root = insert(root, e);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, Integer e) {
        TreeNode tmp = root;

        if (root == null) return new TreeNode(e);

        while (true) {
            if (tmp.getKey() == e) return root;
            if (tmp.getKey() > e) {
                if (tmp.getLeft() != null) tmp = tmp.getLeft();
                else {
                    tmp.setLeft(new TreeNode(e));
                    return root;
                }
            } else {
                if (tmp.getRight() != null) tmp = tmp.getRight();
                else {
                    tmp.setRight(new TreeNode(e));
                    return root;
                }
            }
        }
    }

    /*// PRED/SUCC?
    public TreeNode deleteNode(TreeNode root, int key*//*, DelType delType*//*) {
        if(root == null) return root;
        if(key > root.key){ //move right
            root.right = deleteNode(root.right, key*//*, delType*//*);
        }else if(key < root.key){ //move left
            root.left = deleteNode(root.left, key*//*, delType*//*);
        }else{ //oh yes, we finally found the target
            if(root.left == null && root.right == null){ //hmm, its a leaf node; easy peasy
                root = null;
            }else if(root.right != null){ // oh, it has a right child, don't make it an orphan or is it old enough to become a parent ? lets find out
                root.key = successor(root); // my worthy successor
                root.right = deleteNode(root.right, root.key*//*, delType*//*);
            }else{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
                root.key = predecessor(root);
                root.left = deleteNode(root.left, root.key*//*, delType*//*);
            }
        }
        return root;
    }*/

    public void delete(int key, DelType b) {
        // x: usuwany węzeł
        // parent: rodzic usuwanego węzła
        // z: zamiennik usuwanego węzła
        // t: rodzic zamiennika


        TreeNode t, x, parent, z;
        TreeNode[] temp = new TreeNode[]{null};
        x = recSearch(key, root, temp);
//        z = x;
        parent = temp[0];

        if (x!=null) {
            if ((x.left == null) || (x.right == null)) {
                if ((x.left == null) && (x.right == null)) z = null;
                else if (x.left == null) z = x.right;
                else z = x.left;
                if (parent == null) root = z;
                else if (x == parent.left) parent.left = z;
                else parent.right = z;
            } else {
                if (b.equals(DelType.PRED)) {
                    z = x.left;
                    if (z.right == null) x.left = z.left;
                    else {
                        do {
                            t = z;
                            z = z.right;
                        } while (z.right != null);
                        t.right = z.left;
                    }
                } else {
                    z = x.right;
                    if (z.left == null) x.right = z.right;
                    else {
                        do {
                            t = z;
                            z = z.left;
                        } while (z.left != null);
                        t.left = z.right;
                    }
                }
                x.key = z.key;
            }
        }
//        return t;
    }

    public TreeNode recSearch(int key, TreeNode ro, TreeNode[] prev) {
        if (ro == null) return null;
        else
            if (ro.key == key) return ro;
            else {
                prev[0] = ro;
                if (key < ro.key) return recSearch(key, ro.left, prev);
                else return recSearch(key, ro.right, prev);
            }
    }

    private int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.key;
    }

    private int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.key;
    }

//    public boolean delete (TreeNode root, Integer e, DelType delType) {
//        TreeNode tmp = root;
//
//        if (root == null) return false;
//
//        while (true) {
//            if (tmp.getKey() == e) {
//                if (delType == DelType.SUCC) {
//                    TreeNode succ = tmp.getLeft() == null ? tmp.getRight() : tmp.getLeft();
//                    if (succ == null)
//                    tmp =
//                }
//                return true;
//            }
//            if (tmp.getKey() > e) {
//                if (tmp.getLeft() != null) tmp = tmp.getLeft();
//                else {
//                    tmp.setLeft(new TreeNode(e));
//                    return root;
//                }
//            } else {
//                if (tmp.getRight() != null) tmp = tmp.getRight();
//                else {
//                    tmp.setRight(new TreeNode(e));
//                    return root;
//                }
//            }
//        }
//    }

}

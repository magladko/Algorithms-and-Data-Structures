package dataStructures;

public class TreeNode {

    public Integer key;
    public TreeNode left;
    public TreeNode right;
    public Integer height;

    public TreeNode() {
        this.height = 0;
    }

    public TreeNode(Integer key) {
        this.key = key;
        left = null;
        right = null;
        height = 0;
    }

    public Integer getKey() {
        return key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

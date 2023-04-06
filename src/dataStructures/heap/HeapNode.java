package dataStructures.heap;

import dataStructures.TreeNode;

public class HeapNode extends TreeNode {

    public HeapNode parent;
    public HeapNode prev;
    public HeapNode next;

    public HeapNode() {
        parent = null;
        left = null;
        right = null;
        prev = null;
        next = null;
    }

    public HeapNode (Integer val) {
        parent = null;
        left = null;
        right = null;
        prev = null;
        next = null;
        this.key = val;
    }

    public HeapNode (TreeNode node) {
        parent = null;
        left = null;
        right = null;
        prev = null;
        next = null;
    }

}

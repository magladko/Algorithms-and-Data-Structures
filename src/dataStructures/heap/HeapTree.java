/*
package dataStructures.heap;

import dataStructures.BinaryTree;
import dataStructures.TreeNode;

public class HeapTree extends BinaryTree {

    public HeapNode root;
    public HeapNode last_inner_node;
    public HeapNode last_outer_node;

    public static void main(String[] args) {

    }

    public HeapTree() {
        this.root = null;
    }

    public HeapTree(int val) {
        this.root = newHeapNode(val);
    }

    HeapTree heapFastConstruct(int[] e) {
        HeapTree H;
        HeapNode tmp;

        H = build_initial_tree(e);

    }

    private HeapTree build_initial_tree(int[] arr) {

        HeapTree h = new HeapTree(arr[0]);
        HeapNode tmp;

        h.heapInsert(arr, h.root, 0, arr.length-1);
        return h;
    }

}
*/

package dataStructures.heap;

import com.BTreePrinter;
import dataStructures.BinaryTree;

import java.util.Arrays;

public class MinHeap1 {

    static int[] heap = new int[1000];
    static int n;
    static int przestawienia;
    static int compareCount;

    public static void main(String[] args) {
        Arrays.fill(heap, Integer.MAX_VALUE);

        // 0. INDEKS POMIJANY!!
//        a = new int[]{-1,11, 13, 19, 1, 18, 5, 8, 17, 12, 15};
//        a = new int[]{-1,15,14,9,11,13,17,5,3,7,1};
//        a = new int[]{-1,2,16,3,18,14,15,7,5,19,9};
//        a = new int[]{-1,11,13,19,1,18,5,8,17,12,15};
        int[] a = new int[]{12, 10, 4, 8, 6, 15, 1, 13, 11, 0};

        przestawienia = 0;
        compareCount = 0;

        n = a.length;

        construct(a);

        printUsedPart();
//        System.out.println(Arrays.toString(a));
//        delmin();
//        delmin();
//        delmin();
//        printUsedPart();


        a = Arrays.stream(a).skip(1).toArray();
//        System.out.println(Arrays.toString(a));
        BinaryTree tree = BinaryTree.fromHeapArr(a);
        BTreePrinter.printNode(tree.root);

        System.out.println("przestawien: " + przestawienia);
        System.out.println("porówań: " + compareCount);
        tree.printInorder();
        tree.printPostorder();
        tree.printPreorder();
        System.out.println("Height: " + tree.findHeight(tree.root));

//        int[] res = Arrays.stream(a).filter(e -> e != -1).toArray();
//        System.out.println(Arrays.toString(res));
    }

    public static void construct(int[] a) {
        int i;

        System.arraycopy(a, 0, heap, 0, a.length);

        for (i = n/2; i >= 0; i--) {
            downHeap(i);
        }
    }

    public static void downHeap(int k) {
        int l = 2*k, v = heap[k];

        while (l <=n) {
            if ((l<n) && ((compareCount++>-1) && heap[l] > heap[l+1])) l++;
            if ((compareCount++>-1) && v > heap[l]) {
                przestawienia++;
                heap[k] = heap[l];
                k = l;
                l*=2;
            } else l = n+1;
        }
        heap[k] = v;
    }

    public static void delmin() {
        heap[0] = heap[n-1];
        heap[n-1] = Integer.MAX_VALUE;

        if (n > 0) {
            downHeap(1);
        }
    }

    public static void printUsedPart() {
        for (int i = 0; i < n-1; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.print(heap[n-1]);
        System.out.println();
    }

}

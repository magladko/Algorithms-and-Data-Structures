package dataStructures;

import com.BTreePrinter;

import java.util.Arrays;

public class MinHeap {

    static int[] a;
    static int n;
    static int przestawienia;
    static int compareCount;

    public static void main(String[] args) {
        // 0. INDEKS POMIJANY!!
//        a = new int[]{-1,11, 13, 19, 1, 18, 5, 8, 17, 12, 15};
//        a = new int[]{-1,15,14,9,11,13,17,5,3,7,1};
//        a = new int[]{-1,2,16,3,18,14,15,7,5,19,9};
        a = new int[]{-1,11,13,19,1,18,5,8,17,12,15};

        przestawienia = 0;
        compareCount = 0;

        n = a.length-1;
        construct();
        printUsedPart();
//        System.out.println(Arrays.toString(a));
        delmin();
        delmin();
        delmin();
        printUsedPart();


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

    public static void construct() {
        int i;

        for (i = n/2; i > 0; i--) {
            downHeap(i);
        }
    }

    public static void downHeap(int k) {
        int l = 2*k, v = a[k];

        while (l <=n) {
            if ((l<n) && ((compareCount++>-1) && a[l] > a[l+1])) l++;
            if ((compareCount++>-1) && v > a[l]) {
                przestawienia++;
                a[k] = a[l];
                k = l;
                l*=2;
            } else l = n+1;
        }
        a[k] = v;
    }

    public static void delmin() {
        a[1] = a[n];
        a = Arrays.copyOf(a, n--);

        if (n > 0) {
            downHeap(1);
        }
    }

    public static void printUsedPart() {
        for (int i = 1; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[n]);
        System.out.println();
    }

}

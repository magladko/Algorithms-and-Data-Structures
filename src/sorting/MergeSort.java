package sorting;

import java.util.Arrays;

public class MergeSort {

    static int execCount;
    static int treeHeight;
    static int maxTreeHeight;

    public static void main(String[] args) {
        MergeSort ob = new MergeSort();

//        int[] a1 = {5,16,3,14,17,1,19,11,18,9,10};
//        int[] a1 = {5,16,3,14,17,1,19,11,18,9,10};
//        int[] a2 = {3,12,10,6,0,16,9,4};
//        int[] a3 = {10,9,16,8,1,4,15,13,12};
//        int[] a1 = {0,1,8,9,5,6,4,12,10,7,19};
//        int[] a2 = {3,12,10,6,0,16,9,4};
//        int[] a3 = {10,9,16,8,1,4,15,13,12};
//        int[] a1 = {7,4,0,14,12,9,2,19,5,16,17};
//        int[] a2 = {5,8,4,14,17,7,12,10,1,6,0,16,3,2,15};
//        int[] a3 = {14,4,0,19,18,16,9,7,8,13,1,6,2};
        int[] a1 = {14,18,9,4,11,19,7,2,13,6,0};
        int[] a2 = {0,15,9,2,19,6,1,18,3,8,14};

        ob.init(a1);
        ob.init(a2);
//        ob.init(a3);
    }

    public void init(int[] a) {
        execCount = 0;
        treeHeight = 0;
        maxTreeHeight = 0;

        System.out.println();
        System.out.println(Arrays.toString(a) + ": ");
        sortuj(a);

        System.out.println(Arrays.toString(a));
        System.out.println("liczba wykonań (rozgałęzień): " + execCount);
        System.out.println("tree height: " + maxTreeHeight);
        System.out.println();
    }

    private void scal(int le, int sr, int pr, int[] arr) {
        int i = le;
        int j = sr+1;
        int k = -1;

        int[] b = new int[pr-le+1];

        while ((i <= sr) && (j <= pr)) {
            k++;
            if (arr[i] <= arr[j]) {
                b[k] = arr[i];
                i++;
            } else {
                b[k] = arr[j];
                j++;
            }
        }

        if (i <= sr) {
            for (j = pr; j > le+k; j--) {
                arr[j] = arr[sr];
                sr--;
            }
        }

        for (i = 0; i <= k; i++) {
            arr[le+i] = b[i];
        }
    }

    private void sortujRek(int le, int pr, int[] arr) {

        System.out.print(execCount + ". H=" + treeHeight + ": ");
        for (int i = le; i <= pr; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();

        int sr = (le + pr) / 2;
        if (le < pr) {
            execCount++;

            if (le <= sr) {
                treeHeight++;
//                printPart(arr, le, sr);
                sortujRek(le, sr, arr);
                if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
                treeHeight--;
            }
            if ((sr + 1) <= pr) {
                treeHeight++;
//                printPart(arr, sr + 1, pr);
                sortujRek(sr + 1, pr, arr);
                if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
                treeHeight--;
            }
        }

        scal(le, sr, pr, arr);
    }

    public void sortuj(int[] arr) {

        if (arr.length >= 2) {
            sortujRek(0, arr.length-1, arr);
        }
    }

    public static void printPart(int[] arr, int l, int r) {
        System.out.print("H=" + treeHeight + ",\t");
        for (int i = l; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

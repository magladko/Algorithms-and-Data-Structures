package sorting;

import java.util.Arrays;

public class MergeSort {

    static int execCount;
    static int treeHeight;
    static int maxTreeHeight;
    static int mergeCount;

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
//        int[] a1 = {14,18,9,4,11,19,7,2,13,6,0};
//        int[] a2 = {0,15,9,2,19,6,1,18,3,8,14};
        int[] a1 = {0,15,5,18,2,9,3,14,8};
        int[] a2 = {5,2,9,3,15,0,18,14};

        ob.init(a1);
        ob.init(a2);
//        ob.init(a3);
    }

    public void init(int[] a) {
        execCount = 0;
        treeHeight = 0;
        maxTreeHeight = 0;
        mergeCount = 0;

        System.out.println();
        System.out.println(Arrays.toString(a) + ": ");
        sortuj(a);

        System.out.println(Arrays.toString(a));
        System.out.println("liczba wykonań (rozgałęzień): " + execCount);
        System.out.println("liczba wywołań rekurencyjnych: " + mergeCount);
        System.out.println("tree height: " + maxTreeHeight);
        System.out.println();
    }

    private void merge(int[] arr, int left, int right) {
        mergeCount++;
        int n = right-left+1;
        int m = left+n/2;

//        int[] tmp = new int[m-left+1];
        int[] tmp = Arrays.copyOfRange(arr, left, m+1);

        int i = left, w1 = 0, w2 = m+1;

        while (w1 < m-left+1 && w2 < right) {
            if (tmp[w1] < arr[w2]) {
                arr[i] = tmp[w1];
                 w1++;
            } else {
                arr[i] = arr[w2];
                w2++;
            }

            i++;
        }
        while (w1 < m-left+1 && w2 == right) {
            arr[i] = tmp[w1];
            i++; w1++;
        }
        while (w1 == m-left+1 && w2 < right) {
            arr[i] = arr[w2];
            i++; w2++;
        }

//        int sr = (pr - le +1)/2;
//
//        int i = le;
//        int j = sr+1;
//        int k = -1;
//
//        int[] b = new int[pr-le+1];
//
//        while ((i <= sr) && (j <= pr)) {
//            k++;
//            if (arr[i] <= arr[j]) {
//                b[k] = arr[i];
//                i++;
//            } else {
//                b[k] = arr[j];
//                j++;
//            }
//        }
//
//        if (i <= sr) {
//            for (j = pr; j > le+k; j--) {
//                arr[j] = arr[sr];
//                sr--;
//            }
//        }
//
//        for (i = 0; i <= k; i++) {
//            arr[le+i] = b[i];
//        }
    }

    private void mergeSort(int[] arr, int left, int right) {

//        System.out.print(mergeCount + ". H=" + treeHeight + ": ");
//        for (int i = left; i <= right; i++) {
//            System.out.print(arr[i] + ", ");
//        }
//        System.out.println();
        int n = right-left+1;

        if (n > 1) {
            if (n / 2 > 1) {
                treeHeight++;
                mergeSort(arr, left, left + n/2 - 1);
                maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
            }
            if (n - n/2 > 1) {
                treeHeight++;
                mergeSort(arr, left + n/2, right);
                maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
            }

            merge(arr, left, right);
        }
    }


//        System.out.print(execCount + ". H=" + treeHeight + ": ");
//        for (int i = le; i <= pr; i++) {
//            System.out.print(arr[i] + ", ");
//        }
//        System.out.println();
//
//        int sr = (le + pr) / 2;
//        if (le < pr) {
//            execCount++;
//
//            if (le <= sr) {
//                treeHeight++;
////                printPart(arr, le, sr);
//                mergeSort(le, sr, arr);
//                maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
//            }
//            if ((sr + 1) <= pr) {
//                treeHeight++;
////                printPart(arr, sr + 1, pr);
//                mergeSort(sr + 1, pr, arr);
//                maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
//            }
//        }
//
//        merge(le, sr, pr, arr);
//    }

    public void sortuj(int[] arr) {

        if (arr.length >= 2) {
            mergeSort(arr, 0, arr.length-1);
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

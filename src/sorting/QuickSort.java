package sorting;

import java.util.Arrays;

public class QuickSort {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int execCount;
    static int partition;
    static int recursionCount;
    static int treeHeight;
    static int maxTreeHeight;

    /**
     * Na generatorach używana jest metoda ustawiająca PIVOT na końcu tablic (quicksortPivotEnd())
     * metoda: com.Partition
     */
    public static void main(String[] args) {
//        int[] a1 = {3,18,13,5,8,14,19,12,4,2,6};
//        int[] a2 = {3,18,2,5,8,13,19,14,4,12,6};
//        int[] a3 = {4,18,19,5,8,14,3,12,6,13,2};
//        int[] a2 = {3,16,6,13,10,4,14,18,0,1,5};
//        int[] a2 = {3,16,6,10,13,4,14,18,0,1,5};
//        int[] a3 = {3,0,6,13,10,5,16,14,4,1,18};
//        int[] a1 = {14,17,0,2,16,19,4,9,1,7,5};
//        int[] a2 = {5,14,0,2,16,19,4,17,1,7,9};
//        int[] a1 = {11,18,7,12,9,0,6,5,17,4,2};
//        int[] a2 = {5,18,7,12,9,0,4,6,17,11,2};
//        int[] a1 = {11,0,9,13,2,14,1,3,18,12,7};
//        int[] a2 = {9,0,7,13,2,14,1,3,18,11,12};
//        int[] a1 = {10,15,0,16,6,19,9,12,4,11,18};
//        int[] a2 = {11,15,18,0,6,16,9,12,4,19,10};
//        int[] a3 = {4,15,0,10,6,19,9,16,11,12,18};
//        int[] a1 = {19,5,12,4,6,10,9,8,16,7,3};
//        int[] a2 = {19,12,5,4,6,10,9,8,16,7,3};
//        int[] a3 = {19,5,12,4,7,10,9,6,16,3,8};
//        int[] a1 = {11,18,7,12,9,0,6,5,17,4,2};
//        int[] a2 = {11,2,7,12,18,4,6,5,0,9,17};
//        int[] a3 = {7,5,18,12,9,0,6,2,17,4,11};
//        int[] a1 = {14,7,19,16,2,13,17,18,8,11,4};
//        int[] a2 = {14,7,2,16,19,13,17,18,8,11,4};
//        int[] a3 = {14,7,19,16,2,13,17,18,11,8,4};
//        int[] a1 = {4,7,2,8,18,11,14,1,0,16,3};
//        int[] a2 = {8,7,2,4,18,11,14,1,0,16,3};
//        int[] a3 = {4,0,18,8,3,11,2,1,14,16,7};
//        int[] a1 = {14,17,0,2,16,19,4,9,1,7,5};
//        int[] a2 = {5,14,0,2,16,19,4,17,1,7,9};
//        int[] a3 = {4,17,0,2,16,14,19,9,1,7,5};
        int[] a1 = {11,9,7,6,4,5,8,13,19,14,15};
        int[] a2 = {11,9,7,6,5,15,8,13,19,4,14};
        int[] a3 = {14,9,7,6,4,5,8,11,19,13,15};

        System.out.println("\nMAIN DATA:");
        execNew(a1);
        execNew(a2);
        execNew(a3);
    }

    public static void execNew(int[] arr) {
        execCount = 0;
        partition = 0;
        recursionCount = 0;
        maxTreeHeight = 0;
        treeHeight = 0;

        System.out.println("FOR: " + Arrays.toString(arr));

        sortujQuickPivotEndPartition(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("partition times: " + partition);
        System.out.println("recursion count: " + execCount);
        System.out.println("max tree height: " + (maxTreeHeight+1)); // o 1 większe z jakiegoś powodu
        System.out.println();
    }

    public static void quickSortPivotEnd(int l, int r, int[] a) {
        int i, j, v, x;

        v = a[r];
        i = l-1;
        j = r;

        System.out.print(execCount + ":\t");
        for (int k = 0; k < a.length; k++) {
            System.out.print(ANSI_RESET);
            if (k == r) {
                System.out.print(ANSI_BLUE);
                System.out.print(a[k] + "\t");
            } else if (k >= l && k < r+1) {
                System.out.print(ANSI_RED);
                System.out.print(a[k] + "\t");
            }
            else {
                System.out.print(a[k] + "\t");
            }
        }
        System.out.println(ANSI_RESET);

        partition++;
        do {
            do {
                i++;
            } while ((i <= r) && (a[i] < v));
            do {
                j--;
            } while (j > l && a[j] > v);
            if (i < j) {
                x = a[i]; a[i] = a[j]; a[j] = x;
            }
        } while (i < j);
        a[r] = a[i]; a[i] = v;

        if (i-1 > l) {
            execCount++;
            treeHeight++;
            quickSortPivotEnd(l, i-1, a);
            if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
            treeHeight--;
        }
        if (r > i+1){
            execCount++;
            treeHeight++;
            quickSortPivotEnd(i+1, r, a);
            if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
            treeHeight--;
        }
    }

    public static void quickSortPivotEndPartition(int l, int r, int[] a) {
        System.out.print(execCount + ":\t");
        for (int k = 0; k < a.length; k++) {
            System.out.print(ANSI_RESET);
            if (k == r) {
                System.out.print(ANSI_BLUE);
                System.out.print(a[k] + "\t");
            } else if (k >= l && k < r+1) {
                System.out.print(ANSI_RED);
                System.out.print(a[k] + "\t");
            }
            else {
                System.out.print(a[k] + "\t");
            }
        }
        System.out.println(ANSI_RESET);

        partition++;
        int m = com.Partition.partition(a, l, r, false);

        if (m - 1 > l) {
            execCount++;
            treeHeight++;
            quickSortPivotEndPartition(l, m - 1, a);
            if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
            treeHeight--;
        }
        if (m+1 < r) {
            execCount++;
            treeHeight++;
            quickSortPivotEndPartition(m + 1, r, a);
            if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
            treeHeight--;
        }
    }

    public static void quickSortPivotStart(int l, int r, int[] a) {
        int i, j, v, x;

//        v = a[r];
//        i = l-1;
//        j = r;

        System.out.print(execCount + ": ");
        for (int k = l; k < r+1; k++) {
            System.out.print(a[k] + ", ");
        }
        System.out.println();

        v = a[l];
        i = l;
        j = r+1;

        System.out.print(execCount + ": ");
        for (int k = l; k < r+1; k++) {
            System.out.print(a[k] + ", ");
        }
        System.out.println();

        // partition begin
        do {
            do {
                i++;
            } while ((i <= r) && (a[i] < v));
            do {
                j--;
            } while (a[j] > v);
            if (i < j) {
                x = a[i]; a[i] = a[j]; a[j] = x;
            }
        } while (i < j);
        a[l] = a[j]; a[j] = v;
        // partition end

        if (j-1 > l) {
            execCount++;
            quickSortPivotStart(l, j-1, a);
        }
        if (r > j+1){
            execCount++;
            quickSortPivotStart(j+1, r, a);
        }
    }

    public static void sortujQuickPivotEnd(int[] a) {
        if (a.length >= 2) {
            execCount++;
            quickSortPivotEnd(0, a.length-1, a);
        }
    }

    public static void sortujQuickPivotEndPartition(int[] a) {
        if (a.length >= 2) {
            execCount++;
            quickSortPivotEndPartition(0, a.length-1, a);
        }
    }

}

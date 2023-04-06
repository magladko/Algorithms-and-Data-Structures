package sorting;

import com.Partition;
import com.Split;

import java.util.Arrays;

import static com.TextColors.*;

public class QuickSort {

    static int execCount;
    static int partition;
    static int recursionCount;
    static int treeHeight;
    static int maxTreeHeight;

    public enum Podzial {
        PARTITION, SPLIT
    }

    /**
     * Na generatorach używana jest metoda ustawiająca PIVOT na końcu tablic (quicksortPivotEnd())
     * Obecna wersja nie zgodna z generatorami, ale zgodna z próbnymi kolosami
     * metoda: com.Partition // com.Split
     */
    public static void main(String[] args) {
        int[] a1 = {3,18,13,5,8,14,19,12,4,2,6};
        int[] a2 = {3,18,2,5,8,13,19,14,4,12,6};
        int[] a3 = {4,18,19,5,8,14,3,12,6,13,2};
//        int[] a1 = {3,16,6,13,10,4,14,18,0,1,5};
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
//        int[] a1 = {11,9,7,6,4,5,8,13,19,14,15};
//        int[] a2 = {11,9,7,6,5,15,8,13,19,4,14};
//        int[] a3 = {14,9,7,6,4,5,8,11,19,13,15};
//        int[] a1 = {11,18,7,12,9,0,6,5,17,4,2};
//        int[] a2 = {11,2,7,12,18,4,6,5,0,9,17};
//        int[] a3 = {7,5,18,12,9,0,6,2,17,4,11};
//        int[] a1 = {14,17,0,2,16,19,4,9,1,7,5};
//        int[] a2 = {4,17,0,2,16,14,19,9,1,7,5};
//        int[] a3 = {5,14,0,2,16,19,4,17,1,7,9};
//        int[] a1 = {1,2,3,4};
//        int[] a2 = {1,2,3,4,5,6,7,8};
//        int[] a3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//        int[] a1 = {0,10,7,11,13,8,16,14,6,1,15};
//        int[] a2 = {14,7,11,6,15,10,8,13,0,1,16};
//        int[] a3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//        int[] a1 = {0,10,7,11,13,8,16,14,6,1,15};
//        int[] a2 = {14,7,11,6,15,10,8,13,0,1,16};
//        int[] a3 = {2,5,19,12,10,3,7,18,14,13,11};
//        int[] a1 = {13,2,3,12,11,19,10,18,7,5,14};
//        int[] a2 = {10,18,5,19,11,13,3,12,14,2,7};
//        int[] a3 = {2,5,19,12,10,3,7,18,14,13,11};

        Podzial p = Podzial.PARTITION;
//        Podzial p = Podzial.SPLIT;

        System.out.println("\nMAIN DATA:");
        execNew(a1, p);
        execNew(a2, p);
        execNew(a3, p);
    }

    public static void execNew(int[] arr, Podzial p) {
        execCount = 0;
        partition = 0;
        recursionCount = 0;
        maxTreeHeight = 0;
        treeHeight = 0;

        if (p == Podzial.PARTITION) System.out.println("PARTITION:");
        else System.out.println("SPLIT:");
        System.out.println("FOR: " + Arrays.toString(arr));

        if (p == Podzial.PARTITION) quickSortPartition(arr, 0, arr.length-1);
//            sortujQuickPivotEnd(arr, p);
        else quickSortSplit(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
        System.out.println("partition times: " + partition);
        System.out.println("recursion count: " + (recursionCount));
        System.out.println("max tree height: " + (maxTreeHeight)); // o 1 większe z jakiegoś powodu
        System.out.println();
    }

    public static void quickSortPivotEnd(int l, int r, int[] a, Podzial p) {
//        System.out.print("P=" + partition + " H=" + treeHeight + ": ");
//        printPart(a, l, r);
        if (r-l+1 <= 1) return; // wp: n>1
        printStatus(a, l, r);

        partition++;
        int m;
        if (p == Podzial.PARTITION) m = com.Partition.partition(a, l, r, false);
        else m = com.Split.split(a, l, r, false);

//        if (m - 1 > l) {
        execCount++;
        recursionCount++;
        treeHeight++;
//            System.out.print("P=" + partition + " H=" + treeHeight + ": ");
//            printPart(a, l, m - 1);
        quickSortPivotEnd(l, m - 1, a, p);
        if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
        treeHeight--;
//        }
//        if (m+1 < r) {
        execCount++;
        recursionCount++;
        treeHeight++;
//            System.out.print("P=" + partition + " H=" + treeHeight + ": ");
//            printPart(a, m+1, r);
        quickSortPivotEnd(m + 1, r, a, p);
        if (treeHeight > maxTreeHeight) maxTreeHeight = treeHeight;
        treeHeight--;
//        }
    }

    public static void sortujQuickPivotEnd(int[] a, Podzial p) {
        if (a.length >= 2) {
            execCount++;
            quickSortPivotEnd(0, a.length-1, a, p);
        }
    }

    public static void quickSortPartition(int[] arr, int left, int right) {

        printStatus(arr, left, right);
//        System.out.print(treeHeight + ": ");
//        printPart(arr, left, right);

        partition++;
        int m = Partition.partition(arr, left, right, false);

        if (m > left+1) {
            recursionCount++;
            treeHeight++;
            quickSortPartition(arr, left, m-1);
            maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
        }
        if (right-m > 1) {
            recursionCount++;
            treeHeight++;
            quickSortPartition(arr, m+1, right);
            maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
        }
    }

    public static void quickSortSplit(int[] arr, int left, int right) {
        printStatus(arr, left, right);

//        System.out.print(treeHeight + ": ");
//        printPart(arr, left, right);

        partition++;
        int m = Split.split(arr, left, right, false);

        if (m > left+1) {
            recursionCount++;
            treeHeight++;
            quickSortSplit(arr, left, m-1);
            maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
        }
        if (right-m > 1) {
            recursionCount++;
            treeHeight++;
            quickSortSplit(arr, m+1, right);
            maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
        }
    }

    private static void printStatus(int[] a, int l, int r) {
        System.out.print("par=");
        System.out.print((partition+1) + ":\t");
        for (int k = 0; k < a.length; k++) {
            System.out.print(ANSI_RESET.getColor());
            if (k == r) {
                System.out.print(ANSI_BLUE.getColor());
                System.out.print(a[k] + "\t");
            } else if (k >= l && k < r+1) {
                System.out.print(ANSI_RED.getColor());
                System.out.print(a[k] + "\t");
            }
            else {
                System.out.print(a[k] + "\t");
            }
        }
        System.out.println(ANSI_RESET.getColor());
    }

    public static void printPart(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

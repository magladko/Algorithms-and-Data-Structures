package sorting;

import java.util.Arrays;

public class QuickSort {

    static int execCount;
    static int partition;

    /**
     * Na generatorach używana jest metoda ustawiająca PIVOT na końcu tablic (quicksortPivotEnd())
     * metoda: com.Partition
     */
    public static void main(String[] args) {
//        int[] a = new int[]{3,18,13,5,8,14,19,12,4,2,6};
//        int[] a = new int[]{3,18,2,5,8,13,19,14,4,6};
//        int[] a = new int[]{4,18,19,5,8,14,3,12,6,13,2};
//        int[] a = new int[]{3,16,6,13,10,4,14,18,0,1,5};
//        int[] a = {17,15,9,11,14,12,6,18,13};
        int[] a = {11,18,7,12,9,0,6,5,17,4,2};
//        int[] a = {5,18,7,12,9,0,4,6,17,11,2};
        execCount = 0;
        partition = 0;
        sortujQuickPivotEnd(a);
        System.out.println(Arrays.toString(a) +  " " + execCount);
        System.out.println("partition times: " + partition);
    }

    public static void quickSortPivotEnd(int l, int r, int[] a) {
        int i, j, v, x;

        v = a[r];
        i = l-1;
        j = r;

        System.out.print(execCount + ": ");
        for (int k = l; k < r+1; k++) {
            System.out.print(a[k] + ", ");
        }
        System.out.println();

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
            quickSortPivotEnd(l, i-1, a);
        }
        if (r > i+1){
            execCount++;
            quickSortPivotEnd(i+1, r, a);
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

}

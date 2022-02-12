package com;

import java.util.Arrays;

/**
 * Jeżeli "Po pierwszych n operacjach", należy wziąć wyniki n+1
 */
public class Partition {

    static int swapCount;
    static int compareCount;

    public static void main(String[] args) {
//        int[] a = {8,18,13,9,2,1,19,4,3,7,14,6,12};
//        int[] a = {6,8,17,10,3,0,2,1,15,16,18,9,13};
//        int[] a = {2,15,13,17,14,19,4,10,8,1,5,12,18};
//        int[] a = {8,5,15,11,7,9,16,2,6,0,17,4,10};
//        int[] a = {19,17,1,12,8,3,14,10,5,13,11};
//        int[] a = {19,17,1,12,8,3,14,10,5,13,11};
        int[] a = {10,5,0,7,11,4,14,8,13};

        swapCount = 0;
        compareCount = 0;

        System.out.println(Arrays.toString(a));
        partition(a, true);
        System.out.println(Arrays.toString(a));
    }

    public static int partition(int[] T, boolean print) {
        return partition(T, 0, T.length-1, print);
    }

    public static int partition(int[] T, int leftBoundaryIdx, int rightBoundaryIdx, boolean print) {
        swapCount = 0;
        compareCount = 0;

        int l = leftBoundaryIdx-1, r = leftBoundaryIdx, idx = rightBoundaryIdx;

        while (r<idx) {
            if ((++compareCount>-1) && T[r] < T[idx]) {
                if (r > l+1) {
                    swapCount++;
                    Util.swapInt(T, l+1, r);
                }
                l++;
            }
            r++;
            if (print) printStatus(T,l,r);
        }
        if (l+1<idx) {
            swapCount++;
            Util.swapInt(T, l+1, idx);
            if (print) printStatus(T,l,r);
            idx = l+1;
        }
        return idx;
    }

    private static void printStatus(int[]arr, int l, int r) {
        System.out.println("swap=" + swapCount + "\tcompare=" + compareCount + "\tl=" + l + "\tr=" + r + "\t" + Arrays.toString(arr));
    }

}

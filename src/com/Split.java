package com;

import java.util.Arrays;

public class Split {

    static int swaps;
//    static int ifSwaps;

    public static void main(String[] args) {
//        int[] a = {6,8,5,7,4};
//        int[] a = {10, 7, 6, 4, 2, 11, 16, 8, 3, 1, 9};
//        int[] a = {12,4,10,17,14,8,0,11,1,18,5};
        int[] a = {13,8,1,10,9,16,11,15,2,7,18};

        swaps = 0;
//        ifSwaps = 0;

        split(a, true);
        System.out.println(Arrays.toString(a));
    }

    public static int split(int[] arr, boolean out) {
        return split(arr, 0, arr.length-1, out);
    }

    public static int split(int[] arr, int left, int right, boolean out) {
//        int l = 1, r = arr.length-1, idx = 0;
        int l = left+1, r = right, idx = left;

        while (l <= r) {
            while (l <= r && arr[r] > arr[idx]) r--;
            while (l <= r && arr[l] < arr[idx]) l++;
            if (out) {
                System.out.print("pre if: ");
                printStatus(arr, left, right, l, r);
            }
            if (/*(ifSwaps++>0) &&*/ l < r) {
                swaps++;
                Util.swapInt(arr, l, r);
//                int temp = arr[l]; arr[l] = arr[r]; arr[r] = temp;
                r--; l++;
            }
            if (out) {
                System.out.print("aft if: ");
                printStatus(arr, left, right, l, r);
            }
        }
        if (r > left) {
            swaps++;
            Util.swapInt(arr, idx, r);
//            int temp = arr[idx]; arr[idx] = arr[r]; arr[r] = temp;
            idx = r;
        }
        if (out) printStatus(arr, left, right, l, r);
        return idx;
    }

    public static void printStatus(int[] arr, int left, int right, int l, int r) {
        System.out.print("swaps=" + swaps + " l=" + l + " r=" +r+ ": ");
        Util.printPartOfArr(arr, left, right);
        System.out.println();
    }

}

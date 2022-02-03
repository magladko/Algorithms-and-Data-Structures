package com;

import java.util.Arrays;

public class Split {
    public static void main(String[] args) {
        int[] a = {6,8,5,7,4};
//        int[] a = {10, 7, 6, 4, 2, 11, 16, 8, 3, 1, 9};
        split(a);
        System.out.println(Arrays.toString(a));
    }

    public static int split(int[] arr) {
        int l = 1, r = arr.length-1, idx = 0;

        while (l <= r) {
            while (l <= r && arr[r] > arr[idx]) r--;
            while (l <= r && arr[l] < arr[idx]) l++;
            if (l < r) {
                Util.swapInt(arr, l, r);
//                int temp = arr[l]; arr[l] = arr[r]; arr[r] = temp;
                r--; l++;
            }
        }
        if (r > 0) {
            Util.swapInt(arr, idx, r);
//            int temp = arr[idx]; arr[idx] = arr[r]; arr[r] = temp;
            idx = r;
        }
        return idx;
    }
}

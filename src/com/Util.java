package com;

import java.util.Arrays;

public class Util {

    public static void main(String[] args) {
//        alg1(10);
    }

    public enum Podzial {
        PARTITION, SPLIT
    }

    public static void swapInt(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2]; arr[i2] = temp;
    }

    public static int alg1(int n) {
        int i=1, x=1;
        while (i < n) {
            i=i+1;
            x=x+i;
            System.out.println((2*x) + " " + (i*(i+1)));
        }
        return x;
    }

    public static void printPartOfArr(int[] arr, int l, int r) {
        System.out.print(Arrays.toString(Arrays.stream(arr).skip(l).limit(r - l + 1).toArray()));
    }

}

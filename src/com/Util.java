package com;

public class Util {

    public static void main(String[] args) {
//        alg1(10);
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

}

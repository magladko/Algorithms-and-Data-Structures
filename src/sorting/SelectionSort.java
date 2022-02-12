package sorting;

import java.util.Arrays;


public class SelectionSort {

    static int swapCount;
    static int compareCount;

    public static void main(String[] args) {
//        int[] arr = {13,9,0,1,3,16,5,11};
//        int[] arr = {6,8,5,7,4};
//        int[] arr = {13,6,4,18,1,12,7,9};
        int[] arr = {11,0,15,13,14,12,16,10};
//        int[] arr = {12,9,19,13,0,4,16,15};
//        int[] arr = {12,12,6,2,0,16,8,14,4};


        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        swapCount = 0;
        compareCount = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int jMin = i;
            for (int j = i+1; j < arr.length; j++) {
                compareCount++;
                if (arr[j] < arr[jMin]) jMin = j;
            }
            if (jMin != i) {

                swap(arr, i,jMin);
            }
            System.out.println("after " + (i+1) +": swaps=" + swapCount + ",\tcompares=" + compareCount +  "\t;;\t" + Arrays.toString(arr));
        }
    }
    public static void swap(int[] arr, int i1, int i2) {
        if (i1 == i2) return;
        swapCount++;
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}

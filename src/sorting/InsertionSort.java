package sorting;

import java.util.Arrays;

class InsertionSort {
    /*Function to sort array using insertion sort*/

    static int swapCount;
    static int compareCount;

    // Driver method
    public static void main(String[] args)
    {
//        int[] arr = {6,8,5,7,4};
//        int[] arr = {2,10,4,19,18,15,9,8};
//        int[] arr = {7,16,3,4,9,13,10,2};
//        int[] arr = {1,2,3,4,5};
//        int[] arr = {1,4,5,2,3};
        int[] arr = {12,9,19,13,0,4,16,15};
//        int[] arr = {7,16,3,4,9,13,10,2};
//        int[] arr = {15,14,10,16,19,7,2,12,8,5,3};
 //           int[] arr = {5, 12, 9, 6, 15, 10, 1, 17};

//        int[] arr = new int[100];
//        for (int i = 0; i < arr.length; i++) arr[i] = i+1;



        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }

    void sort(int[] arr)
    {
        swapCount = 0;
        compareCount = 0;
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0 && ((++compareCount)>-1 && arr[j-1] > arr[j]); j--) {
                swap(arr, j, j-1);
            }
            System.out.println(i +". swaps=" + swapCount + ",\tcompares=" + compareCount +  "\t;;\t" + Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int i1, int i2) {
        if (i1 == i2) return;
        swapCount++;
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /* A utility function to print array of size n*/
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");

        System.out.println();
    }
}
package sorting;

import java.util.Arrays;

class InsertionSort {
    /*Function to sort array using insertion sort*/

    static int swap_nr;

    void sort(int[] arr)
    {
        swap_nr = 0;
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0 && arr[j-1] > arr[j]; j--) {
                swap(arr, j, j-1);
            }
            System.out.println("for " + i + " swaps = " + swap_nr + " ;; " + Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int i1, int i2) {
        if (i1 == i2) return;
        swap_nr++;
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /* A utility function to print array of size n*/
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String[] args)
    {
        int[] arr = {6,8,5,7,4};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}
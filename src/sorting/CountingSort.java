package sorting;

import java.util.Arrays;

public class CountingSort {

    // Driver method
    public static void main(String[] args)
    {
        CountingSort ob = new CountingSort();
//        int[] arr = {0,0,5,1,1,0,0,3,5,0,0,0};
//        int[] arr = {4,3,0,4,2,4,0,3,0,0,2};
//        int[] arr = {0,5,2,5,1,0,1,3,3,4,1,1};
 //           int[] arr = {1,0,0,5,0,3,5,0,1,4,0,0};
        int[] arr = {2,1,2,5,4,4,3,5,3,0,4,1};

        ob.sort(arr);

        System.out.print("sorted:\t" + Arrays.toString(arr));
    }

    void sort(int[] arr)
    {

        int n = arr.length;

        // The output character array that will have sorted arr
        int[] output = new int[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0

        int maxNr = arr[0];
        for (int x : arr) if (maxNr < x) maxNr = x;

        int[] count = new int[maxNr+1];

        // store count of each character
        for (int j : arr) ++count[j];
        System.out.println("zliczanie:\t" + Arrays.toString(count));

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < count.length; ++i) count[i] += count[i - 1];
        System.out.println("sumowanie:\t" + Arrays.toString(count));

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        System.out.println("wypisanie:\t" + Arrays.toString(count));

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        System.arraycopy(output, 0, arr, 0, n);
    }
}
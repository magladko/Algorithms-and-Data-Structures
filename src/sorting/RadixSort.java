package sorting;
import java.util.*;

public class RadixSort {

    static int totalMaxQueueLen;
    static int totalFirstCount;
    static int totalInCount;

    public static void main(String[] args)
    {
//        int[] arr = {185,567,750,239,855,115,779,403,886,933,766,122};
<<<<<<< HEAD
 //       int[] arr = {814,689,979,430,453,481,474,524,857,753,819,794};
=======
//        int[] arr = {814,689,979,430,453,481,474,524,857,753,819,794};
>>>>>>> 41df3d944dd834b414f35f35790cf0626a1c8262
//        int[] arr = {931,440,537,738,109,887,496,450,784,110,653,881};
//        int[] arr = {165,829,988,583,481,393,915,892,620,840,986,641};
//        int[] arr = {753,713,824,121,740,253,503,528,770,632,526,930};
//        int[] arr = {242,291,648,319,873,101,511,436,529,126,131,785};
//        int[] arr = {920,394,191,907,173,584,530,281,559,388,674,152};
<<<<<<< HEAD
        //int[] arr = {732,162,913,828,764,903,524,547,969,929,545};
            int[] arr = {928,704,411,723,603,728,284,107,864,451,654};
=======
        int[] arr = {732,162,913,828,764,903,524,547,969,929,545};
>>>>>>> 41df3d944dd834b414f35f35790cf0626a1c8262
        int n = arr.length;

        // Function Call
        radixSort(arr, n);
        System.out.println();
        print(arr, n);
        System.out.println();
        System.out.println("Max QUEUE len: " + totalMaxQueueLen);
        System.out.println("Total FIRST:   " + totalFirstCount);
        System.out.println("Total IN ops:  " + totalInCount);
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr, int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp)
    {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];

        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
            totalInCount++;
        }


        System.out.println();
        System.out.println("EXP: " + exp);
        System.out.println("Before:\t" + Arrays.toString(arr));
        System.out.print("number:\t");
        for (int j = 0; j < 10; j++) System.out.print(j + "\t");
        System.out.print("\ncount:\t");
        for (int j = 0; j < count.length; j++) {
            System.out.print(count[j] + "\t");
            if (count[j] > totalMaxQueueLen) totalMaxQueueLen = count[j];
        }


        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        System.out.print("\nindex:\t");
        for (int j = 0; j < count.length; j++) System.out.print(count[j] + "\t");
        System.out.println();

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];

            totalFirstCount++;
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];

        System.out.println("After:\t" + Arrays.toString(arr));
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int[] arr, int n)
    {
        totalMaxQueueLen = 0;
        totalFirstCount = 0;
        totalInCount = 0;
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void print(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    /*Driver Code*/

}
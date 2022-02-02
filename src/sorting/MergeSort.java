package sorting;

import java.util.Arrays;

public class MergeSort {

    static int execCount;

    public static void main(String[] args) {
        MergeSort ob = new MergeSort();

        int[] a = {5,16,3,14,17,1,19,11,18,9,10};

        execCount = 0;
        ob.sortuj(a);

        System.out.println(Arrays.toString(a));
        System.out.println(execCount);
    }

    private void scal(int le, int sr, int pr, int[] arr) {
        int i = le;
        int j = sr+1;
        int k = -1;

        int[] b = new int[pr-le+1];

        while ((i <= sr) && (j <= pr)) {
            k++;
            if (arr[i] <= arr[j]) {
                b[k] = arr[i];
                i++;
            } else {
                b[k] = arr[j];
                j++;
            }
        }

        if (i <= sr) {
            for (j = pr; j > le+k; j--) {
                arr[j] = arr[sr];
                sr--;
            }
        }

        for (i = 0; i <= k; i++) {
            arr[le+i] = b[i];
        }
    }

    private void sortujRek(int le, int pr, int[] arr) {
        execCount++;
        System.out.print(execCount + ": ");
        for (int i = le; i <= pr; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();

        int sr = (le+pr)/2;
        if (le < sr) {
            sortujRek(le, sr, arr);
        }
        if ((sr+1) < pr){
            sortujRek(sr+1, pr, arr);
        }

        scal(le, sr, pr, arr);
    }

    public void sortuj(int[] arr) {
        if (arr.length >= 2) {
            sortujRek(0, arr.length-1, arr);
        }
    }
}

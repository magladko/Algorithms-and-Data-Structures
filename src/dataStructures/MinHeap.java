package dataStructures;

import java.util.Arrays;

public class MinHeap {

    static int[] a;
    static int n;

    public static void main(String[] args) {
        a = new int[]{-1,11, 13, 19, 1, 18, 5, 8, 17, 12, 15};
        n = a.length-1;


        construct();
        printUsedPart();
        System.out.println(Arrays.toString(a));
        delmin();
        delmin();
        delmin();
        printUsedPart();
        System.out.println(Arrays.toString(a));


        int[] res = Arrays.stream(a).filter(e -> e != -1).toArray();
        System.out.println(Arrays.toString(res));
    }

    public static void construct() {

        int i;

        for (i = n/2; i > 0; i--) {
            downHeap(i);
        }
    }

    public static void downHeap(int k) {
        int l = 2*k, v = a[k];

        while (l <=n) {
            if ((l<n) && (a[l] > a[l+1])) l++;
            if (v > a[l]) {
                a[k] = a[l];
                k = l;
                l*=2;
            } else l = n+1;
        }
        a[k] = v;
    }

    public static void delmin() {
        a[1] = a[n];
        a[n--] = -1;

        if (n > 0) {
            downHeap(1);
        }
    }

    public static void printUsedPart() {
        for (int i = 1; i < n; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[n]);
        System.out.println();
    }

//    public static int[] trimArr();

}

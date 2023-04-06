package searching;

import java.util.Arrays;
import com.*;
import sorting.QuickSort;

/**
 * Wyszukiwanie k-tego co do wielkości elementu.
 */
public class HoareAlg {

    static int partitionCount;
    static int treeHeight;
    static int maxTreeHeight;

    public static void main(String[] args) {
//        int[] arr = {17,15,9,11,14,12,6,18,13}; int k = 1;
//        int[] arr = {10,5,0,7,11,4,14,8,13}; int k = 6;
//        int[] arr = {6,3,8,7,19,17,16,18,14}; int k = 8;
//        int[] arr = {12,3,1,16,8,14,13,5,0,10,6}; int k = 9;
//        int[] arr = {9,12,3,8,4,6,17,13,16,2,15}; int k = 9;
//        int[] arr = {2,10,15,1,14,9,13,17,5,8,0}; int k = 8;
//        int[] arr = {11,10,3,7,18,9,16,6,0,15,19}; int k = 8;
//            int[] arr = {10,5,0,7,11,4,14,8,13}; int k = 9;
        int[] arr = {11,10,3,7,18,9,16,6,0,15,19}; int k = 8;

        Util.Podzial p = Util.Podzial.PARTITION;

        treeHeight = 0;
        maxTreeHeight = 0;
        partitionCount = 0;
//        res = hoare(arr, k);

        if (p == Util.Podzial.PARTITION) System.out.println("PARTITION");
        else System.out.println("SPLIT");

        int res = hoare(arr, 0, arr.length-1, k, p);
        System.out.println("for k=" + k + "\tpartitions=" + partitionCount + "\nresIdx=" + res + "\t" + Arrays.toString(arr));
        System.out.println("tree height: " + maxTreeHeight);
        System.out.println();

//        arr = new int[]{17, 15, 9, 11, 14, 12, 6, 18, 13}; k = 2;
//        partitionCount = 0;
//        res = hoare(arr, k);
//        System.out.println("for k=" + k + "\tpartitions=" + partitionCount + "\tresIdx=" + res + "\t" + Arrays.toString(arr));
    }

    public static int hoare(int[] E, int left, int right, int k, Util.Podzial p) {
        int tmp = 0, m;



        partitionCount++;
        printStatus(E, left, right, k);
        if (p == Util.Podzial.PARTITION) m = Partition.partition(E, left, right, false);
        else m = Split.split(E, left, right, false);

        if (right - m +1 == k) return m;
        else {
            treeHeight++;
            if ((right+1)-m > k) tmp += hoare(E, m+1, right, k, p);
            else tmp = hoare(E, left, m-1, k-(right-m+1), p);
            maxTreeHeight = Math.max(maxTreeHeight, treeHeight--);
        }
        return tmp;
    }

    static void printStatus(int[] E, int left, int right, int k){
        System.out.print(partitionCount + ": ");
        Util.printPartOfArr(E, left, right);
        System.out.println(" k=" + k);
    }

//    public static int hoareSplit(int[] E, int left, int right, int k) {
//        int tmp = 0;
//
//        partitionCount++;
//        System.out.print(partitionCount + ": ");
//        Util.printPartOfArr(E, left, right);
//        System.out.println(" k=" + k);
//        int m = Split.split(E, left, right, false);
//
//        if (right - m +1 == k) return m;
//        else {
//            if ((right+1)-m > k) tmp += hoareSplit(E, m+1, right, k);
//            else tmp = hoareSplit(E, left, m-1, k-(right-m+1));
//        }
//        return tmp;
//    }

//    static int hoare(int[] T, int k) {
//        int idx = -1;
//        int l = 0, r = T.length-1;
//        boolean jest = false;
//
//        while (!jest) {
//            partitionCount++;
//            System.out.println(partitionCount + ". partition arg = " + Arrays.toString(Arrays.stream(T).skip(l).limit(r-l+1).toArray()));
////            System.out.println(", szukamy na idx: " + idx);
//            idx = Partition.partition(T, l, r, false);
////            System.out.println(partitionCount + ". partition after  = " + Arrays.toString(T)
////                                       + " idx=" + idx + " n-idx=" + (T.length-idx));
//
//            if (k == T.length-idx) jest = true;
//            else if (k > T.length-idx) r = idx-1;
//            else {
//                l = idx+1;
//                k = k-(idx-l+1);
//            }
//        }
//        return idx;
//
//        /*
//        Rekurencyjnie, do poprawnego działania, powinien zmieniać postać tablicy
//        int idx;
//
//        partitionCount++;
//        System.out.println(partitionCount + ". partition before = " + Arrays.toString(T));
//        idx = com.Partition.partition(T,false);
//        System.out.println(partitionCount + ". partition after  = " + Arrays.toString(T)
//                                   + " idx=" + idx + " n-idx=" + (n-idx));
//
//        if (n-idx == k) return idx;
//        else if (n-idx > k) {
//            if (n-idx-1 > 0)
//                return idx+1+ hoare(Arrays.stream(T).skip(idx+1).toArray(), n-idx-1, k);
//        } else if (idx > 0) return hoare(Arrays.stream(T).limit(idx).toArray(), idx, k-(n-idx));
//
//        return idx;*/
//    }

}

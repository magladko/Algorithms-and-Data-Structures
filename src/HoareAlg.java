import java.util.Arrays;

/**
 * Wyszukiwanie k-tego co do wielkości elementu.
 */
public class HoareAlg {

    static int partitionCount;

    public static void main(String[] args) {
        int[] arr = {17,15,9,11,14,12,6,18,13}; int k = 1;

        int res;

        partitionCount = 0;
        res = hoare(arr, k);
        System.out.println("for k=" + k + "\tpartitions=" + partitionCount + "\tres=" + res + "\t" + Arrays.toString(arr));
        System.out.println();

        arr = new int[]{17, 15, 9, 11, 14, 12, 6, 18, 13}; k = 6;
        partitionCount = 0;
        res = hoare(arr, k);
        System.out.println("for k=" + k + "\tpartitions=" + partitionCount + "\tres=" + res + "\t" + Arrays.toString(arr));
    }

    static int hoare(int[] T, int k) {
        int idx = -1;
        int l = 0, r = T.length-1;
        boolean jest = false;

        while (!jest) {
            partitionCount++;
//            System.out.println(partitionCount + ". partition before = " + Arrays.toString(T));
            idx = Partition.partition(T, l, r, false);
//            System.out.println(partitionCount + ". partition after  = " + Arrays.toString(T)
//                                       + " idx=" + idx + " n-idx=" + (T.length-idx));

            if (k == T.length-idx) jest = true;
            else if (k > T.length-idx) r = idx-1;
            else {
                l = idx+1;
                k = k-(idx-l+1);
            }
        }
        return idx;

        /*
        Rekurencyjnie, do poprawnego działania, powinien zmieniać postać tablicy
        int idx;

        partitionCount++;
        System.out.println(partitionCount + ". partition before = " + Arrays.toString(T));
        idx = Partition.partition(T,false);
        System.out.println(partitionCount + ". partition after  = " + Arrays.toString(T)
                                   + " idx=" + idx + " n-idx=" + (n-idx));

        if (n-idx == k) return idx;
        else if (n-idx > k) {
            if (n-idx-1 > 0)
                return idx+1+ hoare(Arrays.stream(T).skip(idx+1).toArray(), n-idx-1, k);
        } else if (idx > 0) return hoare(Arrays.stream(T).limit(idx).toArray(), idx, k-(n-idx));

        return idx;*/
    }

}

import java.util.Arrays;

/**
 * Jeżeli "Po pierwszych n operacjach", należy wziąć wyniki n+1
 */
public class Partition {

    static int swapCount;
    static int compareCount;

    public static void main(String[] args) {
        int[] a = {8,18,13,9,2,1,19,4,3,7,14,6,12};

        swapCount = 0;
        compareCount = 0;

        System.out.println(Arrays.toString(a));
        partition(a);
        System.out.println(Arrays.toString(a));
    }

    public static int partition(int[] T) {
        int l = -1, r = 0, idx = T.length-1;

        for (;r<idx;r++) {
            if ((++compareCount>-1) && T[r] < T[idx]) {
                if (r > l+1) {
                    swapCount++;
                    Misc.swapInt(T, l+1, r);
                    printStatus(T,l,r);
                }
                l++;
            }
        }
        if (l+1<idx) {
            swapCount++;
            Misc.swapInt(T, l+1, idx);
            printStatus(T,l,r);
            idx = l+1;
        }
        return idx;
    }

    private static void printStatus(int[]arr, int l, int r) {
        System.out.println("swap=" + swapCount + "\tcompare=" + compareCount + "\tl=" + l + "\tr=" + r + "\t" + Arrays.toString(arr));
    }

}

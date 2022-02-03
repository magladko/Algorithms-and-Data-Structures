package searching;

public class BinSearch {

    static int compareCount;

    public static void main(String[] args) {
        int res;

        int[] a = {0,3,4,5,6,7,8,9,10,12,13,15,16,17,19}; int x = 7;

        compareCount = 0;
        res = binSearch(a, x);
        System.out.println(x + ": compare=" + compareCount);

        x = 6;
        compareCount = 0;
        res = binSearch(a, x);
        System.out.println(x + ": compare=" + compareCount);


        x = 5;
        compareCount = 0;
        res = binSearch(a, x);
        System.out.println(x + ": compare=" + compareCount);
    }

    public static int binSearch(int[] T, int x) {
        int l = 0, r = T.length-1, idx = (l+r)/2;

        while ((compareCount++>-1) && T[idx] != x) {
            if ((compareCount++)>-1 && T[idx] < x) l = idx+1;
            else r = idx-1;
            idx = (l+r)/2;
        }
        return idx;
    }

}

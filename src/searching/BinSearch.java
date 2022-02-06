package searching;

public class BinSearch {

    static int compareCount;

    public static void main(String[] args) {
        int res;

//        int[] a = {0,3,4,5,6,7,8,9,10,12,13,15,16,17,19}; int x = 7;
        int[] a = {0,2,3,4,5,6,7,8,10,11,13,14,15,17,18}; int x = 13;

        compareCount = 0;
        res = binSearch(a, x);
        System.out.println(x + ": compare=" + compareCount + "\n");

        x = 18;
        compareCount = 0;
        res = binSearch(a, x);
        System.out.println(x + ": compare=" + compareCount + "\n");

//        x = 5;
//        compareCount = 0;
//        res = binSearch(a, x);
//        System.out.println(x + ": compare=" + compareCount);
    }

    public static int binSearch(int[] T, int x) {
        int l = 0, r = T.length-1, idx = (l+r)/2;

        System.out.print("T[idx]: ");
        while ((compareCount++>-1) && T[idx] != x) {
            System.out.print(T[idx] + " ");
            if ((compareCount++)>-1 && T[idx] < x) l = idx+1;
            else r = idx-1;
            idx = (l+r)/2;
        }
        System.out.println();
        return idx;
    }

}

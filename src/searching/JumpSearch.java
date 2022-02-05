package searching;

public class JumpSearch {
    public static void main(String[] args) {
        int[] a = {0, 3, 5, 6, 7, 10, 11, 13, 16};

        System.out.println(jumpSearch(a, a.length, 3, 18));

    }

    public static int jumpSearch(int[] arr, int n, int k, int x) {
        int i = 0;

        while ((i<n) && (x> arr[i])) i+=k;
        if (i>=n) {
            i = n-1;
        }
        int temp = i;
        while (arr[i]!=x && i > temp-k) i--;
        return arr[i] == x ? i : -1;
    }
}
